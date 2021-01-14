/**
 * Check if one string is a permutation of another string
 *
 * @author Will Malisch
 */
public class checkPermutation {


    public static boolean checkPerm(String s1, String s2){
        if(s1.length() != s2.length()) { return false; }
        int[] char_count = new int[256];
        for(int i = 0; i < s1.length(); i++){
            char_count[s1.charAt(i)]++;
        }
        for(int i = 0; i < s2.length(); i++){
            char_count[s2.charAt(i)]--;
            // If one character is different, the char count array will have a value of 1 and -1 somewhere in it
            if(char_count[s2.charAt(i)] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String s1 = "Will";
        String s2 = "lliW";
        String s3 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s4 = "";
        String s5 = "abcdeae";
        System.out.printf("Testing s1 = %s: %b\n", s1, checkPerm(s1,s2));
        System.out.printf("Testing s1 = %s: %b\n", s2, checkPerm(s2,s3));
    }
}
