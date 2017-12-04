package com.zhp.leetcode.linked;

import java.util.Arrays;

/**
 * @author zhp.dts
 * @date 2017/12/4.
 * @info 搜索出数组中targe的索引范围他，不存在是返回[-1,-1]
 */
public class Search4Range {

    public static int[] solution(int[] nums,int target){
        int [] result = new int[]{-1,-1};
        boolean isFound = false;
        for(int i=0;i<nums.length;i++){
            if(!isFound&&nums[i]>target){
                break;
            }else if(nums[i]==target){
                if(!isFound){
                    isFound = true;
                    result[0] = i;
                    result[1] = i;
                }else{
                    result[1] = i;
                }
            }else if(isFound){
                break;
            }
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,7,7,8,8,8,8,8,9,9,9},5)));
    }
}
