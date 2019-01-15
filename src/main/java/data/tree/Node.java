package main.java.data.tree;

public class Node {

    private int iData;
    private double fData;
    private Node lChild;
    private Node rChild;

    public Node() {
    }

    public Node(int iData, double fData, Node lChild, Node rChild) {
        this.iData = iData;
        this.fData = fData;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    public int getiData() {
        return iData;
    }

    public void setiData(int iData) {
        this.iData = iData;
    }

    public double getfData() {
        return fData;
    }

    public void setfData(double fData) {
        this.fData = fData;
    }

    public Node getlChild() {
        return lChild;
    }

    public void setlChild(Node lChild) {
        this.lChild = lChild;
    }

    public Node getrChild() {
        return rChild;
    }

    public void setrChild(Node rChild) {
        this.rChild = rChild;
    }

    public void displayNode(){
        System.out.println("Node存储数据:"+iData);
    }

}
