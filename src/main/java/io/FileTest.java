package main.java.io;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fupengga
 * 文件类的方法测试
 */
public class FileTest {

    static List<File> excelFiles = new ArrayList<>();

    public static void main(String[] args) {
//       recursionFile("/Users/fupengga/IdeaProjects");
//       sortFile("/Users/fupengga/IdeaProjects/exercise/src/main/java/sort");
       findExcel("/Users/fupengga/IdeaProjects");
       if(excelFiles != null){
           excelFiles.stream().map(file -> file.getName()).forEach(System.out::println);
       }
    }

    /**
     * 递归遍历文件夹下问价
     * @param path
     */
    public static  void recursionFile(String path){
        File file = new File(path);
        if(file.exists()){
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                return;
            }else{
                for(File file1 : files){
                    if(file1.isDirectory()){
                        System.out.println("文件夹："+file1.getAbsolutePath());
                        recursionFile(file1.getAbsolutePath());
                    }else{
                        System.out.println(" 文件："+file1.getAbsolutePath());
                    }

                }
            }
        }
    }

    /**
     * 目录下文件过滤排序展示
     * @param path
     */
    public static  void sortFile(String path){
        File dir = new File(path);
        String[] list = dir.list((file,name)->name.endsWith(".java"));
        Arrays.stream(list).sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::println);
    }
    /**
     * 找到固定目录下的所有excel文件
     */
    public static void findExcel(String path){
        File file = new File(path);
        if(file.exists()){
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                return;
            }else{
                for(File file1 : files){
                    if(file1.isDirectory()){
                        findExcel(file1.getAbsolutePath());
                    }else{
                        if(file1.getName().endsWith(".xls")){
                            excelFiles.add(file1);
                        }
                    }

                }
            }
        }
    }
}
