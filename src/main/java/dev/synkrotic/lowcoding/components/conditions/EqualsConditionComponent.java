package dev.synkrotic.lowcoding.components.conditions;

import dev.synkrotic.lowcoding.components.types.DataTypeComponent;
import dev.synkrotic.lowcoding.environment.Environment;

import java.awt.*;

public class EqualsConditionComponent extends ConditionComponent {
    public EqualsConditionComponent(Environment env) {
        super(env);
    }


    @Override
    public String toString() {
        return "Equals";
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(140, 138, 131);
    }

    @Override
    public boolean getBoolean() {
        if (inputs.size() < 2 || inputs.get(0) == null || inputs.get(1) == null) {
            return false;
        }

        if (inputs.getFirst() instanceof DataTypeComponent firstData
                && inputs.getLast() instanceof DataTypeComponent lastData) {
            return firstData.isEqualTo(lastData);
        }
        return false;
    }
}
