package dev.synkrotic.lowcoding.components.types.numbers;

import dev.synkrotic.lowcoding.components.setup.ComponentDetails;
import dev.synkrotic.lowcoding.geo.Coord;
import dev.synkrotic.lowcoding.geo.Size;

public class NumberComponentDetails extends ComponentDetails {
    public float number;

    public NumberComponentDetails(Size size, Coord loc, float value) {
        super(size, loc);
        this.number = value;
    }


    public float getNumber() {
        return number;
    }
    public void setNumber(float value) {
        this.number = value;
    }
}