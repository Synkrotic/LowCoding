package dev.synkrotic.lowcoding.components.gates;

import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowBoolean;

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
    public boolean getBoolean() {
        for (LowComponent input : inputs) {
            if (input instanceof LowBoolean lInput) {
                if (!lInput.getBoolean()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "AND";
    }
}
