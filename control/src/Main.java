import java.io.File;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	static int tch;
	static Scanner scn1;
	static String com,help[],url;
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		boolean re = true;
		ex:
		do{
			System.out.print("com\\:");
			com=scn.next();
			switch (com) {
			case "help":
				help();
				break;
			case "/?":
				help();
				break;
			case "exit":
				break ex;

			default:
				break;
			}
		}while(re);

	}
	private static void help() {
		url="res\\help\\help.txt";
		OpenFile(url);
		help=new String[tch];
		ReadFile(help);
		CloseFile();
		for(int i=0;i<help.length;i++){
			/*String result=null;
			try {
				result = new String(new String(help[i].getBytes(),"ASCII").getBytes("Cp866"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			Print(help[i]);
		}
	}
	private static void CloseFile() {
		scn1.close();
		tch=0;
	}
	private static void ReadFile(String e[]) {
		if(scn1.hasNext()){
			for(int i=0;i<e.length;i++){
				e[i]=scn1.nextLine();
			}
		}
	}
	private static void Print(String e){
		System.out.println(e);
	}
	private static void Print(int e){
		System.out.println(e);
	}
	private static void OpenFile(String url){
		try{
			scn1=new Scanner(new File(url));
			while(scn1.hasNextLine()){
				tch++;
				scn1.nextLine();
			}
			scn1.reset();
			scn1=new Scanner(new File(url));
		}catch(Exception e){Print("No_File");}
	}

}
