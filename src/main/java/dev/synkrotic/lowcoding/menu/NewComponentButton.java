package dev.synkrotic.lowcoding.menu;

import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.geo.Coord;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class NewComponentButton extends JButton {
    private final Class<? extends LowComponent> componentClass;
    private final Environment env;

    public NewComponentButton(Environment env, String label, Class<? extends LowComponent> componentClass) {
        this.env = env;
        this.componentClass = componentClass;

        setText(label);
        addActionListener(_ -> newInstance());
    }

    private void newInstance() {
        try {
            LowComponent component = componentClass
                .getConstructor(Environment.class)
                .newInstance(env);
            component.setLocation(new Coord(150, 50));

            env.addComponent(component);

            System.out.println(env.getComponentsList().size() + " components in environment.");
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}