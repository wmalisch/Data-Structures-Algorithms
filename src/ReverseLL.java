import Structures.ListNode;

public class ReverseLL {

    public static void printList(ListNode head){
        while(head != null){
            System.out.printf("%d -> ", head.val);
            head = head.next;
        }
        System.out.println("\n");
    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args){
        ListNode e = new ListNode(5);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        printList(a);
        ListNode p = reverse(a);
        printList(p);
    }
}
