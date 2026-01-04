package dev.synkrotic.lowcoding.components.types.bools;

import dev.synkrotic.lowcoding.components.types.DataTypeComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.components.setup.ComponentDefaultsProvider;
import dev.synkrotic.lowcoding.types.LowBoolean;

import java.awt.*;
import java.awt.event.MouseEvent;

public class BoolComponent extends DataTypeComponent implements LowBoolean {
    public BoolComponent(Environment env) {
        super(env, ComponentDefaultsProvider.BOOL_DEFAULTS());
    }


    @Override
    protected Color getBackgroundColor() {
        return getBoolean() ? Color.GREEN : Color.RED;
    }

    @Override
    public void onLeftClick(MouseEvent e) {
        super.onLeftClick(e);
        setBoolean(!getBoolean());
    }

    @Override
    public String toString() {
        return "Boolean: " + getBoolean();
    }

    @Override
    public boolean isEqualTo(LowComponent other) {
        if (other == this) return true;

        if (other instanceof LowBoolean otherBool) {
            return this.getBoolean() == otherBool.getBoolean();
        }

        return false;
    }

    @Override
    public boolean getBoolean() {
        return ((BoolComponentSettings) settings).getBool();
    }
    public void setBoolean(boolean value) {
        ((BoolComponentSettings) settings).setBool(value);
    }
}
