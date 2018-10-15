package main.java.clone;

/**
 *       一。从中可以看出，调用Object类中clone()方法产生的效果是：先在内存中开辟一块和原始对象一样的空间，然后原样拷贝原始对象中的内 容。对基本数据类型，这样的操作是没有问题的，
 * 但对非基本类型变量，我们知道它们保存的仅仅是对象的引用，这也导致clone后的非基本类型变量和原始对 象中相应的'个对象。
 *
 *       二。StringBuffer没有重载clone()方法，更为严重的是StringBuffer还是一个 final类，这也是说我们也不能用继承的办法间接实现StringBuffer的clone。
 *       如果一个类中包含有StringBuffer类型对象或和 StringBuffer相似类的对象，我们有两种选择：要么只能实现影子clone，
 *       要么就在类的clone()方法中加一句（假设是 SringBuffer对象，而且变量名仍是unCA）： o.unCA = new StringBuffer(unCA.toString()); //原来的是：o.unCA = (UnCloneA)unCA.clone();
 *
 */
public class CloneMain {
    public static void main(String[] a){
        CloneB b1 = new CloneB();
        b1.aInt = 11;
        System.out.println("before clone,b1.aInt = "+ b1.aInt);
        System.out.println("before clone,b1.unCA = "+ b1.unCA);

        CloneB b2 = (CloneB)b1.clone();
        b2.aInt = 22;
        b2.unCA.doublevalue();
        System.out.println("=================================");
        System.out.println("after clone,b1.aInt = "+ b1.aInt);
        System.out.println("after clone,b1.unCA = "+ b1.unCA);
        System.out.println("=================================");
        System.out.println("after clone,b2.aInt = "+ b2.aInt);
        System.out.println("after clone,b2.unCA = "+ b2.unCA);
        /**
         * 深度clone
         * 把上面的例子改成深度clone很简单，需要两个改变：一是让UnCloneA类也实现和CloneB类一样的clone功能（实现Cloneable接 口，重载clone()方法）。
         * 二是在CloneB的clone()方法中加入一句o.unCA = (UnCloneA)unCA.clone();
         */
    }
}
