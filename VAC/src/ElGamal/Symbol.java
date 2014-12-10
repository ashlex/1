package ElGamal;

import java.math.BigInteger;

public class Symbol {
	BigInteger a;
	BigInteger b;
	public Symbol(BigInteger a, BigInteger b) {
		this.a=a;
		this.b=b;
	}
	public String toString(){
		return "{"+a+" : "+b+"}";
		
	}
}
