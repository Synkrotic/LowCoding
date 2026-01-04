package dev.synkrotic.lowcoding.components.types.bools;

import dev.synkrotic.lowcoding.components.types.DataTypeComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.components.setup.ComponentDetailsProvider;
import dev.synkrotic.lowcoding.types.LowBoolean;

import java.awt.*;
import java.awt.event.MouseEvent;

public class BoolComponent extends DataTypeComponent implements LowBoolean {
    public BoolComponent(Environment env) {
        super(env, ComponentDetailsProvider.BOOL_DEFAULTS());
    }


    @Override
    protected Color getBackgroundColor() {
        return (Boolean) getValue() ? Color.GREEN : Color.RED;
    }

    @Override
    public void onDoubleLeftClick(MouseEvent e) {
        super.onDoubleLeftClick(e);
        setBoolean(!(Boolean) getValue());
    }

    @Override
    public String toString() {
        return "Boolean: " + getValue();
    }

    @Override
    public boolean isEqualTo(LowComponent other) {
        if (other == this) return true;

        if (other instanceof LowBoolean otherBool) {
            return this.getValue() == otherBool.getValue();
        }

        return false;
    }

    @Override
    public Object getValue() {
        return ((BoolComponentDetails) componentDetails).getBool();
    }
    public void setBoolean(boolean value) {
        ((BoolComponentDetails) componentDetails).setBool(value);
    }
}
