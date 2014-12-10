package general;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author Alexej
 * 
 */
public class Alphabet {
	private Map<String, String> alphabet = new TreeMap<String, String>();
	static String[][] a = {
			{ "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�",
					"�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�",
					"�", "�", "�", "�", "�", "�", "�", "�", "�" },
			{ "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�",
					"�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�",
					"�", "�", "�", "�", "�", "�", "�", "�" },
			{ "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�",
					"�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�",
					"�", "�", "�", "�", "�", "�", "�", "�", "�", "�" },
			{ "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�",
					"�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�",
					"�", "�", "�", "�", "�", "�", "�", "�", "�" }

	};
	public Alphabet(int l) {
		for (int i = 1; i <= a[l].length; i++) {
			this.alphabet.put(i+"", a[l][i - 1]);
		}
//			String val="";
//			for (int i = 1; i <= a[l].length; i++) {
//				if(i<10){
//					val="0"+i;
//				}else{
//					val=i+"";
//				}
//				this.alphabet.put(val, a[l][i - 1]);
//			}	
		

	}
	public Alphabet(int l, String option) {
		if(option.equalsIgnoreCase("rsa")){
			String val="";
			for (int i = 1; i <= a[l].length; i++) {
				if(i<10){
					val="0"+i;
				}else{
					val=i+"";
				}
				this.alphabet.put(val, a[l][i - 1]);
			}	
		}

	}

	public Map<String, String> getAlphabet() {
		return this.alphabet;
	}

	public Integer getByAlphabet(String value) {
		for (Entry<String, String> obj : this.alphabet.entrySet()) {
			if (obj.getValue().equalsIgnoreCase(value)) {
				return Integer.parseInt(obj.getKey());
			}
		}
		return -1;
	}

	public String getByAlphabet(Integer key) {
		for (Entry<String, String> obj : this.alphabet.entrySet()) {
			if (obj.getKey().equals(key+"")) {
				return obj.getValue();
			}
			// System.out.println(obj.getKey());
			// System.out.println(key);
		}
		return null;
	}

	public String toString() {
		return this.alphabet.toString();
	}

	/**
	 * @param value
	 * @return
	 */
	public Integer mod(int value) {
		int c = value % alphabet.size();
		// System.out.println("alphabet.size()="+alphabet.size());
		// System.out.println("mod value"+value);
		// System.out.println("mod return"+c);
		if (c != 0) {
			return c;
		} else {
			return value;
		}
	}
}
