import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * Two sum algorithms. Given an integer array and an integer target, return the indecies for the two numbers that would add up to the target
 * Each array has exactly one solution
 *
 * @author Will Malisch
 */
public class TwoSum {

    public static int[] twoSumSlow(int[] nums, int target){
        int[] arr = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = (i + 1); j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    return new int[] { i,j };
                }
            }
        }
        return arr;
    }

    public static int[] twoSumOnePass(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                return new int[] { map.get(target - nums[i]), i};
            }
        }
        throw new IllegalArgumentException("No solution");
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15,4,8,1};
        int target = 8;
        System.out.println(Arrays.toString(twoSumSlow(nums, target)));
        System.out.println(Arrays.toString(twoSumOnePass(nums, target)));
    }
}
