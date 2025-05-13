package Structural_Decorator.Example2;

public class PizzaDecoratorDemo {
    public static void main(String... args) {
        Pizza pizza = new Crunchy();
        pizza = new Cheese(pizza);
        pizza = new Cheese(pizza);
        pizza = new Salami(pizza);
        pizza = new Chili(pizza);

        System.out.println("Pizza: " + pizza.getDescription());
        System.out.println("Preis: " + pizza.getPrice() + "  €");
        System.out.println("Vegetarisch: " + pizza.isVegetarian());
        System.out.println("Scharf: " + pizza.isHot());
    }
}

