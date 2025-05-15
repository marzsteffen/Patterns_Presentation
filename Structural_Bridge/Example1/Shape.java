package Structural_Bridge.Example1;

//Abstraktion
public abstract class Shape{
    protected Color color;

    public Shape(Color color){
        this.color = color;

    }
    abstract public String draw();
}
