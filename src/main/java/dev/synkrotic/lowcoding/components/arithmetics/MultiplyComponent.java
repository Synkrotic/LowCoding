package dev.synkrotic.lowcoding.components.arithmetics;

import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;
import dev.synkrotic.lowcoding.types.LowType;

import java.awt.*;

public class MultiplyComponent extends ArithmeticComponent {
    public MultiplyComponent(Environment env) {
        super(env);
    }

    @Override
    public Object getValue() {
        float total = 1f;
        for (LowComponent lowComp : inputs) {
            LowDataType input = (LowDataType) lowComp;
            if (input.getType().equals(LowType.NUMBER)) {
                total *= (Float) input.getValue();
            }
        }
        return total;
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(215, 181, 52);
    }

    @Override
    public String toString() {
        return "Multiply";
    }
}