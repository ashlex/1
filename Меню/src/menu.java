import java.io.*;
import java.util.Scanner;

public class menu {
	public static void main(String args[]) throws IOException{	
File f=new File(System.getProperty("user.dir")+"\\bin\\file\\test");
System.out.println(f.length());
Scanner r=new Scanner(f);
while(r.hasNextLine()){
	String[] s=r.nextLine().split(";");
	for(int i=0;i<s.length;i++){
System.out.println(s[i]);	
	}
}
FileWriter w=new FileWriter(f, true);
CharSequence q="re";
w.write("d;g\n");
w.close();
	}

}
