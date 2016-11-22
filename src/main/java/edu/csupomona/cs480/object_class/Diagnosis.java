package edu.csupomona.cs480.object_class;

import java.util.ArrayList;
import java.util.Date;

public class Diagnosis {

	String diagnosisName;
	ArrayList <Date> testDates;
	ArrayList <String> testDateStrings;
	ArrayList <String> testNames;
	String Comments;
	String medicine;
	ArrayList<String> medicineDiagnoses;
	String Status;
	
	public Diagnosis(){
		
	}
	
	public Diagnosis(String diagnosis){
		
		diagnosisName = diagnosis;
		testDates = new ArrayList<Date>();
		testNames = new ArrayList<String>();
		testDateStrings = new ArrayList<String>();
		
	}
	
	public Diagnosis(String diagnosis, String test){
		
		diagnosisName = diagnosis;
		testDates = new ArrayList<Date>();
		testNames = new ArrayList<String>();
		testDateStrings = new ArrayList<String>();
		testNames.add(test);
		
	}

	
	public void setTestName(String test){
		testNames.add(test);
	}
	
	public void setTestDate(Date date){
		testDates.add(date);
	}
	
	public void setDiagnosisName(String name){
		diagnosisName = name;
	}
	
	public String getDiagnosisName(){
		return diagnosisName;
	}
	
	public String getTestName(int test){
		return testNames.get(test);
	}
	public void setMedicine(String med){
		medicine = med;
	}

	public Date getTestDate(int test){
		return testDates.get(test);
	}
	public String getComments(){
		return Comments;
	}
	public void setComments(String string){
		Comments = string;
	}
	public String getMedicine(){
		return medicine;
	}
	
	public void setStatus(String status){
		Status = status;
	}
	public String getStatus(){
		return Status;
	}
	
	public ArrayList<Date> getTestDates(){
		return testDates;
	}
	public void setTestDates(ArrayList<Date> dates){
		testDates = dates;
	}
	public ArrayList<String> getTestDateStrings(){
		return testDateStrings;
	}
	public void setTestDateStrigs(ArrayList<String> strings){
		testDateStrings = strings;
	}
}
