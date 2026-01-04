package dev.synkrotic.lowcoding.components.conditions.predicates;

import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowNumber;

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
    public boolean getBoolean() {
        if (validateInputs()) {
            return false;
        }

        LowNumber left = (LowNumber) inputs.getFirst();
        LowNumber right = (LowNumber) inputs.getLast();
        return left.getNumber() <= right.getNumber();
    }
}
