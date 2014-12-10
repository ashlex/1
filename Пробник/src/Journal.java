import java.util.Arrays;
import java.util.Comparator;


public class Journal{
	static Record[] re=new Record[0];

	  public static void add(int im, String src, String err){
		  Record[] tmp=new Record[re.length];
		  System.arraycopy(re, 0, tmp, 0, re.length);
		  re=new Record[re.length+1];
		  System.arraycopy(tmp, 0, re, 0, tmp.length);
		  re[re.length-1]=new Record(im, src, err);
	  }
	  public static void sortByImportanceDate(){
		  Arrays.sort(re, new Comparator<Record>() {
			  @Override
			  public int compare(Record o1, Record o2) {
				  if(o1.importance.compareTo(o2.importance)!=0){
					  return o1.importance.compareTo(o2.importance);
				  }
				  if(o1.date.compareTo(o2.date)!=0){
					  return o1.date.compareTo(o2.date);
				  }
				  return 0;
			  }
		  });
		  System.out.println("======= sortByImportanceDate =======");
		  for (int i = 0; i < re.length; i++) {
			  System.out.println(re[i]);
		  }
		  
	  }
	  public static void sortByImportanceSourceDate(){
		  Arrays.sort(re, new Comparator<Record>() {
			  @Override
			  public int compare(Record o1, Record o2) {
				  if(o1.importance.compareTo(o2.importance)!=0){
					  return o1.importance.compareTo(o2.importance);
				  }
				  if(o1.source.compareTo(o2.source)!=0){
					  return o1.source.compareTo(o2.source);
				  }
				  if(o1.date.compareTo(o2.date)!=0){
					  return o1.date.compareTo(o2.date);
				  }
				  return 0;
			  }
		  });
		  System.out.println("======= sortByImportanceSourceDate =======");
		  for (int i = 0; i < re.length; i++) {
			  System.out.println(re[i]);
		  }
	  }
	  public static void sortBySourceDate(){
		  Arrays.sort(re, new Comparator<Record>() {
			  @Override
			  public int compare(Record o1, Record o2) {
				  if(o1.source.compareTo(o2.source)!=0){
					  return o1.source.compareTo(o2.source);
				  }
				  if(o1.date.compareTo(o2.date)!=0){
					  return o1.date.compareTo(o2.date);
				  }
				  return 0;
			  }
		  });
		  System.out.println("======= sortBySourceDate =======");
		  for (int i = 0; i < re.length; i++) {
			  System.out.println(re[i]);
		  }
	  }
	  public static void sortByDate(){
		  Arrays.sort(re, new Comparator<Record>() {
			  @Override
			  public int compare(Record o1, Record o2) {
				  if(o1.date.compareTo(o2.date)!=0){
					  return o1.date.compareTo(o2.date);
				  }
				  return 0;
			  }
		  });
		  System.out.println("======= sortByDate =======");
		  for (int i = 0; i < re.length; i++) {
			  System.out.println(re[i]);
		  }
	  }
	  public static void main(String arg[]){
		  add(2,"fhf_","A");
		  add(4,"fhg_","B");
		  add(2,"fgf_","C");
		  add(3,"fhgf","D");
		  add(1,"hgf_","5");
		  add(2,"fhgf","6");
		  add(2,"fhgf","7");
		  add(2,"fhgf","8");
		  add(1,"fhgf","9");
		  add(2,"fhgf","10");
		  add(2,"fhgf","11");
		  add(2,"fhgf","12");
	        for (int i = 0; i < re.length; i++) {
	            System.out.println(re[i]);
	        }
	        sortByImportanceDate();
	        sortByImportanceSourceDate();
	        sortByDate();
	        sortBySourceDate();
	  }
}
