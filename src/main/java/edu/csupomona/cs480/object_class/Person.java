package edu.csupomona.cs480.object_class;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.csupomona.cs480.data.provider.FSMedManager;
import edu.csupomona.cs480.data.provider.MedManager;

public class Person {
	
	//Personal settings for potential logging system
	int userID;
	String password;
		
	//Medical Information
	private List<Medicine> medicines;
	LabReport labReport;
	Radiology radiologyReport;
	SpecialistReport specialistReport;
	DiagnosisList diagnosisList;
	ArrayList<Diagnosis> diagnoses;
	String medicineString = " ";
	
	@Autowired
	private MedManager medManager = new FSMedManager();;
	
		
	//getters and setters for all fields
	
	//set the Medicine list
//	public void setMedicine(String[] meds){
//		medicines = new Medicine[meds.length];
//		for(int i = 0; i<meds.length; i++){
//			medicines[i] = medManager.getMed(meds[i]);
//		}
//	}
	
	public Person(Person person){
		this.userID = person.userID;
		this.password = person.password;
		this.medicines = person.medicines;
		this.labReport = person.labReport;
		this.specialistReport = person.specialistReport;
		this.diagnosisList = person.diagnosisList;
		this.diagnoses = person.diagnoses;
		this.medicineString = person.medicineString;
	}
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
	
	public String getMedicineString() {
		return medicineString;
	}

	public void setMedicineString(String medicineString) {
		this.medicineString = medicineString;
	}


	public void processMedicine(){
		
		medicines = new ArrayList<Medicine>();
		String[] meds = medicineString.split(" ");
		for(int i = 0; i < meds.length; i++){
			medicines.add(medManager.getMed(meds[i]));
		}
	}
	
	//set the Lab Report
	public void setLabReport(LabReport lab){
		labReport = lab;
	}
	
	//set the Radiology
	public void setRadiologyReport(Radiology rad){
		radiologyReport = rad;
	}
	
	//set the Specialist Report
	public void setSpecialistReport(SpecialistReport spec){
		specialistReport = spec;
	}
	
	//creates a diagnosis list with the given fields, also gets the diagnoses from the list
	public void createDiagnosisList(){
		diagnosisList = new DiagnosisList(medicines, labReport, radiologyReport, specialistReport);
		diagnoses = diagnosisList.getDiagnoses();
	}
	
	//sets the user id for the person
	public void setUserID(int num){
		userID = num;
	}
	
	//sets the password for the person
	public void setPassword(String pass){
		password = pass;
	}
		
	//gets the Lab Report
	public LabReport getLabReport(){
		return labReport;
	}
	
	//gets the Radiology
	public Radiology getRadiologyReport(){
		return radiologyReport;
	}
	
	//gets the Specialist Report
	public SpecialistReport getSpecialistReport(){
		return specialistReport;
	}
	
	//gets the Diagnosis List
	public DiagnosisList getDiagnosisList(){
		return diagnosisList;
	}
	
	//gets the Diagnoses ArrayList
	public ArrayList<Diagnosis> getDiagnoses(){
		return diagnoses;
	}
	
	//gets the user id
	public int getUserID(){
		return userID;
	}
	
	//gets the password
	public String getPassword(){
		return password;
	}
}
