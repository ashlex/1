package ru.ncedu.java.tasks;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordCounterImpl implements WordCounter {
	private String text = null;

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String getText() {
		return this.text;
	}

	@Override
	public Map<String, Long> getWordCounts() throws IllegalStateException  {
		if (getText()==null) {
			throw new IllegalStateException();
		}
		Map<String, Long> result = new HashMap<String, Long>();
		boolean flag=false;
		for (String t : getText().split("\\s")) {
			t = t.toLowerCase();
			t = t.replaceAll("[\\.\\,\\:\\(\\)\\;\\!\\?\"]", "");
			if(t.matches("\\<.*")){
				flag=true;
			}
			if (t.matches(".*\\>")) {
				flag=false;
				continue;
			}
			
			if (t.length() > 0 && !flag) {
				if (result.containsKey(t)) {
					result.put(t, result.get(t) + 1);
				} else {
					result.put(t, (long) 1);
				}
			}
		}
		return result;
	}

	@Override
	public List<Entry<String, Long>> getWordCountsSorted()  throws IllegalStateException {
		return sortWordCounts(getWordCounts());
	}

	@Override
	public List<Entry<String, Long>> sortWordCounts(Map<String, Long> orig) {
		if(orig==null)return null;
		List<Entry<String, Long>> l=new ArrayList<Map.Entry<String,Long>>(orig.entrySet());
		Collections.sort(l, new Comparator<Map.Entry<String, Long>>() {

			@Override
			public int compare(Entry<String, Long> o1, Entry<String, Long> o2) {
				if(o1.getValue().compareTo(o2.getValue())!=0){
					return -o1.getValue().compareTo(o2.getValue());
				}
				if(o1.getKey().compareTo(o2.getKey())!=0){
					return o1.getKey().compareTo(o2.getKey());
				}
				return 0;
			}
		});
		return l;
	}

	@Override
	public void printWordCounts(PrintStream ps) throws IllegalStateException {
		for (Entry<String, Long> o : getWordCounts().entrySet()) {
			ps.println(o.getKey()+" "+o.getValue());
		}
		ps.flush();
	}

	@Override
	public void printWordCountsSorted(PrintStream ps)  throws IllegalStateException {
		for (Entry<String, Long> o : getWordCountsSorted()) {
			ps.println(o.getKey()+" "+o.getValue());
		}
		ps.flush();
	}

}
