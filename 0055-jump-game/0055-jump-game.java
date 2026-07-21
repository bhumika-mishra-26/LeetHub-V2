class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
   //dp approach 

      int [] dp=new int [n];
      dp[0]=nums[0];

      for(int i=1;i<n;i++)
      {
        if(i>dp[i-1])
        return false;
        dp[i]=Math.max(i+nums[i],dp[i-1]);

      }
      return dp[n-1]>=n-1;

     

        
    }
}