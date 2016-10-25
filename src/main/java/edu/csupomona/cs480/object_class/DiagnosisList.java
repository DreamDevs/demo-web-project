package edu.csupomona.cs480.object_class;

import java.util.List;
import java.util.ArrayList;

public class DiagnosisList {

	Person person;
	ArrayList <Diagnosis> diagnoses;
	Medicine[] medicines;
	
	//initializes the person object
	public DiagnosisList(Person pers){
		person = pers;
	}
	
	//adds the list from the medicine class
	public void addMedicine(){
		medicines = person.getMedicine();
	}
	
	//adds diagnoses for the lab results
	public void addLabResults(){
		Diagnosis tempDiagnosis;
		double check;
		
		//Hemoglobin A1C Lab Result
		check = person.labReport.getHGBA1C();
		if(check >6.4){
			addDiagnosis("Diabetes Mellitus Type 1 or 2", "Hemoglobin A1C Lab");
		}
		
		//Low Density Lipoprotein Result
		check = person.labReport.getLDL();
		if(check >= 100 && check <= 120){
			addDiagnosis("Possible Hyperlipidemia", "Low Density Lipoprotein Lab");
		}else if (check > 120){
			addDiagnosis("Hyperlipidemia", "Low Density Lipoprotein Lab");
		}
		
		//Microalbuminuria Result
		boolean checker = person.labReport.isMicroalbumin();
		if(checker){
			addDiagnosis("Microalbuminuria", "Microalbuminuria Lab");
		}
		
		//Glomerular Filtration Rate Result
		check = person.labReport.getGFR();
		if(person.labReport.isMicroalbumin() && check > 89){
			addDiagnosis("Chronic Kidney Disease Stage 1", "Glomerular Filtration Rate Lab");
		}else if (check >= 60 && check <=89){
			addDiagnosis("Chronic Kidney Disease Stage 2", "Glomerular Filtration Rate Lab");
		}else if (check >= 30 && check <=59){
			addDiagnosis("Chronic Kidney Disease Stage 3", "Glomerular Filtration Rate Lab");
		}else if (check >= 15 && check <=29){
			addDiagnosis("Chronic Kidney Disease Stage 4", "Glomerular Filtration Rate Lab");
		}else if (check < 15){
			addDiagnosis("Chronic Kidney Disease Stage 5", "Glomerular Filtration Rate Lab");
		}
		
		
		//Parathyroid Hormone and Calcium Level Result
		String pth = person.labReport.getPTH();
		String calcium = person.labReport.getCalcium();
		if(pth == "high" && calcium == "high"){
			addDiagnosis("Hyperthyroidism", "Parathyroid Hormone and Calcium Level Lab");
		}else if(pth == "low" && calcium == "low"){
			addDiagnosis("Hypothyroidism", "Parathyroid Hormone and Calcium Level Lab");
		}else if(pth != "normal" || calcium != "normal"){
			addDiagnosis("Possible Issue - PTH and Calcium levels", "Parathyroid Hormone and Calcium Level Lab");
		}
		
	}
	
