package dev.synkrotic.lowcoding.components.actions;

import dev.synkrotic.lowcoding.components.setup.ComponentDetailsProvider;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;
import dev.synkrotic.lowcoding.types.LowType;

import java.awt.*;

public abstract class ActionComponent extends LowComponent {
    public ActionComponent(Environment env) {
        super(env, ComponentDetailsProvider.COMPONENT_DEFAULTS());
    }


    public abstract void execute();

    @Override
    protected void renderComponent(Graphics2D g) {
        if (!inputs.isEmpty()) System.out.println(inputs.size());
        drawStringCentered(g, this.toString());
    }

    @Override
    protected boolean canBeBound(LowComponent component) {
        return inputs.isEmpty()
            && (component instanceof LowDataType ldt)
            && ldt.getType().equals(LowType.BOOLEAN);
    }

    @Override
    public abstract String toString();
}
