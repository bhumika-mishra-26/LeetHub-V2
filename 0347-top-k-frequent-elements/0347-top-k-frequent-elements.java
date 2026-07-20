class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int [] ans=new int [k];
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i:nums)
        {
            mp.put(i,mp.getOrDefault(i,0)+1);

        }
        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        
        
        for(int i:mp.keySet())

        {
            pq.offer(new int []{i,mp.get(i)});
           
            
        }
        for(int i=0;i<k;i++)

        {
            ans[i]=pq.poll()[0];


        }
        return ans;
    }
}