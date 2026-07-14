class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        if(s1.length() > s2.length()){
            return false;
        }

        for(int i=0; i<s1.length(); i++){
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        int r = s1.length();
        int l = 0;
        while(r<s2.length()){
            if(Arrays.equals(map1,map2)){
                return true;
            }
            map2[s2.charAt(l) - 'a']--; 
            map2[s2.charAt(r) - 'a']++; 
            l++;
            r++;          
        }

        return false;
    }
}
