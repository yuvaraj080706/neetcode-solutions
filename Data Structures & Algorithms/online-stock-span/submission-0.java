class StockSpanner {

    Stack<Integer> priceStack;
    Stack<Integer> span;

    public StockSpanner() {
        priceStack = new Stack<>();
        span = new Stack<>();    
    }
    
    public int next(int price) {
        int spanVal = 1;
        while(!priceStack.isEmpty() && price > priceStack.peek()){
            priceStack.pop();
            spanVal += span.pop();
        }
        priceStack.push(price);
        span.push(spanVal);

        return span.peek();
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */