package dev.synkrotic.lowcoding.components.types;

import dev.synkrotic.lowcoding.components.types.setup.ComponentSettings;
import dev.synkrotic.lowcoding.geo.Coord;
import dev.synkrotic.lowcoding.geo.Size;

public class BoolComponentSettings extends ComponentSettings {
    public boolean value;

    public BoolComponentSettings(Size size, Coord loc, boolean value) {
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