package com.zhp.leetcode.linked;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhp.dts
 * @date 2017/11/15.
 * @info 输出n个“()”组合的字符串
 */
public class GenerateParentheses {
    public List<String> result = new LinkedList<>();
    public List<String> solution(int n){
        nextString(n,0,"");
        return result;
    }
    public void nextString(int n,int leftNum,String lastSoure){
        if(leftNum==0){
            if(lastSoure.length()>=n*2){
                result.add(lastSoure);
            } else {
                nextString(n,leftNum+1,lastSoure+"(");
            }
        }else if(leftNum==n){
            nextString(n,leftNum-1,lastSoure+")");
        }else/*(leftNum<n)*/{
            if(lastSoure.length()+leftNum==n*2){
                nextString(n,leftNum-1,lastSoure+")");
            }else{
                nextString(n,leftNum+1,lastSoure+"(");
                nextString(n,leftNum-1,lastSoure+")");

            }
        }
    }
    public static void main(String[]args){
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.solution(4);
        for(int i=0;i<generateParentheses.result.size();i++){
            System.out.println(generateParentheses.result.get(i));
        }
    }

}
