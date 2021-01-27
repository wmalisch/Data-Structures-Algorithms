import java.util.LinkedList;
import java.util.Stack;
import java.util.HashMap;

public class PalindromeLinkedList {

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
