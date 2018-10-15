package main.java.designmodel.builder;

public class Coke extends ColorDrink{
    @Override
    public String name() {
        return "coke";
    }

    @Override
    public double price() {
        return 8.88;
    }
}
