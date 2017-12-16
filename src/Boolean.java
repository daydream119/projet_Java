import java.util.HashMap;
import indexation.Index;

public class Boolean extends IRModel{
	public Boolean(Index index){
		super(index);
	}

	@Override
	protected HashMap<String, Double> getDocScores(HashMap<String, Integer> queryProcessed) {
		HashMap<String, Double> res = new HashMap<String, Double>();
		for(String idDoc : index.getDocs().keySet()){
			boolean toutExiste = true;
			// pour chaque mot dans la requ¨ºte
			for(String mot : queryProcessed.keySet()){
				boolean existe = false;
				// pour chaque mot dans le document en cours
				for(String word : index.getTfsForDoc(idDoc).keySet()){
					if(mot == word){
						existe = true;
						break;
					}
				}
				if(!existe){
					toutExiste = false;
				}
			}
			
			if(toutExiste){
				res.put(idDoc, 1.0);
			}else{
				res.put(idDoc, 0.0);
			}
		}
		return res;
	}
}
