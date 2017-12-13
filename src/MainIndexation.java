import indexation.Index;
import indexation.ParserCISI;
import indexation.Stemmer;

public class MainIndexation {
	public static void main(String[] args){
		ParserCISI ps = new ParserCISI();
		Stemmer st = new Stemmer();
		Index i = new Index("index1", ps, st);
		i.index("src/cisi.txt");
	}
}
