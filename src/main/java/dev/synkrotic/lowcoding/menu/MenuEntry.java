package dev.synkrotic.lowcoding.menu;

import dev.synkrotic.lowcoding.components.setup.LowComponent;

import java.io.Serializable;

class MenuEntry implements Serializable {
    String name;
    Class<? extends LowComponent> componentClass;

    public MenuEntry(String name, Class<? extends LowComponent> componentClass) {
        this.name = name;
        this.componentClass = componentClass;
    }

    public String getName() {
        return name;
    }

    public Class<? extends LowComponent> getComponentClass() {
        return componentClass;
    }
}
