package dev.synkrotic.lowcoding;

import dev.synkrotic.lowcoding.environment.Environment;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App {
    private static final JFrame frame = new JFrame("LowCoding");
    private static final Environment env = new Environment();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            App.frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            App.frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
//                    env.saveEnvironment();
                    System.exit(0);
                }
            });
            App.frame.setSize(800, 600);
            frame.add(env);
            App.frame.setVisible(true);
        });

    }
}
