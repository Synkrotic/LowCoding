package dev.synkrotic.lowcoding.components.conditions.predicates;

import dev.synkrotic.lowcoding.components.conditions.ConditionComponent;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;
import dev.synkrotic.lowcoding.types.LowNumber;
import dev.synkrotic.lowcoding.types.LowType;

public abstract class PredicateComponent extends ConditionComponent {
    public PredicateComponent(Environment env) {
        super(env);
    }

    @Override
    public boolean canBeBound(LowComponent component) {
        return inputs.size() < 2
            && (component instanceof LowDataType ldt)
            && ldt.getType().equals(LowType.NUMBER);
    }

    protected boolean validateInputs() {
        return inputs.isEmpty() || inputs.size() < 2
            || (!(inputs.getFirst() instanceof LowNumber) || !(inputs.getLast() instanceof LowNumber));
    }
}
