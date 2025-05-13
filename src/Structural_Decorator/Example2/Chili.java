package Structural_Decorator.Example2;

public class Chili extends Topping {
    public Chili(Pizza below) {
        super(below);
    }

    public boolean isHot() {
        return true;
    }
}