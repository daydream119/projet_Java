import java.util.HashMap;
import indexation.Index;

public class VectorielCartesien extends Vectoriel{
	private WeighterTF poids;
	
	public VectorielCartesien(Index index, WeighterTF w) {
		super(index);
		poids = w;
	}
	
	@Override
	protected HashMap<String, Double> getDocScores(HashMap<String, Integer> queryProcessed) {
		HashMap<String, Double> res = new HashMap<String, Double>();
		HashMap<String, Double> qPoid = this.queryPoid(queryProcessed);
		for(String idDoc : index.getDocs().keySet()){
			double score = 0.0;
			HashMap<String, Double> dPoid = poids.getMotPoid(idDoc);
			for(String mot : qPoid.keySet()){
				score += qPoid.get(mot)*dPoid.get(mot);
			}
			res.put(idDoc, score);
		}
		return res;
	}

}
