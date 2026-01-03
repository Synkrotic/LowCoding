package dev.synkrotic.lowcoding.components.arithmetics;

import dev.synkrotic.lowcoding.components.setup.ComponentDefaultsProvider;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowNumber;

import java.awt.*;

public class SubtractionComponent extends ArithmeticComponent {
    public SubtractionComponent(Environment env) {
        super(env, ComponentDefaultsProvider.COMPONENT_DEFAULTS());
    }

    @Override
    public float getNumber() {
        float total = 0f;
        for (LowComponent input : leftComponents) {
            if (input instanceof LowNumber lInput) {
                total -= lInput.getNumber();
            }
        }
        return total;
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(255, 50, 50);
    }

    @Override
    public String toString() {
        return "";
    }
}