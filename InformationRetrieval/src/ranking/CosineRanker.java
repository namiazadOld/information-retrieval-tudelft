package ranking;

import java.util.ArrayList;
import java.util.List;



public class CosineRanker {

	
	
	
	public static List<Integer> rankingResults (List<Integer> unranked){
		
		List<Integer> ranked = fullyClone(unranked);
		
		
		
		return ranked;
		
	}
	
	private static List<Integer> fullyClone (List<Integer> toBeCloned){
		
		List<Integer> cloned = new ArrayList<Integer>();
		for (Integer i: toBeCloned)
			cloned.add(Integer.valueOf(i.intValue()));
		return cloned;
	}
}