package dev.synkrotic.lowcoding.components.types;

import dev.synkrotic.lowcoding.components.setup.ComponentDetails;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;

import java.awt.*;

public abstract class DataTypeComponent extends LowComponent implements LowDataType {
    public DataTypeComponent(Environment env, ComponentDetails componentDetails) {
        super(env, componentDetails);
    }

    @Override
    protected boolean canBeBound(LowComponent component) {
        return false; // Data types cannot have bindings
    }

    @Override
    protected void renderComponent(Graphics2D g) {
        drawStringCentered(g, toString());
    }

    @Override
    public abstract String toString();

    public abstract boolean isEqualTo(LowComponent other);
}
