class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '[' || c == '(' || c == '{'){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else if(!isMatch(stack.pop(),c)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatch(char a, char b){

        return (a=='(' && b==')') || (a=='{' && b=='}') || (a=='[' && b==']');
    }
}
