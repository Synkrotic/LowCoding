package dev.synkrotic.lowcoding.menu;

import dev.synkrotic.lowcoding.components.actions.FileExecute;
import dev.synkrotic.lowcoding.components.actions.PrintComponent;
import dev.synkrotic.lowcoding.components.arithmetics.AdditionComponent;
import dev.synkrotic.lowcoding.components.arithmetics.DivisionComponent;
import dev.synkrotic.lowcoding.components.arithmetics.MultiplyComponent;
import dev.synkrotic.lowcoding.components.arithmetics.NegateComponent;
import dev.synkrotic.lowcoding.components.conditions.EqualsConditionComponent;
import dev.synkrotic.lowcoding.components.conditions.predicates.GeqConditionComponent;
import dev.synkrotic.lowcoding.components.conditions.predicates.GtrConditionComponent;
import dev.synkrotic.lowcoding.components.conditions.predicates.LeqConditionComponent;
import dev.synkrotic.lowcoding.components.conditions.predicates.LssConditionComponent;
import dev.synkrotic.lowcoding.components.gates.AndComponent;
import dev.synkrotic.lowcoding.components.gates.InvertComponent;
import dev.synkrotic.lowcoding.components.gates.OrComponent;
import dev.synkrotic.lowcoding.components.gates.XorComponent;
import dev.synkrotic.lowcoding.components.types.files.FileComponent;
import dev.synkrotic.lowcoding.components.types.numbers.NumberComponent;
import dev.synkrotic.lowcoding.components.types.text.TextComponent;
import dev.synkrotic.lowcoding.components.types.vars.VariableComponent;
import dev.synkrotic.lowcoding.environment.Environment;
import dev.synkrotic.lowcoding.components.types.bools.BoolComponent;

import javax.swing.*;
import java.util.List;

public class Menu extends JPanel {
    private final List<MenuEntry> inputs = List.of(
        new MenuEntry("Variable", VariableComponent.class),
        new MenuEntry("Boolean", BoolComponent.class),
        new MenuEntry("Text", TextComponent.class),
        new MenuEntry("Number", NumberComponent.class),
        new MenuEntry("File", FileComponent.class)
    );

    private final List<MenuEntry> arithmetics = List.of(
        new MenuEntry("Addition", AdditionComponent.class),
        new MenuEntry("Multiplication", MultiplyComponent.class),
        new MenuEntry("Division", DivisionComponent.class),
        new MenuEntry("Negation", NegateComponent.class)
    );

    private final List<MenuEntry> conditions = List.of(
        new MenuEntry("Equals", EqualsConditionComponent.class),
        new MenuEntry("Less Than", LssConditionComponent.class),
        new MenuEntry("Less Equals", LeqConditionComponent.class),
        new MenuEntry("Greater Than", GtrConditionComponent.class),
        new MenuEntry("Greater Equals", GeqConditionComponent.class)
    );

    private final List<MenuEntry> gateEntries = List.of(
        new MenuEntry("AND Gate", AndComponent.class),
        new MenuEntry("OR Gate", OrComponent.class),
        new MenuEntry("XOR Gate", XorComponent.class),
        new MenuEntry("Inverter", InvertComponent.class)
    );

    private final List<MenuEntry> actionEntries = List.of(
        new MenuEntry("Print", PrintComponent.class),
        new MenuEntry("Execute File", FileExecute.class)
    );

    private boolean inputsExpanded = false;
    private boolean arithmeticsExpanded = false;
    private boolean conditionsExpanded = false;
    private boolean gatesExpanded = false;
    private boolean actionsExpanded = false;


    public Menu(Environment env) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        addComponentButtons(env);
    }

    private void addComponentButtons(Environment env) {
        removeAll();
        addInputs(env);
        addArithmetics(env);
        addConditions(env);
        addGates(env);
        addActions(env);
        revalidate();
    }

    private void addInputs(Environment env) {
        JButton dataTypesLabel = new JButton("Inputs");
        dataTypesLabel.setAlignmentX(CENTER_ALIGNMENT);
        dataTypesLabel.addActionListener(_ -> {
            inputsExpanded = !inputsExpanded;
            addComponentButtons(env);
        });
        add(dataTypesLabel);

        if (inputsExpanded) {
            for (MenuEntry entry : inputs) {
                NewComponentButton entryButton = new NewComponentButton(env, entry.getName(), entry.getComponentClass());
                add(entryButton);
            }
        }

        add(Box.createVerticalStrut(20));
    }
    
    private void addArithmetics(Environment env) {
        JButton arithmeticsLabel = new JButton("Arithmetics");
        arithmeticsLabel.setAlignmentX(CENTER_ALIGNMENT);
        arithmeticsLabel.addActionListener(_ -> {
            arithmeticsExpanded = !arithmeticsExpanded;
            addComponentButtons(env);
        });
        add(arithmeticsLabel);

        if (arithmeticsExpanded) {
            for (MenuEntry entry : arithmetics) {
                NewComponentButton entryButton = new NewComponentButton(env, entry.getName(), entry.getComponentClass());
                add(entryButton);
            }
        }

        add(Box.createVerticalStrut(20));
    }

    private void addConditions(Environment env) {
        JButton conditionsLabel = new JButton("Conditions");
        conditionsLabel.setAlignmentX(CENTER_ALIGNMENT);
        conditionsLabel.addActionListener(_ -> {
            conditionsExpanded = !conditionsExpanded;
            addComponentButtons(env);
        });
        add(conditionsLabel);

        if (conditionsExpanded) {
            for (MenuEntry entry : conditions) {
                NewComponentButton entryButton = new NewComponentButton(env, entry.getName(), entry.getComponentClass());
                add(entryButton);
            }
        }

        add(Box.createVerticalStrut(20));
    }

    private void addGates(Environment env) {
        JButton gatesLabel = new JButton("Gates");
        gatesLabel.setAlignmentX(CENTER_ALIGNMENT);
        gatesLabel.addActionListener(_ -> {
            gatesExpanded = !gatesExpanded;
            addComponentButtons(env);
        });
        add(gatesLabel);

        if (gatesExpanded) {
            for (MenuEntry entry : gateEntries) {
                NewComponentButton entryButton = new NewComponentButton(env, entry.getName(), entry.getComponentClass());
                add(entryButton);
            }
        }

        add(Box.createVerticalStrut(20));
    }

    private void addActions(Environment env) {
        JButton actionsLabel = new JButton("Actions");
        actionsLabel.setAlignmentX(CENTER_ALIGNMENT);
        actionsLabel.addActionListener(_ -> {
            actionsExpanded = !actionsExpanded;
            addComponentButtons(env);
        });
        add(actionsLabel);

        if (actionsExpanded) {
            for (MenuEntry entry : actionEntries) {
                NewComponentButton entryButton = new NewComponentButton(env, entry.getName(), entry.getComponentClass());
                add(entryButton);
            }
        }

        add(Box.createVerticalStrut(20));
    }
}