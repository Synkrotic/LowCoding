package dev.synkrotic.lowcoding.components.gates;

import dev.synkrotic.lowcoding.components.setup.ComponentDetailsProvider;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowBoolean;
import dev.synkrotic.lowcoding.types.LowDataType;

import java.awt.*;

public class InvertComponent extends LowComponent implements LowBoolean {
    public InvertComponent(Environment env) {
        super(env, ComponentDetailsProvider.COMPONENT_DEFAULTS());
    }

    @Override
    public Object getValue() {
        for (LowDataType input : inputs) {
            return !(Boolean) input.getValue();
        }
        return false;
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(255, 50, 50);
    }

    @Override
    protected void renderComponent(Graphics2D g) {
        drawStringCentered(g, String.format("%s: %b", this, getValue()));
    }

    @Override
    protected boolean canBeBound(LowComponent component) {
        return component instanceof LowBoolean && inputs.isEmpty();
    }

    @Override
    public String toString() {
        return "Invert";
    }
}