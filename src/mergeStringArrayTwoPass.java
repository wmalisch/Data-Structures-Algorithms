import java.util.HashSet;
import java.util.Set;

/**
 * Merge two string arrays and remove duplicates
 *
 * @author Will Malisch
 * @implNote Two pass with set. Worse on speed, but potentially better on space, than my other merge two strings algo
 */

public class Main {

    public static String[] func(String[] a, String[] b){
        Set<String> set = new HashSet<>();
        for(int i = 0; i < a.length; i++){
            set.add(a[i]);
        }
        for(int i = 0; i < b.length; i++){
            set.add(b[i]);
        }
        String[] list = new String[set.size()];
        int i = 0;
        for(String s : set){
            list[i++] = s;
        }
        return list;
}

    public static void main(String[] args) {
        String[] one = {"Adam","Brian","Peter"};
        String[] two = {"Jason","Peter","Sara"};
        String[] result = func(one,two);
        System.out.println(Arrays.toString(result));
    }
}
