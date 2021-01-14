import java.util.HashSet;
import java.util.Set;

/**
 * Check if a string has all unique characters
 *
 * @author Will Malisch
 * @implNote ASCII character set
 */
public class isUnique {

    public static boolean isUnique(String str){
        boolean[] arr = new boolean[256];
        if(str.length() > 256){ return false; }
        for(int i = 0; i < str.length(); i++){
            if(arr[str.charAt(i)]){
                return false;
            }else{
                arr[str.charAt(i)] = true;
            }
        }
        return true;
    }

    public static boolean isUniqueLowSpace(String str){
        for(int i = 0; i < str.length(); i++){
            for(int j = (i + 1); j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    return false;
                }else{
                    continue;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s1 = "Will";
        String s2 = "tacomier";
        String s3 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s4 = "";
        String s5 = "abcdeae";
        System.out.printf("Testing s1 = %s: %b\n", s1, isUniqueLowSpace(s1));
        System.out.printf("Testing s1 = %s: %b\n", s2, isUniqueLowSpace(s2));
        System.out.printf("Testing s1 = %s: %b\n", s3, isUniqueLowSpace(s3));
        System.out.printf("Testing s1 = %s: %b\n", s4, isUniqueLowSpace(s4));
        System.out.printf("Testing s1 = %s: %b\n", s5, isUniqueLowSpace(s5));
        System.out.printf("Testing s1 = %s: %b\n", s5, isUniqueLowSpace(s5));
    }
}
