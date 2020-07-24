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

    /**
     * 给定英文字符串中的最大回文串长度
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int[] intArr= new int[58];
        for(char c : s.toCharArray()){
            intArr[c - 'A'] += 1;
        }
        int result = 0;
        for(int a : intArr){
            result += a - (a & 1);
        }
        return result < s.length() ? result+1:result;
    }

    /**
     * 两个字符串的最长公共子串
     * @param a
     * @param b
     * @return
     */
    public String maxSubstring(String a,String b){
        if(a == null || "".equals(a) || b == null || "".equals(b)){
            return null;
        }
        String max = a.length()> b.length()? a:b;
        String min = a.length()< b.length()? a:b;
        for(int i=0;i<min.length();i++) {
            //每次子串长度减一，判断大串是否包含子串
            for (int beg = 0, end = min.length() - i; end <= min.length(); beg++, end++) {
                //取子串
                String s = min.substring(beg, end);
                //如果大串中含有子串，则返回子串，该子串就是最大的公共子串
                //这里也可以使用java中String类提供的contains()方法，这里选择自己写一个类似的方法
                if (max.contains(s)) {
                    return s;
                }
            }
        }
        return null;
    }

    /**
     * 按字节截取字符串
     * @param
     */
//    public String subByByte(String s ,int length){
//
//    }

    /**
     * leetcode：91 解码方法
     * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
     *
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     */
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        return decode(chars,chars.length-1);
    }

    private int decode(char[] chars, int i) {
        if(i == 0 && chars[i] == '0'){
            return 0;
        }
        if(i <= 0){
            return 1;
        }
        int count = 0;

        char curr = chars[i];
        char prev = chars[i-1];
        if(curr > '0'){
            count = decode(chars,i-1);
        }
        if(prev == '1' || (prev == '2' && curr <= '6')){
            count += decode(chars,i-1);
        }
        return count;

    }

    /**
     * 不重复最大子串字符个数
     * 快慢指针法
     */

    public int lengthOfLongestSubstring(String s){
        Set<Character> characters = new HashSet<>();
        int max = 0;
        for(int i=0,j=0;j<s.length();j++){
            while (characters.contains(s.charAt(j))){
                characters.remove(s.charAt(i));
                i++;
            }
            characters.add(s.charAt(j));
            max = Math.max(max,characters.size());
        }
        return max;
    }

    /**
     * hashMap
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s){
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0,j=0;j<s.length();j++){
            while (map.containsKey(s.charAt(j))){
                i = Math.max(i,map.get(s.charAt(j))+1);
            }
            map.put(s.charAt(j),j);
            max = Math.max(max,j-i+1);
        }
        return max;
    }

    /**
     * 两个数组的交集
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
       Map<Integer,Integer> map = new HashMap<>();
       for(int i = 0;i<nums1.length;i++){
           map.put(nums1[i],map.get(nums1[i]) == null? 1 :map.get(nums1[i])+1);
       }
       List<Integer> result = new ArrayList<>();
       for(int j = 0;j< nums2.length;j++){
           if(map.containsKey(nums2[j])){
               result.add(nums2[j]);
               map.put(nums2[j],map.get(nums2[j])-1);
               if(map.get(nums2[j]) < 1){
                   map.remove(nums2[j]);
               }
           }
       }
       int[] tmp = new int[result.size()];
       for(int i =0;i< result.size();i++){
           tmp[i] = result.get(i);
       }
       return tmp;
    }

    /**
     * 左旋字符串
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        char[] result = new char[s.length()];
        int low = n;
        int high = 0;
        for(int i = 0;i<s.length()-n;i++){
            result[i] = s.charAt(low);
            low++;
        }
        for(int i = s.length()-n;i<s.length();i++){
            result[i] = s.charAt(high);
            high++;
        }
        return new String(result);
    }
    public static void main(String[] args) {
//        System.out.println(new StringTest().charStat("aabbcc"));
//        System.out.println(new StringTest().maxSubstring("aaaaafghj","sdfsdfghjgfggg"));
//        System.out.println(new StringTest().numDecodings("216"));
//        System.out.println(Arrays.toString(new StringTest().intersect(new int[]{1,2,3,1,2,4},new int[]{1,2,2})));
//        System.out.println(new StringTest().reverseLeftWords("abcdefg",2));
    }
}
