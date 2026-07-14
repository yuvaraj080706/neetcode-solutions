class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int n : nums){
            hmap.put(n,hmap.getOrDefault(n,0)+1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(Map.Entry<Integer,Integer> entry : hmap.entrySet()){
            heap.offer(new int[]{entry.getKey(),entry.getValue()});
            if(heap.size()>k){
                heap.poll();
            }
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = heap.poll()[0];
        }

        return res;
    }
}
