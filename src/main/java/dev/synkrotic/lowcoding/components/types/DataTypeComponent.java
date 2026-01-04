package dev.synkrotic.lowcoding.components.types;

import dev.synkrotic.lowcoding.components.setup.ComponentSettings;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;

import java.awt.*;

public abstract class DataTypeComponent extends LowComponent {
    public DataTypeComponent(Environment env, ComponentSettings settings) {
        super(env, settings);
    }

    @Override
    protected boolean canBeBound(LowComponent component) {
        return false; // Data types cannot have bindings
    }

    @Override
    protected void renderComponent(Graphics2D g) {
        drawStringCentered(g, toString());
    }

    @Override
    public abstract String toString();

    public abstract boolean isEqualTo(LowComponent other);
}
