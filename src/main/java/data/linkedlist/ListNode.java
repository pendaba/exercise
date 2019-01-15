package main.java.data.linkedlist;


/**
 * @author fupengga
 * 链表节点
 */
public class ListNode {
    int val;

    ListNode next;

    ListNode(int x) { val = x; }

    ListNode(int[] intArr){
        if(intArr == null || intArr.length == 0 ){
            throw new IllegalArgumentException(" arr can not be empty");
        }
        this.val = intArr[0];
        ListNode current = this;
        for(int i = 1;i<intArr.length;i++){
           current.next =  new ListNode(intArr[i]);
           current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        ListNode current = this;
        while (current != null){
            stringBuffer.append(current.val+"->");
            current=current.next;
        }
        stringBuffer.append("null");
        return stringBuffer.toString();
    }
}