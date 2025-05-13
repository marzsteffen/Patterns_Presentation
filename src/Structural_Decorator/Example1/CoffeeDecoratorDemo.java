package Structural_Decorator.Example1;

public class CoffeeDecoratorDemo {
    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();
        System.out.println("Erstellter Kaffee: " + coffee.getDescription() + " || Preis: " + coffee.getCost() + " €");

        coffee = new MilkDecorator(coffee);
        System.out.println("Erstellter Kaffee: " + coffee.getDescription() + " || Preis: " + coffee.getCost()+ " €");

        coffee = new SugarDecorator(coffee);
        System.out.println("Erstellter Kaffee: " + coffee.getDescription() + " || Preis: " + coffee.getCost()+ " €");
    }
}