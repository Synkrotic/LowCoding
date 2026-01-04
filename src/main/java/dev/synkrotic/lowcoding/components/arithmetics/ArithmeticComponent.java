package dev.synkrotic.lowcoding.components.arithmetics;

import dev.synkrotic.lowcoding.components.setup.ComponentDefaultsProvider;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowNumber;

import java.awt.*;

public abstract class ArithmeticComponent extends LowComponent implements LowNumber {
    public ArithmeticComponent(Environment env) {
        super(env, ComponentDefaultsProvider.COMPONENT_DEFAULTS());
    }

    @Override
    protected void renderComponent(Graphics2D g) {
        drawStringCentered(g, String.format("%s: %f", this, getNumber()));
    }

    @Override
    protected boolean canBeBound(LowComponent component) {
        return component instanceof LowNumber;
    }

    @Override
    public abstract String toString();
}
