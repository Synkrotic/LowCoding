package dev.synkrotic.lowcoding.components.gates;

import dev.synkrotic.lowcoding.components.setup.ComponentDefaultsProvider;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowBoolean;

import java.awt.*;

public abstract class GateComponent extends LowComponent implements LowBoolean {

    public GateComponent(Environment env) {
        super(env, ComponentDefaultsProvider.COMPONENT_DEFAULTS());
    }

    @Override
    protected void renderComponent(Graphics2D g) {
        drawStringCentered(g, String.format("%s: %b", this, getBoolean()));
    }

    @Override
    public abstract String toString();
}
