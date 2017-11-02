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
        for(Byte one: s.getBytes()){
            if(!hadChar.containsKey(one)){
                hadChar.put(one,1);
            }
        }
        return hadChar.size();
    }
    public static void main(String[] args){
        String s = "abcabcabcabcabc";
        System.out.println(solution(s));
    }
}
