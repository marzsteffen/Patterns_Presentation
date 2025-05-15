package Structural_Bridge.Example1;

public class ShapeDemo {
    public static void main(String[] args) {
        Shape square = new Square(new RedColor());
        System.out.println(square.draw()); // Output: Square drawn. Color is Red

        Shape circle = new Circle(new BlueColor());
        System.out.println(circle.draw()); // Output: Circle drawn. Color is Blue

    }
}
