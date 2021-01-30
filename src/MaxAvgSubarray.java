public class MaxAvgSubarray {

    public static double maxSubArr(int[] nums, int k){
        double max = Double.MIN_VALUE;
        int sum = 0;
        if(nums.length <= k){
            for(int i : nums){
                sum += i;
            }
            max = sum / nums.length;
            return max;
        }

        int end = 0;
        int front = k - 1;
        for(int i = 0; i < k; i++){
            sum+=nums[i];
        }

        max = ((sum / k) > max) ? (sum / k) : max;

        while(front < nums.length - 1){
            front++;
            sum += nums[front];
            sum -= nums[end];
            end++;
            max = ((sum / k) > max) ? (sum / k) : max;
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr = {1,12,-5,-6,50,3};
        System.out.println(maxSubArr(arr, 4));
    }
}
