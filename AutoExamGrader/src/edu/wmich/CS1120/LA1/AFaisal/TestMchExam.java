package edu.wmich.CS1120.LA1.AFaisal;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class TestMchExam {
	
public static void main(String[] args) throws IOException{
		
		String[] arrayReader= fileReader();
		String[] studentArray= makeStudentArray(arrayReader);
		int[] counterArray= makeCounterArray(arrayReader);
		
		
		MultipleChoiceExam examGrader= new MultipleChoiceExam(arrayReader[0],
				arrayReader[1],arrayReader[2],studentArray, counterArray);
		examGrader.Output();
		
	}
	
	
public static String[] fileReader() throws IOException{
		
		File f= new File("input.txt");
	Scanner inFile= new Scanner(f);
	
	ArrayList<String> listReader= new ArrayList<String>();
	
while(inFile.hasNext()) {
	String record= inFile.nextLine();
	listReader.add(record);
	
}
inFile.close();
String arrayReader[]= new String[listReader.size()];

for(int i=0;i<listReader.size();i++) {	
	
	arrayReader[i]=listReader.get(i);

}
return arrayReader;
		
	}
	

public static String[] makeStudentArray(String[] arrayReader) {
	
	String[] studentArray= new String[arrayReader.length-3];
	int j= 0;
	for(int i = 3 ; i< arrayReader.length; i++) {
		
		studentArray[j]= new String (arrayReader[i]);
		j++;
		
	}
	return studentArray;
}

public static int [] makeCounterArray(String[] arrayReader) {
	
	int size= Integer.parseInt(arrayReader[2]);
	int [] counterArray= new int [size];
	for (int i=0; i<size; i++) {
		
		counterArray[i] = 0;
		
	}
	return counterArray;
	
	
	
}





	
	
	

}


