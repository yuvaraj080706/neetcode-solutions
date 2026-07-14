class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.size(); i++){
            sb.append(strs.get(i));
            if(i!=strs.size()-1){
                sb.append("#");
            }
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        String[] list = str.split("#");
        for(String s : list){
            result.add(s);
        }
        return result;
    }
}
