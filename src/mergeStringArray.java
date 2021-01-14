import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Merge two arrays and remove duplicates.
 *
 * @author Will Malisch
 * @implNote One pass with set
 */

public class Main {

    public static String[] func(String[] a, String[] b){
        Set<String> set = new HashSet<>();
        String[] list = new String[a.length+b.length];
        int index = 0;
        for(int i = 0; i < a.length; i++){
            if(set.contains(a[i])){
                continue;
            }else{
                set.add(a[i]);
                list[index] = a[i];
                index++;
            }
        }
        for(int i = 0; i < b.length; i++) {
            if (set.contains(b[i])) {
                continue;
            } else {
                set.add(b[i]);
                list[index] = b[i];
                index++;
            }
        }
        return Arrays.copyOfRange(list, 0, set.size());
    }

    public static void main(String[] args) {
        String[] one = {"Adam","Brian","Peter"};
        String[] two = {"Jason","Peter","Sara"};
        String[] result = func(one,two);
        System.out.println(Arrays.toString(result));
    }
}
