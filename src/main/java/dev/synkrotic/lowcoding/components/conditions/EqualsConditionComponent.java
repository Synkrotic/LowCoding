package dev.synkrotic.lowcoding.components.conditions;

import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;

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
    public Object getValue() {
        if (inputs.size() < 2 || inputs.get(0) == null || inputs.get(1) == null) {
            return false;
        }
        System.out.println("2 inputs");

        if (inputs.getFirst() instanceof LowDataType firstData
                && inputs.getLast() instanceof LowDataType lastData) {
            return firstData.isEqualTo(lastData);
        }
        return false;
    }
}
