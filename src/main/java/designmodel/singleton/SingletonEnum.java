package main.java.designmodel.singleton;

public enum SingletonEnum {
    INSTANCE;
    private  SingletonEnum(){}

    public static void main(String[] args) {
        System.out.println(SingletonEnum.INSTANCE == SingletonEnum.INSTANCE);
    }
}
