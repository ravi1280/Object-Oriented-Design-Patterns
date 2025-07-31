import java.util.ArrayList;
import java.util.List;

// Interface with only required methods
interface MenuComponent {
    String getName();
    double getPrice();
    void print();
}

// Leaf class
class MenuItem implements MenuComponent {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public void print() {
        System.out.println("- " + name + " : $" + price);
    }
}

// Composite class
class Menu implements MenuComponent {
    private String name;
    private List<MenuComponent> components = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void add(MenuComponent component) {
        components.add(component);
    }

    public void remove(MenuComponent component) {
        components.remove(component);
    }

    public String getName() { return name; }

    public double getPrice() {
        double total = 0;
        for (MenuComponent component : components) {
            total += component.getPrice();
        }
        return total;
    }

    public void print() {
        System.out.println("Menu: " + name);
        for (MenuComponent component : components) {
            component.print();
        }
        System.out.println("Total for " + name + ": $" + getPrice());
    }
}

// Main class
public class RestaurantOrderingSystem {
    public static void main(String[] args) {
        MenuItem pizza = new MenuItem("Pizza", 12.0);
        MenuItem burger = new MenuItem("Burger", 8.0);
        MenuItem drink = new MenuItem("Coke", 2.0);
        MenuItem iceCream = new MenuItem("Ice Cream", 3.0);
        MenuItem cake = new MenuItem("Cake", 4.0);

        Menu lunchMenu = new Menu("Lunch Menu");
        lunchMenu.add(pizza);
        lunchMenu.add(burger);

        Menu dessertMenu = new Menu("Dessert Menu");
        dessertMenu.add(iceCream);
        dessertMenu.add(cake);

        Menu fullMenu = new Menu("Full Menu");
        fullMenu.add(lunchMenu);
        fullMenu.add(dessertMenu);
        fullMenu.add(drink);

        fullMenu.print();
    }
}
