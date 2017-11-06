package com.zhp.leetcode.linked;

/**
 * @author zhp.dts
 * @date 2017/11/6.
 * @info 整数类型倒叙展示
 */
public class ReverseInteger {
    public static int solution(int x){
        int result = 0;
        int steps = 10;
        while(x!=0){
            int one = x%steps;
            x = x/steps;
            result = result*steps+one;
        }
        return result;
    }
    public static void main(String[] args){
        Integer num = 0;
        System.out.println(solution(num));
    }
}
