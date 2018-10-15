package main.java.designmodel.singleton;

/**
 * 双重校验锁
 */
public class SingletonValidate {
//    private SingletonValidate(){}
//    private volatile static SingletonValidate singletonValidate;
//    public static SingletonValidate getInstance(){
//        if(singletonValidate == null){
//            synchronized (SingletonValidate.class){
//                if(singletonValidate == null){
//                    singletonValidate = new SingletonValidate();
//                }
//            }
//        }
//        return singletonValidate;
//    }


//    private volatile static SingletonValidate singletonValidate;
//    private SingletonValidate(){}
//    public static SingletonValidate getInstance(){
//        if(singletonValidate == null){
//            synchronized (SingletonValidate.class){
//                if(singletonValidate == null){
//                    singletonValidate = new SingletonValidate();
//                }
//            }
//        }
//        return singletonValidate;
//    }
    private static class InstanceHolder{
        public static SingletonValidate singletonValidate = new SingletonValidate();
    }
    public static SingletonValidate getInstance(){
        return  InstanceHolder.singletonValidate;
    }



}
