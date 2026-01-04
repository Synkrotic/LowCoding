package dev.synkrotic.lowcoding.geo;

public record Coord(int x, int y) {
    public Coord offset(int dx, int dy) {
        return new Coord(x + dx, y + dy);
    }
}