	public void addRadiologyResults(){
		
		boolean value;
		String check;
		
		//
		//CARDIAC WORK-UPS
		//
		
		//Electrocardiogram Result
		if(person.radiologyReport.isElectrocardiogram()){
			
			//checks for Arrhythmia and Type
			check = person.radiologyReport.getArrhythmia();
			if(check == "Tachycardia"){
				addDiagnosis("Arrhythmia, Tachycardia", "Electrocardiogram Report", person.radiologyReport.getElecDate());
			}else if (check == "Bradycardia"){
				addDiagnosis("Arrhythmia, Bradycardia", "Electrocardiogram Report", person.radiologyReport.getElecDate());
			}
			
			//checks for Atrial Fibrillation
			value = person.radiologyReport.isAFP();
			if(value){
				addDiagnosis("Atrial Fibrillation Present", "Electrocardiogram Report", person.radiologyReport.getElecDate());
			}
			
			//checks for Myocardial Infaction
			value = person.radiologyReport.isMI();
			if(value){
				addDiagnosis("Myocardial Infaction", "Electrocardiogram Report", person.radiologyReport.getElecDate());
			}
			
			//Other under Electrocardiogram
			check = person.radiologyReport.getElecOther();
			if(check!=null){
				addDiagnosis(check, "Electrocardiogram Report", person.radiologyReport.getElecDate());
			}
		}
		
		//Echocardiogram Result
		if(person.radiologyReport.isEchocardiogram()){
			
			//Checks for Cardiomegaly
			value = person.radiologyReport.isCardiomegaly();
			if(value){
				addDiagnosis("Cardiomegaly", "Echocardiogram Report", person.radiologyReport.getEchoDate());
			}
			
			//Checks for Cardiomyopathy
			value = person.radiologyReport.isCardiomyopathy();
			if(value){
				addDiagnosis("Cardiomyopathy", "Echocardiogram Report", person.radiologyReport.getEchoDate());
			}
			
			//Checks for Aortic ASP
			value = person.radiologyReport.isAASP();
			if(value){
				addDiagnosis("Aortic Atherosclerosis, Stenosis, Plaque", "Echocardiogram Report", person.radiologyReport.getEchoDate());
			}
			
			//Checks for Congestive Heart Failure
			float num = person.radiologyReport.getEF();
			if(num < 40){
				addDiagnosis("Congestive Heart Failure", "Echocardiogram Report", person.radiologyReport.getEchoDate());
			}
			
			//Other under Echocardiogram
			check = person.radiologyReport.getEchoOther();
			if(check!=null){
				addDiagnosis(check, "Echocardiogram Report", person.radiologyReport.getEchoDate());
			}
		}
		
		//
		//X-RAYS
		//
		
		
		//Chest X-Ray
		if(person.radiologyReport.isChestXRay()){
			
			//Checks for all of the possible Diagnoses
			List<Boolean> values = person.radiologyReport.getChestDiagnosis();
			if(values.get(0)){
				addDiagnosis("Aortic Atherosclerosis, Stenosis, Plaque", "Chest X-Ray Report", person.radiologyReport.getChestDate());
			}else if(values.get(1)){
				addDiagnosis("Aortic Aneurysm", "Chest X-Ray Report", person.radiologyReport.getChestDate());
			}else if(values.get(2)){
				addDiagnosis("Aortic Ectasia", "Chest X-Ray Report", person.radiologyReport.getChestDate());
			}else if(values.get(3)){
				addDiagnosis("Aortic Tortuosity", "Chest X-Ray Report", person.radiologyReport.getChestDate());
			}else if(values.get(4)){
				addDiagnosis("Chronic Obstructive Pulmonary Disease", "Chest X-Ray Report", person.radiologyReport.getChestDate());
			}else if(values.get(5)){
				addDiagnosis("Pneumonia", "Chest X-Ray Report", person.radiologyReport.getChestDate());
			}else if(values.get(6)){
				addDiagnosis("Chronic Bronchitis", "Chest X-Ray Report", person.radiologyReport.getChestDate());
			}else if(values.get(7)){
				addDiagnosis("Pulmonary Cystic Fibrosis", "Chest X-Ray Report", person.radiologyReport.getChestDate());
			}else if(values.get(8)){
				addDiagnosis("Cardiomegaly", "Chest X-Ray Report", person.radiologyReport.getChestDate());
			}
	
			//Other under Chest X-Rays
			check = person.radiologyReport.getChestOther();
			if(check!=null){
				addDiagnosis(check, "Chest X-Ray Report", person.radiologyReport.getChestDate());
			}
		}
		//Extremity X-Ray
		if(person.radiologyReport.isExtremityXray()){
			
			//Upper Extremity Report
			
			if(person.radiologyReport.isUpperEx()){
				//Checks for which version of ASP of the Upper Extremity
				check = person.radiologyReport.getASPofUpper();
				if(check == "Left")
					check = "Left Atherosclerosis, Stenosis, Plaque of the Upper Extremity";
				else if(check == "Right")
					check = "Right Atherosclerosis, Stenosis, Plaque of the Upper Extremity";
				else
					check = "Left and Right Atherosclerosis, Stenosis, Plaque of the Upper Extremity";
				
				addDiagnosis(check, "Extremity X-Ray Report: Upper Extremity", person.radiologyReport.getUpperDate());
			
			}
			
			//Lower Extremity
			if(person.radiologyReport.isLowerEx()){
				//Checks for which version of ASP of the Lower Extremity
				check = person.radiologyReport.getASPofLower();
				if(check == "Left")
					check = "Left Atherosclerosis, Stenosis, Plaque of the Lower Extremity";
				else if(check == "Right")
					check = "Right Atherosclerosis, Stenosis, Plaque of the Lower Extremity";
				else
					check = "Left and Right Atherosclerosis, Stenosis, Plaque of the Lower Extremity";
				
				addDiagnosis(check, "Extremity X-Ray Report: Lower Extremity", person.radiologyReport.getLowerDate());
			}
			
			//Other Extremity
			check = person.radiologyReport.getOtherExResult();
			if(check!=null){
				addDiagnosis(check, "Extremity X-Ray: Other", person.radiologyReport.getOtherExDate());

			}
		}
		
		//
		//ULTRASOUND AND DOPPLER STUDIES
		//
		
		//Abdominal Ultrasound
		if(person.radiologyReport.isAbdUS()){

			//checks for all diagnoses under Abdominal Ultrasound
			List<Boolean> values = person.radiologyReport.getAbdUSDiagnosis();
			if(values.get(0)){
				addDiagnosis("Aortic Atherosclerosis, Stenosis, Plaque", "Abdominal Ultrasound", person.radiologyReport.getAbdUSDate());
			}else if(values.get(1)){
				addDiagnosis("Aortic Aneurysm", "Abdominal Ultrasound", person.radiologyReport.getAbdUSDate());
			}else if(values.get(2)){
				addDiagnosis("Nephritis", "Abdonminal Ultrasound", person.radiologyReport.getAbdUSDate());
			}else if(values.get(2)){
				addDiagnosis("Renal Artery Atherosclerosis, Stenosis, Plaque", "Chest X-Ray Report", person.radiologyReport.getAbdUSDate());
			}
			
			//Other Diagnoses under Abdominal Ultrasound
			check = person.radiologyReport.getAbdADOther();
			if(check!=null){
				addDiagnosis(check, "Abdominal Ultrasound", person.radiologyReport.getAbdUSDate());
			}
		}
		
		//Abdominal Aortic Doppler
		if(person.radiologyReport.isAbdAD()){
			//checks for all under Abdominal Aortic Doppler
			List<Boolean> values = person.radiologyReport.getAbdADDiagnosis();
			if(values.get(0)){
				addDiagnosis("Aortic Atherosclerosis, Stenosis, Plaque", "Abdominal Aortic Doppler", person.radiologyReport.getAbdADDate());
			}else if (values.get(1)){
				addDiagnosis("Aortic Aneurysm", "Abdominal Aortic Doppler", person.radiologyReport.getAbdADDate());
			}
			
			//Other under Abdominal Aortic Doppler
			check = person.radiologyReport.getAbdADOther();
			if(check!=null){
				addDiagnosis(check, "Abdominal Aortic Doppler", person.radiologyReport.getAbdADDate());
			}
		}
		
		//Lower Extremity Doppler
		if(person.radiologyReport.isLowerED()){
			
			//check for Monophasic Waves
			value = person.radiologyReport.isMonophasicWaves();
			if(value){
				addDiagnosis("Monophasic Waves", "Lower Extremity Doppler", person.radiologyReport.getLowerEDDate());
			}
			
			//check for type ASP of Lower Extremity
			check = person.radiologyReport.getASPofLower();
			if(check == "Left")
				check = "Left Atherosclerosis, Stenosis, Plaque of the Lower Extremity";
			else if(check == "Right")
				check = "Right Atherosclerosis, Stenosis, Plaque of the Lower Extremity";
			else
				check = "Left and Right Atherosclerosis, Stenosis, Plaque of the Lower Extremity";
			
			addDiagnosis(check, "Lower Extremity Doppler", person.radiologyReport.getLowerEDDate());

			//checks for Peripheral Vascular Disease
			value = person.radiologyReport.isPVD();
			if(value){
				addDiagnosis("Peripheral Vascular Disease", "Lower Extremity Doppler", person.radiologyReport.getLowerEDDate());
			}
			
		}
		
	}
	
