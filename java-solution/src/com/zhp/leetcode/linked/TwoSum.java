package com.zhp.leetcode.linked;

import java.util.HashMap;

/**
 * @author zhp.dts
 * @date 2017/11/2.
 * @info 获取数组中和为目标值的两个值的位置
 */
public class TwoSum {
    public static int[] solution(int [] list,int target){
        HashMap<Integer,Integer> value2Index = new HashMap<Integer,Integer>();
        for(int i=0;i<list.length;i++){
            if(value2Index.containsKey(list[i])){
                return new int[]{value2Index.get(list[i]),i};
            }
            int foundKey = target - list[i];//少一次运算
            value2Index.put(foundKey,i);
        }
        throw new IllegalArgumentException("没有找到答案");
    }

    public static int[] solution2(int [] list,int target){
        int[] result = new int[2];
        HashMap<Integer,Integer> value2Index = new HashMap<Integer,Integer>();
        for(int i=0;i<list.length;i++){
            int foundKey = target - list[i];
            if(value2Index.containsKey(foundKey)){
                result[0] = value2Index.get(foundKey);
                result[1] = i;
                break;
            }
            value2Index.put(list[i],i);
        }
        return result;
    }
    /*public static int[] solution3(int [] list,int target){
        int[] result = new int[2];
        if(list.length<2) {
            return result;
        }
        HashMap<Integer,Integer> value2Index = new HashMap<Integer,Integer>();
        for(int i=0;i<list.length;i++){
            if(value2Index.containsKey(list[i])){
                result[0] = value2Index.get(list[i]);
                result[1] = i;
                break;
            }
            if(list[i]+list[list.length-i-1]==target){
                result[0] = list.length-i-1;
                result[1] = i;
                break;
            }
            int foundKey = target - list[i];//少一次运算
            value2Index.put(foundKey,i);
            foundKey = target - list[list.length-1-i];
            value2Index.put(foundKey,list.length-1-i);
        }
        return result;
    }*/
    public static void main(String [] args){
        int [] list = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,23};
        int target = 24;
        int [] result = new int[2];
        long nanoTime = System.nanoTime(),nextTime=System.nanoTime();


        nanoTime = (System.nanoTime());
        int [] result1 = solution(list,target);
        nextTime =(System.nanoTime());
        System.out.println(nextTime-nanoTime);
        System.out.println(result1[0]+","+result1[1]);


        /*nanoTime = (System.nanoTime());
        int [] result2 = solution(list,target);
        nextTime =(System.nanoTime());
        System.out.println(nextTime-nanoTime);
        System.out.println(result2[0]+","+result2[1]);*/


        /*System.out.println(System.currentTimeMillis());
        result = solution3(list,target);
        System.out.println(System.currentTimeMillis());
        System.out.println(result[0]+","+result[1]);*/


    }
}
