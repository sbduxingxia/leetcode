package com.zhp.leetcode.linked;

import java.util.Arrays;

/**
 * @author zhp.dts
 * @date 2017/11/22.
 * @info 将传入的有序数组nums,去重后并返回原数组长度（非重部分），需要修改原有数组的赋值内容
 */
public class RemoveDuplicatesFromSortedArray {
    public static int solution(int[] nums){
        int lastIndex = 0;
        if(nums.length>1){
            for(int i=1;i<nums.length;i++){
                if(nums[i]!=nums[lastIndex]){
                    lastIndex++;
                    nums[lastIndex] = nums[i];
                }
            }
        }
        return lastIndex+1;
    }
    public static void main(String[] args){
        System.out.println(solution(new int[]{1,1,1,2}));
    }
}
