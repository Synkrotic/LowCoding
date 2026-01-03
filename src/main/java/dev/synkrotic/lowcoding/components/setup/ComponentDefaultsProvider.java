package dev.synkrotic.lowcoding.components.setup;

import dev.synkrotic.lowcoding.components.types.bools.BoolComponentSettings;
import dev.synkrotic.lowcoding.components.types.numbers.NumberComponentSettings;
import dev.synkrotic.lowcoding.geo.Coord;
import dev.synkrotic.lowcoding.geo.Size;

public class ComponentDefaultsProvider {
    public static BoolComponentSettings BOOL_DEFAULTS() {
        return new BoolComponentSettings(
            new Size(100, 50),
            new Coord(50, 50),
            false
        );
    }

    public static NumberComponentSettings NUMBER_DEFAULTS() {
        return new NumberComponentSettings(
            new Size(100, 50),
            new Coord(50, 50),
            0.0f
        );
    }

    public static ComponentSettings COMPONENT_DEFAULTS() {
        return new ComponentSettings(
            new Size(100, 50),
            new Coord(50, 50)
        );
    }
}