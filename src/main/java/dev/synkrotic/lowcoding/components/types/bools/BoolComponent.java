package dev.synkrotic.lowcoding.components.types;

import dev.synkrotic.lowcoding.Environment;
import dev.synkrotic.lowcoding.LowComponent;
import dev.synkrotic.lowcoding.components.types.setup.ComponentDefaultsProvider;

import java.awt.*;
import java.awt.event.MouseEvent;

public class BoolComponent extends LowComponent {
    public BoolComponent(Environment env) {
        super(env, ComponentDefaultsProvider.BOOL_DEFAULTS());
    }

    @Override
    public void onLeftClick(MouseEvent e) {
        super.onLeftClick(e);
        setValue(!getValue());
    }

    public boolean getValue () {
        return ((BoolComponentSettings) settings).getBool();
    }
    public void setValue (boolean value) {
        ((BoolComponentSettings) settings).setBool(value);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.fillRoundRect(
            settings.loc().x(), settings.loc().y(),
            settings.size().width(), settings.size().height(),
            ROUNDING_RADIUS, ROUNDING_RADIUS
        );
        g.setColor(Color.BLACK);

        String text = "Bool: " + getValue();
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();
        int x = settings.loc().x() + (settings.size().width() - textWidth) / 2;
        int y = settings.loc().y() + (settings.size().height() - textHeight) / 2 + fm.getAscent();

        g.drawString(text, x, y);
    }
}
