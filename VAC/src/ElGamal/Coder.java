package ElGamal;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class Coder {
	Logger log = Logger.getLogger("test");
	private BigInteger p;
	private BigInteger g;
	private BigInteger x;
	private BigInteger y;
	private BigInteger k;

	public Coder(int bitLength) {
		p = BigInteger.probablePrime(bitLength, new Random());
		do {
			log.info("поиск g");
			g = new BigInteger(p.bitLength(), new Random());
		} while (g.compareTo(p) > 0);
		do {
			log.info("поиск x");
			x = new BigInteger(p.bitLength(), new Random());
		} while (x.compareTo(p) > 0 || x == g);
		y=g.modPow(x, p);
		
	}
	public Coder(BigInteger p, BigInteger g , BigInteger x) {
		this.p = p;
		this.g = g;
		this.x = x;
		y=g.modPow(x, p);
		
	}

	public BigInteger getP(){
		return p;
	}
	public BigInteger getG(){
		return g;
	}
	public BigInteger getX(){
		return x;
	}
	public BigInteger getY(){
		return y;
	}
	
	private Symbol getCodeSymbol(char ch){
		BigInteger key=BigInteger.valueOf((int)ch);
		BigInteger a;
		BigInteger b;
		a=g.modPow(k, p);
		b=key.multiply(y.modPow(k, p)).mod(p);
		return new Symbol(a,b);
	}
	public ArrayList<Symbol> getCode(String str){
		Text text=new Text(str);
		createK();
		ArrayList<Symbol> code=new ArrayList<Symbol>();
		while(text.hasNext()){
			char ch=text.next();
			code.add(getCodeSymbol(ch));
		}
		return code;
		
	}
	private void createK(){
		do {
			log.info("поиск k");
			k = new BigInteger(p.bitLength(), new Random());
		} while (k.compareTo(p.subtract(BigInteger.valueOf(1))) > 0 || k == g|| k==x);
	}

}
