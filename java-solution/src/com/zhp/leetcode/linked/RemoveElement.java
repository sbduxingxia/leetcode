package com.zhp.leetcode.linked;

import java.util.Arrays;

/**
 * @author zhp.dts
 * @date 2017/11/23.
 * @info 给定一个数组和一个值，删除该值的所有实例并返回新长度
 */
public class RemoveElement {
    public static int solution(int [] nums,int val){
        int beginIndex = 0;
        int endIndex = nums.length;
        while(beginIndex<endIndex){
            if(nums[beginIndex]==val){
                if(beginIndex<endIndex-1){
                    endIndex--;
                    while(beginIndex<endIndex){
                        if(nums[endIndex]!=val){
                            nums[beginIndex] = nums[endIndex];
                            nums[endIndex] = val;
                            beginIndex++;
                            break;
                        }else{
                            endIndex--;
                        }
                    }
                }else{
                    return beginIndex;
                }
            }else{
                beginIndex++;
            }
        }
        return beginIndex;
    }
    public static void main(String[] args){
        int [] nums = new int[]{};
        System.out.println(solution(nums,3));
        System.out.println(Arrays.toString(nums));

        System.out.println("hello".indexOf("ll"));
    }
}
