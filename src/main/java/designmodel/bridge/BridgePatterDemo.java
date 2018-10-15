package main.java.designmodel.bridge;

/**
 * 一。如果一个系统需要在构件的抽象化角色（shape）和具体化角色(draw)之间增加更多的灵活性，避免在两个层次之间建立静态的继承联系，通过桥接模式可以使它们在抽象层建立一个关联关系
 *
 */
public class BridgePatterDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());
        Shape yellowRectangle = new Rectangle(20,20,100,180,new YellowRectangle());
        redCircle.draw();
        greenCircle.draw();
        yellowRectangle.draw();
    }
}
