package com.zhp.leetcode.linked;

import java.util.HashMap;

/**
 * @author zhp.dts
 * @date 2017/11/2.
 * @info 获取字符串非重复字符的数量
 */
public class LongestSubstringWithoutRepeatingCharachers {
    public static int solution(String s){
        HashMap<Byte,Integer> hadChar = new HashMap<>();
        int maxLenght = 0,beginIndex = 0;
        byte[] chars = s.getBytes();
        for(int i=0;i<chars.length;i++){
            if(hadChar.containsKey(chars[i])&&hadChar.get(chars[i])>=beginIndex){//存在
                if(maxLenght<i-beginIndex){
                    maxLenght = i-beginIndex;
                }
                beginIndex = hadChar.get(chars[i])+1;
            }
            hadChar.put(chars[i],i);
        }
        if(maxLenght<chars.length-beginIndex){
            maxLenght=chars.length-beginIndex;
        }
        return maxLenght;
    }
    public static void main(String[] args){
        String s = "abcouyphagkrfxzdefescyouyphagkrfxz";
        System.out.println(solution(s));
        s = "";
        System.out.println(solution(s));
    }
}
