import java.math.BigInteger;


public class all {
	static int i=1,k=3;
	public static void main(String args[]){
		Integer r=556;
		BigInteger k=BigInteger.valueOf(556);
		System.out.println(r.byteValue());
		System.out.println(Integer.toBinaryString(r));
		System.out.println(k.bitCount());
		
//		switch(i){
//		case 1:	
//			For();
//			break;
//		case 2:
//			Do_While();
//			break;
//		case 3:
//			While();
//			break;
//		}
	}

	private static void While() {
		int j=5;
		while(j<=4|k==5){
			System.out.println("цикл while "+j);
			j++;
			if(j>10)break;
		}
	}

	private static void Do_While() {
		int j=6;
		do{
			System.out.println("цикл do while "+j);
			j--;
			if(j>10|j<-10)break;
		}while(j<5|k==5);
	}

	private static void For() {
		boolean f = true;
	    int g = 0;
		do {
		    g++;
		    System.out.print(g + " ");
		    if(g==10)f=false;
		} while (f);
	}

}
