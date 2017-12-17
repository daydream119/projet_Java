import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import core.Document;
import indexation.Index;

public class TestIndexation {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		Index idxD = Index.deserialize("index1");
		Index idxq = Index.deserialize("indexq");
		System.out.println(idxq.getDocs().size());
		for(String doc: idxq.getDocs().keySet()) {
			System.out.println("eeeeeeeeeeeee"+idxq.getTfsForDoc(doc));
		}
		//Index idxr = Index.deserialize("indexr");
//		Document dc = idx.getDoc("55");
//		System.out.println(dc.getText());
		
//		HashMap<String, Integer> hm1 = idx.getTfsForDoc("55");
//		for(String word : hm1.keySet()){
//			System.out.println("l'occurence de mot "+word+" est "+hm1.get(word));
//		}
//		
//		HashMap<String, Integer> hm2 = idx.getTfsForStem("attempt");
//		for(String document : hm2.keySet()){
//			System.out.println("l'occurence attempt dans "+document+" est "+hm2.get(document));
//		}
//		
//		HashMap<String, Integer> hm3 = idx.getTfsForDoc("666");
//		System.out.println("le nombre de termes est "+hm3.size());
//		
//		HashMap<String, Integer> hm4 = idx.getTfsForStem("attempt");
//		System.out.println("le nombre de documents contenant the est " + hm4.size());
//		
//		HashMap<String, Integer> hm5 = idx.getTfsForStem("attempt");
//		for(String docum : hm5.keySet()){
//			System.out.println(idx.getDoc(docum).getText());
//			System.out.println("------------------------------------------------------------");
//		}
//		
//		HashMap<String, String> hm6 = idx.getDocs();
//		HashMap<String, Double> hm7 = new HashMap<String, Double>();
//		for(String id : hm6.keySet()){
//			hm7.put(id, Math.random());
//		}	
//		for(String id : hm7.keySet()){
//			System.out.println("id "+id+" value "+hm7.get(id));
//		}
		//-------------------------------EXO3-------------------------------
		
		
		
	}
}
