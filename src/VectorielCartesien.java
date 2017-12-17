import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import indexation.Index;

public class VectorielCartesien extends Vectoriel{
	private WeighterTF poids;
	
	public VectorielCartesien(Index index, WeighterTF w) {
		super(index);
		poids = w;
	}
	
	@Override
	protected HashMap<String, Double> getDocScores(HashMap<String, Integer> queryProcessed){
		HashMap<String, Double> res = new HashMap<String, Double>();
		HashMap<String, Double> qPoid = this.queryPoid(queryProcessed);
		for(String idDoc : index.getDocs().keySet()){
			double score = 0.0;
			HashMap<String, Double> dPoid = poids.getMotPoid(idDoc);
			Iterator itd = dPoid.entrySet().iterator();
			Iterator itq = qPoid.entrySet().iterator();
			if(dPoid.size()>qPoid.size()){
				while(itq.hasNext()){
					Map.Entry<String, Double> pairq = (Map.Entry<String, Double>)itq.next();
					Map.Entry<String, Double> paird = (Map.Entry<String, Double>)itd.next();
					System.out.println(pairq);
					System.out.println(paird);
					score+=pairq.getValue()*paird.getValue();
			}
			}
			else{
					System.out.println("Erreur");
			}
			res.put(idDoc, score);
		}
			
		return res;
	}

}
