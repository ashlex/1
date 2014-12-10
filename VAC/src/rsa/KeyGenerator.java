package rsa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class KeyGenerator {
	private BigInteger p;
	private BigInteger q;
	private BigInteger m;
	private BigInteger e;
	private BigInteger n;
	private BigInteger d;

	private BigInteger[] kit;
	private int[] a = { 2687, 2689, 2693, 2699, 2707, 2711, 2713, 2719, 2729,
			2731, 2741, 2749, 2753, 2767, 2777, 2789, 2791, 2797, 2801, 2803,
			2819, 2833, 2837, 2843, 2851, 2857, 2861, 2879, 2887, 2897, 2903,
			2909, 2917, 2927, 2939, 2953, 2957, 2963, 2969, 2971, 2999, 3001,
			3011, 3019, 3023, 3037, 3041, 3049, 3061, 3067, 3079, 3083, 3089,
			3109, 3119, 3121, 3137, 3163, 3167, 3169, 3181, 3187, 3191, 3203,
			3209, 3217, 3221, 3229, 3251, 3253, 3257, 3259, 3271, 3299, 3301,
			3307, 3313, 3319, 3323, 3329, 3331, 3343, 3347, 3359, 3361, 3371,
			3373, 3389, 3391, 3407, 3413, 3433, 3449, 3457, 3461, 3463, 3467,
			3469, 3491, 3499, 3511, 3517, 3527, 3529, 3533, 3539, 3541, 3547,
			3557, 3559, 3571, 3581, 3583, 3593, 3607, 3613, 3617 };

	public KeyGenerator() {
		kit = new BigInteger[this.a.length];
		for (int i = 0; i < this.a.length; i++) {
			kit[i] = new BigInteger(this.a[i] + "");
		}
		Random rnd = new Random();
		Integer rndInt;
		ArrayList<Integer> rndOld = new ArrayList<Integer>();
		while (true) {
			rndInt = rnd.nextInt(kit.length);
			if (!rndOld.contains(rndInt)) {
				this.p = kit[rndInt];
				rndOld.add(rndInt);
				break;
			}
		}
		while (true) {
			rndInt = rnd.nextInt(kit.length);
			if (!rndOld.contains(rndInt)) {
				this.q = kit[rndInt];
				rndOld.add(rndInt);
				break;
			}
		}
		createKeys();
	}

	public KeyGenerator(BigInteger p, BigInteger q) {
		this.p = p;
		this.q = q;
		createKeys();
	}


	private void createKeys() {
		this.m = p.multiply(this.q); // m=p*q
		this.n = p.add(new BigInteger("-1")).multiply(
				q.add(new BigInteger("-1"))); // (p-1)(q-1)
		this.e = new BigInteger("3");
		BigInteger tmp = new BigInteger("2");
		while (true) {
			if (this.e.gcd(this.n).equals(new BigInteger("1"))) {
				break;
			} else {
				this.e = this.e.add(tmp);
			}
		}
		this.d = e.modInverse(this.n);
	}
	public static Map<String, BigInteger> createE(BigInteger p, BigInteger q) {
		Map<String, BigInteger> request=new TreeMap<String, BigInteger>();
		BigInteger m = p.multiply(q); // m=p*q
		BigInteger n = p.add(new BigInteger("-1")).multiply(
				q.add(new BigInteger("-1"))); // (p-1)(q-1)
		BigInteger e = new BigInteger("3");
		BigInteger tmp = new BigInteger("2");
		while (true) {
			if (e.gcd(n).equals(new BigInteger("1"))) {
				break;
			} else {
				e = e.add(tmp);
			}
		}
		BigInteger d = e.modInverse(n);
		request.put("m", m);
		request.put("n", n);
		request.put("e", e);
		request.put("d", d);
		return request;
	}

	public BigInteger getP() {
		return this.p;
	}

	public BigInteger getQ() {
		return this.q;
	}

	public BigInteger getM() {
		return this.m;
	}

	public BigInteger getE() {
		return this.e;
	}

	public BigInteger getN() {
		return this.n;
	}

	public BigInteger getD() {
		return this.d;
	}
}
