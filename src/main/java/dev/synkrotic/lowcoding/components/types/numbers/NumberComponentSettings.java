package dev.synkrotic.lowcoding.components.types.ints;

import dev.synkrotic.lowcoding.components.setup.ComponentSettings;
import dev.synkrotic.lowcoding.geo.Coord;
import dev.synkrotic.lowcoding.geo.Size;

public class IntegerComponentSettings extends ComponentSettings {
    public float number;

    public IntegerComponentSettings(Size size, Coord loc, boolean value) {
        super(size, loc);
        this.value = value;
    }


    public boolean getInt() {
        return value;
    }
    public void setBool(boolean value) {
        this.value = value;
    }
}