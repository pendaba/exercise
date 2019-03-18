package main.java.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fupengga
 * 其实return与finally并没有明显的谁强谁弱。在执行时，是return语句先把返回值写入但内存中，然后停下来等待finally语句块执行完，return再执行后面的一段。
 */
public class FinallyTest {
    public static void main(String[] args) {
       System.out.println(test1());
    }
    public static Map<String, Integer> test(){
        Map<String,Integer> map  = new HashMap<>();
        try {
            map.put("aa",3);
            int i = 1/0;
            return map ;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("aa",5);
            return map ;
        } finally {
            map.put("bb",6);
        }

    }
    public static int test1() {
        int i = 0;
        try {
            i = 4;
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            i = 7;
            return i;
        } finally {
            i = 9;
            return i;

        }
    }
}
