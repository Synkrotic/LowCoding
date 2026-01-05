package dev.synkrotic.lowcoding.components.conditions.predicates;

import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;

import java.awt.*;

public class LssConditionComponent extends PredicateComponent {
    public LssConditionComponent(Environment env) {
        super(env);
    }

    @Override
    public String toString() {
        return "<";
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(0, 0, 200);
    }

    @Override
    public Object getValue() {
        if (validateInputs()) {
            return false;
        }

        Float left = (Float) ((LowDataType) inputs.getFirst()).getValue();
        Float right = (Float) ((LowDataType) inputs.getLast()).getValue();
        return left < right;
    }
}
