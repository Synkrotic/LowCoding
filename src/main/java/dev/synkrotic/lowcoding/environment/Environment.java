package dev.synkrotic.lowcoding.environment;

import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.menu.Menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Environment extends JPanel {
    private static Image backgroundImage;
    static {
        try {
            URL imgUrl = Environment.class.getResource("/images/background.jpg");
            if (imgUrl != null) {
                backgroundImage = ImageIO.read(imgUrl);
            } else {
                System.err.println("Couldn't find file: " + "/images/background.jpg");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final List<LowComponent> components = new ArrayList<>();

    // Zooming
    public static float scale = 1;
    public static float offsetX = 0;
    public static float offsetY = 0;


    public Environment() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Welcome to LowCoding Environment!");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(label, BorderLayout.NORTH);

        Menu menu = new Menu(this);
        this.add(menu, BorderLayout.WEST);

        EnvironmentMouseAdapter mouseAdapter = new EnvironmentMouseAdapter(this);
        this.addMouseListener(mouseAdapter);
        this.addMouseMotionListener(mouseAdapter);
        this.addMouseWheelListener(mouseAdapter);
    }


    public void addComponent(LowComponent component) {
        components.add(component);
        repaint();
    }
    public List<LowComponent> getComponentsList() {
        return components;
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        // Apply zoom transformations
        g2d.translate(offsetX, offsetY);
        g2d.scale(scale, scale);

        for (LowComponent component : components) {
            component.renderLines(g2d);
        }
        for (LowComponent component : components) {
            component.render(g2d);
        }

        // Reset g2d for menu rendering
        g2d.scale(1 / scale, 1 / scale);
        g2d.translate(-offsetX, -offsetY);
    }
}
