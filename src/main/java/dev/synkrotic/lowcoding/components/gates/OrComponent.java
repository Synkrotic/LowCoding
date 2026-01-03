package dev.synkrotic.lowcoding.components.gates;

import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowBoolean;

import java.awt.*;

public class OrComponent extends GateComponent {
    public OrComponent(Environment env) {
        super(env);
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(200, 100, 255);
    }

    @Override
    public boolean getBoolean() {
        for (LowComponent input : leftComponents) {
            if (input instanceof LowBoolean lInput) {
                if (lInput.getBoolean()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "OR";
    }
}
