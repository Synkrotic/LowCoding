package dev.synkrotic.lowcoding.components.setup;

import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.geo.Coord;
import dev.synkrotic.lowcoding.geo.Size;
import dev.synkrotic.lowcoding.types.LowDataType;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public abstract class LowComponent implements Serializable {
    public static final int ROUNDING_RADIUS = 10;

    private Coord rightHoldPoint = null;

    protected final ComponentDetails componentDetails;
    protected Environment env;

    protected final List<LowDataType> inputs = new ArrayList<>();

    public Coord leftClickOffset = null;


    public LowComponent(Environment env, ComponentDetails componentDetails) {
        this.componentDetails = componentDetails;
        this.env = env;
    }

    public void setEnvironment(Environment env) {
        this.env = env;
    }

    protected void drawStringCentered(Graphics2D g, String text) {
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();
        int x = componentDetails.loc().x() + (componentDetails.size().width() - textWidth) / 2;
        int y = componentDetails.loc().y() + (componentDetails.size().height() - textHeight) / 2 + fm.getAscent();

        g.setColor(Color.BLACK);
        g.drawString(text, x, y);
    }

    public boolean isMouseOver(Point mousePos) {
        return mousePos.x >= componentDetails.loc().x() &&
            mousePos.x <= componentDetails.loc().x() + componentDetails.size().width() &&
            mousePos.y >= componentDetails.loc().y() &&
            mousePos.y <= componentDetails.loc().y() + componentDetails.size().height();
    }

    public void setLocation(Coord location) {
        componentDetails.setLoc(location);
    }
    public Size getSize() {
        return componentDetails.size();
    }

    public void moveClick(MouseEvent e) {
        leftClickOffset = new Coord(
            e.getX() - componentDetails.loc().x(),
            e.getY() - componentDetails.loc().y()
        );
    }
    public void moveHold(MouseEvent e) {
        if (leftClickOffset != null) {
            int scaledMouseX = e.getX();
            int scaledMouseY = e.getY();

            int newX = scaledMouseX - leftClickOffset.x();
            int newY = scaledMouseY - leftClickOffset.y();

            componentDetails.setLoc(new Coord(newX, newY));
            env.repaint();
        }
    }
    public void moveRelease() {
        leftClickOffset = null;
        env.repaint();
    }

    public void lineHold(MouseEvent e) {
        rightHoldPoint = new Coord(e.getX(), e.getY());
        env.repaint();
    }
    public void lineRelease(MouseEvent e) {
        for (LowComponent component : env.getComponentsList()) {
            if (component != this && component.isMouseOver(new Point(e.getX(), e.getY()))) {
                component.bindInput(this);
                break;
            }
        }
        rightHoldPoint = null;
        env.repaint();
    }

    private void bindInput(LowComponent comp) {
        // Check if it needs to be removed
        for (LowDataType input : inputs) {
            if (input == comp) {
                inputs.remove(comp);
                onInputRemoved(input);
                return;
            }
        }

        // Check if can be bound
        if (!canBeBound(comp)) return;

        // Bind
        LowDataType ldt = comp instanceof LowDataType ? (LowDataType) comp : null;
        inputs.add(ldt);
        onInputAdded(ldt);
    }


    public void renderLines(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(3));

        // Draw line if holding
        if (rightHoldPoint != null) {
            g.drawLine(
                componentDetails.loc().x() + componentDetails.size().width() / 2,
                componentDetails.loc().y() + componentDetails.size().height() / 2,
                rightHoldPoint.x(),
                rightHoldPoint.y()
            );
        }

        inputs.removeIf(inp -> !env.getComponentsList().contains((LowComponent) inp));

        // Draw lines to connected components
        if (inputs.isEmpty()) return;
        for (LowDataType inp : inputs) {
            LowComponent comp = (LowComponent) inp;

            g.drawLine(
                componentDetails.loc().x() + componentDetails.size().width() / 2,
                componentDetails.loc().y() + componentDetails.size().height() / 2,
                comp.componentDetails.loc().x() + comp.componentDetails.size().width() / 2,
                comp.componentDetails.loc().y() + comp.componentDetails.size().height() / 2
            );
        }
    }
    public void render(Graphics2D g) {
        g.setColor(getBackgroundColor());
        g.fillRoundRect(
            componentDetails.loc().x(),
            componentDetails.loc().y(),
            componentDetails.size().width(),
            componentDetails.size().height(),
            ROUNDING_RADIUS,
            ROUNDING_RADIUS
        );
        renderComponent(g);
    }
    public void renderOutline(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.setStroke(new BasicStroke(3));
        g.drawRoundRect(
            componentDetails.loc().x(),
            componentDetails.loc().y(),
            componentDetails.size().width(),
            componentDetails.size().height(),
            ROUNDING_RADIUS,
            ROUNDING_RADIUS
        );
    }


    // Abstracts
    public void onDoubleLeftClick(MouseEvent e) { }
    protected void onInputAdded(LowDataType inp) { }
    protected void onInputRemoved(LowDataType inp) { }

    protected abstract Color getBackgroundColor();
    protected abstract void renderComponent(Graphics2D g);
    protected abstract boolean canBeBound(LowComponent component);
}
