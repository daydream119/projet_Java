import java.util.HashMap;
import java.util.LinkedHashMap;

import indexation.Index;

public class mainInterrogation {
	public static void main(String[] args){
		Index index = Index.deserialize("index1");
		String query = "souris grise ordinateur gris";
		IRModel mod = new Boolean(index);
		LinkedHashMap<String, Double> res = mod.runModel(query);
		System.out.println(res.size());
		System.out.println(index.getDocs().size());
	}
}