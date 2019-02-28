package main.java.io;

import java.io.*;

/**
 * @author fupengga
 */
public class DataInputStreamTest {
    public static void main(String[] args) {
//       memoryInput();
//        formattedMemoryInput();
        fileOutput();
    }

    /**
     * StringReader的读
     */
    public static void memoryInput(){
        StringReader in = null;
        try {
            in = new StringReader(MyInputStream.read("/Users/fupengga/Desktop/fupengga.txt"));
            int c;
            while ((c = in.read()) != -1){
                System.out.println((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * DataInputStream.read
     */
    public static void formattedMemoryInput(){
        DataInputStream in = null ;
        try {
            in = new DataInputStream(new ByteArrayInputStream(MyInputStream.read("/Users/fupengga/Desktop/fupengga.txt").getBytes()));
//            available()方法返回还有多少可以读取的字符，
            while (in.available() != 0 ){
                System.out.println((char)in.readByte());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 流的输出使用PringWriter
     */
    public static void fileOutput(){
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/fupengga/Desktop/fupengga1.txt")));
            in = new BufferedReader(new StringReader(MyInputStream.read("/Users/fupengga/Desktop/fupengga.txt")));
            int line = 1;
            String s;
            while ((s = in.readLine()) != null){
                out.println(line++ + ":" + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 流的输出使用PringWriter,构造器简化版本
     */
    public static void fileOutShortcut(){
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new StringReader(MyInputStream.read("/Users/fupengga/Desktop/fupengga.txt")));
            //简化了printWriter的构造器
            out = new PrintWriter("/Users/fupengga/Desktop/fupengga1.txt");
            int line = 1;
            String s;
            while ((s = in.readLine()) != null){
                out.println(line++ + ":" + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
