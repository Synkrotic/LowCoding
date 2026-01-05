package dev.synkrotic.lowcoding.components.types.files;

import dev.synkrotic.lowcoding.components.setup.ComponentDetailsProvider;
import dev.synkrotic.lowcoding.components.types.DataTypeComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;

public class FileComponent extends DataTypeComponent implements LowFile {
    public FileComponent(Environment env) {
        super(env, ComponentDetailsProvider.FILE_DEFAULTS());
    }

    @Override
    public String toString() {
        return "File: " + getFileName();
    }

    @Override
    public void onDoubleLeftClick(MouseEvent e) {
        JFileChooser fileChooser = new JFileChooser();

        int response = fileChooser.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            ((FileComponentDetails) componentDetails).setFile(file);
        }
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(200, 200, 255);
    }

    @Override
    public Object getValue() {
        return ((FileComponentDetails) componentDetails).getFile();
    }

    public String getFileName() {
        return getValue() != null ? ((File) getValue()).getName() : "";
    }
}
