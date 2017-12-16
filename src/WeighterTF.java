import java.util.HashMap;
import indexation.Index;

public class WeighterTF {
	private Index index;
	private HashMap<String, HashMap<String, Double>> docs;
	
	public WeighterTF(Index index){
		this.index = index;
		docs = new HashMap<String, HashMap<String, Double>>();
		for(String idDoc : index.getDocs().keySet()){
			HashMap<String, Double> motFreq = new HashMap<String, Double>();
			HashMap<String, Integer>motOccurences = index.getTfsForDoc(idDoc);
			int sum = 0;
			for(int occurence : motOccurences.values()){
				sum += occurence;
			}
			for(String mot : motOccurences.keySet()){
				motFreq.put(mot, (double) (motOccurences.get(mot)/sum));
			}
			docs.put(idDoc, motFreq);
		}
	}
	
	public HashMap<String, Double> getMotPoid(String idDoc){
		return docs.get(idDoc);
	}
}
