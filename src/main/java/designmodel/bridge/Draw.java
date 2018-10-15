package main.java.designmodel.bridge;

/**
 * 一。桥接用于把抽象化与实现化解耦，，使得二者可以独立变化
 * 二。主要解决的问题：在有多种可能会变化的情况下用继承会造成类爆炸问题，扩展起来不灵活。
 */
public interface Draw {
    void drawCircle(int radius,int x,int y);
    void drawRectangle(int x,int y,int width,int length);
}
