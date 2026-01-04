package dev.synkrotic.lowcoding.components.conditions.predicates;

import dev.synkrotic.lowcoding.components.conditions.ConditionComponent;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowNumber;

public abstract class PredicateComponent extends ConditionComponent {
    public PredicateComponent(Environment env) {
        super(env);
    }

    @Override
    public boolean canBeBound(LowComponent component) {
        return inputs.size() < 2 && component instanceof LowNumber;
    }

    protected boolean validateInputs() {
        return inputs.isEmpty() || inputs.size() < 2
            || (!(inputs.getFirst() instanceof LowNumber) || !(inputs.getLast() instanceof LowNumber));
    }
}
