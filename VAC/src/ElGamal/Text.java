package ElGamal;

public class Text {
	private String text;
	private int i=0;
	public Text(String str) {
		text=str;
	}
	public boolean hasNext(){
		if(i<text.length()){
			return true;
		}
		return false;
	}
	public char next(){
		char tmp=text.charAt(i);
		i++;
		return tmp;
	}
	
}
