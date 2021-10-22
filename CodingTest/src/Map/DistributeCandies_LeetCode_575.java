package Map;
import java.util.HashSet;

public class DistributeCandies_LeetCode_575 {
	  public int distributeCandies(int[] candyType) {
			HashSet<Integer> set = new HashSet<>();
			for(int i = 0; i<candyType.length; i++) {
				if(set.size()< (candyType.length)/2) {
					set.add(candyType[i]);
				}
			}
			
			return set.size();
		}
}
