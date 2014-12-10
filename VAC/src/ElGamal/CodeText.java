package ElGamal;

import java.math.BigInteger;
import java.util.ArrayList;

public class CodeText {
	ArrayList<Symbol> code=new ArrayList<Symbol>();
	int i=0;
	public CodeText(String text) {
		String t[]=text.split(",");
		for(int i=0;i<t.length;i++){
			String tm[]=t[i].split(":");
			for(int j=0;j<tm.length;j++){
				tm[j]=tm[j].replaceAll("\\D", "");
				
			}
			code.add(new Symbol(new BigInteger(tm[0]), new BigInteger(tm[1])));
		}
	}
	public boolean hasNext(){
		if(i<code.size()){
			return true;
		}
		return false;
	}
	public Symbol next(){
		Symbol tmp=code.get(i);
		i++;
		return tmp;
	}
}
