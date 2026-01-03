package dev.synkrotic.lowcoding.components.arithmetics;

import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowNumber;

import java.awt.*;

public class MultiplyComponent extends ArithmeticComponent {
    public MultiplyComponent(Environment env) {
        super(env);
    }

    @Override
    public float getNumber() {
        float total = 1f;
        for (LowComponent input : inputs) {
            if (input instanceof LowNumber lInput) {
                total *= lInput.getNumber();
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