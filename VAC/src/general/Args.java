package general;

import java.util.ArrayList;

public class Args {

	private ArrayList<String> args = new ArrayList<String>();
	private final static Args INSTANCE = new Args();

	private Args() {
	}

	public static Args getInstance() {
		return INSTANCE;
	}

	public void addAllArgs(String[] str) {
		for (String s : str) {
			args.add(s);
		}
	}

	public void addArgs(String str) {
		args.add(str);
	}

	public boolean equalsIgnoreCase(String str) {
		for (String s : args) {
			if (s.equalsIgnoreCase(str))
				return true;
		}
		return false;
	}
}
