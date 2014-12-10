package general;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



public class Word {
	String word;
	Alphabet alphabet;
	/**
	 * @param word
	 */
	public Word(String word , Alphabet alphabet) {
		this.word = word;
		this.alphabet=alphabet;
	}

	/**
	 * @return Collection<Char>
	 */
	public Collection<Char> toCollectionChar() {
		Collection<Char> collection = new ArrayList<Char>();
		char[] str = this.word.toUpperCase().toCharArray();
		for (char string : str) {
				collection.add(new Char(alphabet.getByAlphabet(string + ""), string+""));
		}
		return collection;
	}
	
	
	/**
	 * @param ID
	 * @param key
	 * @return WordObj(ID, value, key)
	 */
	@SuppressWarnings("deprecation")
	public WordObj getNewWord(int ID ,int key) {
		
		Collection<Char> a=toCollectionChar();
		String value="";
		Iterator<Char> it=a.iterator();
		while (it.hasNext()) {
			Char strings = (Char) it.next();
			if(strings.getKey()!=-1){
				value+=alphabet.getByAlphabet(alphabet.mod(strings.getKey()+key));
//				System.out.println(value);
			}else{
				value+=strings.getValue();
			}
			
		}
		
        
//        Matcher mt = pt.matcher(value);
//        if (mt.find()) {
//        	System.out.println("ERROR");
//    		return null;
//        } else {
        	return new WordObj(ID, value, key);
//        }
	}
	@Override
	public String toString() {
		
		return super.toString();
	}
}
