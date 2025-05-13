package Structural_Decorator.Example1;

public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 4.0;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}
