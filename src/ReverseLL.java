import Structures.ListNode;

public class ReverseLL {

    public static void printList(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void reverse(ListNode head){

    }

    public static void main(String[] args){
        ListNode e = new ListNode(5);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        printList(a);
    }
}
