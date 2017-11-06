package com.zhp.leetcode.linked.def;

/**
 * @author zhp.dts
 * @date 2017/11/6.
 * @info 将字符串转为int ,参考atoi方法
 * @link 整数是否是回文数,负数均不是
 */
public class PalindromeNumber {
    public static boolean solution(int x){
        int result = 0;
        int steps = 10;
        int old = x;
        if(x<0||(x!=0&&x%steps==0)) return false;
        if(x>=0&&x<10) return true;
        while(x!=0){
            int one = x%steps;
            x = x/steps;
            result = result*steps+one;
            if(x==result||x==result*steps+x%10){
                return true;
            }

        }
        return false;
    }

    /**
     * 参考网站的解决办法
     * @param x
     * @return
     */
    public static boolean solution2(int x) {
        if (x<0 || (x%10==0 && x!=0))    return false;
        if (x<10)   return true;
        int n=0;
        while (n<x){
            n *= 10;
            n += x%10;
            x /= 10;
        }
        if (n==x)   return true;
        n /= 10;
        return (n==x);
    }
    public static void main(String[]args){
        int x = 1;
        System.out.println(solution(x));
    }
}
