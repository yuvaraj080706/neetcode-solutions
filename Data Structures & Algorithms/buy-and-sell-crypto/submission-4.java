class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int max = 0;

        while(r < prices.length){
            if(prices[l]<prices[r]){
                int currProfit = prices[r] - prices[l];
                max = Math.max(max, currProfit);
            }
            else{
                l = r;
            }
            r++;
        }

        return max;
    }
}
