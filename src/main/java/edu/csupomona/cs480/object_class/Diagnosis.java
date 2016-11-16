package edu.csupomona.cs480.object_class;

import java.util.ArrayList;
import java.util.Date;

public class Diagnosis {

	String diagnosisName;
	Boolean diagnosisValue;
	ArrayList <Date> testDates;
	ArrayList <String> testNames;
	
	
	public Diagnosis(String diagnosis){
		
		diagnosisName = diagnosis;
		diagnosisValue = false;
		testDates = new ArrayList<Date>();
		testNames = new ArrayList<String>();
		
	}
	
	public Diagnosis(String diagnosis, String test){
		
		diagnosisName = diagnosis;
		diagnosisValue = false;
		testDates = new ArrayList<Date>();
		testNames = new ArrayList<String>();
		testNames.add(test);
		
	}
	
	public void setValue(Boolean val){
		diagnosisValue = val;
	}
	
	public void setTestName(String test){
		testNames.add(test);
	}
	
	public void setTestDate(Date date){
		testDates.add(date);
	}
	
	public String getDiagnosisName(){
		return diagnosisName;
	}
	
	public Boolean getValue(){
		return diagnosisValue;
	}
	
	public String getTestName(int test){
		return testNames.get(test);
	}

	public Date getTestDate(int test){
		return testDates.get(test);
	}

}
