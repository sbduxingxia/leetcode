package com.zhp.leetcode.linked;

import com.zhp.leetcode.linked.def.ListNode;

/**
 * @author zhp.dts
 * @date 2017/11/2.
 */
public class AddTwoNumbers {
    public static ListNode solution(ListNode l1, ListNode l2){
        ListNode result=new ListNode(0),nextNode=result;
        int addNext = 0;
        while(l1!=null||l2!=null){
            int sum =(l1==null?0:l1.val)+(l2==null?0:l2.val)+addNext;
            l1 = l1!=null?l1.next:null;
            l2 = l2!=null?l2.next:null;
            addNext = sum/10;
            nextNode.next = new ListNode(sum%10);
            nextNode = nextNode.next;
        }
        if(addNext>0){
            nextNode.next = new ListNode(addNext);
        }
        return result.next;
    }
    public static ListNode solution2(ListNode l1, ListNode l2){
        ListNode result=null,nextNode=null;
        int addNext = 0;
        while(l1!=null||l2!=null||addNext>0){
            int sum =(l1==null?0:l1.val)+(l2==null?0:l2.val)+addNext;
            l1 = l1!=null?l1.next:null;
            l2 = l2!=null?l2.next:null;
            addNext = sum/10;
            if(result==null){
                result = new ListNode(sum%10);
                nextNode = result;
            }else{
                nextNode.next = new ListNode(sum%10);
                nextNode = nextNode.next;
            }
        }
        return result;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);

        ListNode result = solution(l1,l2);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }

}
