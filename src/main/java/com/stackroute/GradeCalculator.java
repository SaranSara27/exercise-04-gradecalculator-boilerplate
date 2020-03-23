package com.stackroute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GradeCalculator {

	public static Map<Integer, String> calculateGrade(Map<Integer, Integer> scores) {
		
		if(scores==null || scores.isEmpty())
			return null;
		
		Map<Integer, String> grades=new HashMap<>();
		Map<Integer, String> sortedMap=new TreeMap<>();
		for(Map.Entry<Integer, Integer> entry:scores.entrySet()) {
			int mark=entry.getValue();
			if(mark>=80 && mark<=100) {
				grades.put(entry.getKey(), "A");
			}
			else if(mark<80 && mark>=60){
				grades.put(entry.getKey(), "B");
			}
			else if(mark<60 && mark>=45){
				grades.put(entry.getKey(), "C");
			}
			else if(mark<45) {
				grades.put(entry.getKey(), "D");
			}
			List<Integer> rollNo= new ArrayList<>(grades.keySet());
			Collections.sort(rollNo);
			for(Integer r:rollNo) {
				sortedMap.put(r, grades.get(r));
			}
		}
		return sortedMap;
	}

   	//Do not print anything other than what's expected/asked in problem
    public static void main(String[] args) {
    	//Use Scanner to get input from console
    	Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		Map<Integer, Integer> scores=new HashMap<>();
		Map<Integer, String> sortedMap=new TreeMap<>();
		for(int i=0;i<n;n--) {
			String  student=scanner.nextLine();
			String[] sDetails=student.split(" ");
			scores.put(Integer.parseInt(sDetails[0].trim()), Integer.parseInt(sDetails[1].trim()));
			
		}
		sortedMap=calculateGrade(scores);
		sortedMap.entrySet().forEach(entry->{
			System.out.println(entry.getKey()+" "+entry.getValue());
		});
		

	}
}