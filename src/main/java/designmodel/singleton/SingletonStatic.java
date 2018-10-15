package main.java.designmodel.singleton;

/**
 * 静态内部类
 */
public class SingletonStatic {
    private SingletonStatic(){}
    private static class SingletonBuilder{
        private static final SingletonStatic instance = new SingletonStatic();
    }
    public static SingletonStatic getInstancce(){
        return SingletonBuilder.instance;
    }

    public static void main(String[] args) {
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
    }

}
