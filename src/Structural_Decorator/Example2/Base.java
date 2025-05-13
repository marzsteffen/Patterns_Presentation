package Structural_Decorator.Example2;

public abstract class Base implements Pizza {
    private final double price;

    private final boolean hot;

    public Base(double price, boolean hot) {
        this.price = price;
        this.hot = hot;
    }

    public double getPrice() {
        return price;
    }

    public boolean isHot() {
        return hot;
    }

    public boolean isVegetarian() {
        return true;
    }

    public String getDescription() {
        return this.getClass().getSimpleName();
    }
}