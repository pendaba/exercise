package main.java.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 带随机指针的链表复制
 */
public class RandomLinkedList {
    /**
     * map
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Map<Node,Node> nodeMap = new HashMap<>();
        Node p = head;
        while (p != null){
            Node newNode = new Node(p.val);
            nodeMap.put(p,newNode);
            p = p.next;
        }
        p = head;
        while (p != null){
            Node node = nodeMap.get(p);
            if(p.next != null){
                node.next = nodeMap.get(p.next);
            }
            if(p.random != null){
                node.random = nodeMap.get(p.random);
            }
            p = p.next;
        }
        return nodeMap.get(head);
    }

    /**
     * 原链表基础上进行复制
     * 每个节点进行复制
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
       if(head == null){
           return null;
       }
       Node p = head;
       while (p != null){
           Node node = new Node(p.val);
           node.next = p.next;
           p.next = node;
           p = node.next;
       }
       p = head;
       while (p != null){
           if(p.random != null){
               p.next.random = p.random.next;

           }
           p = p.next.next;
       }

        Node dummy = new Node(-1);
        p = head;
        Node cur = dummy;
        //第三步，将两个链表分离
        while(p!=null) {
            cur.next = p.next;
            cur = cur.next;
            p.next = cur.next;
            p = p.next;
        }

        return dummy.next;
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

