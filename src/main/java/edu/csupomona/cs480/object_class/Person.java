package edu.csupomona.cs480.object_class;

import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private String medicineString = " ";
	private List<String> FinalizedDiagnoses = new ArrayList<String>();
	
	@Autowired
	private MedManager medManager = new FSMedManager();
	
		
	//getters and setters for all fields
	
	public Person(Person person){
		this.userID = person.getUserID();
		this.password = person.getPassword();
		this.medicines = person.getMedicines();
		this.labReport = person.getLabReport();
		this.specialistReport = person.getSpecialistReport();
		this.diagnosisList = person.getDiagnosisList();
		this.diagnoses = person.getDiagnoses();
	}
	
	public void setPerson(Person person){
		userID = person.getUserID();
		password = person.getPassword();
		medicines = person.getMedicines();
		labReport = person.getLabReport();
		specialistReport = person.getSpecialistReport();
		diagnosisList = person.getDiagnosisList();
		diagnoses = person.getDiagnoses();
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
	
	public void combineDiagnoses(List<Diagnosis> diag){
		
		//Processes the Dates into a better format
		for(int i = 0; i<diagnoses.size(); i++){
			String name = diagnoses.get(i).getDiagnosisName();
			for(int j = 0; j<diag.size(); j++){
				if(name.equals(diag.get(j).getDiagnosisName())){
					diagnoses.get(i).testDates = diag.get(j).testDates;
					diagnoses.get(i).testNames = diag.get(j).testNames;
					diagnoses.get(i).testDateStrings = diag.get(j).testDateStrings;
				}
			}
		}
		
		
	}
	
	
	public void updatePerson(){
		
		//Processes the Dates into a better format
		for(int i = 0; i<diagnoses.size(); i++){
			ArrayList<Date> dates = diagnoses.get(i).getTestDates();
			if(dates!=null){
				for(int j = 0; j<dates.size(); j++){
					DateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
				try {
						Date date = (Date)dateFormat.parse(dates.get(j).toString());
						SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMM dd yyyy");
						diagnoses.get(i).getTestDateStrings().add(dateFormat2.format(date));
						System.out.println(dateFormat2.format(date));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		//Adds all medicine diagnoses to the list
		for(int i =0; i<FinalizedDiagnoses.size(); i++){
			String[] parts = FinalizedDiagnoses.get(i).split(":");
			int check = 0;
			for(int j=0; j<diagnoses.size(); j++){
				if(parts[1].equals(diagnoses.get(j).getDiagnosisName())){
					diagnoses.get(j).setMedicine(parts[0]);
					check++;
				}
			}
			if(check==0){
				Diagnosis newDiagnosis = new Diagnosis();
				newDiagnosis.setDiagnosisName(parts[1]);
				newDiagnosis.setMedicine(parts[0]);				diagnoses.add(newDiagnosis);
			}
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
	
	public void setDiagnoses(ArrayList<Diagnosis> diag){
		diagnoses = diag;
	}
	
	//gets the user id
	public int getUserID(){
		return userID;
	}
	
	//gets the password
	public String getPassword(){
		return password;
	}

	public List<String> getFinalizedDiagnoses() {
		return FinalizedDiagnoses;
	}

	public void setFinalizedDiagnoses(List<String> finalizedDiagnoses) {
		FinalizedDiagnoses = finalizedDiagnoses;
	}

}
