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
    protected Color getBackgroundColor() {
        return Color.GREEN;
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
    protected void renderComponent(Graphics2D g) {
        String text = "Bool: " + getBoolean();
        drawStringCentered(g, text);
    }
}
