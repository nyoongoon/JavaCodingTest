package Array;

public class PartitionArrayThreeParts {
	public static void main(String[] args) {
		int [] arr = {1, -1, 1, -1};
		boolean result = canThreePartsEqualSum(arr);
		System.out.println(result);
	}
	
	public static boolean canThreePartsEqualSum(int[] arr) {
        //0 ~ i // i+1 ~ j-1// j ~ arr.legnth-1
		//처음 인덱스 범위 하나씩 늘리기.
		//이후 처음인덱스 범위와 같은 값이 나오도록 더하기 // 나머지 부분의 합도 같은가?
		int[] radixArr = new int[arr.length];
		radixArr[0] = arr[0];
		for(int i = 1 ; i<radixArr.length;i++) {
			radixArr[i] = radixArr[i-1] + arr[i];	
		}
		
		for(int i = 0; i<radixArr.length; i++) {
			for(int j = i+1; j<radixArr.length; j++) {
					
				if(radixArr[i]==(radixArr[j]-radixArr[i])) {
					if(radixArr[i]==(radixArr[radixArr.length-1]-radixArr[j])) {
						System.out.println("i: " + i + "  j: " + j);
						if(j == radixArr.length-1) {
							return false;
						}
						return true;
					}
				}
			}
		}
		return false;
			
			//for(int j = i+1; j<radixArr.length; j++) { // 경계만 찾으면 되니까 j비교가 아니라 i+1만 하면 되나?!
			//	if(radixArr[i] == (radixArr[j] - radixArr[i])) {
			//		if(radixArr[j] == (radixArr[radixArr.length-1]-radixArr[j])) {
			//			return true;
			//		}
			//	}
			//}
		
	
    }
}
