package com.zhp.leetcode.linked;

import java.util.HashMap;

/**
 * @author zhp.dts
 * @date 2017/11/3.
 * @info 截取最长的回文字符串
 */
public class LongestPalindromicSubstring {
    public static String solution(String s){
        if(s==null||s.length()==0) {
            return "";
        }
        byte[] chars = s.getBytes();
        int beginIndex = 0,endIndex=0,lastIndex=0;

        int sameBegin = 0,sameEnd=0;
        HashMap<Byte,Integer> char2Index = new HashMap<Byte,Integer>();
        int maxLength = 0;
        int[] resultIndex = new int[2];
        for(int i = 0 ;i<chars.length;i++){
            byte one = chars[i];
            if(char2Index.containsKey(one)){
                lastIndex  = char2Index.get(one);
                if(lastIndex+i==(i-1)*2||i-lastIndex==1){//符合第一个的情况
                    if(i-lastIndex==1){//连续相同字符
                        beginIndex = lastIndex;
                        endIndex = i;
                        for(int j = i+1;j<chars.length;j++){
                            if(chars[j]==chars[i]){
                                beginIndex = lastIndex;
                                endIndex = j;
                            }else{
                                break;
                            }
                        }
                        if(endIndex-beginIndex>maxLength){
                            maxLength = endIndex-beginIndex;
                            resultIndex[0] = beginIndex;
                            resultIndex[1] = endIndex;
                        }
                    }
                    beginIndex = lastIndex;
                    endIndex = i;
                    for(int j = i+1;j<chars.length;j++){
                        if(beginIndex-1<0){
                            break;
                        }
                        if(chars[beginIndex-1]==chars[j]){
                            beginIndex = beginIndex-1;
                            endIndex++;
                        }else{
                            break;
                        }
                    }
                    if(endIndex-beginIndex>maxLength){
                        maxLength = endIndex-beginIndex;
                        resultIndex[0] = beginIndex;
                        resultIndex[1] = endIndex;
                    }
                }
            }
            char2Index.put(one,i);
        }
        return s.substring(resultIndex[0],resultIndex[1]+1);
    }
    public static void main(String[] args){
        String s ="caabbad";//"badbadbadbadbadbadbad";//"abababababa";//
        long startTime = System.nanoTime();
        System.out.println(solution(s));
        System.out.println(System.nanoTime()-startTime);
    }
}
