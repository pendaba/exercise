package main.java.java8.lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Person {
    public Person() {
    }

    public Person(int height, String name, int weight) {
        this.height = height;
        this.name = name;
        this.weight = weight;
    }
    private int height;
    private String name;
    private int weight;



    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public  static Person updatePerson(Person Person, Predicate<Person> predicate, Consumer<Person> consumer){

        //Use the predicate to decide when to update the discount.

        if ( predicate.test(Person)){
            //Use the consumer to update the discount value.
            consumer.accept(Person);
        }
        return Person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static void main(String[] args) {
        System.out.println( Person.updatePerson(new Person(175,"小明",75),s -> s.getHeight()>170, s -> s.setWeight(80)));
//        比较
        Person xiaoming = new Person(175,"xiaoming",70);
        Person xiaowang = new Person(180,"xiaowang",75);
        Person xiaohong = new Person(160,"xiaohong",80);
        xiaoming.getName().compareTo(xiaowang.getName());
    }
}
