public class MaxAvgSubarray {

    public static double maxSubArr(int[] nums, int k){
        double max = Double.MIN_VALUE;
        double sum = 0;
        if(nums.length <= k){
            for(int i : nums) {
                sum += i;
            }
            return sum / k;
        }

        int end = 0;
        int front = k - 1;
        for(int i = 0; i < k; i++){
            sum+=nums[i];
        }

        max = (sum > max) ? sum : max;

        while(front < nums.length - 1){
            front++;
            sum += nums[front];
            sum -= nums[end];
            end++;
            max = (sum > max) ? sum : max;
        }
        return max / k;
    }

    public static double maxsubarraytwo(int[] nums, int k){
        double sum=0;
        for(int i=0;i<k;i++)
            sum+=nums[i];
        double res=sum;
        for(int i=k;i<nums.length;i++){
            sum+=nums[i]-nums[i-k];
            res=Math.max(res,sum);
        }
        return res/k;
    }

    public static void main(String[] args){
        int[] arr = {-1};
        System.out.println(maxSubArr(arr, 1));
    }
}
