package Structural_Decorator.Example2;

public abstract class Topping implements Pizza {
    private final Pizza below;

    public Topping(Pizza below) {
        this.below = below;
    }

    public boolean isVegetarian() {
        return below.isVegetarian();
    }

    public boolean isHot() {
        return below.isHot();
    }

    public double getPrice() {
        return below.getPrice();
    }

    public String getDescription() {
        return below.getDescription() + ", " + this.getClass().getSimpleName();
    }
}