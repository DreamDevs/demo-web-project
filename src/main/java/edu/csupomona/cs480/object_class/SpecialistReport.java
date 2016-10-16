package edu.csupomona.cs480.object_class;

import java.util.Hashtable;

public class SpecialistReport {

	Hashtable<String, String> specialistReports;
	Hashtable<String, Boolean> diagnoses;
	Hashtable<String, String> dates;
	
	public SpecialistReport(){
		
		//Hashtable for holding dates
		dates = new Hashtable<String,String>();
		
		
		//Hashtable linking all diagnoses to their report
		specialistReports = new Hashtable<String, String>();

		//Cardiologist Report
		specialistReports.put("Hyperlipidemia", "Cardiologist");
		specialistReports.put("Cardiomyopathy", "Cardiologist");
		specialistReports.put("Congestive Heart Failure", "Cardiologist");
		specialistReports.put("Atrial Fibrillation", "Cardiologist");
		specialistReports.put("Atrial Flutter", "Cardiologist");
		specialistReports.put("Deep Vein Thrombosis", "Cardiologist");
		specialistReports.put("Old Myocardial Infarction", "Cardiologist");
		specialistReports.put("Angina Pectoris", "Cardiologist");
		specialistReports.put("Supraventricular Tachycardia", "Cardiologist");
		specialistReports.put("Hypertention", "Cardiologist");
		
		//Ophthalmologist Report
		specialistReports.put("Glaucoma", "Ophtalmologist");
		specialistReports.put("Proliferative Retinopathy", "Ophtalmologist");
		specialistReports.put("Non-Proliferative Retinopathy", "Ophtalmologist");
		specialistReports.put("Cataract", "Ophtalmologist");
		
		//Pulmonologist Report
		specialistReports.put("Compulsive Obstructive Pulmonary Disease", "Pulmonologist");
		specialistReports.put("Asthma, Asthma Bronchitis", "Pulmonologist");
		specialistReports.put("Pulmonary Embolism", "Pulmonologist");
		specialistReports.put("Pulmonary Cystic Fibrosis", "Pulmonologist");

		//Neurologist Report
		specialistReports.put("Parkinson's Disease", "Neurologist");
		specialistReports.put("Seizure Disorder", "Neurologist");
		specialistReports.put("Epilespy", "Neurologist");
		specialistReports.put("Migraine Headache", "Neurologist");
		specialistReports.put("Dementia", "Neurologist");
		specialistReports.put("Alzheimer's Disease", "Neurologist");
		specialistReports.put("Multiple Scerosis", "Neurologist, Rheumatologist");
		
		//Psychiatrist/Psychologist Report
		specialistReports.put("Major Depression", "Psychiatrist/Psychologist");
		specialistReports.put("Anxiety Disorder", "Psychiatrist/Psychologist");
		specialistReports.put("Schizophrenia", "Psychiatrist/Psychologist");
		specialistReports.put("Bipolar Disease", "Psychiatrist/Psychologist");
		specialistReports.put("Alcohol Dependence", "Psychiatrist/Psychologist");
		
		//Rheumatologist Report
		specialistReports.put("Rheumatoid Arthritis", "Rheumatologist");
		specialistReports.put("Systemic Lupus", "Rheumatologist");
		specialistReports.put("Multiple Sclerosis", "Neurologist, Rheumatologist");

		//Podiatrist Report
		specialistReports.put("Below Kneww Amputation", "Podiatrist");
		specialistReports.put("Above Knee Amputation", "Podiatrist");
		specialistReports.put("Am", "Podiatrist");
		specialistReports.put("Poly-Neuropathy", "Podiatrist");
		specialistReports.put("Mono-Neuropathy", "Podiatrist");
		specialistReports.put("Onychomycosis", "Podiatrist");
		specialistReports.put("Peripheral Vascular Disease", "Podiatrist");
		specialistReports.put("Ulcers of lower Extremity", "Podiatrist");
		
		
		
		//Hashtable of all possible diagnoses and their status for the patient
		diagnoses = new Hashtable<String, Boolean>();

		//Cardiologist Report
		diagnoses.put("Hyperlipidemia", false);
		diagnoses.put("Cardiomyopathy", false);
		diagnoses.put("Congestive Heart Failure", false);
		diagnoses.put("Atrial Fibrillation", false);
		diagnoses.put("Atrial Flutter", false);
		diagnoses.put("Deep Vein Thrombosis", false);
		diagnoses.put("Old Myocardial Infarction", false);
		diagnoses.put("Angina Pectoris", false);
		diagnoses.put("Supraventricular Tachycardia", false);
		diagnoses.put("Hypertention", false);
		
		//Ophthalmologist Report
		diagnoses.put("Glaucoma", false);
		diagnoses.put("Proliferative Retinopathy", false);
		diagnoses.put("Non-Proliferative Retinopathy", false);
		diagnoses.put("Cataract", false);
		
		//Pulmonologist Report
		diagnoses.put("Compulsive Obstructive Pulmonary Disease", false);
		diagnoses.put("Asthma, Asthma Bronchitis", false);
		diagnoses.put("Pulmonary Embolism", false);
		diagnoses.put("Pulmonary Cystic Fibrosis", false);

		//Neurologist Report
		diagnoses.put("Parkinson's Disease", false);
		diagnoses.put("Seizure Disorder", false);
		diagnoses.put("Epilespy", false);
		diagnoses.put("Migraine Headache", false);
		diagnoses.put("Dementia", false);
		diagnoses.put("Alzheimer's Disease", false);
		diagnoses.put("Multiple Scerosis", false);
		
		//Psychiatrist/Psychologist Report
		diagnoses.put("Major Depression", false);
		diagnoses.put("Anxiety Disorder", false);
		diagnoses.put("Schizophrenia", false);
		diagnoses.put("Bipolar Disease", false);
		diagnoses.put("Alcohol Dependence", false);
		
		//Rheumatologist Report
		diagnoses.put("Rheumatoid Arthritis", false);
		diagnoses.put("Systemic Lupus", false);
		diagnoses.put("Multiple Sclerosis", false);

		//Podiatrist Report
		diagnoses.put("Below Kneww Amputation", false);
		diagnoses.put("Above Knee Amputation", false);
		diagnoses.put("Am", false);
		diagnoses.put("Poly-Neuropathy", false);
		diagnoses.put("Mono-Neuropathy", false);
		diagnoses.put("Onychomycosis", false);
		diagnoses.put("Peripheral Vascular Disease", false);
		diagnoses.put("Ulcers of lower Extremity", false);
		

	}
	
	//Changes boolean value of a diagnosis 
	public void setStatus(String diagnosis, Boolean status){
		diagnoses.put(diagnosis, status);
	}
	
	//Retrieves boolean value of a diagnosis
	public Boolean getStatus(String diagnosis){
		return diagnoses.get(diagnosis);
	}
	
	//Retrieves which tests correlate with this diagnosis
	public String getTest(String diagnosis){
		return specialistReports.get(diagnosis);
	}
	
	public void addDate(String report, String date){
		dates.put(report, date);
	}
	
	public String getDate(String report, String date){
		return dates.get(report);
	}
}
