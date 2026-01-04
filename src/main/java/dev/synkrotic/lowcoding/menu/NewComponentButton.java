package dev.synkrotic.lowcoding.menu;

import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.geo.Coord;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class NewComponentButton extends JButton {
    private final Class<? extends LowComponent> componentClass;
    private final Environment env;

    public NewComponentButton(Environment env, String label, Class<? extends LowComponent> componentClass) {
        this.env = env;
        this.componentClass = componentClass;

        setText(label);
        setAlignmentX(CENTER_ALIGNMENT);
        addActionListener(_ -> newInstance());
    }

    private void newInstance() {
        try {
            LowComponent component = componentClass
                .getConstructor(Environment.class)
                .newInstance(env);

            Coord centerWorldCoords = Environment.toWorldCoordinates(
                new Coord(env.getWidth() / 2, env.getHeight() / 2));
            component.setLocation(centerWorldCoords.offset(
                -component.getSize().width() / 2,
                -component.getSize().height() / 2
            ));

            env.addComponent(component);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(150, 50);
    }
}