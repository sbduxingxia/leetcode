package com.zhp.leetcode.linked;

import com.zhp.leetcode.linked.def.ListNode;

/**
 * @author zhp.dts
 * @date 2017/11/17.
 */
public class ReverseNodesInKGroup {
    public static ListNode solution(ListNode head,int k){
        if(k<=1) {
            return head;
        }
        ListNode[] listNodes  = new ListNode[k-1];
        ListNode resultNode = new ListNode(0);
        resultNode.next = head;
        ListNode curNode = head;
        ListNode preNode = resultNode;
        ListNode nextNode = null;
        int i=0;
        while(curNode!=null){
            int index = i%k;
            if(index<k-1){
                listNodes[index] = curNode;
                curNode = curNode.next;
            }else{
                nextNode = curNode.next;
                preNode.next = curNode;
                for(int j = listNodes.length-1;j>=0;j--){
                    if(j==listNodes.length-1){
                        curNode.next = listNodes[j];
                    }else{
                        listNodes[j+1].next = listNodes[j];
                    }
                }
                listNodes[0].next = nextNode;
                //下轮变量
                preNode = listNodes[0];
                curNode = nextNode;
            }
            i++;
        }
        return resultNode.next;
    }
    public static void main(String[] args){
        ListNode listNode = new ListNode(0);
        ListNode cacheNode = listNode;
        for(int i=0;i<6;i++){
            cacheNode.next = new ListNode(i+1);
            cacheNode = cacheNode.next;
        }
        ListNode resutNode = solution(listNode,4);
        while(resutNode!=null){
            System.out.print(resutNode.val+"->");
            resutNode = resutNode.next;
        }
    }
}
