package dev.synkrotic.lowcoding.menu;

import dev.synkrotic.lowcoding.components.arithmetics.AdditionComponent;
import dev.synkrotic.lowcoding.components.arithmetics.InvertComponent;
import dev.synkrotic.lowcoding.components.arithmetics.DivisionComponent;
import dev.synkrotic.lowcoding.components.arithmetics.MultiplyComponent;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.components.types.numbers.NumberComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.components.types.bools.BoolComponent;

import javax.swing.*;
import java.util.Map;

public class Menu extends JPanel {
    private final Map<String, Class<? extends LowComponent>> componentTypes = Map.of(
        "Boolean", BoolComponent.class,
        "Number", NumberComponent.class,
        "Sum", AdditionComponent.class,
        "Invert", InvertComponent.class,
        "Multiply", MultiplyComponent.class,
        "Divide", DivisionComponent.class
    );

    public Menu(Environment env) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        addComponentButtons(env);
    }

    private void addComponentButtons(Environment env) {
        for (Map.Entry<String, Class<? extends LowComponent>> entry : componentTypes.entrySet()) {
            NewComponentButton button = new NewComponentButton(env, entry.getKey(), entry.getValue());
            button.setAlignmentX(CENTER_ALIGNMENT);
            add(button);
        }
    }
}
