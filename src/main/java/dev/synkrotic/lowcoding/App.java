package dev.synkrotic.lowcoding;

import dev.synkrotic.lowcoding.environment.Environment;

import javax.swing.*;

public class App {
    private static final JFrame frame = new JFrame("LowCoding");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            App.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            App.frame.setSize(800, 600);
            App.frame.setVisible(true);
        });

        frame.add(new Environment());
    }
}
