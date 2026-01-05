package dev.synkrotic.lowcoding.components.actions;

import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;
import dev.synkrotic.lowcoding.types.LowType;

import java.awt.*;

public class PrintComponent extends ActionComponent {
    public PrintComponent(Environment env) {
        super(env);
    }

    @Override
    protected void execute() {
        if (inputs.isEmpty()) return;

        for (LowDataType input : inputs) {
            if (!input.getType().equals(LowType.TEXT)) continue;

            System.out.println(input.getValue());
        }
    }

    @Override
    protected boolean canBeBound(LowComponent component) {
        // Max 2 inputs
        if (inputs.size() > 1) return false;

        // Allow one LowText and one LowBoolean
        if (component instanceof LowDataType ldt) {
            if (ldt.getType().equals(LowType.TEXT)) {
                return inputs.stream().noneMatch(input ->
                    input instanceof LowDataType inputLdt
                        && inputLdt.getType().equals(LowType.TEXT));
            } else if (ldt.getType().equals(LowType.BOOLEAN)) {
                return inputs.stream().noneMatch(input ->
                    input instanceof LowDataType inputLdt
                        && inputLdt.getType().equals(LowType.BOOLEAN));
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Print";
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(182, 98, 98);
    }
}
