package edu.wmich.CS1120.LA1.AFaisal;

import java.io.*;
import java.util.Arrays;



public class MultipleChoiceExam {
	
	private int questions;
	private int numOfStu;
	private int[] incorrect;
	private Character[][] stuAnswers;
	private Character [] answerKey;
	
	
	public MultipleChoiceExam(String numQuestions, String Key ,String numStudents,String[] studentsAnswers,int[] incorrectArray) {
		
		setQuestions(numQuestions);
		setAnswerKey(Key);
		setNumOfStudents(numStudents);
		setStudentAnswers(studentsAnswers);
		setIncorrect(incorrectArray);

	}
	
	public int getQuestions() {
		
		return questions;		
	}
	
	
	public void setQuestions(String questions) {
		
		this.questions= Integer.parseInt(questions);
		
	}
	
	public Character[] getAnswerKey() {
		
		return answerKey;
		
	}
	
	
	public void setAnswerKey(String Key) {
		
		Character [] answers= new Character[questions];
		for(int i=0;i<answers.length;i++) {
			
			answers[i]= new Character(Key.charAt(i));
		}
		this.answerKey= answers;
	}
	
	public int getNumOfStudents(){
		
		return numOfStu;
	}
		
	public void setNumOfStudents(String numOfStu) {
		
		this.numOfStu= Integer.parseInt(numOfStu);
		
	}
	
	public Character[][] getStudentAnswers() {
		return stuAnswers;
	}
	
	
	public void setStudentAnswers(String[] answers) {
		
		Character[][] students= new Character [questions][numOfStu];
		
		for (int i=0;i< questions; i++) {
			
			for (int j=0; j<numOfStu; j++) {
				
				students [i][j]= new Character(answers[j].charAt(i));
				
			}
			
		}
		this.stuAnswers= students;
			
	}
	
	public int[] getIncorrect() {
		
		return incorrect;
		
	}
	
	public void setIncorrect(int[] incorrect) {
		
		this.incorrect= incorrect;
		
	}
	
	
	
	
	
	public char findLetterGrades(double score) {
		
		char c;
		if(score>=90) {
			c='A';
			
		} else if (score< 90 && score> 80) {
			c='B';
				
		}else if (score< 80 && score> 70) {
			
			c= 'C';
			
		}else if (score< 70 && score> 60) {
			
			c= 'D';
			
		}else   {
			
			c= 'E';
		}
		return c;
		
	}
		
		
		
		public  String examGrader (int i, int j) {
			
			String returned;
			
			if(stuAnswers[i][j].equals(answerKey[i])) {
				
				returned= String.format("%2d)%2s\t\t",i+1, stuAnswers[i][j]);
			}else {
				returned = String.format("%2d)%2s (%s)\t ", i+1,stuAnswers[i][j], answerKey[i]);
				incorrect[j]++;
			}
			return returned;
			
		}
		
		
		public void Output() {
			
			System.out.printf("%s\n","Answer Key:");
			
			for(int i=0; i< answerKey.length; i++) {
				
				System.out.printf("%2d)%2s\n", i+1,answerKey[i]);
			}
			
		System.out.println("\nStudent Answers:");
		
		for(int i=0; i< numOfStu; i++){
			
			System.out.printf("Student %d\t ",i+1);
		}	
		System.out.println();
		
		
		String PrintNice;
		
		for (int i=0;i< questions; i++){
			for (int j=0; j<numOfStu; j++) {
				PrintNice= examGrader(i,j);
				System.out.printf(PrintNice);
				
			}
			System.out.println();
			
		}
		
		double length= answerKey.length;
		double score;
		char letterGrade;
		
		
		
		for(int i=0;i< numOfStu; i++) {
			
			score=(((questions-incorrect[i])*100)/length);
			letterGrade= findLetterGrades(score);
			System.out.printf("Student %d: %.0f%% %s\n", i+1,score,letterGrade);
				
		}
		
		
		
		}	
		
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

