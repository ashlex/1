import java.math.BigInteger;
import java.util.logging.Logger;


public class Main {

	public static void main(String []args){
		Logger log=Logger.getLogger(Main.class.getName());
		BigInteger p=new BigInteger("3557");
		BigInteger q=new BigInteger("2579");
		BigInteger m=p.multiply(q); // m=p*q
		log.info("m="+m.toString());
		BigInteger tmp=p.add(new BigInteger("-1")).multiply(q.add(new BigInteger("-1")));// (p-1)(q-1)
		log.info("tmp="+tmp.toString());
		BigInteger e=new BigInteger("3");
		BigInteger tmp2=new BigInteger("2");
		while(true){
			if(e.gcd(tmp).equals(new BigInteger("1"))){
				break;
			}else{
				e=e.add(tmp2);
			}
		}
		String ch="32"; // char
		BigInteger x=new BigInteger(ch); // msg
		BigInteger y=x.modPow(e, m); // coded msg
		BigInteger d=e.modInverse(tmp); // decoded msg
		log.info("d="+d.toString());
		String outmsg="";
//		outmsg+=Integer.toBinaryString(y.intValue());
		outmsg+=y.intValue();
		log.info(y.toString());
		log.info(x.toString());
		log.info(outmsg);
		BigInteger msg=y.modPow(d, m);
		log.info(msg+"");
	}
}
