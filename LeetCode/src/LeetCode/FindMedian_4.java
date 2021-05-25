package LeetCode;
// 우수 답안 다시 풀어보기!!! 
public class FindMedian_4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		  
		        // Deal with invalid corner case. 
		        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return 0.0;
		        
		        int m = nums1.length, n = nums2.length;
		        int l = (m + n + 1) / 2; //left half of the combined median
		        int r = (m + n + 2) / 2; //right half of the combined median
		        
		        // If the nums1.length + nums2.length is odd, the 2 function will return the same number
		        // Else if nums1.length + nums2.length is even, the 2 function will return the left number and right number that make up a median
		        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
		    }
		    
		    private double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
		        // This function finds the Kth element in nums1 + nums2
		        
		        // If nums1 is exhausted, return kth number in nums2
		        if (start1 > nums1.length - 1) return nums2[start2 + k - 1];
		        
		        // If nums2 is exhausted, return kth number in nums1
		        if (start2 > nums2.length - 1) return nums1[start1 + k - 1];
		        
		        // If k == 1, return the first number
		        // Since nums1 and nums2 is sorted, the smaller one among the start point of nums1 and nums2 is the first one
		        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
		        
		        int mid1 = Integer.MAX_VALUE;
		        int mid2 = Integer.MAX_VALUE;
		        if (start1 + k / 2 - 1 < nums1.length) mid1 = nums1[start1 + k / 2 - 1];
		        if (start2 + k / 2 - 1 < nums2.length) mid2 = nums2[start2 + k / 2 - 1];
		        
		        // Throw away half of the array from nums1 or nums2. And cut k in half
		        if (mid1 < mid2) {
		            return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2); //nums1.right + nums2
		        } else {
		            return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2); //nums1 + nums2.right
		        }
		    }
		/*// 내 정답
		// 병합정렬
		// 데이터의 개수가 홀수라면 중앙값은 정렬된 결과의 가운데 수입니다
		// 데이터의 개수가 짝수라면 중앙값은 가운데 두 수의 평균입니다.
		int size = nums1.length + nums2.length;
		int[] merged = new int[size];
		double answer;
		int idx1 = 0;
		int idx2 = 0;
		int idxM = 0;
		while (idx1 < nums1.length && idx2 < nums2.length) {
			merged[idxM++] = (nums1[idx1] <= nums2[idx2]) ? nums1[idx1++] : nums2[idx2++];
		}

		while (idx1 < nums1.length) {
			merged[idxM++] = nums1[idx1++];
		}
		while (idx2 < nums2.length) {
			merged[idxM++] = nums2[idx2++];
		}
		
		if (size % 2 == 0) {// 짝수
			return answer = (double) (merged[(size - 1) / 2] + merged[(((size - 1) / 2) + 1)]) / 2.0;

		} else {// 홀수
			return answer = merged[(merged.length - 1) / 2];
		}
		*/

	}

