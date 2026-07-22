class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;

        
        List<int[]>ans=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int [] prev=intervals[0];


        for(int i=1;i<n;i++)
        {
            int [] interval=intervals[i];
            if(interval[0]<=prev[1])
            {
                prev[1]=Math.max(prev[1],interval[1]);   
            }
            else{
                ans.add(prev);
                prev=interval;

            }
        }
        ans.add(prev);
      int[][] ans1 = new int[ans.size()][];

for (int i = 0; i < ans.size(); i++) {
    ans1[i] = ans.get(i);
}

return ans1;


    }
}