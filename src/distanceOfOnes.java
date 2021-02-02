public class distanceOfOnes {
    public boolean kLengthApart(int[] nums, int k) {
        int recent = -(2000000) - nums.length;
        for(int i = 0; i < nums.length; i++){

            if(nums[i] == 1){
                if(i - recent - 1 < k){
                    return false;
                }
                recent = i;
            }
        }
        return true;
    }
}
