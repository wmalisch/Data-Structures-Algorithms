import java.util.*;

public class LuckyNumber {

    public static int bruteForce(int[] arr){
        int max = -1;

        for(int num : arr){
            int count =0;
            for(int iter : arr){
                if(num == iter){
                    count++;
                }
            }
            if(count == num){ max = Math.max(num, max); }
        }

        return max;
    }

    public static int findLucky(int[] arr){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }else{
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        int max = -1;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getKey().equals(entry.getValue())){
                max = Math.max(max, entry.getKey());
            }else{
                continue;
            }

        }

        return max;
    }

    public static void main(String[] args){
        int[] arr = { 2,2,3,3,3,3,4,9 };
        System.out.println(bruteForce(arr));
    }

}
