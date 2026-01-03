package dev.synkrotic.lowcoding.components.arithmetics;

import dev.synkrotic.lowcoding.components.setup.ComponentDefaultsProvider;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowNumber;

import java.awt.*;

public class DivisionComponent extends ArithmeticComponent {
    public DivisionComponent(Environment env) {
        super(env, ComponentDefaultsProvider.COMPONENT_DEFAULTS());
    }

    @Override
    public float getNumber() {
        float total = 0f;
        for (LowComponent input : leftComponents) {
            if (input instanceof LowNumber lInput) {
                if (total == 0f) {
                    total = lInput.getNumber();
                } else if (lInput.getNumber() != 0f) {
                    total /= lInput.getNumber();
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