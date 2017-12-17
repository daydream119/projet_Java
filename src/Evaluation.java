import java.util.ArrayList;
import java.util.LinkedHashMap;
import indexation.Index;

public class Evaluation {
	private Index index;
	// la listeDN contenant n premiers r¨¦sultats recherch¨¦ ¨¤ partir d'un model donn¨¦e par rapport un requete donnee
	private ArrayList<String> listDN;
	private ArrayList<String> listAttendu;
	private int nb;
	private DocAttendu att;
	private IRModel model;
	private String query;
	
	// une evaluation correspond ¨¤ la comparaison de resultats attendus 
	// et les r¨¦sultats toruv¨¦s par rapport ¨¤ un mod¨¨le et une requete donnee
	public Evaluation(Index index, int nb, IRModel m, String query, DocAttendu att){
		this.index=index;
		this.nb=nb;
		listDN = new ArrayList<String>();
		att=new DocAttendu();
		model = m;
		this.query = query;
		this.setlistDN(query);
		this.att = att;
		listAttendu = att.idDocsAttenduToAL(query);
	}
	
	//initialiser DN par rapport une requete donn¨¦e (n premiers resultats qui est plus importants au niveau de score)
	public void setlistDN(String query){
		// res contenant les r¨¦sultats trouv¨¦s tri¨¦s en fonction de score
		LinkedHashMap<String, Double> res = model.runModel(query);
		int cpt = 1;
		for(String idDoc : res.keySet()){
			if(cpt == nb){
				break;
			}
			if(res.get(idDoc) == 0.0){
				continue;
			}
			listDN.add(idDoc);
			cpt++;
		}
	}
	
	public ArrayList<String> intersection(ArrayList<String>a, ArrayList<String>b){
		ArrayList<String> inter = new ArrayList<String>();
		for(String idDoc : a){
			if(b.contains(idDoc)){
				inter.add(idDoc);
			}
		}
		return inter;
	}
	
	public double precision(){
		return (double)(intersection(listDN, listAttendu).size()) / (double)(listDN.size());
	}
	
	public double rappel(){
		return (double)(intersection(listDN, listAttendu).size()) / (double)(listAttendu.size());
	}
	
	public double F_mesure(){
		return 2*(precision()*rappel() / precision()+rappel());
	}
}
