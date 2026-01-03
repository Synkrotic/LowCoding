package dev.synkrotic.lowcoding;

import javax.swing.*;

public class Menu extends JPanel {
    public Menu() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("LowCoding Menu");
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(titleLabel);

        
    }
}
