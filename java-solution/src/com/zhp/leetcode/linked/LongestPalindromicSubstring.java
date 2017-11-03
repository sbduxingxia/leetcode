package com.zhp.leetcode.linked;

import java.util.HashMap;

/**
 * @author zhp.dts
 * @date 2017/11/3.
 * @info 截取最长的回文字符串
 */
public class LongestPalindromicSubstring {
    public static String solution(String s){
        int beginIndex=0,endIndex=0,maxLength=0;
        int[] resultIndex = new int[2];
        for(int i=1;i<s.length();i++){
            beginIndex = i;
            endIndex = i;
            while(beginIndex-1>=0&&s.charAt(beginIndex-1)==s.charAt(i)){
                beginIndex--;
            }
            while(endIndex+1<s.length()&&s.charAt(endIndex+1)==s.charAt(i)){
                endIndex++;
            }
            i=endIndex;
            while(beginIndex-1>=0&&endIndex+1<s.length()&&s.charAt(beginIndex-1)==s.charAt(endIndex+1)){
                beginIndex--;
                endIndex++;
            }
            int cacheLen = endIndex-beginIndex;
            if(cacheLen%2==0){

            }
            if(maxLength<cacheLen){
                maxLength=cacheLen;
                resultIndex[0] = beginIndex;
                resultIndex[1] = endIndex;
            }
        }
        return s.substring(resultIndex[0],resultIndex[1]+1);
    }
    public static String solution2(String s){
        int beginIndex=0,endIndex=0,maxLength=0;
        int[] resultIndex = new int[2];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)==s.charAt(i)){//
                beginIndex = i-1;
                endIndex = i;
                while(beginIndex-1>=0&&s.charAt(beginIndex-1)==s.charAt(i)){
                    beginIndex--;
                }
                while(endIndex+1<s.length()&&s.charAt(endIndex+1)==s.charAt(i)){
                    endIndex++;
                }
                i=endIndex;
            }else{
                beginIndex =i;
                endIndex =i;
            }
            while(beginIndex-1>=0&&endIndex+1<s.length()&&s.charAt(beginIndex-1)==s.charAt(endIndex+1)){
                beginIndex--;
                endIndex++;
            }
            if(maxLength<endIndex-beginIndex){
                maxLength=endIndex-beginIndex;
                resultIndex[0] = beginIndex;
                resultIndex[1] = endIndex;
            }
        }
        return s.substring(resultIndex[0],resultIndex[1]+1);
    }

    public static void main(String[] args){
        String s ="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";//"abababababa";//
        long startTime = System.nanoTime();

        System.out.println(solution(s));
        System.out.println(System.nanoTime()-startTime);
    }
}
