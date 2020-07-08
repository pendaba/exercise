package main.java.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class StringTest {
    /**
     * 英文字母，空格，数字个数统计
     * @param str
     * @return
     */
    public String charStat(String str){
        char[] charArr = str.toCharArray();
        Map<Character,Integer> map = new TreeMap<>();
        for(int i = 0;i<charArr.length;i++){
            if ((charArr[i] >='A' && charArr[i] <= 'z') || charArr[i] == ' ' || (charArr[i] >= '0' && charArr[i] <= '9')){
                map.put(charArr[i],map.get(charArr[i]) == null ? 1: map.get(charArr[i])+1);
            }
        }
        List<Map.Entry> list = map.entrySet().stream().sorted( (entry1 , entry2) -> entry1.getValue().compareTo(entry2.getValue())).collect(Collectors.toList());
        Collections.reverse(list);

        return list.stream().map(entry -> String.valueOf(entry.getKey())).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(new StringTest().charStat("aabbcc"));
    }
}
