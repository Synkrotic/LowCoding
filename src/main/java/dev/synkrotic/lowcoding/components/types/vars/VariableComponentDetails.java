package dev.synkrotic.lowcoding.components.types.vars;

import dev.synkrotic.lowcoding.components.setup.ComponentDetails;
import dev.synkrotic.lowcoding.geo.Coord;
import dev.synkrotic.lowcoding.geo.Size;
import dev.synkrotic.lowcoding.types.LowType;

public class VariableComponentDetails extends ComponentDetails {
    private String name;
    private LowType type;

    public VariableComponentDetails(Size size, Coord loc, String name) {
        super(size, loc);
        this.name = name;
        this.type = null;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LowType getType() {
        return type;
    }
    public void setType(LowType type) {
        this.type = type;
    }
}
