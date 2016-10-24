package edu.csupomona.cs480.object_class;

import java.util.ArrayList;

public class Diagnosis {

	String diagnosisName;
	Boolean diagnosisValue;
	ArrayList <String> testDates;
	ArrayList <String> testNames;
	
	
	public Diagnosis(String diagnosis){
		
		diagnosisName = diagnosis;
		diagnosisValue = false;
		
	}
	
	public Diagnosis(String diagnosis, String test){
		
		diagnosisName = diagnosis;
		diagnosisValue = false;
		testNames.add(test);
		
	}
	
	public void setValue(Boolean val){
		diagnosisValue = val;
	}
	
	public void setTestName(String test){
		testNames.add(test);
	}
	
	public void setTestDate(String date){
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

	public String getTestDate(int test){
		return testDates.get(test);
	}

}
