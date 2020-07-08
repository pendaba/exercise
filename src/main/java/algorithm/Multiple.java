package main.java.algorithm;

import com.sun.deploy.util.StringUtils;

/**
 * 最小公倍数和最大公约数
 */
public class Multiple {
    public static int minMultiply(int a ,int b){
//        求两数最大公约数
        int minMultiply = 1;
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        int minDivision = 1;
        while (min != 0){
           minDivision = max%min;
           max = min;
           min = minDivision;

        }
        return (a*b)/max;
    }

    public static void main(String[] args) {
        System.out.println(minMultiply(328,7751));
    }



}
