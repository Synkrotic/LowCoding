package dev.synkrotic.lowcoding.components.types.numbers;

import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.components.setup.ComponentDefaultsProvider;
import dev.synkrotic.lowcoding.types.LowNumber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class NumberComponent extends LowComponent implements LowNumber {
    public NumberComponent(Environment env) {
        super(env, ComponentDefaultsProvider.NUMBER_DEFAULTS());
    }

    @Override
    public float getNumber() {
        return ((NumberComponentSettings) settings).getNumber();
    }
    public void setNumber(float value) {
        ((NumberComponentSettings) settings).setNumber(value);
        env.repaint();
    }


    @Override
    protected Color getBackgroundColor() {
        return new Color(200, 200, 255);
    }

    @Override
    public void onLeftClick(MouseEvent e) {
        super.onLeftClick(e);

        SpinnerNumberModel model = new SpinnerNumberModel(0f, -Float.MAX_VALUE, Float.MAX_VALUE, 1f);
        JSpinner spinner = new JSpinner(model);

        int option = JOptionPane.showConfirmDialog(null, spinner, "Select a Number", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            float selectedNumber = ((Double) spinner.getValue()).floatValue();
            setNumber(selectedNumber);
        }
    }

    @Override
    protected void renderComponent(Graphics2D g) {
        String text = "Number: " + getNumber();
        drawStringCentered(g, text);
    }
}
