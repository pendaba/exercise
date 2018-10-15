package main.java.clone;

public class StrClone {
    public static void main(String[] a){
        CloneC c1 = new CloneC();
        c1.str = new String("initializeStr");
        c1.strBuff = new StringBuffer("initializeStrBuff");
        System.out.println("before clone,c1.str = "+ c1.str);
        System.out.println("before clone,c1.strBuff = "+ c1.strBuff);

        CloneC c2 = (CloneC)c1.clone();
        c2.str = c2.str.substring(0,5);
        c2.strBuff = c2.strBuff.append(" change strBuff clone");
        System.out.println("=================================");
        System.out.println("after clone,c1.str = "+ c1.str);
        System.out.println("after clone,c1.strBuff = "+ c1.strBuff);
        System.out.println("=================================");
        System.out.println("after clone,c2.str = "+ c2.str);
        System.out.println("after clone,c2.strBuff = "+ c2.strBuff);
    }
}