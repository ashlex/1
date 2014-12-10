package ru.ncedu.java.tasks;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

public class t {
	WordCounterImpl wc=new WordCounterImpl();

    static String line="";
	@BeforeClass
	public static void load(){
		try{
//		InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\Projects\\JavaProjects\\1\\WordCounter\\test\\1"),"Cp1251");
		Scanner scn=new Scanner(new FileInputStream("D:\\Projects\\JavaProjects\\1\\WordCounter\\test\\1"));
//	    BufferedReader bufferedReader = new BufferedReader(isr);
	while(scn.hasNextLine())
	            {
	                line +=scn.nextLine()+"\n";
	            }
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test() {
		System.out.print(line);
		wc.setText(line);
//		System.out.print(wc.getText());
		System.out.print(wc.getWordCounts());
		
	}

	

}


