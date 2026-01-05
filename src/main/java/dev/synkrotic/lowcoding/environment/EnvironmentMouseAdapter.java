package dev.synkrotic.lowcoding.environment;

import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.components.types.numbers.NumberComponent;
import dev.synkrotic.lowcoding.types.LowNumber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class EnvironmentMouseAdapter extends MouseAdapter implements MouseWheelListener {
    private final Environment env;
    private LowComponent activeComponent = null;
    private Point pressPoint = null;

    private boolean isPanning = false;

    private float startOffsetX;
    private float startOffsetY;

    public EnvironmentMouseAdapter(Environment env) {
        this.env = env;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int rotation = e.getWheelRotation();
        Point worldPt = getEventPoint(e);

        for (LowComponent comp : env.getComponentsList()) {
            if (comp.isMouseOver(worldPt)) {
                if ((comp instanceof LowNumber numberComp)) {
                    float currentValue = (Float) numberComp.getValue();
                    NumberComponent numComp = (NumberComponent) numberComp;

                    if (rotation < 0) {
                        numComp.setNumber(currentValue + 1f);
                    } else {
                        numComp.setNumber(currentValue - 1f);
                    }
                    return;
                }
            }
        }

        if (!isPanning && env.getBounds().contains(e.getPoint())) {
            float oldScale = Environment.scale;

            if (rotation < 0) {
                Environment.scale *= 1.1f;
            } else {
                Environment.scale /= 1.1f;
            }

            double mouseX = e.getX();
            double mouseY = e.getY();

            Environment.offsetX = (float) (mouseX - (mouseX - Environment.offsetX) * (Environment.scale / oldScale));
            Environment.offsetY = (float) (mouseY - (mouseY - Environment.offsetY) * (Environment.scale / oldScale));

            env.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        env.requestFocusInWindow();
        if (SwingUtilities.isMiddleMouseButton(e)) {
            isPanning = true;
            pressPoint = e.getPoint();
            startOffsetX = Environment.offsetX;
            startOffsetY = Environment.offsetY;
            return;
        }

        pressPoint = e.getPoint();

        startOffsetX = Environment.offsetX;
        startOffsetY = Environment.offsetY;

        Point worldPt = getEventPoint(e);

        for (LowComponent comp : env.getComponentsList()) {
            if (comp.isMouseOver(worldPt)) {
                activeComponent = comp;
                if (SwingUtilities.isLeftMouseButton(e)) {
                    activeComponent.moveClick(translateEvent(e, worldPt));
                }
                break;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (SwingUtilities.isMiddleMouseButton(e)) {
            isPanning = true;
            Environment.offsetX = startOffsetX + (e.getX() - pressPoint.x);
            Environment.offsetY = startOffsetY + (e.getY() - pressPoint.y);
            env.repaint();
            return;
        }

        if (activeComponent == null) return;

        Point worldPt = getEventPoint(e);
        MouseEvent translatedE = translateEvent(e, worldPt);

        if (SwingUtilities.isLeftMouseButton(e)) {
            activeComponent.moveHold(translatedE);
        } else if (SwingUtilities.isRightMouseButton(e)) {
            activeComponent.lineHold(translatedE);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isMiddleMouseButton(e)) {
            isPanning = false;
            return;
        }

        if (activeComponent == null) {
            env.deselectComponent();
            return;
        }

        double distance = pressPoint.distance(e.getPoint());
        Point worldPt = getEventPoint(e);
        MouseEvent translatedE = translateEvent(e, worldPt);

        int DRAG_THRESHOLD = 5;
        if (distance < DRAG_THRESHOLD) {
            if (SwingUtilities.isRightMouseButton(e)) {
                activeComponent.lineRelease(translatedE);
            } else if (SwingUtilities.isLeftMouseButton(e)) {
                if (e.getClickCount() == 2) {
                    activeComponent.onDoubleLeftClick(translatedE);
                } else {
                    // On Single click
                    env.selectComponent(activeComponent);
                }
                activeComponent.moveRelease();
            }
        } else {
            if (SwingUtilities.isRightMouseButton(e)) {
                activeComponent.lineRelease(translatedE);
            } else if (SwingUtilities.isLeftMouseButton(e)) {
                activeComponent.moveRelease();
            }
        }

        activeComponent = null;
    }

    private Point getEventPoint(MouseEvent e) {
        int worldX = (int) ((e.getX() - Environment.offsetX) / Environment.scale);
        int worldY = (int) ((e.getY() - Environment.offsetY) / Environment.scale);
        return new Point(worldX, worldY);
    }

    private MouseEvent translateEvent(MouseEvent e, Point worldPt) {
        return new MouseEvent(
            (Component) e.getSource(), e.getID(), e.getWhen(), e.getModifiersEx(),
            worldPt.x, worldPt.y, e.getClickCount(), e.isPopupTrigger(), e.getButton()
        );
    }
}