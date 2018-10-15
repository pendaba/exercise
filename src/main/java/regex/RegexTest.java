package main.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static  void main(String[] args){
        String str=",,,,呵呵,,,,";
        String rex="\\b呵呵\\b";
        Pattern pattern=Pattern.compile(rex);
        Matcher matcher=pattern.matcher(str);
        if(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
