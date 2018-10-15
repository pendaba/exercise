package main.java.designmodel.builder;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal= mealBuilder.prepareVegMeal();
        vegMeal.showItems();
        System.out.println(vegMeal.getCost());
        System.out.println("========");
        Meal chickenMeal = mealBuilder.prepareChickenMeal();
        chickenMeal.showItems();
        System.out.println(chickenMeal.getCost());
    }
}
