package main.java.io;

import java.io.*;

/**
 * @author fupengga
 */
public class MyInputStream {
    public static void main(String[] args) {
       System.out.println(read("/Users/fupengga/Desktop/fupengga.txt"));
    }
    public static String read(String path){
        //InputStream inputStream = null;
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        String s;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int count = 0;
           /* inputStream = new FileInputStream(new File("/Users/fupengga/Desktop/note.rtf"));
            while(inputStream.read(new byte[20]) != -1){
                count ++;
            }*/
            reader = new FileReader(new File(path));
            bufferedReader = new BufferedReader(reader);

            while((s = bufferedReader.readLine()) != null){
                stringBuilder.append(s + "\n");
            }
//            System.out.println(reader.markSupported());
//            System.out.print(count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }
}
