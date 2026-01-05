package dev.synkrotic.lowcoding.components.types.vars;

import dev.synkrotic.lowcoding.components.setup.ComponentDetailsProvider;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;
import dev.synkrotic.lowcoding.types.LowType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

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
        drawStringCentered(g, String.format("%s: %s", getName(), getValue()));
    }

    @Override
    public void onDoubleLeftClick(MouseEvent e) {
        String name = JOptionPane.showInputDialog("Name your variable...");
        if (name != null && !name.isBlank()) {
            ((VariableComponentDetails) componentDetails).setName(name);
            env.repaint();
        }
    }

    @Override
    protected boolean canBeBound(LowComponent component) {
        return inputs.isEmpty() && component instanceof LowDataType;
    }

    @Override
    protected void onInputAdded(LowComponent inp) {
        ((VariableComponentDetails) componentDetails).setType(((LowDataType) inp).getType());
    }
    @Override
    protected void onInputRemoved(LowComponent inp) {
        ((VariableComponentDetails) componentDetails).setType(null);
    }

    @Override
    public Object getValue() {
        if (inputs.isEmpty()) {
            return syncVariable();
        }
        return ((LowDataType) inputs.getFirst()).getValue();
    }

    @Override
    public LowType getType() {
        return ((VariableComponentDetails) componentDetails).getType();
    }

    private Object syncVariable() {
        VariableComponent var = env.getVariableByName(getName());
        if (var == null) return null;
        else if (var != this) {
            ((VariableComponentDetails) componentDetails).setType(var.getType());
            return var.getValue();
        }
        env.repaint();
        return null;
    }

    public String getName() {
        return ((VariableComponentDetails) componentDetails).getName();
    }
}
