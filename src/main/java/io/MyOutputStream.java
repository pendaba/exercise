package main.java.io;

import java.io.*;

public class MyOutputStream {
    public static  void  main(String args[]){
       /* // TODO自动生成的方法存根
        byte[] buffer=new byte[512];   //一次取出的字节数大小,缓冲区大小
        int numberRead=0;
        FileInputStream input=null;
        FileOutputStream out =null;
        try {
            input=new FileInputStream("/Users/fupengga/Desktop/note.rtf");
            out=new FileOutputStream("/Users/fupengga/Desktop/符鹏嘎.rtf"); //如果文件不存在会自动创建

            while ((numberRead=input.read(buffer))!=-1) {  //numberRead的目的在于防止最后一次读取的字节小于buffer长度，
                out.write(buffer, 0, numberRead);       //否则会自动被填充0
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }finally{
            try {
                input.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File("/Users/fupengga/Desktop/fupengga.txt"));
            for (int i = 0;i<1000;i++){
                writer.write(i+"    "+"hello,world!"+"\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
