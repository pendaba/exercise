package main.java.algorithm;

import java.util.HashMap;
import java.util.Map;

public class Main1 {

    public String decodeString(String s){
        int[] intArr = new int[26];
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ;i< chars.length;i++){
            if(chars.length > 100 || !((chars[i] >='0' && chars[i] <= '9') || (chars[i] >= 'a' && chars[i] <= 'z'))){
                return "!error";
            }
            if(chars[i] >='0' && chars[i] <= '9'){
                continue;
            }
            intArr[chars[i]-'a'] = intArr[chars[i]-'a']+1;

        }

        for(int i = 0;i<intArr.length;i++){
            if(intArr[i] > 2){
                return "!error";
            }
        }
        StringBuffer result = new StringBuffer();
        for(int i = 0;i< chars.length;i++){

            if(chars[i] >'0' && chars[i] <= '9'){
                int count = 0;
                if(chars[i+1] >= '0' && chars[i+1] <= '9'){
                    count = Integer.parseInt(String.valueOf(chars[i]))*10+Integer.parseInt(String.valueOf(chars[i+1]));
                    for(int j = 0;j< count-1;j++){
                        result.append(chars[i+2]);
                    }
                    i = i+2;
                }else{
                    count = Integer.parseInt(String.valueOf(chars[i]));
                    for(int j = 0;j< count-1;j++){
                        result.append(chars[i+1]);
                    }
                    i = i+1;
                }

            }
            result.append(chars[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Main1().decodeString("3a5c"));
    }
}
