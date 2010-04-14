package ranking;

import indexing.DocumentIndex;
import indexing.TokenAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;



public class CosineRanker {

	private CosineRanker(){}
	
	
	public static List<Integer> rankingResults (List<Integer> unranked, String inputQuery, DocumentIndex index){//, TreeMap<Integer, Integer> docIDsLenghts){
		//access to DocumentIndex.document_IDs_And_Lenghts
		List<Integer> ranked = fullyClone(unranked);
		
		for ( String term: takeOutQueryTerms(inputQuery)){
			index.getTermPostingList(term);
		}
		
		
		return ranked;
		
	}
	
	private static ArrayList<String> takeOutQueryTerms (String inputQuery){
		
		ArrayList<String> out = new ArrayList<String>();

		TokenAnalyzer ta = new TokenAnalyzer(inputQuery);
        String term = null;
		
		while ((term = ta.getNextToken()) != null) {
            if (!out.contains(term))
            	out.add(term);
        }
		return out;
	}
	
	private static List<Integer> fullyClone (List<Integer> toBeCloned){
		
		List<Integer> cloned = new ArrayList<Integer>();
		for (Integer i: toBeCloned)
			cloned.add(Integer.valueOf(i.intValue()));
		return cloned;
	}
}