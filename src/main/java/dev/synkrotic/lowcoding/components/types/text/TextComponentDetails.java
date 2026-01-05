package dev.synkrotic.lowcoding.components.types.text;

import dev.synkrotic.lowcoding.components.setup.ComponentDetails;
import dev.synkrotic.lowcoding.geo.Coord;
import dev.synkrotic.lowcoding.geo.Size;

public class TextComponentDetails extends ComponentDetails {
    public String text;

    public TextComponentDetails(Size size, Coord loc, String value) {
        super(size, loc);
        this.text = value;
    }


    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}