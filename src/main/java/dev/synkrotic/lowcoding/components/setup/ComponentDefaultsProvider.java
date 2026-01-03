package dev.synkrotic.lowcoding.components.types.setup;

import dev.synkrotic.lowcoding.components.types.BoolComponentSettings;
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

    public static ComponentSettings COMPONENT_DEFAULTS() {
        return new ComponentSettings(
            new Size(100, 50),
            new Coord(50, 50)
        );
    }
}