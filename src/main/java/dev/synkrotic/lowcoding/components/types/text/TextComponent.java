package dev.synkrotic.lowcoding.components.types.text;

import dev.synkrotic.lowcoding.components.types.DataTypeComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.components.setup.ComponentDetailsProvider;
import dev.synkrotic.lowcoding.types.LowText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class TextComponent extends DataTypeComponent implements LowText {
    public TextComponent(Environment env) {
        super(env, ComponentDetailsProvider.TEXT_DEFAULTS());
    }


    @Override
    protected Color getBackgroundColor() {
        return new Color(72, 131, 162);
    }

    @Override
    public void onDoubleLeftClick(MouseEvent e) {
        String input = JOptionPane.showInputDialog(null, "Enter Text:", "Text Input", JOptionPane.PLAIN_MESSAGE);

        if (input != null) {
            setText(input);
        }
    }

    @Override
    public String toString() {
        return "Text: " + getValue();
    }

    @Override
    public Object getValue() {
        return ((TextComponentDetails) componentDetails).getText();
    }
    public void setText(String value) {
        ((TextComponentDetails) componentDetails).setText(value);
        env.repaint();
    }
}
