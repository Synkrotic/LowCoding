package dev.synkrotic.lowcoding.components.arithmetics;

import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;
import dev.synkrotic.lowcoding.types.LowNumber;
import dev.synkrotic.lowcoding.types.LowType;

import java.awt.*;

public class NegateComponent extends ArithmeticComponent {
    public NegateComponent(Environment env) {
        super(env);
    }

    @Override
    public Object getValue() {
        float total = 0f;
        for (LowComponent lowComp : inputs) {
            LowDataType input = (LowDataType) lowComp;
            if (input.getType().equals(LowType.NUMBER)) {
                total -= (Float) input.getValue();
            }
        }
        return total;
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(255, 50, 50);
    }

    @Override
    protected boolean canBeBound(LowComponent component) {
        return component instanceof LowNumber && inputs.isEmpty();
    }

    @Override
    public String toString() {
        return "Negation";
    }
}