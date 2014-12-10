package ru.ncedu.java.tasks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		WordCounterImpl wc = new WordCounterImpl();

		String line = "";
		try {
			// InputStreamReader isr = new InputStreamReader(new
			// FileInputStream("D:\\Projects\\JavaProjects\\1\\WordCounter\\test\\1"),"Cp1251");
			Scanner scn = new Scanner(new FileInputStream(
					"D:\\Projects\\JavaProjects\\1\\WordCounter\\test\\1"));
			// BufferedReader bufferedReader = new BufferedReader(isr);
			while (scn.hasNextLine()) {
				line += scn.nextLine() + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

//		System.out.print(line);
		wc.setText(line);
		// System.out.print(wc.getText());
//		System.out.println(wc.getWordCounts());
//		System.out.print(wc.getWordCountsSorted());
		wc.printWordCountsSorted(System.out);
	}
}
