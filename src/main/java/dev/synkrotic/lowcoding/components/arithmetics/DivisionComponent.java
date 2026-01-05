package dev.synkrotic.lowcoding.components.arithmetics;

import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;
import dev.synkrotic.lowcoding.types.LowType;

import java.awt.*;

public class DivisionComponent extends ArithmeticComponent {
    public DivisionComponent(Environment env) {
        super(env);
    }

    @Override
    public Object getValue() {
        float total = 0f;
        for (LowComponent lowComp : inputs) {
            LowDataType input = (LowDataType) lowComp;
            if (input.getType().equals(LowType.NUMBER)) {
                float value = (Float) input.getValue();
                if (total == 0f) {
                    total = value;
                } else if (value != 0f) {
                    total /= value;
                }
            }
        }
        return total;
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(239, 119, 148);
    }

    @Override
    public String toString() {
        return "Division";
    }
}