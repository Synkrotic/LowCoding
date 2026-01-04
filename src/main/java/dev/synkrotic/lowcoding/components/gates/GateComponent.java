package dev.synkrotic.lowcoding.components.gates;

import dev.synkrotic.lowcoding.components.setup.ComponentDetailsProvider;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowBoolean;
import dev.synkrotic.lowcoding.types.LowDataType;
import dev.synkrotic.lowcoding.types.LowType;

import java.awt.*;

public abstract class GateComponent extends LowComponent implements LowBoolean {

    public GateComponent(Environment env) {
        super(env, ComponentDetailsProvider.COMPONENT_DEFAULTS());
    }

    @Override
    protected void renderComponent(Graphics2D g) {
        drawStringCentered(g, String.format("%s: %b", this, getValue()));
    }

    @Override
    protected boolean canBeBound(LowComponent component) {
        return inputs.size() < 2
            && (component instanceof LowDataType ldt)
            && ldt.getType().equals(LowType.BOOLEAN);
    }

    @Override
    public abstract String toString();
}
