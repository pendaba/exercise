package main.java.designmodel.prototype;

public class Square extends Shape {

    Square(){
        type = "square";
    }
    @Override
    void draw() {
        System.out.println("Inside Square::draw() method");
    }
}
