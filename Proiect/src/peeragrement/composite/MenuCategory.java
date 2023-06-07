package peeragrement.composite;

import java.util.ArrayList;
import java.util.List;

public class MenuCategory implements MenuComponent {
    private List<MenuItem> subComponents;

    public MenuCategory() {
        subComponents = new ArrayList<>();
    }

    public void addComponent(MenuItem component) {
        subComponents.add(component);
    }

    public void removeComponent(MenuItem component) {
        subComponents.remove(component);
    }

    @Override
    public void display() {
        // Display menu category and its sub-components
        for (MenuItem component : subComponents) {
            component.display();
        }
    }
}
