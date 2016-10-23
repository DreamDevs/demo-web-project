package edu.csupomona.cs480.object_class;

public class Diagnosis {

	String diagnosisName;
	Boolean diagnosisValue;
	String testName;
	String testDate;
	
	
	public Diagnosis(String diagnosis){
		
		diagnosisName = diagnosis;
		diagnosisValue = false;
		testName = null;
		testDate = null;
		
	}
	
	public Diagnosis(String diagnosis, String test){
		
		diagnosisName = diagnosis;
		diagnosisValue = false;
		testName = test;
		testDate = null;
		
	}
	
	public void setValue(Boolean val){
		diagnosisValue = val;
	}
	
	public void setTestName(String test){
		testName = test;
	}
	
	public void setTestDate(String date){
		testDate = date;
	}
	
	public String getDiagnosisName(){
		return diagnosisName;
	}
	
	public Boolean getValue(){
		return diagnosisValue;
	}
	
	public String getTestName(){
		return testName;
	}
	
	public String getTestDate(){
		return testDate;
	}
	
}
