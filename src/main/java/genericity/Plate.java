package main.java.genericity;

public class Plate<T>{
    private  T t;

    public Plate(T t) {
        this.t = t;
    }

    public Plate() {
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
