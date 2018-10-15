package main.java.designmodel.singleton;

/**
 * 懒汉
 */
public class SingletonLazy {

    private  SingletonLazy(){}

    private static SingletonLazy singletonLazy;
    //懒汉线程不安全
    public static SingletonLazy getInstance(){
        if(singletonLazy == null){
           singletonLazy =  new SingletonLazy();
        }
        return singletonLazy;
    }

    /**
     * 懒汉线程安全
     * @return
     */
    public static synchronized  SingletonLazy getInstance1(){
        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }




}
