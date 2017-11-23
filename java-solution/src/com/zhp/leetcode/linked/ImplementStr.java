package com.zhp.leetcode.linked;

/**
 * @author zhp.dts
 * @date 2017/11/23.
 * @info 返回第一次出现在字符串中的指针位置，如果指针不存在，则返回-1。
 */
public class ImplementStr {
    public static int solution(String haystack, String needle){
        if(haystack.length()<needle.length()){
            return -1;
        }
        if(needle.length()==0){
            return 0;
        }
        int stackBegin = 0;
        while(stackBegin<haystack.length()-needle.length()+1){
            if(haystack.charAt(stackBegin)==needle.charAt(0)){
                boolean isFound = true;
                for(int i=1;i<needle.length();i++){
                    if(haystack.charAt(stackBegin+i)!=needle.charAt(i)){
                        isFound=false;
                        break;
                    }
                }
                if(isFound){
                    return stackBegin;
                }
            }
            stackBegin++;
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(solution("",""));
    }
}
