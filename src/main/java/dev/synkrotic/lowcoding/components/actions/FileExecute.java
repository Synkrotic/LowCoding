package dev.synkrotic.lowcoding.components.actions;

import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.types.LowDataType;
import dev.synkrotic.lowcoding.types.LowType;

import java.awt.*;
import java.io.IOException;

public class FileExecute extends ActionComponent {
    public FileExecute(Environment env) {
        super(env);
    }

    @Override
    protected void execute() {
        if (inputs.isEmpty()) return;

        for (LowDataType input : inputs) {
            if (!input.getType().equals(LowType.FILE)) continue;

            String filePath = input.getValue().toString();
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder pb;

            try {
                if (os.contains("win")) {
                    pb = new ProcessBuilder("cmd", "/c", "start", "", filePath);
                } else if (os.contains("mac")) {
                    pb = new ProcessBuilder("open", filePath);
                } else {
                    pb = new ProcessBuilder("xdg-open", filePath);
                }

                pb.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected boolean canBeBound(LowComponent component) {
        // Max 2 inputs
        if (inputs.size() > 1) return false;

        // Allow one LowText and one LowBoolean
        if (component instanceof LowDataType ldt) {
            if (ldt.getType().equals(LowType.BOOLEAN)) {
                return inputs.stream().noneMatch(input ->
                    input instanceof LowDataType inputLdt
                        && inputLdt.getType().equals(LowType.BOOLEAN));
            } else if (ldt.getType().equals(LowType.FILE)) {
                return inputs.stream().noneMatch(input ->
                    input instanceof LowDataType inputLdt
                        && inputLdt.getType().equals(LowType.FILE));
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Execute File";
    }

    @Override
    protected Color getBackgroundColor() {
        return new Color(200, 180, 255);
    }
}
