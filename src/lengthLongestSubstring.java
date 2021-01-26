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
     * @return
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



    public static void main(String[] args){
        String one = "abcabccbb";
        String two = "bbbbb";
        String three = "pwwkew";
        String four = "dvdf";

        System.out.println(longestSub(one));
        System.out.println(longestSub(two));
        System.out.println(longestSub(three));
        System.out.println(longestSub(four));
    }
}
