package dev.synkrotic.lowcoding.components.conditions.predicates;

import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowNumber;

import java.awt.*;

public class GeqConditionComponent extends PredicateComponent {
    public GeqConditionComponent(Environment env) {
        super(env);
    }

    @Override
    public String toString() {
        return ">=";
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(150, 0, 150);
    }

    @Override
    public boolean getBoolean() {
        if (validateInputs()) {
            return false;
        }

        LowNumber left = (LowNumber) inputs.getFirst();
        LowNumber right = (LowNumber) inputs.getLast();
        return left.getNumber() >= right.getNumber();
    }
}
