import java.text.SimpleDateFormat;
import java.util.Date;


public class Record {
	Date date;
	Integer importance;
	String source;
	String eror;
	String imp=null;
	
	Record(int im, String src, String err){
	date=new Date();
	importance=im;
	source=src.replaceAll(" ", "");
	source=source.replaceAll("\n", "");
	eror=err.replaceAll("\n", "_");
	eror=eror.replaceAll(" ", "_");
	}
	public String toString(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		String dat = formatter.format(date);
		switch (importance) {
		case 1:
			imp=".    ";
			break;
		case 2:
			imp="!    ";
			break;
		case 3:
			imp="!!!  ";
			break;
		case 4:
			imp="!!!!!";
			break;
		}
		return dat+" "+imp+" "+source+" "+eror;
	}

}