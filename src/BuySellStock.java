/**
 * Best time to buy and sell stock
 */
public class BuySellStock {

    public static int maxProfitOnePass(int[] prices){
        int maxProfit = 0, min = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] - min > maxProfit){
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        int[] x = {2,4,1};
        System.out.println(maxProfitOnePass(prices));
        System.out.println(maxProfitOnePass(x));
    }
}
