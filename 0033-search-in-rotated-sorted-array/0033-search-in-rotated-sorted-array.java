class Solution {
    public int findPivot(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public int binarySearch(int l, int r, int[] nums, int target) {
        int idx = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                idx = mid;
                break;

            } else if (nums[mid] < target) {
                l = mid + 1;

            } else {
                r = mid - 1;

            }
        }
        return idx;

    }

    public int search(int[] nums, int target) {

        //isme humlog sabse pehle chota index find karenge 
        int n = nums.length;

        int pivot = findPivot(nums);
      if(target >= nums[pivot] && target <= nums[n-1])
{
    return binarySearch(pivot, n-1, nums, target);
}
else
{
    return binarySearch(0, pivot-1, nums, target);
}
      

    }
}