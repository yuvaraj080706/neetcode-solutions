class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(c=='{' || c=='(' || c=='['){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty() && !isMatch(stack.pop(),c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isMatch(char a, char b){
        if( (a == '{' && b=='}') || (a=='(' && b==')') || (a=='[' && b==']')){
            return true;
        }
        return false;
    }
}
