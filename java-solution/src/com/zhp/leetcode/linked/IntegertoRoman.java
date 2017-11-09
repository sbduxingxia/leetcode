package com.zhp.leetcode.linked;

/**
 * @author zhp.dts
 * @date 2017/11/9.
 */
public class IntegertoRoman {
    //(1)，V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)
    public static String solution(int num){
        StringBuffer resultStr = new StringBuffer();
        int [] bs = new int[]{2,5};
        String [] romanKeys = new String[]{"I","V","X","L","C","D","M"};
        int base = 1000;
        int beginIndex = romanKeys.length-1;
        while(num>0){
            int keyNum = num/base;
            if(keyNum>3&&beginIndex<romanKeys.length-1){
                resultStr.append(romanKeys[beginIndex+1]);

            }else if(keyNum>0){
                if(beginIndex>0){
                    resultStr.append(romanKeys[beginIndex]);
                }
                for(int i=0;i<keyNum;i++){
                    resultStr.append(romanKeys[beginIndex-1]);
                }
            }
            beginIndex++;
            base = base/bs[beginIndex%2];
        }
        return "";
    }
    public static void main(String[] args){
        System.out.println(solution(1996));
    }
}
