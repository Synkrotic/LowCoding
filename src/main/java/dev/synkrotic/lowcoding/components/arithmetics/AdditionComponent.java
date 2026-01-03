package dev.synkrotic.lowcoding.components.arithmetics;

import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowNumber;

import java.awt.*;

public class AdditionComponent extends ArithmeticComponent {
    public AdditionComponent(Environment env) {
        super(env);
    }

    @Override
    public float getNumber() {
        float total = 0f;
        for (LowComponent input : leftComponents) {
            if (input instanceof LowNumber lInput) {
                total += lInput.getNumber();
            }
        }
        return total;
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(25, 150, 50);
    }

    @Override
    public String toString() {
        return "Sum";
    }
}