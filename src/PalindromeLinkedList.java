import java.util.LinkedList;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PalindromeLinkedList {

    public class ListNode
    {
        public int key;
        public ListNode next;
        public ListNode(int item) { this.key = item; this.next = null; }
        public ListNode(int item, ListNode node){ this.key = item; this.next = node; }
    }

    // O(n) space and time using list node
    public static boolean isPalListNode(ListNode head){
        List<Integer> arr = new ArrayList<>();
        while(head != null){
            arr.add(head.key);
            head = head.next;
        }

        int i = 0;
        int j = arr.size() - 1;

        while( i < j ){
            if(!arr.get(i).equals(arr.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    // O(n) space and time with stack
    public static boolean isPalStack(LinkedList<Integer> head){
        if(head.size() < 2) return true;
        Stack<Integer> s = new Stack<>();
        int n = head.size();
        for(int i = 0; i < n / 2; i++){
            s.push(head.remove());
        }

        if( n % 2 == 1 ) head.remove();

        for(int i = 0; i < n / 2; i++){
            if (s.pop() != head.remove()){
                return false;
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args){
        LinkedList<Integer> x = new LinkedList<>();
        x.add(1);
        x.add(2);
        System.out.println(isPalStack(x));
    }

}
