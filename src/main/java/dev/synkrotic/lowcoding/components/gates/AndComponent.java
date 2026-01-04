package dev.synkrotic.lowcoding.components.gates;

import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;
import dev.synkrotic.lowcoding.types.LowType;

import java.awt.*;

public class AndComponent extends GateComponent {
    public AndComponent(Environment env) {
        super(env);
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(100, 200, 255);
    }

    @Override
    public Object getValue() {
        for (LowDataType input : inputs) {
            if (input.getType().equals(LowType.BOOLEAN)
                    && !((Boolean) input.getValue())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "AND";
    }
}
