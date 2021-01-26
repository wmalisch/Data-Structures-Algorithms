import java.util.HashSet;
import java.util.Set;

/**
 * Algorithm for finding the length of the longest substring in a string
 */
public class lengthLongestSubstring {

    /**
     * Check sub is a helper function that uses a noolean array to keep track of characters.
     * Iterates from current index checking if char's are unique, if not, exit
     *
     * @param str
     * @param start index of substring
     * @param end index of substring
     * @return
     */
    private static int checkSub(String str, int start, int end){
        boolean[] checker = new boolean[256];

        int length = 0;

        for(int k = start; k < end + 1; k++){
            if(checker[str.charAt(k)] ==  true){
                return length;
            }else{
                checker[str.charAt(k)] = true;
                length++;
            }
        }
        return length;
    }

    /**
     * Brute force implementation at getting longest substring
     * Tim complexity:
     * @param str
     *
     * O(n^3) time complexity
     * O(n)
     * @return length of longest substring
     */
    public static int longestSub(String str){
        int max = 0;
        int curr = 0;

        for(int i = 0; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){
                curr = checkSub(str, i, j);
                if (curr > max) {
                    max = Math.max(curr, j - i);
                }else{
                    continue;
                }
            }
        }
        return max;
    }


    public static int slidingWindowLongestSubstring(String str){
        int max = 0;
        int tail = 0;
        int head = 0;
        Set<Character> set = new HashSet<>();
        while( tail < str.length() && head < str.length() ){
            if(!set.contains(str.charAt(head))){
                set.add(str.charAt(head));
                head++;
                max = Math.max(max, head - tail);
            }else{
                set.remove(str.charAt(tail));
                tail++;
            }
        }

        return max;
    }


    public static void main(String[] args){
        String one = "abcabccbb";
        String two = "bbbbb";
        String three = "pwwkew";
        String four = "dvdf";
        int j = 0;
        HashSet<Character> set = new HashSet<>();

        System.out.println(slidingWindowLongestSubstring(one));
        System.out.println(slidingWindowLongestSubstring(two));
        System.out.println(slidingWindowLongestSubstring(three));
        System.out.println(slidingWindowLongestSubstring(four));
    }
}
