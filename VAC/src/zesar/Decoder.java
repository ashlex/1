package zesar;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import general.*;

public class Decoder {
	Text text;
	Alphabet alphabet;
	public Decoder(String text,int varAlphabet) {
		this.text = new Text(text);
		this.alphabet= new Alphabet(varAlphabet);
	}

	public Map<Integer, ArrayList<WordObj>> getDecodeWord() {
		Iterator<WordObj> itWordObj = text.getCollectionWord().iterator();
		Map<Integer, ArrayList<WordObj>> newWords = new TreeMap<Integer, ArrayList<WordObj>>();
		while (itWordObj.hasNext()) {
			WordObj wordObj = (WordObj) itWordObj.next();
//			System.out.println(wordObj);
			Word word = new Word(wordObj.getValue(),alphabet);
			ArrayList<WordObj> newWords1 = new ArrayList<WordObj>();
			for (int i = 0; i < alphabet.getAlphabet().size(); i++) {
				if(word.getNewWord(wordObj.getId(), i)!=null){
				newWords1.add(word.getNewWord(wordObj.getId(), i));
				}
			}
			newWords.put(wordObj.getId(), newWords1);
		}
//		for(Entry<Integer, ArrayList<WordObj>> words: newWords.entrySet()){
//			System.out.println(words.getKey()+" "+words.getValue().size()+" "+words.getValue());
//		}
//		System.out.println(alphabet.getAlphabet());
		return newWords;
		
	}
}
