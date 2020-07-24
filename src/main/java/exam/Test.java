package main.java.exam;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public int[] department= new int[]{10,7,5,4};

    /**
     *      * [7, 8, 6, 5]
     *      * [8, 5, 7, 6]
     *      * [5, 6, 8, 7]
     *      * [6, 7, 5, 8]
     *      * [7, 8, 6, 5]
     *      * [8, 5, 7, 6]
     *    //观察可得出结论每4ci调整后部门结构都会回到原来的样子，所以10年后的部门结构是第一种情况（7，8，6，5）
     *         int  type = (10*12)%4;
     */
    public void optimize(){
       Integer max = 0;
        for(int i =0 ;i< department.length;i++){
          max = Math.max(max,department[i]);
        }
        for(int i =0 ;i< department.length;i++){
            if(max == department[i]){
                department[i] = department[i]-3;
            }else{
                department[i] = department[i]+1;
            }

        }
        System.out.println(Arrays.toString(department));

    }

    /**
     * 某产品的⽤户注册邀请码为⼀串有⼩写字⺟和数字组成的字符串，字符串⻓度为16。当⽤户数据邀
     * 请码的时候，系统需要对邀请码做有效性验证，假设验证规则如下：
     * 1、 从序列号最后⼀位字符开始，逆向将奇数位(1、3、5等等)相加；
     * 2、从序列号最后⼀位数字开始，逆向将偶数位数字，先乘以2（如果乘积为两位数，则将其减去
     * 9），再求和；
     * 3、将奇数位总和加上偶数位总和，结果可以被10整除；
     * 4、⼩写字⺟对应数值，可由下⾯键值对确定；
     * [(a,1), (b,2), (c,3)…,(i,9), (j,1), (k, 2)…]，亦即，按字⺟顺序，1-9循环。
     * 输⼊：输⼊16位字符串，表示邀请码
     * 输出：输出“ok”或者“error”
     * @param s
     * @return
     */
    public String validateString(String s){
        char[] chars = s.toCharArray();
        int tmp;
        int sum = 0;
        List<Integer> numbers = new ArrayList<>();
        for(int i = chars.length-2; i >= 0; i = i -2){
            if(chars[i] >= 'a' && chars[i] <= 'z') {
                tmp = (chars[i] - 'a' + 1)%9;
                sum = sum + tmp;
            }else{
                sum = sum+(chars[i]-'0');
            }
            if(chars[i] >= '0' && chars[i] <= '9'){
                numbers.add(Integer.valueOf(chars[i]));
            }
        }
        for(int i = numbers.size()-1;i >= 0 ;i = i-2){
            if(numbers.get(i)*2 >= 10 && numbers.get(i)*2 <= 99){
                sum = sum + numbers.get(i)*2-9;
            }else{
                sum = sum + numbers.get(i)*2;
            }
        }
        if(sum % 10 == 0){
            return "ok";
        }else{
            return "error";
        }
    }

    /**
     * ⼩明的抽屉⾥有n个游戏币，总⾯值m，游戏币的设置有1分的，2分的，5分的，10分的，⽽在⼩明
     * 所拥有的游戏币中有些⾯值的游戏币可能没有，求⼀共有多少种可能的游戏币组合⽅式？
     * 输⼊：输⼊两个数n(游戏币的个数)，m(总⾯值)。
     * 输出：请输出可能的组合⽅式数；
     * @param n
     * @param m
     */
    public int find(int n,int m){
        int possibleCount = 0;
        boolean flag = true;
        return recursionFind(n,m,possibleCount);
    }

    public int recursionFind(int n, int m, int possibleType) {
        System.out.println("n="+n+",m="+m+",possibleType="+possibleType);
        List<Integer> list = new ArrayList<>();
        if (n == 0 && m == 0) {
            possibleType++;
        }
        if (n == 0 || m <= 0) {
            return possibleType;
        }

        possibleType = recursionFind(n - 1, m - 10, possibleType);
        possibleType = recursionFind(n - 1, m - 5, possibleType);
        possibleType = recursionFind(n - 1, m - 2, possibleType);
        possibleType = recursionFind(n - 1, m - 1, possibleType);
        return possibleType;

    }


    /**

     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Test().find(3,11));

    }
}
