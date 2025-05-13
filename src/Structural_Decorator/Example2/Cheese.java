package Structural_Decorator.Example2;

public class Cheese extends Topping {
    public Cheese(Pizza below) {
        super(below);
    }

    public double getPrice() {
        return 1.00 + super.getPrice();
    }
}