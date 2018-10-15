package main.java.designmodel.builder;

public  abstract class ColorDrink implements Item{
    @Override
    public Packing packing() {
        return new Bottle();
    }
}
