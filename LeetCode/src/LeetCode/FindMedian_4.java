package LeetCode;
// 우수 답안 다시 풀어보기!!! 
public class FindMedian_4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) throws Exception {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int x = nums1.length;
		int y = nums2.length;

		int low = 0;
		int high = x;
		while (low <= high) {
			// 우선 절반으로 나눠서 탐색
			int partitionX = (low + high) / 2;
			// ※ 1을 더해놔 홀수나 짝수나 같은 결과가 나오게 할 수 있다!!※
			int partitionY = (x + y + 1) / 2 - partitionX;

			// 파티션X가 0 이라면 왼편엔 아무것도 없으므로 -INF 저장
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			// 파티션X가 배열의 길이를 넘기면 오른편에 아무것도 없으므로 +INF저장
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

			// 파티션에 인접한 4개의 요소 비교
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {//조건이 맞을 때
				if ((x + y) % 2 == 0) {// 배열의 길이가 짝수일 때
					return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY) / 2);
				} else {// 배열의 길이가 홀수 일 때
					return (double) (Math.max(maxLeftX, maxLeftY));
				}
			} else if (maxLeftX > minRightY) {//파티션을 더 왼쪽으로
				high = partitionX - 1;
			} else {// maxLeftY > minRightX --> //파티션을 더 오른쪽으로
				low = partitionX + 1;
			}
		}
		//배열이 정열되지 않은 경
		throw new Exception();	
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

