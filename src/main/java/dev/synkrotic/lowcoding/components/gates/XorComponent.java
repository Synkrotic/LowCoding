package dev.synkrotic.lowcoding.components.gates;

import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;

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
    public Object getValue() {
        return inputs.stream()
                .map(LowDataType::getValue)
                .filter(b -> (boolean) b)
                .count() == 1;
    }
}
