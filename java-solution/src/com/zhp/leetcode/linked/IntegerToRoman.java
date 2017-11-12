package com.zhp.leetcode.linked;

/**
 * @author zhp.dts
 * @date 2017/11/9.
 */
public class IntegerToRoman {
    //(1)，V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)
    public static String solution(int num){
        StringBuffer resultStr = new StringBuffer();
        String [][] romanKeys = new String[][]{{
                "I","V"},{"X","L"},{"C","D"},{"M",""}};
        int base = 1000;
        int beginIndex = 3;
        while(num>0&&beginIndex>=0){
            int keys = num/base;
            if(keys<=3){
                while(keys>0){
                    resultStr.append(romanKeys[beginIndex][0]);
                    keys--;
                }
            }else if(keys<5){
                resultStr.append(romanKeys[beginIndex][0])
                        .append(romanKeys[beginIndex][1]);
            }else if(keys<9){
                resultStr.append(romanKeys[beginIndex][1]);
                while(keys>5){
                    resultStr.append(romanKeys[beginIndex][0]);
                    keys--;
                }
            }else{
                resultStr.append(romanKeys[beginIndex][0])
                        .append(romanKeys[beginIndex+1][0]);
            }
            num = num%base;
            base = base/10;
            beginIndex--;
        }
        return resultStr.toString();
    }
    public static void main(String[] args){
        System.out.println(solution(1996));
        System.out.println(solution(2956));
        System.out.println(solution(1436));
        System.out.println(solution(1432));
        System.out.println(solution(96));
        System.out.println(solution(16));
    }

}
