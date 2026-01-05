package dev.synkrotic.lowcoding.components.conditions.predicates;

import dev.synkrotic.lowcoding.components.conditions.ConditionComponent;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;
import dev.synkrotic.lowcoding.types.LowType;

public abstract class PredicateComponent extends ConditionComponent {
    public PredicateComponent(Environment env) {
        super(env);
    }

    @Override
    public boolean canBeBound(LowComponent component) {
        return inputs.size() < 2
            && (component instanceof LowDataType ldt)
            && ldt.getType() != null
            && ldt.getType().equals(LowType.NUMBER);
    }

    protected boolean validateInputs() {
        if (inputs.size() != 2) return true;

        if ((inputs.getFirst() instanceof LowDataType ldtF)
                && ldtF.getType().equals(LowType.NUMBER)) {
            return false;
        }

        return !((inputs.getLast() instanceof LowDataType ldtL)
            && ldtL.getType().equals(LowType.NUMBER));
    }
}
