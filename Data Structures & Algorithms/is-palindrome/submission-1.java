class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        int l = 0;
        int r = n - 1;

        while(l<r){
            while(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }

            while(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            
            char a = Character.toLowerCase(s.charAt(l));
            char b = Character.toLowerCase(s.charAt(r));

            if(a!=b){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }


}
