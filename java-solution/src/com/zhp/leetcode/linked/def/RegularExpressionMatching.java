package com.zhp.leetcode.linked.def;

/**
 * @author zhp.dts
 * @date 2017/11/6.
 * @info 匹配运算
 * '.' Matches any single character.//可以充当任一个字符
 * '*' Matches zero or more of the preceding element.//可以同前面的元素A一起充当0-n个元素A。
 */
public class RegularExpressionMatching {
    public static boolean solution(String s,String p){
        if(p.length()==0&&s.length()==0){
            return true;
        }
        int lastIndex = 0;
        int nowIndex  = p.indexOf('*');
        if(nowIndex<0&&p.length()!=s.length()){
            return false;
        }
        String cache = p;
        while(nowIndex>=0){
            lastIndex += nowIndex+1;
            cache = cache.substring(nowIndex+1);
            nowIndex = cache.indexOf("*");
        }
        int beginIndex = s.length()-p.length()+lastIndex;
        if(beginIndex<0){
            return false;
        }
        for(int i=beginIndex;i<s.length();i++){

            if(p.length()>lastIndex&&(s.charAt(i)==p.charAt(lastIndex)||p.charAt(lastIndex)=='.')){

            }else{
                return false;
            }
            lastIndex++;

        }
        return true;
    }
    public static void main(String[] args){
        String s="",p="";
        System.out.println(solution("aa","a")); //→ false
        System.out.println(solution("aa","aa")); //→ true
        System.out.println(solution("aaa","aa"));// → false
        System.out.println(solution("aa", "a*"));// → true
        System.out.println(solution("aa", ".*"));// → true
        System.out.println(solution("ab", ".*"));// → true
        System.out.println(solution("aab", "c*a*b"));// → true
        System.out.println(solution("abcd", "d*"));// → false
//        System.out.println("*sadfsf*ssfs*".indexOf('*'));
    }
}
