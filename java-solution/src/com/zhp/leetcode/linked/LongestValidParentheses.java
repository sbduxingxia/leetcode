package com.zhp.leetcode.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhp.dts
 * @date 2017/11/30.
 * @info 查找“（）”组合最长的长度是多少
 */
public class LongestValidParentheses {
    public static int solution(String s){
        if(s.length()<=1) {
            return 0;
        }
        int maxLength = 0;
        List<Integer> leftList = new ArrayList<>();
        int leftIndex = 0,rightIndex=0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='('){
                leftList.add(i);
                leftIndex=i;
            }else{
                if(leftList.size()>0){
                    rightIndex=i;
                    leftList.remove(leftList.size()-1);
                    if(leftList.size()>0){
                        leftIndex = leftList.get(leftList.size()-1)+1;
                    }else{
                        leftIndex = 0;
                    }
                    maxLength = Math.max(maxLength,rightIndex-leftIndex+1);
                }else{
                    leftList.clear();
                    s = s.substring(i+1);
                    i=-1;
                    if(rightIndex!=leftIndex){
                        maxLength = Math.max(maxLength,rightIndex-leftIndex+1);
                    }
                }
            }
        }
        if(leftIndex!=rightIndex){
            maxLength = Math.max(maxLength,rightIndex-leftIndex+1);
        }
        return maxLength;
    }
    public static void main(String[] args){
        System.out.println(solution(")(())))(())())"));
//        System.out.println(solution("(()()"));
//        System.out.println(solution("()()(()"));
//        System.out.println(solution("((())(((()"));
//        System.out.println(solution("()(())(()"));
    }
}
