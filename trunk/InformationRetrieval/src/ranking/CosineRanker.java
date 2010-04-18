package ranking;

import indexing.DocumentIndex;
import indexing.TokenAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;



public class CosineRanker {

	private CosineRanker(){}
	
	
	public static List<Integer> rankingResults (List<Integer> unranked, String inputQuery, int k_top){//, TreeMap<Integer, Integer> docIDsLenghts){
		//access to DocumentIndex.document_IDs_And_Lenghts
//		List<Integer> ranked = fullyClone(unranked);
		List<Integer> ranked = new ArrayList<Integer>();
		double w_f_and_q = 0.0;
		Double d;
		HashMap<Integer, Double> docIDtoScore = new HashMap<Integer, Double>();
		
		MaxHeap scores = new MaxHeap();
		

		for ( String term: takeOutQueryTerms(inputQuery)){
			
			if(term == null || term == "")
				break;
			//
			System.out.println(DocumentIndex.instance().getTermPostingList(term).size() + " - " + DocumentIndex.instance().getTermPosting(term).postingListOfWeights.size());
			//
						
			w_f_and_q = commonality(term);
			for (Integer i: DocumentIndex.instance().getTermPostingList(term) ){
				
				d = DocumentIndex.instance().getTermPosting(term).postingListOfWeights.get(i) * w_f_and_q;
				if ( ! docIDtoScore.containsKey(i) )
					docIDtoScore.put(i, d);
				else
					docIDtoScore.put(i, d + docIDtoScore.get(i));
			}
			
			DocumentIndex.instance().getTermPosting(term);
		}
		
		for(Integer i : docIDtoScore.keySet()){
			scores.enqueue(new Score_DocID_Combination(i, docIDtoScore.get(i)));
		}
		int loop = Math.min(k_top, scores.size());
		assert (k_top <= scores.size());
		for(int i=0; i < loop; i++ )
			ranked.add(scores.dequeue().docID);
		return ranked;
		
	}
	
	private static double commonality (String term){
		
		return Math.log(DocumentIndex.instance().document_IDs_And_Lenghts.size()/DocumentIndex.instance().getTermPostingList(term).size());
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