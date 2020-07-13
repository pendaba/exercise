package main.java.algorithm;


import sun.util.resources.be.CalendarData_be;

public class Main {

    public String reverseWords(String s,int begin,int end){
        String[] array = s.split( " +");
        if(array == null || array.length == 0 || begin >= end || begin > array.length -1 || end < 0 || end > array.length-1){
            return "EMPTY";
        }
        StringBuffer result = new StringBuffer();

        String[]  tmp = new String[end-begin+1];
        int tmpEnd = end;
        for(int i = 0 ;i < tmp.length ; i++){
            tmp[i] = array[tmpEnd--];
        }
        if(tmp.length == 1){
            return "EMPTY";
        }
        for(int i = 0 ;i <= begin-1 ; i++){
            result.append(array[i].trim()).append(" ");
        }
        for(int i = 0 ;i < tmp.length ; i++){
            result.append(tmp[i].trim()).append(" ");
        }
        for(int i = end+1 ;i < array.length ; i++){
            result.append(array[i].trim()).append(" ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Main().reverseWords("hello I am a  developer",2,5));
    }
}
