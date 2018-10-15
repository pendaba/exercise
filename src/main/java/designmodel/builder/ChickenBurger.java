package main.java.designmodel.builder;

public class ChickenBurger extends Burger {


    @Override
    public String name() {
        return "chicken burger";
    }

    @Override
    public double price() {
        return 10.00;
    }
}
