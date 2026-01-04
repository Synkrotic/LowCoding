package dev.synkrotic.lowcoding.components.gates;

import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowBoolean;

import java.awt.*;

public class XorComponent extends GateComponent {
    public XorComponent(Environment env) {
        super(env);
    }

    @Override
    public String toString() {
        return "XOR";
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(133, 108, 75);
    }

    @Override
    public boolean getBoolean() {
        return inputs.stream()
                .map(input -> ((LowBoolean) input).getBoolean())
                .filter(b -> b)
                .count() == 1;
    }
}
