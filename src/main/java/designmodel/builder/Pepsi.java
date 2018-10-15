package main.java.designmodel.builder;

public class Pepsi extends  ColorDrink{
    @Override
    public String name() {
        return "pepsi";
    }

    @Override
    public double price() {
        return 3.00;
    }
}
