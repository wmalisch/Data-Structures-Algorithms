/**
 * Algorithm for finding the length of the longest substring in a string
 */
public class lengthLongestSubstring {

    /**
     * Check sub is a helper function that uses a noolean array to keep track of characters.
     * Iterates from current index checking if char's are unique, if not, exit
     *
     * @param str
     * @param currInd
     * @return
     */
    private static int checkSub(String str, int currInd){
        boolean[] checker = new boolean[256];
        checker[str.charAt(currInd)] = true;

        int ind = currInd + 1;

        for(int j = ind; j < str.length(); j++){
            if(checker[str.charAt(j)] ==  true){
                return ind;
            }else{
                checker[str.charAt(j)] = true;
                ind++;
            }
        }
        return ind;
    }

    /**
     * Brute force implementation at getting longest substring
     * Tim complexity:
     * @param str
     * @return
     */
    public static int longestSub(String str){
        int max = 0;
        int index = 0;

        for(int i = 0; i < str.length(); i++){
            index = checkSub(str, i);
            if(i == 0){
                max = (index - i - 1) > max ? (index - i - 1) : max;
                i = index - 2;
            }else{
                max = (index - i) > max ? (index - i) : max;
                i = index - 1;
            }
        }

        return max;
    }

    public static void main(String[] args){
//        String one = "abcabccbb";
//        String two = "bbbbb";
//        String three = "pwwkew";
        String four = "dvdf";

//        System.out.println(longestSub(one));
//        System.out.println(longestSub(two));
//        System.out.println(longestSub(three));
        System.out.println(longestSub(four));
    }
}
