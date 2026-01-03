package dev.synkrotic.lowcoding.components.setup;

import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.geo.Coord;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public abstract class LowComponent {
    public static final int ROUNDING_RADIUS = 10;

    private Coord rightHoldPoint = null;

    protected final ComponentSettings settings;
    protected final Environment env;

    protected final List<LowComponent> inputs = new ArrayList<>();

    public Coord leftClickOffset = null;


    public LowComponent(Environment env, ComponentSettings settings) {
        this.settings = settings;
        this.env = env;
    }

    protected void drawStringCentered(Graphics2D g, String text) {
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();
        int x = settings.loc().x() + (settings.size().width() - textWidth) / 2;
        int y = settings.loc().y() + (settings.size().height() - textHeight) / 2 + fm.getAscent();

        g.setColor(Color.BLACK);
        g.drawString(text, x, y);
    }

    public boolean isMouseOver(Point mousePos) {
        return mousePos.x >= settings.loc().x() &&
            mousePos.x <= settings.loc().x() + settings.size().width() &&
            mousePos.y >= settings.loc().y() &&
            mousePos.y <= settings.loc().y() + settings.size().height();
    }

    public void setLocation(Coord location) {
        settings.setLoc(location);
    }


    public void moveClick(MouseEvent e) {
        leftClickOffset = new Coord(
            e.getX() - settings.loc().x(),
            e.getY() - settings.loc().y()
        );
    }
    public void moveHold(MouseEvent e) {
        if (leftClickOffset != null) {
            int scaledMouseX = e.getX();
            int scaledMouseY = e.getY();

            int newX = scaledMouseX - leftClickOffset.x();
            int newY = scaledMouseY - leftClickOffset.y();

            settings.setLoc(new Coord(newX, newY));
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
                if (component.inputs.contains(this)) {
                    component.inputs.remove(this);
                    break;
                }

                component.inputs.add(this);
                break;
            }
        }
        rightHoldPoint = null;
        env.repaint();
    }


    public void renderLines(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(3));

        // Draw line if holding
        if (rightHoldPoint != null) {
            g.drawLine(
                settings.loc().x() + settings.size().width() / 2,
                settings.loc().y() + settings.size().height() / 2,
                rightHoldPoint.x(),
                rightHoldPoint.y()
            );
        }

        // Draw lines to connected components
        for (LowComponent comp : inputs) {
            g.drawLine(
                settings.loc().x() + settings.size().width() / 2,
                settings.loc().y() + settings.size().height() / 2,
                comp.settings.loc().x() + comp.settings.size().width() / 2,
                comp.settings.loc().y() + comp.settings.size().height() / 2
            );
        }
    }

    public void render(Graphics2D g) {
        g.setColor(getBackgroundColor());
        g.fillRoundRect(
            settings.loc().x(),
            settings.loc().y(),
            settings.size().width(),
            settings.size().height(),
            ROUNDING_RADIUS,
            ROUNDING_RADIUS
        );
        renderComponent(g);
    }

    // Abstracts
    public void onLeftClick(MouseEvent e) { }
    public void onDoubleLeftClick(MouseEvent e) { }

    protected abstract Color getBackgroundColor();

    protected abstract void renderComponent(Graphics2D g);
}
