class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int i = 0, j = 0, k = 0;

        int idx1 = (m + n) / 2 - 1;
        int idx2 = (m + n) / 2;

        int ele1 = -1, ele2 = -1;

        while (i < m && j < n) {

            if (nums1[i] <= nums2[j]) {

                if (k == idx1) ele1 = nums1[i];
                if (k == idx2) ele2 = nums1[i];

                i++;
            } else {

                if (k == idx1) ele1 = nums2[j];
                if (k == idx2) ele2 = nums2[j];

                j++;
            }

            k++;
        }

        while (i < m) {

            if (k == idx1) ele1 = nums1[i];
            if (k == idx2) ele2 = nums1[i];

            i++;
            k++;
        }

        while (j < n) {

            if (k == idx1) ele1 = nums2[j];
            if (k == idx2) ele2 = nums2[j];

            j++;
            k++;
        }

        int size = m + n;

        if (size % 2 == 1)
            return ele2;

        return (ele1 + ele2) / 2.0;
    }
}