package rsa;

import general.Alphabet;
import general.HelpMenu;

import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Scanner;

public class Help implements HelpMenu{
	Scanner scn1;
	@Override
	public String getHelp() {
		// TODO Auto-generated method stub
		String a="Алфавит с \"Ё\" и без \"Й\" :<br><table>";
		Alphabet al=new Alphabet(0,"rsa");
		int i=0;
		for (Entry<String, String> obj : al.getAlphabet().entrySet()) {
			if(i%6==0){
				a+="<tr>";
			}
			a+="<td>"+obj.getKey()+"=>"+obj.getValue()+"</td>";
			if(i%6==5){
				a+="</tr>";
			}
			i++;
		}
		a+="</table>";
		a+="Алфавит  без \"Ё\" и без \"Й\" :<br><table>";
		Alphabet al2=new Alphabet(1,"rsa");
		i=0;
		for (Entry<String, String> obj : al2.getAlphabet().entrySet()) {
			if(i%6==0){
				a+="<tr>";
			}
			a+="<td>"+obj.getKey()+"=>"+obj.getValue()+"</td>";
			if(i%6==5){
				a+="</tr>";
			}
			i++;
		}
		a+="</table>";
		a+="Алфавит  с \"Ё\" и с \"Й\" :<br><table>";
		Alphabet al3=new Alphabet(2,"rsa");
		i=0;
		for (Entry<String, String> obj : al3.getAlphabet().entrySet()) {
			if(i%6==0){
				a+="<tr>";
			}
			a+="<td>"+obj.getKey()+"=>"+obj.getValue()+"</td>";
			if(i%6==5){
				a+="</tr>";
			}
			i++;
		}
		a+="</table>";
		a+="Алфавит  без \"Ё\" но с \"Й\" :<br><table>";
		Alphabet al4=new Alphabet(3,"rsa");
		i=0;
		for (Entry<String, String> obj : al4.getAlphabet().entrySet()) {
			if(i%6==0){
				a+="<tr>";
			}
			a+="<td>"+obj.getKey()+"=>"+obj.getValue()+"</td>";
			if(i%6==5){
				a+="</tr>";
			}
			i++;
		}
		a+="</table>";


		String b="";
		String tmp;
		if(openFile("help.txt")){
			while(scn1.hasNext()){
				tmp=scn1.nextLine().toString();
				tmp=tmp.replaceAll("\\[getAlphabet\\]", a);
				b+=tmp;
			}
		}
		
		return "<html>"+b+"</html>";
	}

	@Override
	public String getAbout() {
		// TODO Auto-generated method stub
		String b="";
		if(openFile("about.txt")){
			while(scn1.hasNext()){
				b+=scn1.nextLine();
			}
		}
		return b;
	}
	private boolean openFile(String uri){
		InputStream stream=getClass().getResourceAsStream(uri);
		try{
			scn1=new Scanner(stream);
			return true;
		}catch(Exception e){
			System.out.print("Файл не найден");
			return false;
		}
	}
	
}
