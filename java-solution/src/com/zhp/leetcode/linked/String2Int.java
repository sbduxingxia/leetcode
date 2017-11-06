package com.zhp.leetcode.linked;

/**
 * @author zhp.dts
 * @date 2017/11/6.
 * @info 将字符串转为int ,参考atoi方法
 * @link https://baike.baidu.com/item/atoi/10931331?fr=aladdin
 */
public class String2Int {
    public static int solution(String str){
        int result = 0;
        int step = 10;
        int flag = 1;
        int minValue = Integer.MIN_VALUE/step;
        int maxValue = Integer.MAX_VALUE/step;
        for(int i = 0;i<str.length();i++){
            char one = str.charAt(i);
            if(one>=48&&one<=57){
                if(result>maxValue){
                    return Integer.MAX_VALUE;
                }else if(result<minValue){
                    return Integer.MIN_VALUE;
                }else if(result == maxValue&&one>'7'){
                    return Integer.MAX_VALUE;
                }else if(result == minValue&&one>'8'){
                    return Integer.MIN_VALUE;
                }
                result = result*step+(one - 48)*flag;
            }else if(one == '.'){
                break;
            }else if(one=='-'){
                if(result==0){
                    flag = -1 * flag;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        String str = "--21474836.471";
        System.out.println(solution(str));
    }
}
