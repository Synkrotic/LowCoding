package dev.synkrotic.lowcoding.components.operations.addition;

import dev.synkrotic.lowcoding.components.setup.ComponentDefaultsProvider;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.components.types.numbers.NumberComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowNumber;

import java.awt.*;

public class AdditionComponent extends LowComponent implements LowNumber {
    public AdditionComponent(Environment env) {
        super(env, ComponentDefaultsProvider.COMPONENT_DEFAULTS());
    }

    @Override
    public float getNumber() {
        float total = 0f;
        for (LowComponent input : leftComponents) {
            if (input instanceof LowNumber lInput) {
                total += lInput.getNumber();
            }
        }
        return total;
    }

    @Override
    public void renderComponent(Graphics2D g) {
        g.setColor(new Color(255, 255, 200));
        g.fillRoundRect(
            settings.loc().x(), settings.loc().y(),
            settings.size().width(), settings.size().height(),
            ROUNDING_RADIUS, ROUNDING_RADIUS
        );
        g.setColor(Color.BLACK);

        drawStringCentered(g, String.format("Sum: %f", getNumber()));
    }
}