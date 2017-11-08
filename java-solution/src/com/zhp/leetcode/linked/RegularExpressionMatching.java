package com.zhp.leetcode.linked;

/**
 * @author zhp.dts
 * @date 2017/11/6.
 * @info 匹配运算
 * '.' Matches any single character.//可以充当任一个字符
 * '*' Matches zero or more of the preceding element.//可以同前面的元素A一起充当0-n个元素A。
 */
public class RegularExpressionMatching {
    public static boolean solution(String s,String p){
        if(s.length()>0&&p.length()>0&&s.length()!=p.length()&&p.indexOf('*')<0){
            return false;
        }
        if((s.length()!=0&&p.length()==0)){
            return false;
        }
        if(s.length()==p.length()&&s.length()==0){
            return true;
        }
        if(p.length()>=2&&p.charAt(1)=='*'){//存在*
            if(p.length()>=3){
                if(p.charAt(2)==p.charAt(0)){
                    if(p.length()>3){
                        if(p.charAt(3)=='*'){
                            return solution(s,p.substring(2));
                        }
                    }
                    return solution(s,p.substring(0,1)+p.substring(0,1)+p.substring(1,2)+p.substring(3));
                }
            }
            boolean isSoluton = solution(s,p.substring(2));
            if(s.length()>0&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.')){//
                return (isSoluton||solution(s.substring(1),p.substring(2))||solution(s.substring(1),p));
            }else{
                return (solution(s,p.substring(2)));
            }
        }else{
            if(s.length()>0&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.')){
                return solution(s.substring(1),p.substring(1));
            }else{
                return false;
            }
        }
    }

    /**
     * 效率高德方法
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for(int j = 1; j <= plen; j++) {
            if(p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for(int i = 1; i <= slen; i++) {
            for(int j = 1; j <= plen; j++) {
                char pc = p.charAt(j - 1), sc = s.charAt(i - 1);
                if(pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(pc == '*') {
                    // * stand for empty
                    dp[i][j] = dp[i][j - 2];
                    // * stand for a single char
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                    // * stand for multiple char
                    if(sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // pc is a char
                    if(pc == sc) {
                        dp[i][j] = dp[i- 1][j - 1];
                    }
                }
            }
        }
        return dp[slen][plen];
    }
    public static void main(String[] args){
//        String s="",p="";

        System.out.println(solution("aaa","a*a")); //→ true
        System.out.println(solution("a","ab*")); //→ true
        System.out.println(solution("aa","aa")); //→ true
        System.out.println(solution("aa", "a*"));// → true
        System.out.println(solution("aa", ".*"));// → true
        System.out.println(solution("ab", ".*"));// → true
        System.out.println(solution("aab", "c*a*b"));// → true
        System.out.println(solution("aaa", "ab*ac*a"));// → true
        System.out.println(solution("aaa", "ab*a*c*aa"));// → true
        System.out.println(solution("aaa", "ab*aa*ac*"));// → true
        System.out.println(solution("aaa", "ab*a*c*a"));// → true
        System.out.println(solution("a",".*..a*"));// → false
        System.out.println(solution("abcd", "d*"));// → false
        System.out.println(solution("aaba", "ab*a*c*a"));// → false
        System.out.println(solution("aa","a")); //→ false
        System.out.println(solution("aaa","aa"));// → false
        System.out.println(solution("aaaaaaaaaaaaab","a*a*a*a*a*a*a*a*a*a*c")); // → false
        System.out.println(solution("a",".*..a*")); //→ false
//        System.out.println("*sadfsf*ssfs*".indexOf('*'));
    }
}
