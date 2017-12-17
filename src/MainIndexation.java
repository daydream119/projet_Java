import indexation.Index;
import indexation.ParserCISI;
import indexation.Stemmer;

public class MainIndexation {
	public static void main(String[] args){
		ParserCISI ps = new ParserCISI();
		Stemmer st = new Stemmer();
		Index idoc = new Index("index1", ps, st);
		Index iquery = new Index("indexq", ps, st);
		Index ireponse = new Index("indexr", ps, st);
		idoc.index("src/cisi.txt");
		iquery.index("src/cisi.qry");
		iquery.index("src/cisi.rel");
	}
}
