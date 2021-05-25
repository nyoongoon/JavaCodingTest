package LeetCode;

public class FindMedian_4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// 내 정답
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

	}
}
