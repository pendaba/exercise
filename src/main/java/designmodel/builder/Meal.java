package main.java.designmodel.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public double getCost(){
        return items.stream().mapToDouble(Item::price).sum();
    }
    public void showItems(){
        items.stream().forEach(item -> System.out.println(item.name()));
    }

}
