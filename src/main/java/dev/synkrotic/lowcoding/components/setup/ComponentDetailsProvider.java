package dev.synkrotic.lowcoding.components.setup;

import dev.synkrotic.lowcoding.components.types.bools.BoolComponentDetails;
import dev.synkrotic.lowcoding.components.types.files.FileComponentDetails;
import dev.synkrotic.lowcoding.components.types.numbers.NumberComponentDetails;
import dev.synkrotic.lowcoding.components.types.text.TextComponentDetails;
import dev.synkrotic.lowcoding.components.types.vars.VariableComponentDetails;
import dev.synkrotic.lowcoding.geo.Coord;
import dev.synkrotic.lowcoding.geo.Size;

public class ComponentDetailsProvider {
    public static BoolComponentDetails BOOL_DEFAULTS() {
        return new BoolComponentDetails(
            new Size(150, 50),
            new Coord(50, 50),
            false
        );
    }

    public static NumberComponentDetails NUMBER_DEFAULTS() {
        return new NumberComponentDetails(
            new Size(150, 50),
            new Coord(50, 50),
            0.0f
        );
    }

    public static ComponentDetails COMPONENT_DEFAULTS() {
        return new ComponentDetails(
            new Size(150, 50),
            new Coord(50, 50)
        );
    }

    public static VariableComponentDetails VARIABLE_DEFAULTS() {
        return new VariableComponentDetails(
            new Size(150, 50),
            new Coord(50, 50),
            "variable"
        );
    }

    public static TextComponentDetails TEXT_DEFAULTS() {
        return new TextComponentDetails(
            new Size(150, 50),
            new Coord(50, 50),
            "Lorem Ipsum..."
        );
    }

    public static FileComponentDetails FILE_DEFAULTS() {
        return new FileComponentDetails(
            new Size(150, 50),
            new Coord(50, 50),
            null
        );
    }
}