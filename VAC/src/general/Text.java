package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;

public class Text {
	String text;
	Logger log=Logger.getLogger("test");

	public Text(String text) {
		this.text = text;
	}
	public Text() {}
	
	/**
	 * Gets the collection word.
	 *
	 * @return the collection WordObj(ID , value)
	 */
	public Collection<WordObj> getCollectionWord() {
		if(text.length()<1){
			log.severe(getClass().getName().toString()+" нет текста");
			throw new IllegalArgumentException("Нет текста");
		}
		
		Collection<WordObj> collection=new ArrayList<WordObj>();
		String[] str=this.text.toUpperCase().split(" ");
		for(String string: str){
			
			collection.add(new WordObj(Arrays.asList(str).indexOf(string), string.toUpperCase()));
		}
		return collection;
	}
	public void setText(String str){
		this.text=str;
	}
}
