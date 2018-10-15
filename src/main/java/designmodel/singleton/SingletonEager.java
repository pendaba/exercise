package main.java.designmodel.singleton;

public class SingletonEager {

    private SingletonEager(){}

    private static SingletonEager singletonEager = new SingletonEager();

    public static SingletonEager getInstance(){
        return singletonEager;
    }



}
