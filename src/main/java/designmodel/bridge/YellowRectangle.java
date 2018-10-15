package main.java.designmodel.bridge;

public  class YellowRectangle implements Draw {
    @Override
    public void drawCircle(int radius, int x, int y) {

    }

    @Override
    public void drawRectangle(int width, int length, int x, int y) {
        System.out.println("Drawing Rectangle[ color: yellow, width: "
                + width +",length:"+length+", x: " +x+",y"+ y +"]");
    }
}
