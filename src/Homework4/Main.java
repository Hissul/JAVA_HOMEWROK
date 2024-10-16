package Homework4;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.Arrays;

import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		
		Student[] students = new Student[10];
		
		StudentInit(students);
		StudentMakr(students);		
	
		PrintStudentToFile(students);
		
		OtherExamples();

	}
	
	// инициализация массива студентов
	public static void StudentInit(Student[] students) {
		
		for(int i = 0 ; i < students.length ; ++i) {
			students[i] = new Student();			
			students[i].setName("Student " + i);
		}
	}
	
	// средняя оценка + допуск
	public static void StudentMakr(Student[] students) {
		
		Predicate<Float> examAdmission = (mark) -> mark >= 7;
		
		Supplier<Float> getRandomNumber = () -> (float)Math.random() * 12;
		
		for(int i = 0 ; i < students.length ; ++i) {			
			students[i].setAverageMark(getRandomNumber.get());
			students[i].setExamAdmission(examAdmission.test(students[i].getAverageMark()) == true ? "Допущен" : "Забей!");						
		}
	}
	
	// сейв в файл
	public static void PrintStudentToFile(Student[] students) {	
		
		try(FileWriter writer = new FileWriter( "StudentList.txt" , true )){
			
			Consumer<String> nameConsumer = (name) -> {
				try {
					writer.write("\t" + name + " : ");
				} catch (IOException e) {					
					System.out.println(e);
				}
			};
			
			Consumer<String> averageConsumer = (average) -> {
				try {
					writer.write(average + "\t");
				} catch (IOException e) {					
					System.out.println(e);
				}
			};
			
			Consumer<String> examConsumer = (exam) -> {
				try {
					writer.write(exam + "\n");
				} catch (IOException e) {					
					System.out.println(e);
				}
			};
			
			for(int i = 0 ; i < students.length ; ++i) {
				nameConsumer.accept(students[i].getName());
				averageConsumer.accept(students[i].getAverageMark().toString());
				examConsumer.accept(students[i].getExamAdmission());
			}
			
		}
		catch(IOException ex) {
			System.out.println(ex);
		}	
		
	}
	
	// 
	public static void OtherExamples() {
		
		UnaryOperator<Integer> square = x -> x * x;
		System.out.println("UnaryOperator -> " + square.apply(8));
		
		
		BinaryOperator<Integer> compare = BinaryOperator.maxBy((x, y) -> (x > y) ? 1 : ((x == y) ? 0 : -1));
		System.out.println("BinaryOperator -> " + compare.apply(8,6));
	}

}
