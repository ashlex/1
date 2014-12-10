package rsa;

import general.Alphabet;
import general.Text;
import general.WordObj;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.logging.Logger;

public class Decoder {

	Logger log = Logger.getLogger(Coder.class.getName());
	BigInteger p = null;
	BigInteger q = null;
	BigInteger m = null;
	BigInteger e = null;
	BigInteger n = null;
	BigInteger d = null;

	Text text;
	Alphabet alphabet;

	public Decoder(String text, int varAlphabet, BigInteger d, BigInteger m) {
		this.m = m;
		this.d = d;
		this.text = new Text(text);
		this.alphabet = new Alphabet(varAlphabet);

	}

	public Decoder(String text, int varAlphabet, BigInteger p, BigInteger q,
			BigInteger e) {
		this.p = p;
		this.q = q;
		if(e.equals(BigInteger.valueOf(0))){
			this.e = KeyGenerator.createE(p, q).get("e");
		}else{
			this.e = e;
		}
		this.text = new Text(text);
		this.alphabet = new Alphabet(varAlphabet);

	}
	public String getCodeText() {
		if (checkClosedKey()) {
			Iterator<WordObj> itWordObj = text.getCollectionWord().iterator();
			String codeText = "";
			while (itWordObj.hasNext()) {
				WordObj wordObj = (WordObj) itWordObj.next();
				if(!wordObj.getValue().isEmpty()){
				BigInteger charAsInt=new BigInteger(wordObj.getValue());
				codeText += alphabet.getByAlphabet(Integer.parseInt(charAsInt.modPow(d, m).toString())) + " ";
				}
			}
			return codeText;
		} else {
			return "Error";
		}
	}

	private boolean checkClosedKey() {
		if (d == null) {
			if (p != null && q != null && e != null) {
				this.d = e.modInverse(p.add(new BigInteger("-1")).multiply(
						q.add(new BigInteger("-1"))));
				this.m=this.p.multiply(this.q);
				return true;
			} else {
				throw new IllegalArgumentException(
						"Is not possible to create a key");
			}
		}
		return true;
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
