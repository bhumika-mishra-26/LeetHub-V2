class Solution {
    public int findPivot(int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        //isme sabse pehle sabse chota element find karo array mai that is small
        while (s < e)//taaki loop mae na fase  kyuki end mai jab dono equal honge 
        {
            int mid = s + (e - s) / 2;
            if (nums[mid] > nums[e]) {
                s = mid + 1;
            } else
                e = mid;

        }
        return s;

    }
    // 2.Dono mai binary search lagega
    public int binarySearch(int [] nums,int s,int e,int target)
    {
        int idx=-1;

        while(s<=e)
        {
int mid=s+(e-s)/2;
if(nums[mid]==target)
{
    idx=mid;
    break;

}
else if(nums[mid]<target)
s=mid+1;
else
e=mid-1;

        }
        return idx;

    }

    public int search(int[] nums, int target) {
        int n=nums.length;
        // 1. find sabse chota element that will be peak 

        // 2.now apply binary search on nums[0......peak-1] and nums[peak...n-1]
        // bcz both of them are individually sorted


        int idx=1;
        int pivot=findPivot(nums);
    idx=    binarySearch(nums,0,pivot-1,target);
        if(idx!=-1)
        return idx;
        return binarySearch(nums,pivot,n-1,target);




    }
}