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
    public void renderComponent(Graphics2D g) {
        g.setColor(new Color(200, 200, 255));
        g.fillRoundRect(
            settings.loc().x(), settings.loc().y(),
            settings.size().width(), settings.size().height(),
            ROUNDING_RADIUS, ROUNDING_RADIUS
        );
        g.setColor(Color.BLACK);

        String text = "Number: " + getNumber();
        drawStringCentered(g, text);
    }
}
