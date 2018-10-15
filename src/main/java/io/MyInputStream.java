package main.java.io;

import java.io.*;

public class MyInputStream {
    public static void main(String[] args) {
        //InputStream inputStream = null;
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            int count = 0;
           /* inputStream = new FileInputStream(new File("/Users/fupengga/Desktop/note.rtf"));
            while(inputStream.read(new byte[20]) != -1){
                count ++;
            }*/
            reader = new FileReader(new File("/Users/fupengga/Desktop/fupengga.txt"));
            bufferedReader = new BufferedReader(reader);
            while(bufferedReader.read() != -1){
                String s = bufferedReader.readLine();
                System.out.println(s);
            }
            System.out.println(reader.markSupported());
            System.out.print(count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
