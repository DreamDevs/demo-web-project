package edu.csupomona.cs480.object_class;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class DiagnosisList {

	ArrayList <Diagnosis> diagnoses;
	List <Medicine> medicines;
	LabReport labReport;
	Radiology radiologyReport;
	SpecialistReport specialistReport;
	
	//initializes the person object
	public DiagnosisList(List<Medicine> meds, LabReport lab, Radiology rad, SpecialistReport spec){
		medicines = meds;
		labReport = lab;
		radiologyReport = rad;
		specialistReport = spec;
		diagnoses = new ArrayList<Diagnosis>();
		addLabResults();
		addRadiologyResults();
		addSpecialistResults();
	}
	
	
	//adds diagnoses for the lab results
	public void addLabResults(){
		Diagnosis tempDiagnosis;
		double check;
		
		//Hemoglobin A1C Lab Result
		check = labReport.getHGBA1C();
		if(check >6.4){
			addDiagnosis("Diabetes Mellitus Type 1 or 2", "Hemoglobin A1C Lab");
		}
		
		//Low Density Lipoprotein Result
		check =  labReport.getLDL();
		if(check >= 100 && check <= 120){
			addDiagnosis("Possible Hyperlipidemia", "Low Density Lipoprotein Lab");
		}else if (check > 120){
			addDiagnosis("Hyperlipidemia", "Low Density Lipoprotein Lab");
		}
		
		//Microalbuminuria Result
		boolean checker =  labReport.isMicroalbumin();
		if(checker){
			addDiagnosis("Microalbuminuria", "Microalbuminuria Lab");
		}
		
		//Glomerular Filtration Rate Result
		check =  labReport.getGFR();
		if( labReport.isMicroalbumin() && check > 89){
			addDiagnosis("Chronic Kidney Disease Stage 1", "Glomerular Filtration Rate Lab");
		}else if (check >= 60 && check <=89){
			addDiagnosis("Chronic Kidney Disease Stage 2", "Glomerular Filtration Rate Lab");
		}else if (check >= 30 && check <=59){
			addDiagnosis("Chronic Kidney Disease Stage 3", "Glomerular Filtration Rate Lab");
		}else if (check >= 15 && check <=29){
			addDiagnosis("Chronic Kidney Disease Stage 4", "Glomerular Filtration Rate Lab");
		}else if (0 < check && check < 15){
			addDiagnosis("Chronic Kidney Disease Stage 5", "Glomerular Filtration Rate Lab");
		}
		
		
		//Parathyroid Hormone and Calcium Level Result
		String pth =  labReport.getPTH();
		String calcium =  labReport.getCalcium();
		if(	pth!=null && !pth.isEmpty() && calcium !=null && !calcium.isEmpty()){
			if(pth.equals("High") && calcium.equals("High")){
				addDiagnosis("Hyperthyroidism", "Parathyroid Hormone and Calcium Level Lab");
			}else if(pth.equals("Low") && calcium.equals("Low")){
				addDiagnosis("Hypothyroidism", "Parathyroid Hormone and Calcium Level Lab");
			}else if(pth != "normal" || calcium != "normal"){
				addDiagnosis("Possible Issue - PTH and Calcium levels", "Parathyroid Hormone and Calcium Level Lab");
			}
		}
	}
	
	public void addRadiologyResults(){
		
		boolean value;
		String check;
		
		//
		//CARDIAC WORK-UPS
		//
		
		//Electrocardiogram Result
		if( !radiologyReport.isElectrocardiogram()){
			
			//checks for Arrhythmia and Type
			check =  radiologyReport.getArrhythmia();
			if(check!=null && !check.isEmpty()){
				if(check.equals("Tachycardia")){
					addDiagnosis("Arrhythmia, Tachycardia", "Electrocardiogram Report",  radiologyReport.getElecDate());
				}else if (check.equals("Bradycardia")){
					addDiagnosis("Arrhythmia, Bradycardia", "Electrocardiogram Report",  radiologyReport.getElecDate());
				}else if (check.equals("Normal")){
					addDiagnosis("Arrhythmia", "Electrocardiogram Report",  radiologyReport.getElecDate());
				}
			}
			
			//checks for Atrial Fibrillation
			value =  radiologyReport.isAFP();
			if(value){
				addDiagnosis("Atrial Fibrillation Present", "Electrocardiogram Report",  radiologyReport.getElecDate());
			}
			
			//checks for Myocardial Infaction
			value =  radiologyReport.isMI();
			if(value){
				addDiagnosis("Myocardial Infaction", "Electrocardiogram Report",  radiologyReport.getElecDate());
			}
			
			//Other under Electrocardiogram
			check =  radiologyReport.getElecOther();
			if(check!=null && !check.isEmpty()){
				addDiagnosis(check, "Electrocardiogram Report",  radiologyReport.getElecDate());
			}
		}
		
		//Echocardiogram Result
		if( !radiologyReport.isEchocardiogram()){
			
			//Checks for Cardiomegaly
			value =  radiologyReport.isCardiomegaly();
			if(value){
				addDiagnosis("Cardiomegaly", "Echocardiogram Report",  radiologyReport.getEchoDate());
			}
			
			//Checks for Cardiomyopathy
			value =  radiologyReport.isCardiomyopathy();
			if(value){
				addDiagnosis("Cardiomyopathy", "Echocardiogram Report",  radiologyReport.getEchoDate());
			}
			
			//Checks for Aortic ASP
			value =  radiologyReport.isAASP();
			if(value){
				addDiagnosis("Aortic Atherosclerosis, Stenosis, Plaque", "Echocardiogram Report",  radiologyReport.getEchoDate());
			}
			
			//Checks for Congestive Heart Failure
			float num =  radiologyReport.getEF();
			if( 0 < num && num < 40){
				addDiagnosis("Congestive Heart Failure", "Echocardiogram Report",  radiologyReport.getEchoDate());
			}
			
			//Other under Echocardiogram
			check =  radiologyReport.getEchoOther();
			if(check!=null && !check.isEmpty()){
				addDiagnosis(check, "Echocardiogram Report",  radiologyReport.getEchoDate());
			}
		}
		
		//
		//X-RAYS
		//
		
		
		//Chest X-Ray
		if( !radiologyReport.isChestXRay()){
			
			//Checks for all of the possible Diagnoses
			
			//Checks for Aortic ASP
			value =  radiologyReport.isAorticASP();
			if(value){
				addDiagnosis("Aortic Atherosclerosis, Stenosis, Plaque", "Echocardiogram Report",  radiologyReport.getChestDate());
			}
			
			//Checks for Aortic Aneurysm
			value =  radiologyReport.isAorticAneurysm();
			if(value){
				addDiagnosis("Aortic Aneurysm", "Chest X-Ray Report",  radiologyReport.getChestDate());
			}
			
			//Checks for Aortic Ectasia
			value =  radiologyReport.isAorticAneurysm();
			if(value){
				addDiagnosis("Aortic Ectasia", "Chest X-Ray Report",  radiologyReport.getChestDate());
			}
			
			//Checks for Aortic Ectasia
			value =  radiologyReport.isAorticTortuosity();
			if(value){
				addDiagnosis("Aortic Tortuosity", "Chest X-Ray Report",  radiologyReport.getChestDate());
			}
			
			//Checks for COPD
			value =  radiologyReport.isCOPD();
			if(value){
				addDiagnosis("Chronic Obstructive Pulmonary Disease", "Chest X-Ray Report",  radiologyReport.getChestDate());
			}
			
			//Checks for Pneumonia
			value =  radiologyReport.isPneumonia();
			if(value){
				addDiagnosis("Pneumonia", "Chest X-Ray Report",  radiologyReport.getChestDate());
			}
			
			//Checks for Chronic Bronchitis
			value =  radiologyReport.isChronicBronchitis();
			if(value){
				addDiagnosis("Chronic Bronchitis", "Chest X-Ray Report",  radiologyReport.getChestDate());
			}
			
			//Checks for Pulmonary Cystic Fibrosis
			value =  radiologyReport.isPCF();
			if(value){
				addDiagnosis("Pulmonary Cystic Fibrosis", "Chest X-Ray Report",  radiologyReport.getChestDate());
			}
			
			//Checks for Cardiomegaly
			value =  radiologyReport.isCardiomegaly2();
			if(value){
				addDiagnosis("Cardiomegaly", "Chest X-Ray Report",  radiologyReport.getChestDate());
			}
		
			//Other under Chest X-Rays
			check =  radiologyReport.getChestOther();
			if(check!=null && !check.isEmpty()){
				addDiagnosis(check, "Chest X-Ray Report",  radiologyReport.getChestDate());
			}
		}
		//Extremity X-Ray
		if( !radiologyReport.isExtremityXray()){
			
			//Upper Extremity Report
			
			if( !radiologyReport.isUpperEx()){
				//Checks for which version of ASP of the Upper Extremity
				check =  radiologyReport.getASPofUpper();
				if(check!=null && !check.isEmpty()){
					if(check.equals("Left")){
						check = "Left Atherosclerosis, Stenosis, Plaque of the Upper Extremity";
					}else if(check.equals("Right")){
						check = "Right Atherosclerosis, Stenosis, Plaque of the Upper Extremity";
					}else if(check.equals("Both")){
						check = "Left and Right Atherosclerosis, Stenosis, Plaque of the Upper Extremity";
					}
					addDiagnosis(check, "Extremity X-Ray Report: Upper Extremity",  radiologyReport.getUpperDate());
				}
			}
			
			//Lower Extremity
			if( !radiologyReport.isLowerEx()){
				//Checks for which version of ASP of the Lower Extremity
				check =  radiologyReport.getASPofLower();
				if(check!=null && !check.isEmpty()){
					if(check.equals("Left")){
						check = "Left Atherosclerosis, Stenosis, Plaque of the Lower Extremity";
					}else if(check.equals("Right")){
						check = "Right Atherosclerosis, Stenosis, Plaque of the Lower Extremity";
					}else if(check.equals("Both")){
						check = "Left and Right Atherosclerosis, Stenosis, Plaque of the Lower Extremity";
					}
					addDiagnosis(check, "Extremity X-Ray Report: Lower Extremity",  radiologyReport.getLowerDate());
				}
			}
			
			//Other Extremity
			if( !radiologyReport.isOtherEx()){
				check =  radiologyReport.getOtherExResult();
				if(check!=null && !check.isEmpty()){
					addDiagnosis(check, "Extremity X-Ray: Other",  radiologyReport.getOtherExDate());

				}
			}
		}
		
		//
		//ULTRASOUND AND DOPPLER STUDIES
		//
		
		//Abdominal Ultrasound
		if( !radiologyReport.isAbdUS()){

			//checks for all diagnoses under Abdominal Ultrasound
			
			//Checks for Aortic ASP
			value =  radiologyReport.isAorticASP2();
			if(value){
				addDiagnosis("Aortic Atherosclerosis, Stenosis, Plaque", "Abdominal Ultrasound",  radiologyReport.getAbdUSDate());
			}
			
			//Checks for Aortic Aneurysm
			value =  radiologyReport.isAorticAneurysm2();
			if(value){
				addDiagnosis("Aortic Aneurysm", "Abdominal Ultrasound",  radiologyReport.getAbdUSDate());
			}
			
			//Checks for Nephritis
			value =  radiologyReport.isNephritis();
			if(value){
				addDiagnosis("Nephritis", "Abdonminal Ultrasound",  radiologyReport.getAbdUSDate());
			}
			
			//Checks for Renal Artery ASP
			value =  radiologyReport.isRenalArteryASP();
			if(value){
				addDiagnosis("Renal Artery Atherosclerosis, Stenosis, Plaque", "Chest X-Ray Report",  radiologyReport.getAbdUSDate());
			}

			//Other Diagnoses under Abdominal Ultrasound
			check =  radiologyReport.getAbdADOther();
			if(check!=null && !check.isEmpty()){
				addDiagnosis(check, "Abdominal Ultrasound",  radiologyReport.getAbdUSDate());
			}
		}
		
		//Abdominal Aortic Doppler
		if( !radiologyReport.isAbdAD()){
			//checks for all under Abdominal Aortic Doppler
			
			//Checks for Aortic ASP
			value =  radiologyReport.isAorticASP3();
			if(value){
				addDiagnosis("Aortic Atherosclerosis, Stenosis, Plaque", "Abdominal Aortic Doppler",  radiologyReport.getAbdADDate());
			}
			
			//Checks for Aortic Aneurysm
			value =  radiologyReport.isAorticAneurysm3();
			if(value){
				addDiagnosis("Aortic Aneurysm", "Abdominal Aortic Doppler",  radiologyReport.getAbdADDate());
			}
			
			//Other under Abdominal Aortic Doppler
			check =  radiologyReport.getAbdADOther();
			if(check!=null && !check.isEmpty()){
				addDiagnosis(check, "Abdominal Aortic Doppler",  radiologyReport.getAbdADDate());
			}
		}
		
		//Lower Extremity Doppler
		if( !radiologyReport.isLowerED()){
			
			//check for Monophasic Waves
			value =  radiologyReport.isMonophasicWaves();
			if(value){
				addDiagnosis("Peripheral Vascular Disease", "Lower Extremity Doppler",  radiologyReport.getLowerEDDate());
			}
			
			//check for type ASP of Lower Extremity
			check =  radiologyReport.getASPofLower();
			if(check!=null && !check.isEmpty()){
				if(check.equals("Left")){
					check = "Left Atherosclerosis, Stenosis, Plaque of the Lower Extremity";
				}else if(check.equals("Right")){
					check = "Right Atherosclerosis, Stenosis, Plaque of the Lower Extremity";
				}else if(check.equals("Both")){
					check = "Left and Right Atherosclerosis, Stenosis, Plaque of the Lower Extremity";
				}
				addDiagnosis(check, "Lower Extremity Doppler",  radiologyReport.getLowerEDDate());
			}
			
			//checks for Peripheral Vascular Disease
			value =  radiologyReport.isPVD();
			if(value){
				addDiagnosis("Peripheral Vascular Disease", "Lower Extremity Doppler",  radiologyReport.getLowerEDDate());
			}
			
		}
		
	}
	
	//adds specialist report diagnoses
	public void addSpecialistResults(){
		
		//for all diagnoses in the specialist report, check if they are true
		//if true then add them to the list
		
		boolean value;
		String check;
		
		/*
		/Cardiologist Report
		*/
	
		//check for Hyperlipidemia
		value =  specialistReport.isHyperlipidemia();
		if(value){
			addDiagnosis("Hyperlipidemia", "Cardiologist Report",  specialistReport.getCardiologistDate());
		}
		
		//check for Cardiomyopathy
		value =  specialistReport.isCardiomyopathy();
		if(value){
			addDiagnosis("Cardiomyopathy", "Cardiologist Report",  specialistReport.getCardiologistDate());
		}
	
		//check for Congestive Heart Failure
		value =  specialistReport.isCongestiveHeartFailure();
		if(value){
			addDiagnosis("Congestive Heart Failure", "Cardiologist Report",  specialistReport.getCardiologistDate());
		}
		
		//check for Atrial Fibrillation
		value =  specialistReport.isAtrialFibrillation();
		if(value){
			addDiagnosis("Atrial Fibrillation", "Cardiologist Report",  specialistReport.getCardiologistDate());
		}
		
		//check for Atrial Flutter
		value =  specialistReport.isAtrialFlutter();
		if(value){
			addDiagnosis("Atrial Flutter", "Cardiologist Report",  specialistReport.getCardiologistDate());
		}
		
		//check for Deep Vein Thrombosis
		value =  specialistReport.isDeepVeinThrombosis();
		if(value){
			addDiagnosis("Deep Vein Thrombosis", "Cardiologist Report",  specialistReport.getCardiologistDate());
		}
		
		//check for Old Myocardial Infarction
		value =  specialistReport.isOldMyocardialInfarction();
		if(value){
			addDiagnosis("Old Myocardial Infarction", "Cardiologist Report",  specialistReport.getCardiologistDate());
		}
		
		//check for Angina Pectoris
		value =  specialistReport.isAnginaPectoris();
		if(value){
			addDiagnosis("Angina Pectoris", "Cardiologist Report",  specialistReport.getCardiologistDate());
		}
		
		//check for Supraventricular Tachycardia
		value =  specialistReport.isSupraventricularTachycardia();
		if(value){
			addDiagnosis("Supraventricular Tachycardia", "Cardiologist Report",  specialistReport.getCardiologistDate());
		}
		
		//check for Hypertension
		value =  specialistReport.isHypertension();
		if(value){
			addDiagnosis("Hypertension", "Cardiologist Report",  specialistReport.getCardiologistDate());
		}
		
		//checks for Cardiologist Other
		check = specialistReport.getCardiologistOther();
		if(check!=null && !check.isEmpty()){
			addDiagnosis(check, "Cardiologist Report", specialistReport.getCardiologistDate());
		}
		
		/*
		 * Ophthalmologist Report
		 */
		
		//check for Glaucoma
		check = specialistReport.getGlaucoma();
		if(check!=null && !check.isEmpty()){
			if(check.equals("Left")){
				addDiagnosis("Left Eye Glaucoma", "Ophthalmologist Report",  specialistReport.getOphthalmologistDate());
			}else if(check.equals("Right")){
				addDiagnosis("Right Eye Glaucoma", "Ophthalmologist Report",  specialistReport.getOphthalmologistDate());
			}else if(check.equals("Both")){
				addDiagnosis("Left and Right Eye Glaucoma", "Ophthalmologist Report",  specialistReport.getOphthalmologistDate());
			}
		}
		
		//check for Proliferative
		check = specialistReport.getProliferative();
		if(check!=null && !check.isEmpty()){
			if(check.equals("Left")){
				addDiagnosis("Left Eye Proliferative Retinopathy", "Ophthalmologist Report",  specialistReport.getOphthalmologistDate());
			}else if(check.equals("Right")){
				addDiagnosis("Right Eye Proliferative Retinopathy", "Ophthalmologist Report",  specialistReport.getOphthalmologistDate());
			}else if(check.equals("Both")){
				addDiagnosis("Left and Right Proliferative Eye Retinopathy", "Ophthalmologist Report",  specialistReport.getOphthalmologistDate());
			}
		}
		
		//check for Non-Proliferative
		check = specialistReport.getNonProliferative();
		if(check!=null && !check.isEmpty()){
			if(check.equals("Left")){
				addDiagnosis("Left Eye Non-Proliferative Retinopathy", "Ophthalmologist Report",  specialistReport.getOphthalmologistDate());
			}else if(check.equals("Right")){
				addDiagnosis("Right Eye Non-Proliferative Retinopathy", "Ophthalmologist Report",  specialistReport.getOphthalmologistDate());
			}else if(check.equals("Both")){
				addDiagnosis("Left and Right Non-Proliferative Eye Retinopathy", "Ophthalmologist Report",  specialistReport.getOphthalmologistDate());
			}
		}
		
		//check for Cataract
		check = specialistReport.getCataract();
		if(check!=null && !check.isEmpty()){
			if(check.equals("Left")){
				addDiagnosis("Left Eye Cataract", "Ophthalmologist Report",  specialistReport.getOphthalmologistDate());
			}else if(check.equals("Right")){
				addDiagnosis("Right Eye Cataract", "Ophthalmologist Report",  specialistReport.getOphthalmologistDate());
			}else if(check.equals("Both")){
				addDiagnosis("Left and Right Eye Cataract", "Ophthalmologist Report",  specialistReport.getOphthalmologistDate());
			}
		}
		
		//check for Opthalmologist Other
		check = specialistReport.getOphthalmologistOther();
		if(check!=null && !check.isEmpty()){
			addDiagnosis(check, "Ophthalmologist Report",  specialistReport.getOphthalmologistDate());
		}
		
		/*
		 * Pulmonologist Report
		 */
		
		//checks for Compulsive Obstructive Pulmonary Disease
		value = specialistReport.isCompulsiveObstructivePulmonaryDisease();
		if(value){
			addDiagnosis("Compulsive Obstructive Pulmonary Disease", "Pulmonologist Report",  specialistReport.getPulmonologistDate());
		}
		
		//checks for Asthma, Asthma Bronchitis
		value = specialistReport.isAsthmaBronchitis();
		if(value){
			addDiagnosis("Ashtma, Asthma Bronchitis", "Pulmonologist Report",  specialistReport.getPulmonologistDate());
		}
		
		//checks for Pulmonary Embolism
		value = specialistReport.isPulmonaryCysticFibrosis();
		if(value){
			addDiagnosis("Pulmonary Embolism", "Pulmonologist Report",  specialistReport.getPulmonologistDate());
		}
		
		//checks for Pulmonary Cystic Fibrosis
		value = specialistReport.isPulmonaryCysticFibrosis();
		if(value){
			addDiagnosis("Pulmonary Cystic Fibrosis", "Pulmonologist Report",  specialistReport.getPulmonologistDate());
		}
		
		//checks for Pulmonologist Other
		check = specialistReport.getPulmonologistOther();
		if(check!=null && !check.isEmpty()){
			addDiagnosis(check, "Pulmonologist Report", specialistReport.getPulmonologistDate());
		}
		
		/*
		 * Neurologist Report
		 */
		
		//checks for Parkinson's Disease
		value = specialistReport.isParkinsonsDisease();
		if(value){
			addDiagnosis("Parkinson's Disease", "Neurologist Report", specialistReport.getNeurologistDate());
		}
		
		//checks for Seizure Disorder
		value = specialistReport.isSeizureDisorder();
		if(value){
			addDiagnosis("Seizure Disorder", "Neurologist Report", specialistReport.getNeurologistDate());
		}

		//checks for Epilepsy
		value = specialistReport.isEpilepsy();
		if(value){
			addDiagnosis("Epilepsy", "Neurologist Report", specialistReport.getNeurologistDate());
		}

		//checks for Migraine Headache
		value = specialistReport.isMigrainHeadache();
		if(value){
			addDiagnosis("Migraine Headache", "Neurologist Report", specialistReport.getNeurologistDate());
		}

		//checks for Dementia
		value = specialistReport.isDementia();
		if(value){
			addDiagnosis("Dementia", "Neurologist Report", specialistReport.getNeurologistDate());
		}

		//checks for Alzheimer's Disease
		value = specialistReport.isAlzheimersDisease();
		if(value){
			addDiagnosis("Alzheimer's Disease", "Neurologist Report", specialistReport.getNeurologistDate());
		}

		//checks for Multiple Sclerosis
		value = specialistReport.isMultipleSclerosis1();
		if(value){
			addDiagnosis("Multiple Sclerosis", "Neurologist Report", specialistReport.getNeurologistDate());
		}
		
		//checks for Neurologist other
		check = specialistReport.getNeurologistOther();
		if(check!=null && !check.isEmpty()){
			addDiagnosis(check, "Neurologist Report", specialistReport.getNeurologistDate());
		}
		
		/*
		 * Psychiatrist/Psychologist Report
		 */
		
		//checks for Major Depression
		value = specialistReport.isMajorDepression();
		if(value){
			addDiagnosis("Major Depression", "Psychiatrist/Psychologist Report", specialistReport.getPsychiatristPsychologistDate());
		}
		
		//checks for Anxiety Disorder
		value = specialistReport.isAnxietyDisorder();
		if(value){
			addDiagnosis("Anxiety Disorder", "Psychiatrist/Psychologist Report", specialistReport.getPsychiatristPsychologistDate());
		}
		
		//checks for Schizophrenia
		value = specialistReport.isSchizophrenia();
		if(value){
			addDiagnosis("Schizophrenia", "Psychiatrist/Psychologist Report", specialistReport.getPsychiatristPsychologistDate());
		}
		
		//checks for Bipolar Disease
		value = specialistReport.isBipolarDisease();
		if(value){
			addDiagnosis("Bipolar Disease", "Psychiatrist/Psychologist Report", specialistReport.getPsychiatristPsychologistDate());
		}
		
		//checks for Alcohol Dependence
		value = specialistReport.isAlcoholDependence();
		if(value){
			addDiagnosis("Alcohol Dependence", "Psychiatrist/Psychologist Report", specialistReport.getPsychiatristPsychologistDate());
		}

		//checks for Psychiatrist/Psychologist Other
		check = specialistReport.getPsychiatristPsychologistOther();
		if(check!=null && !check.isEmpty()){
			addDiagnosis(check, "Psychiatrist/Psychologist Report", specialistReport.getPsychiatristPsychologistDate());
		}
		
		/*
		 * Rheumatologist Report
		 */
		
		//checks for Rheumatoid Arthritis
		value = specialistReport.isRheumatoidArthritis();
		if(value){
			addDiagnosis("Rheumatoid Arthritis", "Rheumatologist Report", specialistReport.getRheumatologistDate());
		}
		
		//checks for Systemic Lupus
		value = specialistReport.isSystemicLupus();
		if(value){
			addDiagnosis("Systemic Lupus", "Rheumatologist Report", specialistReport.getRheumatologistDate());
		}
		
		//checks for Multiple Sclerosis
		value = specialistReport.isMultipleSclerosis2();
		if(value){
			addDiagnosis("Multiple Sclerosis", "Rheumatologist Report", specialistReport.getRheumatologistDate());
		}
		
		//checks for Rheumatologist Other
		check = specialistReport.getRheumatologistOther();
		if(check!=null && !check.isEmpty()){
			addDiagnosis(check, "Rheumatologist Report", specialistReport.getRheumatologistDate());
		}			
		
		/*
		 * Podiatrist Report
		 */
		
		//checks for Below Knee Amputation
		check = specialistReport.getBelowKneeAmputation();
		if(check!=null && !check.isEmpty()){
			if(check.equals("Left")){
				addDiagnosis("Left Below Knee Amputation", "Podiatrist Report", specialistReport.getPodiatristDate());
			}else if(check.equals("Right")){
				addDiagnosis("Right Below Knee Amputation", "Podiatrist Report", specialistReport.getPodiatristDate());
			}else if(check.equals("Both")){
				addDiagnosis("Left and Right Below Knee Amputation", "Podiatrist Report", specialistReport.getPodiatristDate());
			}		
		}
		
		//checks for Above Knee Amputation
		check = specialistReport.getAboveKneeAmputation();
		if(check!=null && !check.isEmpty()){
			if(check.equals("Left")){
				addDiagnosis("Left Above Knee Amputation", "Podiatrist Report", specialistReport.getPodiatristDate());
			}else if(check.equals("Right")){
				addDiagnosis("Right Above Knee Amputation", "Podiatrist Report", specialistReport.getPodiatristDate());
			}else if(check.equals("Both")){
				addDiagnosis("Left and Right Above Knee Amputation", "Podiatrist Report", specialistReport.getPodiatristDate());
			}
		}

		//checks for Am
		value = specialistReport.isAm();
		if(value){
			addDiagnosis("Am", "Podiatrist Report", specialistReport.getPodiatristDate());
		}

		//checks for Poly-Neuropathy
		value = specialistReport.isPolyNeuropathy();
		if(value){
			addDiagnosis("Poly-Neuropathy", "Podiatrist Report", specialistReport.getPodiatristDate());
		}

		//checks for Mono-Neuropathy
		value = specialistReport.isMonoNeuropathy();
		if(value){
			addDiagnosis("Mono-Neuropathy", "Podiatrist Report", specialistReport.getPodiatristDate());
		}

		//checks for Onychomycosis
		value = specialistReport.isOnychomycosis();
		if(value){
			addDiagnosis("Onychomycosis", "Podiatrist Report", specialistReport.getPodiatristDate());
		}

		//checks for Peripheral Vascular Disease
		value = specialistReport.isPeripheralVascularDisease();
		if(value){
			addDiagnosis("Peripheral Vascular Disease", "Podiatrist Report", specialistReport.getPodiatristDate());
		}		
		
		//checks for Ulcers of Lower Extremity
		check = specialistReport.getUlcersOfLowerExtremity();
		if(check!=null && !check.isEmpty()){
			if(check.equals("Left")){
				addDiagnosis("Left Ulcers of Lower Extremity", "Podiatrist Report", specialistReport.getPodiatristDate());
			}else if(check.equals("Right")){
				addDiagnosis("Right Ulcers of Lower Extremity", "Podiatrist Report", specialistReport.getPodiatristDate());
			}else if(check.equals("Both")){
				addDiagnosis("Left and Right Ulcers of Lower Extremity", "Podiatrist Report", specialistReport.getPodiatristDate());
			}
		}
		
		//checks for Podiatrist Other
		check = specialistReport.getPodiatristOther();
		if(check!=null && !check.isEmpty()){
			addDiagnosis(check, "Podiatrist Report", specialistReport.getPodiatristDate());
		}
	}
	
	//adds a diagnosis with a date
	public void addDiagnosis(String diagnosisName, String reportName, Date date){
		//checks if the diagnosis is already in the list
		//if it is, it will add more information to the diagnosis
		for(int i = 0; i<diagnoses.size(); i++){
			if(diagnoses.get(i).getDiagnosisName() == diagnosisName){
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
	public void editDiagnosis(int num, String reportName, Date reportDate){
		diagnoses.get(num).setTestName(reportName);
		diagnoses.get(num).setTestDate(reportDate);
	}
	

	public void updateDiagnosisList(List<String> FinalizedDiagnoses){
		for(int i =0; i<diagnoses.size(); i++){
			String name = diagnoses.get(i).getDiagnosisName();
			for(int j=0; j<FinalizedDiagnoses.size(); j++){
				if(name.equals(FinalizedDiagnoses.get(j))){
					
				}
			}
		}
		
		
		
	}
	
	
	//returns list of Diagnoses
	public ArrayList<Diagnosis> getDiagnoses(){
		return diagnoses;
	}
	
	public Diagnosis getDiagnosis(int i){
		return diagnoses.get(i);
	}

}
