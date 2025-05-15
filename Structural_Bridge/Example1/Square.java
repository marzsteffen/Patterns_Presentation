package Structural_Bridge.Example1;

public class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Square drawn in " + color.fill();
    }
}
