class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        while(l<=r){
            int mid = (l+r)/2;
            int sq_mid = mid*mid;
            if(sq_mid == x){
                return mid;
            }
            else if(sq_mid > x){
                r = mid+1;
            }
            else{
                l = mid-1;
            }

        }
        return l;
    }
}