	//adds specialist report diagnoses
	public void addSpecialistResults(){
		
		//for all diagnoses in the specialist report, check if they are true
		//if true then add them to the list
		for(int i = 0; i<person.specialistReport.diagnoses.length; i++){
			if(person.specialistReport.getStatus(i)){
				addDiagnosis(person.specialistReport.getDiagnosis(i).getDiagnosisName(),
						person.specialistReport.getDiagnosis(i).getTestName(0),
						person.specialistReport.getDiagnosis(i).getTestDate(0));
			}
		}
		
	}
	
	//adds a diagnosis with a date
	public void addDiagnosis(String diagnosisName, String reportName, String date){
		//checks if the diagnosis is already in the list
		//if it is, it will add more information to the diagnosis
		for(int i = 0; i<diagnoses.size(); i++){
			if(diagnoses.get(0).getDiagnosisName() == diagnosisName){
				editDiagnosis(i, reportName, date);
				return;
			}
		}
		//creates a new diagnosis if none already exists
		Diagnosis tempDiagnosis = new Diagnosis(diagnosisName, reportName);
		tempDiagnosis.setValue(true);
		tempDiagnosis.testDates.add(date);
		diagnoses.add(tempDiagnosis);
	}
	
	//adds a diagnosis without a date
	public void addDiagnosis(String diagnosisName, String reportName){
		Diagnosis tempDiagnosis = new Diagnosis(diagnosisName, reportName);
		tempDiagnosis.setValue(true);
		diagnoses.add(tempDiagnosis);
	}
	
	//adds an extra test to an existing diagnosis
	public void editDiagnosis(int num, String reportName, String reportDate){
		diagnoses.get(num).setTestName(reportName);
		diagnoses.get(num).setTestDate(reportDate);
	}
	
	
}
