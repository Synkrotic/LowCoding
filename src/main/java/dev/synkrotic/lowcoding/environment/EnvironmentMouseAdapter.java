package dev.synkrotic.lowcoding.components.types;

import dev.synkrotic.lowcoding.Environment;
import dev.synkrotic.lowcoding.LowComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EnvironmentMouseAdapter extends MouseAdapter {
    private final int DRAG_THRESHOLD = 5;
    private final Environment env;
    private LowComponent activeComponent = null;
    private Point pressPoint = null;

    public EnvironmentMouseAdapter(Environment env) {
        this.env = env;
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
        if (activeComponent != null && SwingUtilities.isLeftMouseButton(e)) {
            activeComponent.moveHold(e);
            activeComponent.onLeftHold(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (activeComponent != null) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                double distance = pressPoint.distance(e.getPoint());

                if (distance < DRAG_THRESHOLD) {
                    activeComponent.onLeftClick(e);
                } else {
                    activeComponent.onLeftRelease(e);
                }
                activeComponent.moveRelease();
            }
            activeComponent = null;
        }
    }
}