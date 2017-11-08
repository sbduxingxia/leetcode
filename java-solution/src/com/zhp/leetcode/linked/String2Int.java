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
        boolean hadFLag=false;
        boolean isBegin = false;
        int minValue = Integer.MIN_VALUE/step;
        int maxValue = Integer.MAX_VALUE/step;
        for(int i = 0;i<str.length();i++){
            char one = str.charAt(i);

            if(isBegin&&(one<48&&one>57)){
                break;
            }
            if(one=='-'||one=='+'||one==' '){
                if(hadFLag){
                    break;
                }else if(one==' '){

                }else{
                    hadFLag = true;
                    flag = one=='-'?-1:1;
                }
            }else if(one>=48&&one<=57){
                if(result>maxValue){
                    return Integer.MAX_VALUE;
                }else if(result<minValue){
                    return Integer.MIN_VALUE;
                }else if(result == maxValue&&one>'7'){
                    return Integer.MAX_VALUE;
                }else if(result == minValue&&one>'8'){
                    return Integer.MIN_VALUE;
                }
                hadFLag = true;
                result = result*step+(one - 48)*flag;
            }else{
                break;
            }
        }
        return result;
    }
    public static void main(String[] args){
        String str ="123  456" ;//"  -0012a42";//"   +0 123";//
        System.out.println(solution(str));

        String source= "370312";
        System.out.println(source.substring(0,source.length()-2));
    }
}
