package main.java.data;

public class ArrayTest {
    public static void main(String[] args) {
        int[] intArr = new int[20];
        for(int i = 0;i<18;i++){
            intArr[i] = i;
        }
        System.out.println(intArr.length);
    }
}
