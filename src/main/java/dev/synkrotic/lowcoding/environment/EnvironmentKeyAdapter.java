package dev.synkrotic.lowcoding.environment;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EnvironmentKeyAdapter extends KeyAdapter {
    private final Environment env;

    public EnvironmentKeyAdapter(Environment environment) {
        this.env = environment;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DELETE -> env.removeComponent(env.getSelectedComponent());
            case KeyEvent.VK_ESCAPE -> env.deselectComponent();
            case KeyEvent.VK_S -> System.out.println("Environment scale: " + Environment.scale);
        }
    }
}
