package edu.csupomona.cs480.object_class;

import java.util.ArrayList;
import java.util.Date;

public class Diagnosis {

	String diagnosisName;
	ArrayList <Date> testDates;
	ArrayList <String> testDateStrings;
	ArrayList <String> testNames;
	String Comments;
	ArrayList<String> medicineDiagnoses = new ArrayList<String>();
	String Status;
	
	public Diagnosis(){
		medicineDiagnoses = new ArrayList<String>();
		testDateStrings = new ArrayList<String>();
		testNames = new ArrayList<String>();
		testDates = new ArrayList<Date>();
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
	public Date getTestDate(int test){
		return testDates.get(test);
	}
	public String getComments(){
		return Comments;
	}
	public void setComments(String string){
		Comments = string;
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
	
	public void addMedicineDiagnoses(String med){
		medicineDiagnoses.add(med);
	}
	
	public ArrayList<String> getMedicineDiagnoses(){
		return medicineDiagnoses;
	}
	
	public ArrayList<String> combinedTests(){
		ArrayList<String> combined = new ArrayList<String>();
		for(int i =0; i<testNames.size(); i++){
			if(testDateStrings.size() > i){
				combined.add(testNames.get(i) + "  :  " + testDateStrings.get(i));
			}else{
				combined.add(testNames.get(i));
			}
		}
		return combined;
	}
}
