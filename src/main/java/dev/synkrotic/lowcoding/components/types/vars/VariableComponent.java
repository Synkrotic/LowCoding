package dev.synkrotic.lowcoding.components.types.vars;

import dev.synkrotic.lowcoding.components.setup.ComponentDetailsProvider;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;
import dev.synkrotic.lowcoding.types.LowType;

import java.awt.*;

public class VariableComponent extends LowComponent implements LowDataType {
    public VariableComponent(Environment env) {
        super(env, ComponentDetailsProvider.VARIABLE_DEFAULTS());
    }


    @Override
    protected Color getBackgroundColor() {
        return new Color(200, 255, 200);
    }

    @Override
    protected void renderComponent(Graphics2D g) {
        drawStringCentered(g, String.format("Variable: %s", getValue()));
    }

    @Override
    protected boolean canBeBound(LowComponent component) {
        return inputs.isEmpty() && component instanceof LowDataType;
    }

    @Override
    protected void onInputAdded(LowDataType inp) {
        ((VariableComponentDetails) componentDetails).setType(inp.getType());
    }
    @Override
    protected void onInputRemoved(LowDataType inp) {
        ((VariableComponentDetails) componentDetails).setType(null);
    }

    @Override
    public Object getValue() {
        if (inputs.isEmpty()) return null;
        return inputs.getFirst().getValue();
    }

    @Override
    public LowType getType() {
        return ((VariableComponentDetails) componentDetails).getType();
    }

    public String getName() {
        return ((VariableComponentDetails) componentDetails).getName();
    }
}
