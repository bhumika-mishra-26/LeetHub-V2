class Solution {
    public boolean solve(int [] arr,int i)
    {
        if(i<0 || i>=arr.length )
        return false;
        if(arr[i]==0)
        return true;
           if(arr[i]<0)
        return false;
        arr[i]*=-1;
     

        boolean a=solve(arr,i-arr[i]);
        boolean b=solve(arr,i+arr[i]);
        return a || b;

    }
    public boolean canReach(int[] arr, int start) {
        return solve(arr,start);
        // do path honge har call ke liye return true even if one return true 

        
    }
}