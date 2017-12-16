import java.util.HashMap;
import indexation.Index;

public class VectorielCosinus extends Vectoriel {
	private WeighterTFIDF poids;
	
	public VectorielCosinus(Index index, WeighterTFIDF w) {
		super(index);
		poids = w;
	}

	@Override
	protected HashMap<String, Double> getDocScores(HashMap<String, Integer> queryProcessed) {
		HashMap<String, Double> res = new HashMap<String, Double>();
		HashMap<String, Double> qPoid = this.queryPoid(queryProcessed);
		for(String idDoc : index.getDocs().keySet()){
			double score = 0.0;
			double sumQD = 0.0;
			double sumQSquare = 0.0;
			double sumDSquare = 0.0;
			HashMap<String, Double> dPoid = poids.getMotPoid(idDoc);
			for(String mot : qPoid.keySet()){
				sumQD += qPoid.get(mot)*dPoid.get(mot);
				sumQSquare = Math.pow(qPoid.get(mot), 2.0);
				sumDSquare = Math.pow(dPoid.get(mot), 2.0);
				score = sumQD/Math.sqrt(sumQSquare)+Math.sqrt(sumDSquare);
			}
			res.put(idDoc, score);
		}
		return res;
	}

}
