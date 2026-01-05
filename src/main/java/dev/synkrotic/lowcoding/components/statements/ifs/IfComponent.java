package dev.synkrotic.lowcoding.components.statements.ifs;

import dev.synkrotic.lowcoding.components.actions.ActionComponent;
import dev.synkrotic.lowcoding.components.setup.ComponentDetailsProvider;
import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;
import dev.synkrotic.lowcoding.types.LowType;

import java.awt.*;

public class IfComponent extends LowComponent {
    public IfComponent(Environment env) {
        super(env, ComponentDetailsProvider.COMPONENT_DEFAULTS());
    }


    @Override
    protected Color getBackgroundColor() {
        return new Color(77, 77, 178);
    }

    @Override
    protected void renderComponent(Graphics2D g) {
        drawStringCentered(g, "IF");
    }

    @Override
    protected boolean canBeBound(LowComponent component) {
        if (component instanceof  LowDataType ldt) {
            long boolCount = inputs.stream()
                .filter(i -> i instanceof LowDataType ld && ld.getType().equals(LowType.BOOLEAN))
                .count();
            return ldt.getType().equals(LowType.BOOLEAN) && boolCount < 1;
        }
        return false;
    }

    public void execute() {
        for (LowComponent output : outputs) {
            if (output instanceof ActionComponent actionC) {
                actionC.execute();
            }
        }
    }
}
