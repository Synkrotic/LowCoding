package dev.synkrotic.lowcoding.environment;

import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.components.types.numbers.NumberComponent;

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

    public EnvironmentMouseAdapter(Environment env) {
        this.env = env;
    }


    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int rotation = e.getWheelRotation();

        for (LowComponent comp : env.getComponentsList()) {
            if (comp.isMouseOver(e.getPoint())) {
                if (comp instanceof NumberComponent numberComp) {
                    float currentValue = numberComp.getNumber();

                    if (rotation < 0) {
                        numberComp.setNumber(currentValue + 1f);
                    } else {
                        numberComp.setNumber(currentValue - 1f);
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressPoint = e.getPoint();

        for (LowComponent comp : env.getComponentsList()) {
            if (comp.isMouseOver(e.getPoint())) {
                activeComponent = comp;
                if (SwingUtilities.isLeftMouseButton(e)) {
                    activeComponent.moveClick(e);
                }

                break;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (activeComponent == null) return;

        if (SwingUtilities.isLeftMouseButton(e)) {
            activeComponent.moveHold(e);
            activeComponent.onLeftHold(e);
        } else if (SwingUtilities.isRightMouseButton(e)) {
            activeComponent.lineHold(e);
            activeComponent.onRightHold(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (activeComponent != null) {
            double distance = pressPoint.distance(e.getPoint());

            int DRAG_THRESHOLD = 5;
            if (distance < DRAG_THRESHOLD) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    activeComponent.onRightClick(e);
                    activeComponent.lineRelease(e);
                } else if (SwingUtilities.isLeftMouseButton(e)) {
                    activeComponent.onLeftClick(e);
                    activeComponent.moveRelease();
                }
            } else {
                if (SwingUtilities.isRightMouseButton(e)) {
                    activeComponent.onRightRelease(e);
                    activeComponent.lineRelease(e);
                } else if (SwingUtilities.isLeftMouseButton(e)) {
                    activeComponent.onLeftRelease(e);
                    activeComponent.moveRelease();
                }
            }

            activeComponent = null;
        }
    }
}