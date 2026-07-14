class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            heap.offer(stone);
        }

        while(heap.size()>1){
            int top1 = heap.poll();
            int top2 = heap.poll();

            if(top1 < top2){
                heap.offer(top2-top1);
            }
            else if(top2 < top1){
                heap.offer(top1 - top2);
            }
        }

        return heap.peek();
    }
}
