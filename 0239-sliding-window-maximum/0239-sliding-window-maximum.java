class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //jab bhi naya element aaega make space for it //window ka size k se greater nhi hona chahiye 
        // jab nums[i] comes,there is no need to keep small elements  in that window pop them 
        //now push i in deque for nums[i]
        //if i>=k then deque .front is our answer ///iski time complexity yaad rakhna o(n) hoti h once for for push and pop
    
        int n=nums.length;
        int size=n-k+1;
        int [] ans=new int [size];
        int id=0;

        Deque<Integer>dq=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++)
        {
            while(!dq.isEmpty() && dq.peekFirst()<(i-k+1))
            {
                dq.pollFirst();

            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i])
            {
                dq.pollLast();

            }
            dq.offer(i);
            if(i>=k-1)
            {
ans[id++]=nums[dq.peekFirst()];

            }


        }

return ans;

    }
}