package main.java.designmodel.bridge;

public class RedCircle implements Draw{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+",y "+ y +"]");
    }

    @Override
    public void drawRectangle(int x, int y, int width, int length) {

    }
}
