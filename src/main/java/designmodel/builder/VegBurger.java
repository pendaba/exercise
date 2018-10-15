package main.java.designmodel.builder;

public class VegBurger extends  Burger{
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public double price() {
        return 5.50d;
    }
}
