package dev.synkrotic.lowcoding.geo;

import java.io.Serializable;

public record Coord(int x, int y) implements Serializable {
    public Coord offset(int dx, int dy) {
        return new Coord(x + dx, y + dy);
    }
}
