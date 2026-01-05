package dev.synkrotic.lowcoding.components.conditions;

import dev.synkrotic.lowcoding.components.setup.ComponentDetailsProvider;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowBoolean;
import dev.synkrotic.lowcoding.types.LowDataType;
import dev.synkrotic.lowcoding.types.LowType;

import java.awt.*;

public abstract class ConditionComponent extends LowComponent implements LowBoolean {
    public ConditionComponent(Environment env) {
        super(env, ComponentDetailsProvider.COMPONENT_DEFAULTS());
    }

    @Override
    protected void renderComponent(Graphics2D g) {
        drawStringCentered(g, String.format("%s, %b", this, this.getValue()));
    }

    @Override
    protected boolean canBeBound(LowComponent component) {
        // Max 2 inputs of any datatype
        if (inputs.size() >= 2 || !(component instanceof LowDataType secondInput)) return false;

        // First input can be of any datatype
        if (inputs.isEmpty() || inputs.getFirst() == null) return true;

        // Both inputs must be of the same type
        LowDataType firstInput = inputs.getFirst() instanceof LowDataType ldt ? ldt : null;

        // Check if none null
        assert firstInput != null;
        LowType firstType = firstInput.getType();
        LowType secondType = secondInput.getType();
        if (firstType == null || secondType == null) return false;

        return firstType.equals(secondType);
    }

    @Override
    public abstract String toString();
}
