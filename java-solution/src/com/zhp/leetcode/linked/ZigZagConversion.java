package com.zhp.leetcode.linked;

/**
 * @author zhp.dts
 * @date 2017/11/3.
 * @info 字符串已折现形式展示出来
 */
public class ZigZagConversion {


    public static String solution(String s, int numRows){
        if(numRows<=1) {
            return s;
        }
        String[] strings = new String[numRows];

        int changeNum = numRows-1;
        int flag =1;
        int rowIndex = 0;
        for(int i = 0; i<s.length();i++){
            if(i%changeNum==0){
                int n1 = i/changeNum;
                if(n1%2==0){
                    flag=1;
                }else{
                    flag=-1;
                }
            }
            if(strings[rowIndex]==null){
                strings[rowIndex]="";
            }
            strings[rowIndex]+=s.charAt(i);
            rowIndex+=flag;
        }
        String result="";
        for(int i=0;i<strings.length;i++){
            result+=(strings[i]==null?"":strings[i]);
        }
        return result;
    }
    public static void main(String[] args){
        String s ="ABCDEFGHIJKLMNOP";
        long startTime = System.nanoTime();
        System.out.println(solution(s,4));
        System.out.println(System.nanoTime()-startTime);
    }
}
