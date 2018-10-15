package main.java.designmodel.prototype;

public class Rectangle extends Shape{

    Rectangle(){
        type = "rectangle";
    }
    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
