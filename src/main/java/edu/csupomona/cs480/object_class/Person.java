package edu.csupomona.cs480.object_class;

public class Person {
	
	//Personal settings for potential logging system
	int userID;
	String password;
	
	//Medical Information
	Medicine[] medicines;
	LabReport labReport;
	Radiology radiologyReport;
	SpecialistReport specialistReport;
	
	
	//getters and setters for all fields
	public void setMedicine(Medicine[] meds){
		medicines = new Medicine[meds.length];
		for(int i = 0; i<meds.length; i++){
			medicines[i] = meds[i];
		}
	}
	
	public void setLabReport(LabReport lab){
		labReport = lab;
	}
	
	public void setRadiologyReport(Radiology rad){
		radiologyReport = rad;
	}
	
	public void setSpecialistReport(SpecialistReport spec){
		specialistReport = spec;
	}
	
	public void setUserID(int num){
		userID = num;
	}
	
	public void setPassword(String pass){
		password = pass;
	}
	
	
	public Medicine[] getMedicine(){
		return medicines;
	}
	
	public LabReport getLabReport(){
		return labReport;
	}
	
	public Radiology getRadiologyReport(){
		return radiologyReport;
	}
	
	public SpecialistReport getSpecialistReport(){
		return specialistReport;
	}
	
	public int getUserID(){
		return userID;
	}
	
	public String getPassword(){
		return password;
	}
}
