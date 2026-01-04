package dev.synkrotic.lowcoding.menu;

import dev.synkrotic.lowcoding.components.arithmetics.AdditionComponent;
import dev.synkrotic.lowcoding.components.arithmetics.DivisionComponent;
import dev.synkrotic.lowcoding.components.arithmetics.MultiplyComponent;
import dev.synkrotic.lowcoding.components.arithmetics.NegateComponent;
import dev.synkrotic.lowcoding.components.conditions.EqualsConditionComponent;
import dev.synkrotic.lowcoding.components.conditions.predicates.GeqConditionComponent;
import dev.synkrotic.lowcoding.components.conditions.predicates.GtrConditionComponent;
import dev.synkrotic.lowcoding.components.conditions.predicates.LeqConditionComponent;
import dev.synkrotic.lowcoding.components.conditions.predicates.LssConditionComponent;
import dev.synkrotic.lowcoding.components.gates.AndComponent;
import dev.synkrotic.lowcoding.components.gates.InvertComponent;
import dev.synkrotic.lowcoding.components.gates.OrComponent;
import dev.synkrotic.lowcoding.components.gates.XorComponent;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.components.types.numbers.NumberComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.components.types.bools.BoolComponent;

import javax.swing.*;
import java.util.Map;

public class Menu extends JPanel {
    private final Map<String, Class<? extends LowComponent>> componentTypes = Map.ofEntries(
        // Inputs
        Map.entry("Boolean", BoolComponent.class),
        Map.entry("Number", NumberComponent.class),

        // Arithmetics
        Map.entry("Sum", AdditionComponent.class),
        Map.entry("Negate", NegateComponent.class),
        Map.entry("Multiply", MultiplyComponent.class),
        Map.entry("Divide", DivisionComponent.class),

        // Conditions
        Map.entry("Equals", EqualsConditionComponent.class),
        Map.entry("Less Than", LssConditionComponent.class),
        Map.entry("Less Equals", LeqConditionComponent.class),
        Map.entry("Greater Than", GtrConditionComponent.class),
        Map.entry("Greater Equals", GeqConditionComponent.class),

        // Gates
        Map.entry("Invert", InvertComponent.class),
        Map.entry("AND", AndComponent.class),
        Map.entry("OR", OrComponent.class),
        Map.entry("XOR", XorComponent.class)
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
