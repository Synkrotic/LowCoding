package dev.synkrotic.lowcoding;

import dev.synkrotic.lowcoding.components.types.setup.ComponentSettings;
import dev.synkrotic.lowcoding.geo.Coord;

import java.awt.*;
import java.awt.event.MouseEvent;


public abstract class LowComponent {
    public static final int ROUNDING_RADIUS = 10;

    protected final ComponentSettings settings;
    protected final Environment env;

    public Point clickOffset = null;


    public LowComponent(Environment env, ComponentSettings settings) {
        this.settings = settings;
        this.env = env;
    }

    public void moveClick(MouseEvent e) {
        clickOffset = new Point(
            e.getX() - settings.loc().x(),
            e.getY() - settings.loc().y()
        );
    }
    public void moveHold(MouseEvent e) {
        if (clickOffset != null) {
            int newX = e.getX() - clickOffset.x;
            int newY = e.getY() - clickOffset.y;

            settings.setLoc(new Coord(newX, newY));
            env.repaint();
        }
    }
    public void moveRelease() {
        clickOffset = null;
        env.repaint();
    }

    public boolean isMouseOver(Point mousePos) {
        return mousePos.x >= settings.loc().x() && mousePos.x <= settings.loc().x() + settings.size().width() &&
               mousePos.y >= settings.loc().y() && mousePos.y <= settings.loc().y() + settings.size().height();
    }

    public void setLocation(Coord location) {
        settings.setLoc(location);
    }


    // Abstracts
    public void onLeftClick(MouseEvent e) { }
    public void onLeftHold(MouseEvent e) { }
    public void onLeftRelease(MouseEvent e) { }
    public void onRightClick(MouseEvent e) { }
    public void onRightHold(MouseEvent e) { }
    public void onRightRelease(MouseEvent e) { }

    public abstract void render(Graphics2D g);
}
