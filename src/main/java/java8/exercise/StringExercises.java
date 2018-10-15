package main.java.java8.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StringExercises {


    public static int countLowercaseLetters(String string) {
        return (int) string.chars()
                .filter(Character::isLowerCase)
                .count();
    }

    public static  Long  charCountOfString(String s){
        return  s.chars().filter( cha -> cha == 'a').count();
    }

    /**
     * 返回字符串数组中小写字母最多的数组
     * 高级函数的标准：参数或返回值中包含有函数式接口
     * @param stringList
     * @return
     */
    public static Optional<String> mostLowercaseString(List<String> stringList){
        return stringList.stream().max(Comparator.comparing(StringExercises::countLowercaseLetters));
    }
    public static void main(String[] args) {
        //字符串操作
        String  s = "asfsdfhfeRterbvnbnrtyjjhaantryrewrwvv";

        System.out.println(charCountOfString(s));

        System.out.println(countLowercaseLetters(s));

        System.out.println(mostLowercaseString(Arrays.asList("sfsfwerrAS","asdfbGHYJGG","Hsdfds")).get());
    }
}
