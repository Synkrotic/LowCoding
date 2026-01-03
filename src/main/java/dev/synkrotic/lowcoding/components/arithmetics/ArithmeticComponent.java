package dev.synkrotic.lowcoding.components.arithmetics;

import dev.synkrotic.lowcoding.components.setup.ComponentSettings;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowNumber;

import java.awt.*;

public abstract class ArithmeticComponent extends LowComponent implements LowNumber {
    public ArithmeticComponent(Environment env, ComponentSettings settings) {
        super(env, settings);
    }

    protected abstract Color getBackgroundColor();

    @Override
    public void renderComponent(Graphics2D g) {
        g.setColor(getBackgroundColor());
        g.fillRoundRect(
            settings.loc().x(), settings.loc().y(),
            settings.size().width(), settings.size().height(),
            ROUNDING_RADIUS, ROUNDING_RADIUS
        );
        g.setColor(Color.BLACK);

        drawStringCentered(g, String.format("%s: %f", this, getNumber()));
    }

    @Override
    public abstract String toString();
}
