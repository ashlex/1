package general;

public class WordObj {
	private int id;
	private String value;

	// private int keyy=0;
	public WordObj(int ID, String value) {
		this.id = ID;
		this.value = value;
	}

	@Deprecated
	public WordObj(int ID, String value, int key) {
		this.id = ID;
		this.value = value;
		// this.keyy=key;
	}

	public int getId() {
		return this.id;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		// if(this.keyy==0){
		// return "[ id="+this.id+" value="+this.value+"]";
		// }else{
		// return "[ смещение="+this.keyy+" value="+this.value+"]";
		// }
		return this.value;
	}
}
