package main.java.date;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @description 日期测试类
 * @author fupengga
 * @date 2019/5/11
 */
public class MyDate {
    public static void main(String[] args){
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
