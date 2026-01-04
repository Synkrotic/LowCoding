package dev.synkrotic.lowcoding.components.conditions;

import dev.synkrotic.lowcoding.components.setup.ComponentDefaultsProvider;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.components.types.DataTypeComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowBoolean;

import java.awt.*;

public abstract class ConditionComponent extends LowComponent implements LowBoolean {
    public ConditionComponent(Environment env) {
        super(env, ComponentDefaultsProvider.COMPONENT_DEFAULTS());
    }

    @Override
    protected void renderComponent(Graphics2D g) {
        drawStringCentered(g, String.format("%s, %b", this, getBoolean()));
    }

    @Override
    protected boolean canBeBound(LowComponent component) {
        // Max 2 inputs of any datatype
        if (inputs.size() >= 2 && !(component instanceof DataTypeComponent)) return false;

        // First input can be of any datatype
        if (inputs.isEmpty() || inputs.getFirst() == null) return true;

        // Both inputs must be of the same type
        System.out.println(inputs.getFirst().getClass().equals(component.getClass()));
        return inputs.getFirst().getClass().equals(component.getClass());
    }

    @Override
    public abstract String toString();
}
