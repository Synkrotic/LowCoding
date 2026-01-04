package dev.synkrotic.lowcoding.environment;

import dev.synkrotic.lowcoding.components.setup.LowComponent;
import dev.synkrotic.lowcoding.geo.Coord;
import dev.synkrotic.lowcoding.menu.Menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private static final File saveDir = new File("saves");

    private final List<LowComponent> components = new ArrayList<>();
    private static LowComponent selectedComponent = null;

    // Zooming
    public static float scale = 1;
    public static float offsetX = 0;
    public static float offsetY = 0;


    public Environment() {
        setLayout(new BorderLayout());
        loadRecentEnvironment();

        JLabel label = new JLabel("Welcome to LowCoding Environment!");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label, BorderLayout.NORTH);

        Menu menu = new Menu(this);
        this.add(menu, BorderLayout.WEST);

        EnvironmentMouseAdapter mouseAdapter = new EnvironmentMouseAdapter(this);
        this.addMouseListener(mouseAdapter);
        this.addMouseMotionListener(mouseAdapter);
        this.addMouseWheelListener(mouseAdapter);

        EnvironmentKeyAdapter keyAdapter = new EnvironmentKeyAdapter(this);
        this.addKeyListener(keyAdapter);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }


    public void addComponent(LowComponent component) {
        components.add(component);
        repaint();
    }
    public void removeComponent(LowComponent component) { // Essentially deleting component
        components.remove(component);
        if (selectedComponent == component) {
            selectedComponent = null;
        }
        repaint();
    }
    public List<LowComponent> getComponentsList() {
        return components;
    }

    public void selectComponent(LowComponent component) {
        selectedComponent = component;
        repaint();
    }
    public void deselectComponent() {
        selectedComponent = null;
        repaint();
    }
    public LowComponent getSelectedComponent() {
        return selectedComponent;
    }

    public static Coord toWorldCoordinates(Coord screenPoint) {
        int worldX = (int) ((screenPoint.x() - offsetX) / scale);
        int worldY = (int) ((screenPoint.y() - offsetY) / scale);
        return new Coord(worldX, worldY);
    }

    public void saveEnvironment() {
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String formatDateTime = now.format(formatter);
        String fileName = String.format("env_%s.dat", formatDateTime);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(saveDir, fileName)))) {
            oos.writeObject(this.components);
            oos.writeFloat(scale);
            oos.writeFloat(offsetX);
            oos.writeFloat(offsetY);
            System.out.println("Environment saved successfully!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadRecentEnvironment() {
        File[] files = saveDir.listFiles((_, name) -> name.endsWith(".dat"));
        if (files == null || files.length == 0) {
            System.out.println("No saved environments found.");
            return;
        }

        File recentFile = files[0];
        for (File file : files) {
            if (file.lastModified() > recentFile.lastModified()) {
                recentFile = file;
            }
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(recentFile))) {
            List<LowComponent> loadedComponents = (List<LowComponent>) ois.readObject();
            this.components.clear();
            for (LowComponent component : loadedComponents) {
                component.setEnvironment(this);
                this.components.add(component);
            }
            scale = ois.readFloat();
            offsetX = ois.readFloat();
            offsetY = ois.readFloat();
            System.out.println("Environment loaded successfully!");
            repaint();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        // Apply zoom transformations
        g2d.translate(offsetX, offsetY);
        g2d.scale(scale, scale);

        for (LowComponent component : components) {
            component.renderLines(g2d);
        }
        for (LowComponent component : components.reversed()) {
            component.render(g2d);
            if (component == selectedComponent) {
                component.renderOutline(g2d);
            }
        }

        g2d.dispose();
    }
}
