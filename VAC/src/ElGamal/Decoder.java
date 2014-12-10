package ElGamal;

import java.math.BigInteger;

public class Decoder {
	BigInteger x;
	BigInteger p;
	public Decoder(BigInteger x, BigInteger p) {
		this.x=x;
		this.p=p;
	}
	public String getDecode(String str){
		CodeText code=new CodeText(str);
		String st="";
		while(code.hasNext()){
			Symbol s=code.next();
			BigInteger m=s.b.multiply((s.a.modPow(x, p)).modInverse(p)).mod(p);
			st+=(char)m.intValue();
		}
		return st;
	}
	
}
