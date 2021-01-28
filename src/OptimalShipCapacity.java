public class OptimalShipCapacity {

    public boolean capacityIsFeasible(int[] weights, int D, int capacity){

        int remainCap = capacity, currentPackage = 0;

        for(int i = 0; i < D; i++){
            while( ( weights.length > currentPackage ) && remainCap >= weights[currentPackage] ){
                remainCap -= weights[currentPackage];
                currentPackage++;
            }
            remainCap = capacity;
        }
        return ( currentPackage == weights.length );
    }


    public int shipWithinDays(int[] weights, int D) {

        int middle, sumOfAll = 0, largestPack = 0;

        // Find the sum of all weights. This will be the largest possible
        for( int i = 0; i < weights.length; i++ ){
            if( weights[i] > largestPack ) { largestPack = weights[i]; }
            sumOfAll += weights[i];
        }

        if( D == 1 ){
            return sumOfAll;
        }


        int ans;
        while(largestPack < sumOfAll){

            middle = ( largestPack + sumOfAll ) / 2;

            if(capacityIsFeasible(weights, D, middle)){
                sumOfAll = middle;

            }else{
                largestPack = middle + 1;
            }
        }

        return sumOfAll;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
    }
}
