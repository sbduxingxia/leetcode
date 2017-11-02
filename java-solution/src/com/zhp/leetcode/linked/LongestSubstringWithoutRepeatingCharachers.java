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

    /**
     * 效率高
     * @param s
     * @return
     */
    public static int solution2(String s){
        byte[] chats = s.getBytes();
        int maxLength = 0,beginIndex=0;

        for(int i = 0;i<chats.length;i++){
            boolean isHad = false;
            byte one = chats[i];
            for(int j = beginIndex;j<i;j++){
                if(chats[j]==one){
                    isHad=true;
                    beginIndex=j+1;
                    break;
                }
            }
            if(isHad){
                if(maxLength<i-beginIndex+1){
                    maxLength=i-beginIndex+1;
                }
            }
        }
        if(maxLength<chats.length-beginIndex){
            maxLength=chats.length-beginIndex;
        }
        return maxLength;
    }
    public static void main(String[] args){
        String s = "abcouyphagkrfxzdefescyouyphagkrfxz";
        long nanoTime = (System.nanoTime());
        System.out.println(solution2(s));
        System.out.println(System.nanoTime()-nanoTime);
        s = "";
        System.out.println(solution(s));
    }
}
