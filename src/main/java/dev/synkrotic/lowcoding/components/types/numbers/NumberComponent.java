package dev.synkrotic.lowcoding.components.types.numbers;

import dev.synkrotic.lowcoding.components.types.DataTypeComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.components.setup.ComponentDetailsProvider;
import dev.synkrotic.lowcoding.types.LowNumber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class NumberComponent extends DataTypeComponent implements LowNumber {
    public NumberComponent(Environment env) {
        super(env, ComponentDetailsProvider.NUMBER_DEFAULTS());
    }


    @Override
    protected Color getBackgroundColor() {
        return new Color(200, 200, 255);
    }

    @Override
    public void onDoubleLeftClick(MouseEvent e) {
        SpinnerNumberModel model = new SpinnerNumberModel(0f, -Float.MAX_VALUE, Float.MAX_VALUE, 1f);
        JSpinner spinner = new JSpinner(model);

        int option = JOptionPane.showConfirmDialog(null, spinner, "Select a Number", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            float selectedNumber = ((Double) spinner.getValue()).floatValue();
            setNumber(selectedNumber);
        }
    }

    @Override
    public String toString() {
        return "Number: " + getValue();
    }

    @Override
    public Object getValue() {
        return ((NumberComponentDetails) componentDetails).getNumber();
    }
    public void setNumber(float value) {
        ((NumberComponentDetails) componentDetails).setNumber(value);
        env.repaint();
    }
}
