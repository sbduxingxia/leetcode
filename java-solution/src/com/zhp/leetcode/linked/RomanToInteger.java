package com.zhp.leetcode.linked;

/**
 * @author zhp.dts
 * @date 2017/11/9.
 */
public class RomanToInteger {
    //(1)，V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)
    public static int solution(String s){
        int result = 0;
        int index = s.length()-1;
        int lastBase = 0;
        while(index>=0){
            char c = s.charAt(index);
            int base = 1;
            switch(c){
                case 'M':
                    base *=10;
                case 'C':
                    base *=10;
                case 'X':
                    base *=10;
                case 'I':
                    result +=base;
                    if(lastBase>base){
                        result -=base*2;
                    }
                    lastBase = base;
                    break;
                case 'D':
                    base *=10;
                case 'L':
                    base *=10;
                case 'V':
                    result +=5*base;
                    lastBase = 5*base;
                break;
            }
            index--;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(solution("MCMXCVI"));//1996));
        System.out.println(solution("MMCMLVI"));//2956));
        System.out.println(solution("MCDXXXVI"));//1436));
        System.out.println(solution("MCDXXXII"));//1432));
        System.out.println(solution("XCVI"));//96));
        System.out.println(solution("XVI"));//16));
    }

}
