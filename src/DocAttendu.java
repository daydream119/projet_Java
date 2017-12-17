import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
public class DocAttendu {
	private  HashMap<String, HashMap<String, String>> correspond;

	public DocAttendu(){
		correspond=new HashMap<String, HashMap<String, String>>();
		remplir();
	}
	public void remplir(){
		try {
	        FileInputStream f = new FileInputStream("src/cisi.rel");
	        BufferedReader reader = new BufferedReader(new InputStreamReader(f, "UTF-8"));
	        String ligne;
	        while((ligne = reader.readLine()) != null){
	        	String[] champs = ligne.replaceFirst("^\\D+", "").split("\\s+");
	        	HashMap<String, String> hm = new HashMap<String, String>();
	        	hm.put(champs[0], champs[1]);
	        	correspond.put(champs[0], hm);
	        }
	        f.close();
	    } catch  (IOException e) {
	        e.printStackTrace();
	    }
	 }
		
	public  HashMap<String, String> getDocAttendu(String idReq){
		return correspond.get(idReq);
	}
	
	// Ce qui correspond ид DocAttendus
	public  ArrayList<String> idDocsAttenduToAL(String idReq){
		ArrayList<String> al = new ArrayList<String>();
		HashMap<String, String> hm = this.getDocAttendu(idReq);
		for(String req : hm.keySet()){
			al.add(hm.get(req));
		}
		return al;
	}
	
}
