package main.java.clone;

/**
 * 那么clone类为什么还要实现Cloneable接口呢？稍微注意一下，Cloneable接口是不包含任何方法的！其实这个接口仅仅是一个标志，而且 这个标志也仅仅是针对Object类中clone()方法的，
 * 如果clone类没有实现Cloneable接口，并调用了Object的clone()方 法（也就是调用了super.Clone()方法），那么Object的clone()方法就会抛出 CloneNotSupportedException异常。
 */
public strictfp class CloneDemo implements Cloneable {
    public int aInt;
    public  float a;

    public Object clone() {
        CloneDemo o = null;
        try {
            o = (CloneDemo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}

