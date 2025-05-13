package Structural_Decorator.Example1;

public class Espresso implements Coffee {
    @Override
    public double getCost() {
        return 2.5;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }
}
