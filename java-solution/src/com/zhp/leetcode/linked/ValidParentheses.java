package com.zhp.leetcode.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhp.dts
 * @date 2017/11/14.
 */
public class ValidParentheses {
    public static boolean solution(String s){
        String keys = "{[()]}";
        List<Integer> needMove = new ArrayList<Integer>();
        int firstFound = -1,nextFound = keys.length()-firstFound;
        for(int i=0;i<s.length();i++){
            int index = keys.indexOf(s.charAt(i));
            if(index>=0&&index<3){
                needMove.add(index);
            }else if(index>=3){
                if(needMove.size()==0||(needMove.get(needMove.size()-1)+index!=keys.length()-1)){
                    return false;
                }
                needMove.remove(needMove.size()-1);
            }
        }
        if(needMove.size()>0){
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(solution("122{}"));
        System.out.println(solution(""));
        System.out.println(solution("{[p(])}"));
    }
}
