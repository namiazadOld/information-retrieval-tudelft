package ranking;

class Score_DocID_Combination implements Comparable<Score_DocID_Combination>{

	
	public Score_DocID_Combination(Integer docID, Double score){
		this.docID = docID;
		this.score = score;
	}
	
	public int compareTo(Score_DocID_Combination o) {
	
		if (this.score - o.score > 0.0)
			return 1;
		else if (this.score - o.score < 0.0)
			return -1;
		return 0;
	}
	
	public Score_DocID_Combination clone(){
		return new Score_DocID_Combination(this.docID, this.score);
	}
	
	public Integer docID;
	public Double score;
	
	@SuppressWarnings("unused")
	private Score_DocID_Combination(){};
}