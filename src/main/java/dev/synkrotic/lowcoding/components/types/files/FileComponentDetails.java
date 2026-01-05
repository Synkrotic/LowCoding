package dev.synkrotic.lowcoding.components.types.files;

import dev.synkrotic.lowcoding.components.setup.ComponentDetails;
import dev.synkrotic.lowcoding.geo.Coord;
import dev.synkrotic.lowcoding.geo.Size;

import java.io.File;

public class FileComponentDetails extends ComponentDetails {
    private File file;

    public FileComponentDetails(Size size, Coord loc, File file) {
        super(size, loc);
        this.file = file;
    }

    public File getFile() {
        return file;
    }
    public void setFile(File file) {
        this.file = file;
    }
}