package main.java.genericity;

/**
 * @author fupengga
 * 泛型测试
 */
public class GenericityTest {

    public static void main(String[] args) {
        Plate<Fruit> plate = new Plate<>();

        Plate<Apple> applePlate = new Plate<>();
        /**
         * 上界通配符
         */
        Plate<? extends Fruit> applePlate1 = new Plate<Apple>();
        /**
         * 下界通配符
         */
        Plate< ? super Apple> applePlate2 = new Plate<Food>();

    }
}
