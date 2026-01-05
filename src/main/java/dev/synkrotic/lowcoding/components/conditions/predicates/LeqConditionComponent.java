package dev.synkrotic.lowcoding.components.conditions.predicates;

import dev.synkrotic.lowcoding.environment.Environment;

import java.awt.*;

public class LeqConditionComponent extends PredicateComponent {
    public LeqConditionComponent(Environment env) {
        super(env);
    }

    @Override
    public String toString() {
        return "<=";
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(0, 150, 150);
    }

    @Override
    public Object getValue() {
        if (validateInputs()) {
            return false;
        }

        Float left = (Float) inputs.getFirst().getValue();
        Float right = (Float) inputs.getLast().getValue();
        return left <= right;
    }
}
