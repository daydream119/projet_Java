import java.util.HashMap;

import indexation.Index;

public abstract class Vectoriel extends IRModel{
	
	public Vectoriel(Index index) {
		super(index);
	}
	
	public HashMap<String, Double> queryPoid(HashMap<String, Integer> queryProcessed){
		HashMap<String, Double>qFreq = new HashMap<String, Double>();
		int sum = 0;
		for(int occ : queryProcessed.values()){
			sum += occ;
		}
		for(String mot : queryProcessed.keySet()){
			qFreq.put(mot, (double) (queryProcessed.get(mot)/sum));
		}
		return qFreq;
	}
	
	protected abstract HashMap<String, Double> getDocScores(HashMap<String, Integer> queryProcessed);
	
}
