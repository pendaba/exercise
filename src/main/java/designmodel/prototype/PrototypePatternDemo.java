package main.java.designmodel.prototype;

public class PrototypePatternDemo {

    static String a = "aaaa";
    public static void changeType(Shape circle){
        circle.type="circle11";
    }

    public static void changeValue(String a){
        a = "bbbb";
    }

    public static void main(String[] args) {
        ShapeCache.loacCache();
        Shape clonedShape = ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());

        System.out.println("==============");
        /**
         * 从这个例子知道Java对对象和基本的数据类型的处理是不一样的。和C语言一样，当把Java的基本数据类型（如int，char，double等）作为 入口参数传给函数体的时候，
         * 传入的参数在函数体内部变成了局部变量，这个局部变量是输入参数的一个拷贝，所有的函数体内部的操作都是针对这个拷贝的操作， 函数执行结束后，这个局部变量也就完成了它的使命，
         * 它影响不到作为输入参数的变量。这种方式的参数传递被称为"值传递"。而在Java中用对象的作为入口 参数的传递则缺省为"引用传递"，
         * 也就是说仅仅传递了对象的一个"引用"，这个"引用"的概念同C语言中的指针引用是一样的。当函数体内部对输入变量改变 时，实质上就是在对这个对象的直接操作。
         */
        changeType(clonedShape);
        changeValue(a);
        System.out.println(clonedShape.type);
        System.out.println(a);

        //除了在函数传值的时候是"引用传递"，在任何用"＝"向对象变量赋值的时候都是"引用传递"


    }
}
