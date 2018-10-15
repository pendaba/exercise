package main.java.designmodel.bridge;

public class Rectangle extends Shape{
    private  int x,y,width,length;
    public Rectangle (int x, int y, int width, int length,Draw draw) {
        super(draw);
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
    }

    @Override
    public void draw() {
        draw.drawRectangle(x,y,width,length);
    }
}
