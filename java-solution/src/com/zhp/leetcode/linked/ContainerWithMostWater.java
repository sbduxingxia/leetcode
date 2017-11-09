package com.zhp.leetcode.linked;

/**
 * @author zhp.dts
 * @date 2017/11/9.
 * @info 在xy坐标系中，求出数组中两个点(i,height[i])、(j,height[j])与X轴组成的长方形面积最大的值。
 * 数组坐标为X轴值，对应的值为Y，即height[i] 表示 点(i,height[i])。
 */
public class ContainerWithMostWater {
    public static int solution(int[] height){
        int maxArea = 0;
        int leftIndex = 0,rightIndex=height.length-1;
        while(leftIndex<rightIndex){
            int areaHeight = height[leftIndex];
            int areaWidth = rightIndex-leftIndex;
            if(areaHeight<height[rightIndex]){
                leftIndex++;
            }else{
                areaHeight = height[rightIndex];
                rightIndex--;
            }
            int area = areaWidth*areaHeight;
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
    public static void main(String[] args){
        int [] height = new int[]{1,5,2,3,4};
        System.out.println(solution(height));
    }
}
