package com.example.leetcode;

/**
 * Created by Administrator on 2016/9/13.
 * <p>
 * 联系方式：。。。
 */
public class ReverseLinkedList<T> {

    private int size;


    public static void main(String[] args){
        ReverseLinkedList linkedList = new ReverseLinkedList<Integer>();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);
        linkedList.push(5);
        linkedList.push(6);
        ListNode listNode = linkedList.reverseList(linkedList.head);
        while (listNode.next!= null){
            System.out.println(listNode.next.val);
            listNode = listNode.next;
        }
    }

    ListNode head;

    public ReverseLinkedList(){
        head = null;
    }

    public void push(T x){
        if(head == null){
            head = new ListNode<T>(x);
            ListNode nextNode = new ListNode<>(x);
            head.next = nextNode;
            return;
        }
        ListNode listNode = new ListNode<T>(x);
        listNode.next = head.next;
        head.next = listNode;
        size ++;
    }

    public int getSize(){
        return size;
    }

    /**
     *
     * @param head
     * @return
     */

    public ListNode reverseList(ListNode head) {
        ListNode tail = null;
        while(head.next != null){
            ListNode listNode = new ListNode(head.next.val);
            System.out.println(head.next.val);
            listNode.next = tail;
            tail = listNode;
            head = head.next;
        }
        System.out.println("//////////");
        ListNode node = new ListNode(0);
        node.next = tail;
        return node;
    }

    public T get(int index){
        ListNode<T> x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x.val;
    }

    public static class ListNode<T>{
        T val;
        ListNode next;
        ListNode(T x){val = x;}
    }

}
