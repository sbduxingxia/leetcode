package com.zhp.leetcode.linked;

/**
 * @author zhp.dts
 * @date 2017/11/24.
 * @info 两个整数的除法，超出范围时返回最大正整数
 */
public class DivideTwoIntegers {
    public static int solution(int dividend, int divisor){
        if(divisor==Integer.MIN_VALUE){
            if(dividend==Integer.MIN_VALUE){
                return 1;
            }else{
                return 0;
            }
        }
        if(divisor==0) {
            return Integer.MAX_VALUE;
        }
        if(dividend==0){
            return 0;
        }
        int buchong = 0;
        if(dividend==Integer.MIN_VALUE){
            buchong=1;
            dividend += 1;
        }
        boolean isZheng = (dividend>0&&divisor>0)||(dividend<0&&divisor<0);
        int result = 0;
        int cacheDivisor = Math.abs(divisor);
        int cacheDivident = Math.abs(dividend);
        while(cacheDivident>=cacheDivisor){
            if(result==0){
                result = 1;
            }
            if(cacheDivisor<<1 > cacheDivisor){
                result = result<<1;
                cacheDivisor = cacheDivisor<<1;
            }else{
                break;
            }

        }
        if(result>0){
            if(result>=2){
                result = result>>1;
                cacheDivisor = cacheDivisor>>1;
            }
            int cacheResult= result;
            cacheDivident = cacheDivident - cacheDivisor+buchong;
            while(cacheDivisor>=divisor&&cacheDivident>0){
                if(cacheDivident > cacheDivisor){
                    cacheDivident = cacheDivident - cacheDivisor;
                    if(result+cacheResult<result&&isZheng){
                        return Integer.MAX_VALUE;
                    }
                    result+=cacheResult;
                }else if(cacheDivident < cacheDivisor){
                    cacheResult = cacheResult>>1;
                    cacheDivisor = cacheDivisor>>1;
                }else{
                    cacheDivident = cacheDivident - cacheDivisor;
                    if(result+cacheResult<result&&isZheng){
                        return Integer.MAX_VALUE;
                    }
                    result+=cacheResult;
                }
            }
        }
        return isZheng?result:-result;
    }
    public static void main(String[] args){
        Long beginTime = (System.nanoTime());
//        System.out.println(solution(Integer.MIN_VALUE,-1));
//        System.out.println(solution(Integer.MIN_VALUE,1));
        System.out.println(solution(1100540749,-1090366779));
//        System.out.println(solution(Integer.MAX_VALUE,10));
//        System.out.println(3>>1);
//        System.out.println(System.nanoTime()-beginTime);
    }
}
