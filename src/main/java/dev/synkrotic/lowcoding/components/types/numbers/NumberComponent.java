package dev.synkrotic.lowcoding.components.types.numbers;

import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.components.setup.ComponentDefaultsProvider;
import dev.synkrotic.lowcoding.types.LowNumber;

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
        setNumber(getNumber() + 1.0f);
    }
    @Override
    public void onRightClick(MouseEvent e) {
        super.onRightClick(e);
        setNumber(getNumber() - 1.0f);
    }

    @Override
    protected void renderComponent(Graphics2D g) {
        String text = "Number: " + getNumber();
        drawStringCentered(g, text);
    }
}
