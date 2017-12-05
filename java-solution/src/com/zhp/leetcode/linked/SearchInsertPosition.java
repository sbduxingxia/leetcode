package com.zhp.leetcode.linked;

/**
 * @author zhp.dts
 * @date 2017/12/5.
 * @info 搜索有序数组的数值插入的索引位置
 */
public class SearchInsertPosition {
    public static int solution(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            if(nums[i]>= target){
                return i;
            }
        }
        return nums.length;
    }
}
