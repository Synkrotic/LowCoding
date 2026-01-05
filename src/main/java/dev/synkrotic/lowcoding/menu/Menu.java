package dev.synkrotic.lowcoding.menu;

import dev.synkrotic.lowcoding.components.actions.*;
import dev.synkrotic.lowcoding.components.arithmetics.*;
import dev.synkrotic.lowcoding.components.conditions.*;
import dev.synkrotic.lowcoding.components.conditions.predicates.*;
import dev.synkrotic.lowcoding.components.gates.*;
import dev.synkrotic.lowcoding.components.statements.ifs.IfComponent;
import dev.synkrotic.lowcoding.components.types.files.FileComponent;
import dev.synkrotic.lowcoding.components.types.numbers.NumberComponent;
import dev.synkrotic.lowcoding.components.types.text.TextComponent;
import dev.synkrotic.lowcoding.components.types.vars.VariableComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.components.types.bools.BoolComponent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class Menu extends JPanel {

    public Menu(Environment env) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        addSection(env, "Inputs", List.of(
            new MenuEntry("Variable", VariableComponent.class),
            new MenuEntry("Boolean", BoolComponent.class),
            new MenuEntry("Text", TextComponent.class),
            new MenuEntry("Number", NumberComponent.class),
            new MenuEntry("File", FileComponent.class)
        ));

        addSection(env, "Arithmetics", List.of(
            new MenuEntry("Addition", AdditionComponent.class),
            new MenuEntry("Multiplication", MultiplyComponent.class),
            new MenuEntry("Division", DivisionComponent.class),
            new MenuEntry("Negation", NegateComponent.class)
        ));

        addSection(env, "Statements", List.of(
            new MenuEntry("IF", IfComponent.class)
        ));

        addSection(env, "Conditions", List.of(
            new MenuEntry("Equals", EqualsConditionComponent.class),
            new MenuEntry("Less Than", LssConditionComponent.class),
            new MenuEntry("Less Equals", LeqConditionComponent.class),
            new MenuEntry("Greater Than", GtrConditionComponent.class),
            new MenuEntry("Greater Equals", GeqConditionComponent.class)
        ));

        addSection(env, "Gates", List.of(
            new MenuEntry("AND Gate", AndComponent.class),
            new MenuEntry("OR Gate", OrComponent.class),
            new MenuEntry("XOR Gate", XorComponent.class),
            new MenuEntry("Inverter", InvertComponent.class)
        ));

        addSection(env, "Actions", List.of(
            new MenuEntry("Print", PrintComponent.class),
            new MenuEntry("Execute File", FileExecute.class)
        ));

        add(Box.createVerticalGlue());
    }

    private void addSection(Environment env, String title, List<MenuEntry> entries) {
        JLabel label = new JLabel(title.toUpperCase());
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setFont(new Font("SansSerif", Font.BOLD, 12));
        label.setForeground(Color.GRAY);
        add(label);
        add(Box.createVerticalStrut(5));

        for (MenuEntry entry : entries) {
            NewComponentButton btn = new NewComponentButton(env, entry.getName(), entry.getComponentClass());

            btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, btn.getPreferredSize().height));
            btn.setAlignmentX(CENTER_ALIGNMENT);

            add(btn);
            add(Box.createVerticalStrut(2));
        }

        add(Box.createVerticalStrut(20));
    }

    public static JScrollPane createScrollableMenu(Environment env) {
        Menu menu = new Menu(env);
        JScrollPane scroll = new JScrollPane(menu);

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(12); // Smooth scrolling
        scroll.setBorder(null); // Clean look

        return scroll;
    }
}