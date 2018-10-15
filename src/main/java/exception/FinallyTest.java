package main.java.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FinallyTest {
    public static void main(String[] args) {
       System.out.println(test());
    }
    public static Map<String, Integer> test(){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-hh");
        Map<String,Integer> map  = new HashMap<>();
        try {
            Date date = simpleDateFormat.parse("2018-02-13");
            map.put("aa",3);
            return map ;
        } catch (ParseException e) {
            e.printStackTrace();
            map.put("aa",5);
            return map ;
        } finally {
            map.put("aa",6);
        }

    }
}
