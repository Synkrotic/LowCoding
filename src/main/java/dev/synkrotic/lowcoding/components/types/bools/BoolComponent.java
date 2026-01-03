package dev.synkrotic.lowcoding.components.types.bools;

import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.components.setup.ComponentDefaultsProvider;
import dev.synkrotic.lowcoding.types.LowBoolean;

import java.awt.*;
import java.awt.event.MouseEvent;

public class BoolComponent extends LowComponent implements LowBoolean {
    public BoolComponent(Environment env) {
        super(env, ComponentDefaultsProvider.BOOL_DEFAULTS());
    }

    @Override
    public void onLeftClick(MouseEvent e) {
        super.onLeftClick(e);
        setBoolean(!getBoolean());
    }

    public boolean getBoolean() {
        return ((BoolComponentSettings) settings).getBool();
    }
    public void setBoolean(boolean value) {
        ((BoolComponentSettings) settings).setBool(value);
    }

    @Override
    public void renderComponent(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.fillRoundRect(
            settings.loc().x(), settings.loc().y(),
            settings.size().width(), settings.size().height(),
            ROUNDING_RADIUS, ROUNDING_RADIUS
        );
        g.setColor(Color.BLACK);

        String text = "Bool: " + getBoolean();
        drawStringCentered(g, text);
    }
}
