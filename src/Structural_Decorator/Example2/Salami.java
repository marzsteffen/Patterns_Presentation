package Structural_Decorator.Example2;

public class Salami extends Topping {
    public Salami(Pizza below) {
        super(below);
    }

    public double getPrice() {
        return 1.50 + super.getPrice();
    }

    public boolean isVegetarian() {
        return false;
    }
}