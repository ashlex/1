package rsa;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

//import zesar.Word;
import general.*;

public class Coder {

	Logger log=Logger.getLogger(Coder.class.getName());
	private BigInteger p;
	private BigInteger q;
	private BigInteger m;
	private BigInteger e;
	private BigInteger n;
	private BigInteger d;

	Text text;
	Alphabet alphabet;

	public Coder(String text, int varAlphabet) {
		KeyGenerator kg = new KeyGenerator();
		this.p = kg.getP();
		this.q = kg.getQ();
		this.m = kg.getM();
		this.e = kg.getE();
		this.n = kg.getN();
		this.d = kg.getD();
		this.text = new Text(text);
		this.alphabet = new Alphabet(varAlphabet);
	}

	public Coder(String text, int varAlphabet, BigInteger p, BigInteger q) {
		KeyGenerator kg = new KeyGenerator(p, q);
		this.p = kg.getP();
		this.q = kg.getQ();
		this.m = kg.getM();
		this.e = kg.getE();
		this.n = kg.getN();
		this.d = kg.getD();
		this.text = new Text(text);
		this.alphabet = new Alphabet(varAlphabet);

	}

	public String getCodeText() {
		Iterator<WordObj> itWordObj = text.getCollectionWord().iterator();
		String codeText="";
		while (itWordObj.hasNext()) {
			WordObj wordObj = (WordObj) itWordObj.next();
			Word word = new Word(wordObj.getValue(), alphabet);

			Collection<Char> a = word.toCollectionChar();
			Iterator<Char> it = a.iterator();
			while (it.hasNext()) {
				Char strings = (Char) it.next();
				if (strings.getKey() != -1) {
					Integer tmp = strings.getKey();
					BigInteger charAsInt;
						charAsInt = new BigInteger(tmp+"");
//					log.info(charAsInt.toString());
					
					codeText += charAsInt.modPow(e, m) + " ";
				} else {

				}
			}
			codeText+=" ";
		}
		return codeText;
	}

	public BigInteger getP() {
		return p;
	}

	public BigInteger getQ() {
		return q;
	}

	public BigInteger getM() {
		return m;
	}

	public BigInteger getE() {
		return e;
	}

	public BigInteger getN() {
		return n;
	}

	public BigInteger getD() {
		return d;
	}

}
