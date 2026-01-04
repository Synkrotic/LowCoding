package dev.synkrotic.lowcoding.components.types.bools;

import dev.synkrotic.lowcoding.components.setup.ComponentDetails;
import dev.synkrotic.lowcoding.geo.Coord;
import dev.synkrotic.lowcoding.geo.Size;

public class BoolComponentDetails extends ComponentDetails {
    public boolean value;

    public BoolComponentDetails(Size size, Coord loc, boolean value) {
        super(size, loc);
        this.value = value;
    }


    public boolean getBool() {
        return value;
    }
    public void setBool(boolean value) {
        this.value = value;
    }
}