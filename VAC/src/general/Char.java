package general;

public class Char {
	int id;
	String value;

	public Char(int ID, String value) {
		this.id = ID;
		this.value = value;
	}

	public int getKey() {
		return this.id;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return "[ id=" + this.id + " value=" + this.value + "]";
	}
}
