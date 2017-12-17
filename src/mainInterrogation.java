import java.util.HashMap;
import java.util.LinkedHashMap;

import indexation.Index;

public class mainInterrogation {
	public static void main(String[] args){
		Index idxD = Index.deserialize("index1");
		String query = "young boy" ;
		// Modele booleen
		IRModel mod=new Boolean (idxD) ;
		mod.runModel(query) ;
		
		// Modele Ve c t o r i e l Produi t Car t e s i en avec ponde rat ion TF
		WeighterTF wtf = new WeighterTF(idxD) ;
		IRModel modCos = new VectorielCartesien(idxD,wtf);
		System.out.println(modCos.runModel(query));
		// Modele Ve c t o r i e l Cosinus avec ponde rat ion TFIDF
		WeighterTFIDF wtfidf = new WeighterTFIDF(idxD) ;
		//wtfidf.remplir();
//		IRModel modCart = new VectorielCosinus(idx,wtfidf) ;
		//System.out.println(modCart.runModel(query));
	}
}