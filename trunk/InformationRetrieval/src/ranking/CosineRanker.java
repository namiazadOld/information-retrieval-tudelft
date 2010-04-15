package ranking;

import indexing.DocumentIndex;
import indexing.TokenAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;



public class CosineRanker {

	private CosineRanker(){}
	
	
	public static List<Integer> rankingResults (List<Integer> unranked, String inputQuery, DocumentIndex index, int k_top){//, TreeMap<Integer, Integer> docIDsLenghts){
		//access to DocumentIndex.document_IDs_And_Lenghts
		List<Integer> ranked = fullyClone(unranked);
		double w_f_and_q = 0.0;
		Double d;
		HashMap<Integer, Double> docIDtoScore = new HashMap<Integer, Double>();
		
		MaxHeap scores = new MaxHeap();
		
		for ( String term: takeOutQueryTerms(inputQuery)){
			
			w_f_and_q = commonality(term, index);
			for (Integer i: index.getTermPostingList(term) ){
				
				d = index.getTermPosting(term).postingListOfWeights.get(i) * w_f_and_q;
				if (! docIDtoScore.containsKey(i) )
					docIDtoScore.put(i, d);
				else
					docIDtoScore.put(i, d + docIDtoScore.get(i));
			}
			
			index.getTermPosting(term);
		}
		
		for(Integer i : docIDtoScore.keySet()){
			scores.enqueue(new Score_DocID_Combination(i, docIDtoScore.get(i)));
		}
		
		assert k_top <= scores.size();
		for(int i=0; i < scores.size(); i++ )
			ranked.add(scores.elementAt(i).docID);
		return ranked;
		
	}
	
	private static double commonality (String term, DocumentIndex index){
		
		return Math.log(DocumentIndex.document_IDs_And_Lenghts.size()/index.getTermPostingList(term).size());
	}
	
	private static List<String> takeOutQueryTerms (String inputQuery){
		
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