package dev.synkrotic.lowcoding.components.arithmetics;

import dev.synkrotic.lowcoding.components.setup.ComponentDetailsProvider;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;
import dev.synkrotic.lowcoding.types.LowNumber;
import dev.synkrotic.lowcoding.types.LowType;

import java.awt.*;

public abstract class ArithmeticComponent extends LowComponent implements LowNumber {
    public ArithmeticComponent(Environment env) {
        super(env, ComponentDetailsProvider.COMPONENT_DEFAULTS());
    }

    @Override
    protected void renderComponent(Graphics2D g) {
        drawStringCentered(g, String.format(
            "%s: %f",
            this,
            (Float) getValue()
        ));
    }

    @Override
    protected boolean canBeBound(LowComponent component) {
        return (component instanceof LowDataType ldt)
            && ldt.getType().equals(LowType.NUMBER);
    }

    @Override
    public abstract String toString();
}
