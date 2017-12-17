import java.util.HashMap;
import core.Document;
import indexation.Index;

public class WeighterTFIDF {
	private Index index;
	private WeighterTF tf;
	private HashMap<String, HashMap<String, Double>> docs;
	
	public WeighterTFIDF(Index index){
		this.index = index;
		tf = new WeighterTF(index);
		docs = new HashMap<String, HashMap<String, Double>>();
	}
	
	
	public boolean contient(String idDoc, String mot){
		for(String word : index.getTfsForDoc(idDoc).keySet()){
			if(word == mot){
				return true;
			}
		}
		return false;
	}
	
	public int nbDocContient(String terme){
		int cpt = 0;
		for(String idDoc : index.getDocs().keySet()){
			if(this.contient(idDoc, terme)){
				cpt++;
			}
		}
		return cpt;
	}
	
	public double idf(String terme){
		if(this.nbDocContient(terme)!=0){
			return Math.log((double)index.getDocs().size()/(double)this.nbDocContient(terme));
		}
		return 0.0;
	}
	public HashMap<String, Double> getMotPoid(String idDoc){
		return docs.get(idDoc);
	}
	
	
	public void remplir(){
		for(String idDoc : index.getDocs().keySet()){
			System.out.println(idDoc);
			HashMap<String, Double> motFreq = tf.getMotPoid(idDoc);
			HashMap<String, Double> motTFIDF = new HashMap<String, Double>();
			for(String mot : index.getTfsForDoc(idDoc).keySet()){
				
				motTFIDF.put(mot, motFreq.get(mot)*this.idf(mot));
			}
			docs.put(idDoc, motTFIDF);
		}
	}
	
}
