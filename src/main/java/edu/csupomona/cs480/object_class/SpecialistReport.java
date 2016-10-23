package edu.csupomona.cs480.object_class;

import java.util.Hashtable;

public class SpecialistReport {

	Diagnosis[] diagnoses;
	String[] specialistNames;
	
	public SpecialistReport(){
		
		//String to store the names for the Specialist Reports
		specialistNames = new String[7];
		specialistNames[0] = "Cardiologist";
		specialistNames[1] = "Ophtalmologist";
		specialistNames[2] = "Pulmonologist";
		specialistNames[3] = "Neurologist";
		specialistNames[4] = "Psychiatrist/Psychologist";
		specialistNames[5] = "Rheumatologist";
		specialistNames[6] = "Podiatrist";

		
		//Hashtable linking all diagnoses to their report
		diagnoses = new Diagnosis[41];

		//Cardiologist Report
		diagnoses[0] = new Diagnosis("Hyperlipidemia", "Cardiologist");
		diagnoses[1] = new Diagnosis("Cardiomyopathy", "Cardiologist");
		diagnoses[2] = new Diagnosis("Congestive Heart Failure", "Cardiologist");
		diagnoses[3] = new Diagnosis("Atrial Fibrillation", "Cardiologist");
		diagnoses[4] = new Diagnosis("Atrial Flutter", "Cardiologist");
		diagnoses[5] = new Diagnosis("Deep Vein Thrombosis", "Cardiologist");
		diagnoses[6] = new Diagnosis("Old Myocardial Infarction", "Cardiologist");
		diagnoses[7] = new Diagnosis("Angina Pectoris", "Cardiologist");
		diagnoses[8] = new Diagnosis("Supraventricular Tachycardia", "Cardiologist");
		diagnoses[9] = new Diagnosis("Hypertention", "Cardiologist");
		
		//Ophthalmologist Report
		diagnoses[10] = new Diagnosis("Glaucoma", "Ophtalmologist");
		diagnoses[11] = new Diagnosis("Proliferative Retinopathy", "Ophtalmologist");
		diagnoses[12] = new Diagnosis("Non-Proliferative Retinopathy", "Ophtalmologist");
		diagnoses[13] = new Diagnosis("Cataract", "Ophtalmologist");
		
		//Pulmonologist Report
		diagnoses[14] = new Diagnosis("Compulsive Obstructive Pulmonary Disease", "Pulmonologist");
		diagnoses[15] = new Diagnosis("Asthma, Asthma Bronchitis", "Pulmonologist");
		diagnoses[16] = new Diagnosis("Pulmonary Embolism", "Pulmonologist");
		diagnoses[17] = new Diagnosis("Pulmonary Cystic Fibrosis", "Pulmonologist");

		//Neurologist Report
		diagnoses[18] = new Diagnosis("Parkinson's Disease", "Neurologist");
		diagnoses[19] = new Diagnosis("Seizure Disorder", "Neurologist");
		diagnoses[20] = new Diagnosis("Epilespy", "Neurologist");
		diagnoses[21] = new Diagnosis("Migraine Headache", "Neurologist");
		diagnoses[22] = new Diagnosis("Dementia", "Neurologist");
		diagnoses[23] = new Diagnosis("Alzheimer's Disease", "Neurologist");
		diagnoses[24] = new Diagnosis("Multiple Scerosis", "Neurologist, Rheumatologist");
		
		//Psychiatrist/Psychologist Report
		diagnoses[25] = new Diagnosis("Major Depression", "Psychiatrist/Psychologist");
		diagnoses[26] = new Diagnosis("Anxiety Disorder", "Psychiatrist/Psychologist");
		diagnoses[27] = new Diagnosis("Schizophrenia", "Psychiatrist/Psychologist");
		diagnoses[28] = new Diagnosis("Bipolar Disease", "Psychiatrist/Psychologist");
		diagnoses[29] = new Diagnosis("Alcohol Dependence", "Psychiatrist/Psychologist");
		
		//Rheumatologist Report
		diagnoses[30] = new Diagnosis("Rheumatoid Arthritis", "Rheumatologist");
		diagnoses[31] = new Diagnosis("Systemic Lupus", "Rheumatologist");
		diagnoses[32] = new Diagnosis("Multiple Sclerosis", "Neurologist, Rheumatologist");

		//Podiatrist Report
		diagnoses[33] = new Diagnosis("Below Knee Amputation", "Podiatrist");
		diagnoses[34] = new Diagnosis("Above Knee Amputation", "Podiatrist");
		diagnoses[35] = new Diagnosis("Am", "Podiatrist");
		diagnoses[36] = new Diagnosis("Poly-Neuropathy", "Podiatrist");
		diagnoses[37] = new Diagnosis("Mono-Neuropathy", "Podiatrist");
		diagnoses[38] = new Diagnosis("Onychomycosis", "Podiatrist");
		diagnoses[39] = new Diagnosis("Peripheral Vascular Disease", "Podiatrist");
		diagnoses[40] = new Diagnosis("Ulcers of lower Extremity", "Podiatrist");
		

	}
	
	//Changes boolean value of a diagnosis 
	public void setStatus(int diagnosis, Boolean status){
		diagnoses[diagnosis].setValue(status);
	}
	
	//Retrieves boolean value of a diagnosis
	public Boolean getStatus(int diagnosis){
		return diagnoses[diagnosis].getValue();
	}
	
	//Retrieves which tests correlate with this diagnosis
	public String getTest(int diagnosis){
		return diagnoses[diagnosis].getTestName();
	}
	
	public void addDate(String report, String date){
		for(int i = 0; i<diagnoses.length; i++){
			if(diagnoses[i].getTestName() == report){
				diagnoses[i].setTestDate(date);
			}
		}
	}
	
	public String getDate(String report){
		for(int i = 0; i<diagnoses.length; i++){
			if(diagnoses[i].getTestName() == report){
				return diagnoses[i].getTestDate();
			}
		}
		return null;
	}
}
