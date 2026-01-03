package dev.synkrotic.lowcoding.components.setup;

import dev.synkrotic.lowcoding.geo.Coord;
import dev.synkrotic.lowcoding.geo.Size;

public class ComponentSettings {
    private Size size;
    private Coord loc;

    public ComponentSettings(Size size, Coord loc) {
        this.size = size;
        this.loc = loc;
    }


    public Size size() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }


    public Coord loc() {
        return loc;
    }
    public void setLoc(Coord loc) {
        this.loc = loc;
    }
}
