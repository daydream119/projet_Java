import java.util.HashMap;
import indexation.Index;

public class VectorielCartesien extends Vectoriel{
	
	public VectorielCartesien(Index index, WeighterTF w) {
		super(index, w);
	}
	
	@Override
	protected HashMap<String, Double> getDocScores(HashMap<String, Integer> queryProcessed) {
		HashMap<String, Double> res = new HashMap<String, Double>();
		HashMap<String, Double> qFreq = this.queryFrequences(queryProcessed);
		for(String idDoc : index.getDocs().keySet()){
			double score = 0.0;
			HashMap<String, Double> dFreq = poids.geMotsFreq(idDoc);
			for(String mot : qFreq.keySet()){
				score += qFreq.get(mot)*dFreq.get(mot);
			}
			res.put(idDoc, score);
		}
		return res;
	}

}
