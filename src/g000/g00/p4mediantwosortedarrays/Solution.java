package g000.g00.p4mediantwosortedarrays;

/**
 * Created by mmacias on 27/5/16.
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int length = nums1.length + nums2.length;
        int i1 = 0, i2 = 0;
        int longer = 0, lastlonger=0;
        while(i1+i2 < length / 2 + 1) {
            lastlonger = longer;
            if(i1 >= nums1.length || (i2 < nums2.length) && nums1[i1] > nums2[i2]) {
                longer=nums2[i2++];
            } else {
                longer=nums1[i1++];
            }
        }

        if(length % 2 == 1) return longer;
        else return (longer+lastlonger) / 2.0;
    }
}