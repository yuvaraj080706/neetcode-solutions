class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.remove(c);
            }else{
                map.put(c,i);
            }
        }

        int min = Integer.MAX_VALUE;
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            min = Math.min(min,e.getValue());
        }

        return min==Integer.MAX_VALUE ? -1 : min;
    }
}