package edu.csupomona.cs480.data.provider;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.lang.reflect.Type;

import edu.csupomona.cs480.object_class.Medicine;
import edu.csupomona.cs480.util.ResourceResolver;

/**
 * The implementation of {@link UserManager} interface
 * using file system.
 * <p>
 * This class demonstrates how you can use the file system
 * as a database to store your data.
 *
 */
public class FSMedManager implements MedManager {

	/**
	 * Load the med map from the local file.
	 *
	 * @return
	 */
	
	private List<Medicine> getMedList(){
		List<Medicine> medList = null;
		File medFile = ResourceResolver.getMedFile();
		if (medFile.exists()) {
			// read the file and convert the GSON content
			// to the medList object
			try {
				
				Gson gson = new Gson();
				JsonReader reader = new JsonReader(new FileReader(ResourceResolver.getMedFile()));				
				Type type = new TypeToken<List<Medicine>>(){}.getType();								
				medList = gson.fromJson(reader,type);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			//If the file doesn't exist
			//Create the MedList and store it in default location
			medList = DefaultAllMeds();
			persistMedList(medList);
		}
		return medList;
	}

	/**
	 * Save and persist the med array list in the local file.
	 *
	 * @param medList
	 */
	private void persistMedList(List<Medicine> medList) {
		try {
			// convert the medicine object to GSON format
			Gson gson = new Gson();
			Type type = new TypeToken<List<Medicine>>(){}.getType();
			JsonWriter writer = new JsonWriter(new FileWriter(ResourceResolver.getMedFile()));
			gson.toJson(medList,type, writer);
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//bothNames refers to "GenericName - BrandName"
	@Override
	public Medicine getMed(String bothNames) {
		List<Medicine> medList = getMedList();
		
		for(Medicine med : medList){
			if(med.getBothNames().equals(bothNames))
					return med;
		}
		
		return null;
	}

	@Override
	public void updateMed(Medicine med) {
		List<Medicine> medList = getMedList();
		int index = -1;
		
		if(medList != null){
			for(Medicine currentmeds : medList){
				if(currentmeds.getGenericName().equals(med.getGenericName())){
						index = medList.indexOf(currentmeds);
						break;
				}
			}
		}
		
		if(index != -1){
			medList.set(index, med);
		}
		else{
			medList.add(med);
		}
		
		persistMedList(medList);
	}

	@Override
	public void deleteMed(String bothNames) {
		List<Medicine> medList = getMedList();
		for(Medicine med : medList){
			if(med.getBothNames().equals(bothNames)){
					medList.remove(medList.indexOf(med));
					break;
			}
		}
		persistMedList(medList);
	}

	@Override
	public List<Medicine> listAllMeds() {
		List<Medicine> medList = getMedList();

		
		List<Medicine> clonedList = new ArrayList<Medicine>(medList.size());
		for(Medicine med : medList){
			clonedList.add(new Medicine(med));
		}
				
		return clonedList;
	}
	

	public List<Medicine> DefaultAllMeds(){
		List<Medicine> medList = new ArrayList<Medicine>();
		
		//Long list of meds
		
		//Duplicate Generic Name, different Brandname
		//Insulin Lispro
		//Insulin Glargine
		
		//Nitroglycerine - merged (Duplicate names, Duplicate brand, different classification/different purpose
		
		
		List<String> PurposeList = new ArrayList<String>(Arrays.asList("ADHD"));
		Medicine Methylphenidate = new Medicine("Methylphenidate", "Concerta", "C-II", "", PurposeList);
		medList.add(Methylphenidate);
		PurposeList = new ArrayList<String>(Arrays.asList("ADHD"));
		Medicine Lisdexamfetamine = new Medicine("Lisdexamfetamine", "Vyvanse", "C-II", "", PurposeList);
		medList.add(Lisdexamfetamine);
		PurposeList = new ArrayList<String>(Arrays.asList("ADHD"));
		Medicine Atomoxetine = new Medicine("Atomoxetine", "Strattera", "", "", PurposeList);
		medList.add(Atomoxetine);
		PurposeList = new ArrayList<String>(Arrays.asList("ADHD"));
		Medicine Dexmethylphenidate = new Medicine("Dexmethylphenidate", "Focalin", "C-II", "", PurposeList);
		medList.add(Dexmethylphenidate);
		PurposeList = new ArrayList<String>(Arrays.asList("Allergies"));
		Medicine Fexofenadine = new Medicine("Fexofenadine", "Allegra", "", "", PurposeList);
		medList.add(Fexofenadine);
		PurposeList = new ArrayList<String>(Arrays.asList("Allergies"));
		Medicine Mometasone = new Medicine("Mometasone", "Nasonex", "", "", PurposeList);
		medList.add(Mometasone);
		PurposeList = new ArrayList<String>(Arrays.asList("Allergies"));
		Medicine Cetirizine = new Medicine("Cetirizine", "Zyrtec", "", "", PurposeList);
		medList.add(Cetirizine);
		PurposeList = new ArrayList<String>(Arrays.asList("Alzheimers"));
		Medicine Memantine = new Medicine("Memantine", "Namenda", "", "", PurposeList);
		medList.add(Memantine);
		PurposeList = new ArrayList<String>(Arrays.asList("Anxiety"));
		Medicine Alprazolam = new Medicine("Alprazolam", "Xanax", "C-IV", "", PurposeList);
		medList.add(Alprazolam);
		PurposeList = new ArrayList<String>(Arrays.asList("Anxiety","Seizure Disorder"));
		Medicine Clonazepam = new Medicine("Clonazepam", "Klonopin", "C-IV", "", PurposeList);
		medList.add(Clonazepam);
		PurposeList = new ArrayList<String>(Arrays.asList("Anxiety","Seizure Disorder"));
		Medicine Diazepam = new Medicine("Diazepam", "Valium", "C-IV", "", PurposeList);
		medList.add(Diazepam);
		PurposeList = new ArrayList<String>(Arrays.asList("Anxiety","Seizure Disorder"));
		Medicine Lorazepam = new Medicine("Lorazepam", "Ativan", "C-IV", "", PurposeList);
		medList.add(Lorazepam);
		PurposeList = new ArrayList<String>(Arrays.asList("Anxiety"));
		Medicine Buspirone = new Medicine("Buspirone", "Buspar", "", "", PurposeList);
		medList.add(Buspirone);
		PurposeList = new ArrayList<String>(Arrays.asList("Asthma"));
		Medicine Montelukast = new Medicine("Montelukast", "Singulair", "", "", PurposeList);
		medList.add(Montelukast);
		PurposeList = new ArrayList<String>(Arrays.asList("Atrial Fibrillation"));
		Medicine Dabigatran = new Medicine("Dabigatran", "Pradaxa", "", "Anticoagulant", PurposeList);
		medList.add(Dabigatran);
		PurposeList = new ArrayList<String>(Arrays.asList("Atrial Fibrillation","Deep Vein Thrombosis","Pulmonary Embolism","Transient Ischemic Attack","Stroke (Old CVA)"));
		Medicine Warfarin = new Medicine("Warfarin", "Coumadin", "", "Anti-Cougulant", PurposeList);
		medList.add(Warfarin);
		PurposeList = new ArrayList<String>(Arrays.asList("Atrial Fibrillation","Deep Vein Thrombosis","Pulmonary Embolism"));
		Medicine Rivaroxaban = new Medicine("Rivaroxaban", "Xarelto", "", "Anti-Cougulant", PurposeList);
		medList.add(Rivaroxaban);
		PurposeList = new ArrayList<String>(Arrays.asList("Bening Prostate Hyperplasia","Prostatitis"));
		Medicine Finasteride = new Medicine("Finasteride", "Proscar", "", "", PurposeList);
		medList.add(Finasteride);
		PurposeList = new ArrayList<String>(Arrays.asList("Bening Prostate Hyperplasia","Prostatitis"));
		Medicine Dutasteride = new Medicine("Dutasteride", "Avodart", "", "", PurposeList);
		medList.add(Dutasteride);
		PurposeList = new ArrayList<String>(Arrays.asList("Bening Prostate Hyperplasia","Prostatitis"));
		Medicine Terazosin = new Medicine("Terazosin", "Hytrin", "", "", PurposeList);
		medList.add(Terazosin);
		PurposeList = new ArrayList<String>(Arrays.asList("Chonic Obstructive Pulmonary Disease","Asthma","Chronic Bronchitis","Anaphylaxos"));
		Medicine Albuterol = new Medicine("Albuterol", "ProAir HFA", "", "", PurposeList);
		medList.add(Albuterol);
		PurposeList = new ArrayList<String>(Arrays.asList("Chonic Obstructive Pulmonary Disease","Asthma"));
		Medicine Tiotropium = new Medicine("Tiotropium", "Spiriva", "", "", PurposeList);
		medList.add(Tiotropium);
		PurposeList = new ArrayList<String>(Arrays.asList("Chonic Obstructive Pulmonary Disease"));
		Medicine Roflumilast = new Medicine("Roflumilast", "Daliresp", "", "", PurposeList);
		medList.add(Roflumilast);
		PurposeList = new ArrayList<String>(Arrays.asList("Congestive Heart Failure","Atrial Fibrillation","Supraventrilcular Tachycardia","Cardiomyopathy"));
		Medicine Digoxin = new Medicine("Digoxin", "Lanoxin", "", "", PurposeList);
		medList.add(Digoxin);
		PurposeList = new ArrayList<String>(Arrays.asList("Coronary Artery Disease"));
		Medicine Clopidogrel = new Medicine("Clopidogrel", "Plavix", "", "", PurposeList);
		medList.add(Clopidogrel);
		PurposeList = new ArrayList<String>(Arrays.asList("Deep Vein Thrombosis"));
		Medicine Enoxaparin = new Medicine("Enoxaparin", "Lovenox", "", "Anticoagulant", PurposeList);
		medList.add(Enoxaparin);
		PurposeList = new ArrayList<String>(Arrays.asList("Dementia"));
		Medicine Rivastigmine = new Medicine("Rivastigmine", "Exelon", "", "", PurposeList);
		medList.add(Rivastigmine);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2","Diabetes Type 1"));
		Medicine InsulinLisproA = new Medicine("Insulin Lispro", "Humalog", "", "Insulin Rapid Acting", PurposeList);
		medList.add(InsulinLisproA);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2","Diabetes Type 2"));
		Medicine InsulinLisproB = new Medicine("Insulin Lispro", "Humulin", "", "Insulin Rapid Acting", PurposeList);
		medList.add(InsulinLisproB);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2","Dysmetabolic Syndrome"));
		Medicine Metformin = new Medicine("Metformin", "Glucophage", "", "", PurposeList);
		medList.add(Metformin);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2"));
		Medicine Canagliflozin = new Medicine("Canagliflozin", "Invokana", "", "SGLT2", PurposeList);
		medList.add(Canagliflozin);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2"));
		Medicine Dapagliflozin = new Medicine("Dapagliflozin", "Farxiga", "", "SGLT2", PurposeList);
		medList.add(Dapagliflozin);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2"));
		Medicine Empagliflozin = new Medicine("Empagliflozin", "Jardiance", "", "SGLT2", PurposeList);
		medList.add(Empagliflozin);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2"));
		Medicine Glipizide = new Medicine("Glipizide", "Glucotrol", "", "Sulfonylurea", PurposeList);
		medList.add(Glipizide);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2"));
		Medicine Glyburide = new Medicine("Glyburide", "Diabeta", "", "Sulfonylurea", PurposeList);
		medList.add(Glyburide);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2","Diabetes Type 1"));
		Medicine InsulinDetemir = new Medicine("Insulin Detemir", "Levemir", "", "Insulin Long Acting", PurposeList);
		medList.add(InsulinDetemir);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2","Diabetes Type 1"));
		Medicine InsulinGlargineA = new Medicine("Insulin Glargine", "Lantus", "", "Insulin Long Acting", PurposeList);
		medList.add(InsulinGlargineA);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2"));
		Medicine Linagliptin = new Medicine("Linagliptin", "Tradjenta", "", "Linagliptin", PurposeList);
		medList.add(Linagliptin);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2"));
		Medicine Liraglutide = new Medicine("Liraglutide", "Victoza", "", "Incretin Mimetics", PurposeList);
		medList.add(Liraglutide);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2"));
		Medicine Pioglitazone = new Medicine("Pioglitazone", "Actos", "", "Thiazolidinedione", PurposeList);
		medList.add(Pioglitazone);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2"));
		Medicine Saxagliptin = new Medicine("Saxagliptin", "Onglyza", "", "DPP4 Inhibitors", PurposeList);
		medList.add(Saxagliptin);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2"));
		Medicine Sitagliptin = new Medicine("Sitagliptin", "Januvia", "", "DPP4 Inhibitors", PurposeList);
		medList.add(Sitagliptin);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2","Diabetes Type 1"));
		Medicine InsulinAspart = new Medicine("Insulin Aspart", "Novolog", "", "Insulin Rapid Acting", PurposeList);
		medList.add(InsulinAspart);
		PurposeList = new ArrayList<String>(Arrays.asList("Diabetes Type 2","Diabetes Type 1"));
		Medicine InsulinGlargineB = new Medicine("Insulin Glargine", "Toujeo", "", "Insulin Long Acting", PurposeList);
		medList.add(InsulinGlargineB);
		PurposeList = new ArrayList<String>(Arrays.asList("Edema","Congestive Heart Failure","Cardiomyopathy","Cirrhosis"));
		Medicine Furosemide = new Medicine("Furosemide", "Lasix", "", "Diuretic", PurposeList);
		medList.add(Furosemide);
		PurposeList = new ArrayList<String>(Arrays.asList("Edema","Congestive Heart Failure","Hypertention","Cirrhosis"));
		Medicine Spironolactone = new Medicine("Spironolactone", "Aldactone", "", "Diuretic", PurposeList);
		medList.add(Spironolactone);
		PurposeList = new ArrayList<String>(Arrays.asList("Erectile Dysfunction"));
		Medicine Sildenafil = new Medicine("Sildenafil", "Viagra", "", "", PurposeList);
		medList.add(Sildenafil);
		PurposeList = new ArrayList<String>(Arrays.asList("Erectile Dysfunction"));
		Medicine Vardenafil = new Medicine("Vardenafil", "Levitra", "", "", PurposeList);
		medList.add(Vardenafil);
		PurposeList = new ArrayList<String>(Arrays.asList("Erectile Dysfunction"));
		Medicine Tadalifil = new Medicine("Tadalifil", "Cialis", "", "", PurposeList);
		medList.add(Tadalifil);
		PurposeList = new ArrayList<String>(Arrays.asList("Frequent Urination","Prostatitis","Benign Prostate Hyperplasia"));
		Medicine Tamsulosin = new Medicine("Tamsulosin", "Flomax", "", "", PurposeList);
		medList.add(Tamsulosin);
		PurposeList = new ArrayList<String>(Arrays.asList("Frequent Urination","Prostatitis","Benign Prostate Hyperplasia","Hypertention"));
		Medicine Doxazosin = new Medicine("Doxazosin", "Cardura", "", "", PurposeList);
		medList.add(Doxazosin);
		PurposeList = new ArrayList<String>(Arrays.asList("Frequent Urination"));
		Medicine Solifenacin = new Medicine("Solifenacin", "VESIcare", "", "", PurposeList);
		medList.add(Solifenacin);
		PurposeList = new ArrayList<String>(Arrays.asList("Gastroesophageal Reflux Disease","Gastritis"));
		Medicine Esomeprazole = new Medicine("Esomeprazole", "Nexium", "", "PPI", PurposeList);
		medList.add(Esomeprazole);
		PurposeList = new ArrayList<String>(Arrays.asList("Gastroesophageal Reflux Disease","Gastritis"));
		Medicine Omeprazole = new Medicine("Omeprazole", "Prilosec", "", "PPI", PurposeList);
		medList.add(Omeprazole);
		PurposeList = new ArrayList<String>(Arrays.asList("Gastroesophageal Reflux Disease","Gastritis"));
		Medicine Pantoprazole = new Medicine("Pantoprazole", "Protonix", "", "PPI", PurposeList);
		medList.add(Pantoprazole);
		PurposeList = new ArrayList<String>(Arrays.asList("Gastroesophageal Reflux Disease","Gastritis"));
		Medicine Dexlansoprazole = new Medicine("Dexlansoprazole", "Dexilant", "", "PPI", PurposeList);
		medList.add(Dexlansoprazole);
		PurposeList = new ArrayList<String>(Arrays.asList("Gastroesophageal Reflux Disease","Gastritis","Stomac Ulcer"));
		Medicine Ranitidine = new Medicine("Ranitidine", "Zantac", "", "", PurposeList);
		medList.add(Ranitidine);
		PurposeList = new ArrayList<String>(Arrays.asList("Gastroesophageal Reflux Disease","Gastritis"));
		Medicine Famotidine = new Medicine("Famotidine", "Pepcid", "", "", PurposeList);
		medList.add(Famotidine);
		PurposeList = new ArrayList<String>(Arrays.asList("Gastroesophageal Reflux Disease","Gastritis","Gastroparesis"));
		Medicine Metoclopramide = new Medicine("Metoclopramide", "Reglan", "", "", PurposeList);
		medList.add(Metoclopramide);
		PurposeList = new ArrayList<String>(Arrays.asList("Gastroesophageal Reflux Disease","Gastritis"));
		Medicine Rabeprazole = new Medicine("Rabeprazole", "Aciphex", "", "PPI", PurposeList);
		medList.add(Rabeprazole);
		PurposeList = new ArrayList<String>(Arrays.asList("Gastroesophageal Reflux Disease","Gastritis"));
		Medicine Lansoprazole = new Medicine("Lansoprazole", "Prevacid", "", "PPI", PurposeList);
		medList.add(Lansoprazole);
		PurposeList = new ArrayList<String>(Arrays.asList("Glaucoma"));
		Medicine Latanoprost = new Medicine("Latanoprost", "Xalatan", "", "", PurposeList);
		medList.add(Latanoprost);
		PurposeList = new ArrayList<String>(Arrays.asList("Gout Arthritis","Kidney Stones"));
		Medicine Allopurinol = new Medicine("Allopurinol", "Zyloprim", "", "", PurposeList);
		medList.add(Allopurinol);
		PurposeList = new ArrayList<String>(Arrays.asList("Hyperlipidemia","Atherosclerosis of Artery (Aortic, Carotid, Lower Extremity)"));
		Medicine Atorvastatin = new Medicine("Atorvastatin", "Lipitor", "", "Statins", PurposeList);
		medList.add(Atorvastatin);
		PurposeList = new ArrayList<String>(Arrays.asList("Hyperlipidemia","Atherosclerosis of Artery (Aortic, Carotid, Lower Extremity)"));
		Medicine Simvastatin = new Medicine("Simvastatin", "Zocor", "", "Statins", PurposeList);
		medList.add(Simvastatin);
		PurposeList = new ArrayList<String>(Arrays.asList("Hyperlipidemia","Atherosclerosis of Artery (Aortic, Carotid, Lower Extremity)"));
		Medicine Rosuvastatin = new Medicine("Rosuvastatin", "Crestor", "", "Statins", PurposeList);
		medList.add(Rosuvastatin);
		PurposeList = new ArrayList<String>(Arrays.asList("Hyperlipidemia","Atherosclerosis of Artery (Aortic, Carotid, Lower Extremity)"));
		Medicine Lovastatin = new Medicine("Lovastatin", "Mevacor", "", "Statins", PurposeList);
		medList.add(Lovastatin);
		PurposeList = new ArrayList<String>(Arrays.asList("Hyperlipidemia","Atherosclerosis of Artery (Aortic, Carotid, Lower Extremity)"));
		Medicine Pravastatin = new Medicine("Pravastatin", "Pravachol", "", "Statins", PurposeList);
		medList.add(Pravastatin);
		PurposeList = new ArrayList<String>(Arrays.asList("Hyperlipidemia"));
		Medicine Ezetimibe = new Medicine("Ezetimibe", "Zetia", "", "", PurposeList);
		medList.add(Ezetimibe);
		PurposeList = new ArrayList<String>(Arrays.asList("Hyperlipidemia","Hypertryglidcerides"));
		Medicine Niacin = new Medicine("Niacin", "Niaspan", "", "", PurposeList);
		medList.add(Niacin);
		PurposeList = new ArrayList<String>(Arrays.asList("Hyperlipidemia"));
		Medicine Gemfibrozil = new Medicine("Gemfibrozil", "Lopid", "", "Fibrate", PurposeList);
		medList.add(Gemfibrozil);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Kidney Protection agaisnt Diabetes","Cardiomyopathy","Congestive Heart Failure","Chronic Kidney Disease Stage: 1, 2, 3"));
		Medicine Valsartan = new Medicine("Valsartan", "Diovan", "", "ARB", PurposeList);
		medList.add(Valsartan);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Kidney Protection agaisnt Diabetes","Cardiomyopathy","Congestive Heart Failure","Chronic Kidney Disease Stage: 1, 2, 3"));
		Medicine Olmesartan = new Medicine("Olmesartan", "Benicar", "", "ARB", PurposeList);
		medList.add(Olmesartan);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Kidney Protection agaisnt Diabetes","Cardiomyopathy","Congestive Heart Failure","Chronic Kidney Disease Stage: 1, 2, 3"));
		Medicine Irbesartan = new Medicine("Irbesartan", "Avapro", "", "ARB", PurposeList);
		medList.add(Irbesartan);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Kidney Protection agaisnt Diabetes","Congestive Heart Failure","Chronic Kidney Disease Stage: 1, 2, 3"));
		Medicine Lisinopril = new Medicine("Lisinopril", "Prinivil", "", "ACE", PurposeList);
		medList.add(Lisinopril);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Kidney Protection agaisnt Diabetes","Congestive Heart Failure","Chronic Kidney Disease Stage: 1, 2, 3"));
		Medicine Enalapril = new Medicine("Enalapril", "Vasotec", "", "ACE", PurposeList);
		medList.add(Enalapril);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Kidney Protection agaisnt Diabetes","Congestive Heart Failure","Chronic Kidney Disease Stage: 1, 2, 3"));
		Medicine Benazepril = new Medicine("Benazepril", "Lotensin", "", "ACE", PurposeList);
		medList.add(Benazepril);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Kidney Protection agaisnt Diabetes","Congestive Heart Failure","Chronic Kidney Disease Stage: 1, 2, 3"));
		Medicine Quinapril = new Medicine("Quinapril", "Accupril", "", "ACE", PurposeList);
		medList.add(Quinapril);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Old Myocardial Infarction (Heart Attack)","Supraventrilcular Tachycardia","Angina Pectoris","Congestive Heart Failure","Atrial Fibrillation ","Atrial Flutter","Cardiomyopathy"));
		Medicine Metoprolol = new Medicine("Metoprolol", "Lopressor", "", "Beta Blocker", PurposeList);
		medList.add(Metoprolol);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Old Myocardial Infarction (Heart Attack)","Supraventrilcular Tachycardia","Angina Pectoris","Congestive Heart Failure","Atrial Fibrillation ","Atrial Flutter","Cardiomyopathy"));
		Medicine Atenolol = new Medicine("Atenolol", "Tenormin", "", "Beta Blocker", PurposeList);
		medList.add(Atenolol);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Old Myocardial Infarction (Heart Attack)","Supraventrilcular Tachycardia","Angina Pectoris","Congestive Heart Failure","Atrial Fibrillation ","Atrial Flutter","Cardiomyopathy"));
		Medicine Bisoprolol = new Medicine("Bisoprolol", "Zebeta", "", "Beta Blocker", PurposeList);
		medList.add(Bisoprolol);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Old Myocardial Infarction (Heart Attack)","Supraventrilcular Tachycardia","Angina Pectoris","Congestive Heart Failure","Atrial Fibrillation ","Atrial Flutter","Cardiomyopathy"));
		Medicine Nebivolol = new Medicine("Nebivolol", "Bystolic", "", "Beta Blocker", PurposeList);
		medList.add(Nebivolol);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Old Myocardial Infarction (Heart Attack)","Supraventrilcular Tachycardia","Angina Pectoris","Congestive Heart Failure","Atrial Fibrillation ","Atrial Flutter","Cardiomyopathy"));
		Medicine Carvedilol = new Medicine("Carvedilol", "Coreg", "", "Beta Blocker", PurposeList);
		medList.add(Carvedilol);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Angina Pectoris","Supraventrilcular Tachycardia","Cardiomyopathy","iopathic hypertrophic subaortic stenosis","Atrial Fibrillation ","Atrial Flutter"));
		Medicine Nifedipine = new Medicine("Nifedipine", "Procardia", "", "Calc. Chan. Blocker", PurposeList);
		medList.add(Nifedipine);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Angina Pectoris","Supraventrilcular Tachycardia","Cardiomyopathy","iopathic hypertrophic subaortic stenosis","Atrial Fibrillation ","Atrial Flutter"));
		Medicine Verapamil = new Medicine("Verapamil", "Verelan", "", "Calc. Chan. Blocker", PurposeList);
		medList.add(Verapamil);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Angina Pectoris","Supraventrilcular Tachycardia","Cardiomyopathy","iopathic hypertrophic subaortic stenosis","Atrial Fibrillation ","Atrial Flutter"));
		Medicine Amlodipine = new Medicine("Amlodipine", "Norvasc", "", "Calc. Chnl. Blkr.", PurposeList);
		medList.add(Amlodipine);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension"));
		Medicine Clonidine = new Medicine("Clonidine", "Catapres", "", "Alpha-Agonist", PurposeList);
		medList.add(Clonidine);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension"));
		Medicine Diltiazem = new Medicine("Diltiazem", "Cardizem", "", "", PurposeList);
		medList.add(Diltiazem);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Kidney Protection agaisnt Diabetes","Cardiomyopathy","Congestive Heart Failure"));
		Medicine Losartan = new Medicine("Losartan", "Cozaar", "", "ARB", PurposeList);
		medList.add(Losartan);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Kidney Protection agaisnt Diabetes","Congestive Heart Failure"));
		Medicine Ramipril = new Medicine("Ramipril", "Altace", "", "ACE", PurposeList);
		medList.add(Ramipril);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension"));
		Medicine Hydralazine = new Medicine("Hydralazine", "Apresoline", "", "Vasodialator", PurposeList);
		medList.add(Hydralazine);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertension","Old Myocardial Infarction (Heart Attack)","Supraventrilcular Tachycardia","Angina Pectoris","Congestive Heart Failure","Atrial Fibrillation ","Atrial Flutter","Cardiomyopathy"));
		Medicine Propranolol = new Medicine("Propranolol", "Inderal", "", "Beta Blocker", PurposeList);
		medList.add(Propranolol);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertention","Angina Pectoris"));
		Medicine Nitroglycerine = new Medicine("Nitroglycerine", "NitroStat SL", "", "Vasodialator", PurposeList);
		medList.add(Nitroglycerine);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypertention"));
		Medicine Hydrochlorothiazide = new Medicine("Hydrochlorothiazide", "HCTZ", "", "Diuretic", PurposeList);
		medList.add(Hydrochlorothiazide);
		//PurposeList = new ArrayList<String>(Arrays.asList("Hypertention"));
		//Medicine Nitroglycerine = new Medicine("Nitroglycerine", "NitroStat SL", "", "Vasodialator", PurposeList);
		//medList.add(Nitroglycerine);
		PurposeList = new ArrayList<String>(Arrays.asList("Hypothyroidism"));
		Medicine Levothyroxine = new Medicine("Levothyroxine", "Synthroid", "", "", PurposeList);
		medList.add(Levothyroxine);
		PurposeList = new ArrayList<String>(Arrays.asList("Insomnia"));
		Medicine Zolpidem = new Medicine("Zolpidem", "Ambien", "C-IV", "", PurposeList);
		medList.add(Zolpidem);
		PurposeList = new ArrayList<String>(Arrays.asList("Irritable Bowel Syndrome"));
		Medicine Dicyclomine = new Medicine("Dicyclomine", "Bentyl", "", "", PurposeList);
		medList.add(Dicyclomine);
		PurposeList = new ArrayList<String>(Arrays.asList("Major Depression","Smoking Cessatoin"));
		Medicine Bupropion = new Medicine("Bupropion", "Wellbutrin", "", "", PurposeList);
		medList.add(Bupropion);
		PurposeList = new ArrayList<String>(Arrays.asList("Major Depression"));
		Medicine Mirtazepine = new Medicine("Mirtazepine", "Remeron", "", "", PurposeList);
		medList.add(Mirtazepine);
		PurposeList = new ArrayList<String>(Arrays.asList("Major Depression","Anxiety "));
		Medicine Escitalopram = new Medicine("Escitalopram", "Lexapro", "", "", PurposeList);
		medList.add(Escitalopram);
		PurposeList = new ArrayList<String>(Arrays.asList("Major Depression","Obsessive Compulsive Disorder","Post-Tramatic Stress Disorder","Anxiety"));
		Medicine Sertraline = new Medicine("Sertraline", "Zoloft", "", "", PurposeList);
		medList.add(Sertraline);
		PurposeList = new ArrayList<String>(Arrays.asList("Major Depression"));
		Medicine Trazodone = new Medicine("Trazodone", "Desyrel", "", "", PurposeList);
		medList.add(Trazodone);
		PurposeList = new ArrayList<String>(Arrays.asList("Major Depression","Anxiety ","Neuropathy","Fibromyalgia"));
		Medicine Duloxetine = new Medicine("Duloxetine", "Cymbalta", "", "", PurposeList);
		medList.add(Duloxetine);
		PurposeList = new ArrayList<String>(Arrays.asList("Major Depression"));
		Medicine Citalopram = new Medicine("Citalopram", "Celexa", "", "", PurposeList);
		medList.add(Citalopram);
		PurposeList = new ArrayList<String>(Arrays.asList("Major Depression","Obsessive Compulsive Disorder","Post-Tramatic Stress Disorder","Anxiety"));
		Medicine Paroxetine = new Medicine("Paroxetine", "Paxil", "", "", PurposeList);
		medList.add(Paroxetine);
		PurposeList = new ArrayList<String>(Arrays.asList("Major Depression","Obsessive Compulsive Disorder","Anxiety"));
		Medicine Fluoxetine = new Medicine("Fluoxetine", "Prozac", "", "", PurposeList);
		medList.add(Fluoxetine);
		PurposeList = new ArrayList<String>(Arrays.asList("Major Depression","Anxiety"));
		Medicine Venlafaxine = new Medicine("Venlafaxine", "Effexor", "", "", PurposeList);
		medList.add(Venlafaxine);
		PurposeList = new ArrayList<String>(Arrays.asList("Major Depression","Neuropathy"));
		Medicine Amitriptyline = new Medicine("Amitriptyline", "Elavil", "", "", PurposeList);
		medList.add(Amitriptyline);
		PurposeList = new ArrayList<String>(Arrays.asList("Migraine Headache"));
		Medicine Sumatriptan = new Medicine("Sumatriptan", "Imitrex", "", "", PurposeList);
		medList.add(Sumatriptan);
		PurposeList = new ArrayList<String>(Arrays.asList("Muscle Relaxer","Pain"));
		Medicine Cyclobenzaprine = new Medicine("Cyclobenzaprine", "Flexeril", "", "", PurposeList);
		medList.add(Cyclobenzaprine);
		PurposeList = new ArrayList<String>(Arrays.asList("Muscle Relaxer","Pain"));
		Medicine Carisoprodol = new Medicine("Carisoprodol", "Soma", "C-IV", "", PurposeList);
		medList.add(Carisoprodol);
		PurposeList = new ArrayList<String>(Arrays.asList("Muscle Relaxer","Pain"));
		Medicine Methocarbamol = new Medicine("Methocarbamol", "Robaxin", "", "", PurposeList);
		medList.add(Methocarbamol);
		PurposeList = new ArrayList<String>(Arrays.asList("Muscle Relaxer","Pain"));
		Medicine Baclofen = new Medicine("Baclofen", "Gablofen", "", "", PurposeList);
		medList.add(Baclofen);
		PurposeList = new ArrayList<String>(Arrays.asList("Nausea","Vommiting"));
		Medicine Ondansetron = new Medicine("Ondansetron", "Zofran", "", "", PurposeList);
		medList.add(Ondansetron);
		PurposeList = new ArrayList<String>(Arrays.asList("Ocular Hypertension"));
		Medicine Travoprost = new Medicine("Travoprost", "Travatan", "", "", PurposeList);
		medList.add(Travoprost);
		PurposeList = new ArrayList<String>(Arrays.asList("Osteoporosis"));
		Medicine Risedronate = new Medicine("Risedronate", "Actonel", "", "", PurposeList);
		medList.add(Risedronate);
		PurposeList = new ArrayList<String>(Arrays.asList("Osteoporosis"));
		Medicine Alendronate = new Medicine("Alendronate", "Fosamax", "", "", PurposeList);
		medList.add(Alendronate);
		PurposeList = new ArrayList<String>(Arrays.asList("Osteoporosis"));
		Medicine Raloxifene = new Medicine("Raloxifene", "Evista", "", "", PurposeList);
		medList.add(Raloxifene);
		PurposeList = new ArrayList<String>(Arrays.asList("Pain"));
		Medicine Fentanyl = new Medicine("Fentanyl", "Duragesic", "C-II", "Narcotic Analgesic", PurposeList);
		medList.add(Fentanyl);
		PurposeList = new ArrayList<String>(Arrays.asList("Pain"));
		Medicine Diclofenac = new Medicine("Diclofenac", "Voltaren", "", "NSAID Gel", PurposeList);
		medList.add(Diclofenac);
		PurposeList = new ArrayList<String>(Arrays.asList("Pain"));
		Medicine CodeineAPAP = new Medicine("CodeineAPAP", "Tylenol #2", "C-III", "Narcotic Analgesic", PurposeList);
		medList.add(CodeineAPAP);
		PurposeList = new ArrayList<String>(Arrays.asList("Pain"));
		Medicine Nabumetone = new Medicine("Nabumetone", "Relafen", "", "N.S.A.I.D", PurposeList);
		medList.add(Nabumetone);
		PurposeList = new ArrayList<String>(Arrays.asList("Pain"));
		Medicine Ibuprofen = new Medicine("Ibuprofen", "Advil", "", "N.S.A.I.D.", PurposeList);
		medList.add(Ibuprofen);
		PurposeList = new ArrayList<String>(Arrays.asList("Pain"));
		Medicine Celecoxib = new Medicine("Celecoxib", "Celebrex", "", "N.S.A.I.D.", PurposeList);
		medList.add(Celecoxib);
		PurposeList = new ArrayList<String>(Arrays.asList("Pain"));
		Medicine Naproxen = new Medicine("Naproxen", "Aleve", "", "N.S.A.I.D.", PurposeList);
		medList.add(Naproxen);
		PurposeList = new ArrayList<String>(Arrays.asList("Pain"));
		Medicine HydrocodoneAPAP = new Medicine("HydrocodoneAPAP", "Vicodin", "C-II", "Narcotic Analgesic", PurposeList);
		medList.add(HydrocodoneAPAP);
		PurposeList = new ArrayList<String>(Arrays.asList("Pain"));
		Medicine Tramadol = new Medicine("Tramadol", "Ultram", "C-IV", "Narcotic Analgesic", PurposeList);
		medList.add(Tramadol);
		PurposeList = new ArrayList<String>(Arrays.asList("Pain"));
		Medicine OxycodoneAPAP = new Medicine("OxycodoneAPAP", "Percocet", "C-II", "Narcotic Analgesic", PurposeList);
		medList.add(OxycodoneAPAP);
		PurposeList = new ArrayList<String>(Arrays.asList("Pain"));
		Medicine Oxycodone = new Medicine("Oxycodone", "OxyContin", "C-II", "Narcotic Analgesic", PurposeList);
		medList.add(Oxycodone);
		PurposeList = new ArrayList<String>(Arrays.asList("Parkinson's"));
		Medicine Ropinirole = new Medicine("Ropinirole", "Requip", "", "", PurposeList);
		medList.add(Ropinirole);
		PurposeList = new ArrayList<String>(Arrays.asList("Parkinson's"));
		Medicine Benztropine = new Medicine("Benztropine", "Cogentin", "", "", PurposeList);
		medList.add(Benztropine);
		PurposeList = new ArrayList<String>(Arrays.asList("Parkinson's"));
		Medicine Pramipexole = new Medicine("Pramipexole", "Mirapex", "", "", PurposeList);
		medList.add(Pramipexole);
		PurposeList = new ArrayList<String>(Arrays.asList("Rheumatoid Arthritis"));
		Medicine Etanercept = new Medicine("Etanercept", "Enbrel", "", "", PurposeList);
		medList.add(Etanercept);
		PurposeList = new ArrayList<String>(Arrays.asList("Rheumatoid Arthritis"));
		Medicine Methotrexate = new Medicine("Methotrexate", "Rheumatrex", "", "", PurposeList);
		medList.add(Methotrexate);
		PurposeList = new ArrayList<String>(Arrays.asList("Rheumatoid Arthritis","Pain"));
		Medicine Meloxicam = new Medicine("Meloxicam", "Mobic", "", "NSAID ", PurposeList);
		medList.add(Meloxicam);
		PurposeList = new ArrayList<String>(Arrays.asList("Schizophrenia","Bipolar Disorder","Major Depression"));
		Medicine Aripiprazole = new Medicine("Aripiprazole", "Abilify", "", "Antipsychotic", PurposeList);
		medList.add(Aripiprazole);
		PurposeList = new ArrayList<String>(Arrays.asList("Schizophrenia","Bipolar Disorder"));
		Medicine Risperidone = new Medicine("Risperidone", "Risperdal", "", "Antipsychotic", PurposeList);
		medList.add(Risperidone);
		PurposeList = new ArrayList<String>(Arrays.asList("Schizophrenia"));
		Medicine Lurasidone = new Medicine("Lurasidone", "Latuda", "", "Antipsychotic", PurposeList);
		medList.add(Lurasidone);
		PurposeList = new ArrayList<String>(Arrays.asList("Schizophrenia","Bipolar Disorder","Major Depression"));
		Medicine Quetiapine = new Medicine("Quetiapine", "Seroquel", "", "Anti-Psychotic", PurposeList);
		medList.add(Quetiapine);
		PurposeList = new ArrayList<String>(Arrays.asList("Schizophrenia","Bipolar Disorder"));
		Medicine Olanzapine = new Medicine("Olanzapine", "Zyprexa", "", "Anti-Psychotic", PurposeList);
		medList.add(Olanzapine);
		PurposeList = new ArrayList<String>(Arrays.asList("Seizure Disorder"));
		Medicine Phenytoin = new Medicine("Phenytoin", "Dilantin", "", "", PurposeList);
		medList.add(Phenytoin);
		PurposeList = new ArrayList<String>(Arrays.asList("Seizure Disorder","Neuropathy","Fibromyalgia"));
		Medicine Pregabalin = new Medicine("Pregabalin", "Lyrica", "", "", PurposeList);
		medList.add(Pregabalin);
		PurposeList = new ArrayList<String>(Arrays.asList("Seizure Disorder","Migraine Headaches"));
		Medicine Topiramate = new Medicine("Topiramate", "Topamax", "", "", PurposeList);
		medList.add(Topiramate);
		PurposeList = new ArrayList<String>(Arrays.asList("Seizure Disorder","Bipolar Disorder","Migraine Headaches"));
		Medicine Divalproex = new Medicine("Divalproex", "Depakote", "", "", PurposeList);
		medList.add(Divalproex);
		PurposeList = new ArrayList<String>(Arrays.asList("Seizure Disorder","Bipolar Disorder"));
		Medicine Lamotrigine = new Medicine("Lamotrigine", "Lamictal", "", "", PurposeList);
		medList.add(Lamotrigine);
		PurposeList = new ArrayList<String>(Arrays.asList("Seizure Disorder","Neuropathy","Insomia"));
		Medicine Gabapentin = new Medicine("Gabapentin", "Neurontin", "", "", PurposeList);
		medList.add(Gabapentin);
		PurposeList = new ArrayList<String>(Arrays.asList("Sleep Aid"));
		Medicine Eszopiclone = new Medicine("Eszopiclone", "Lunesta", "C-IV", "", PurposeList);
		medList.add(Eszopiclone);
		PurposeList = new ArrayList<String>(Arrays.asList("Sleep Aid"));
		Medicine Temazepam = new Medicine("Temazepam", "Restoril", "C-IV", "", PurposeList);
		medList.add(Temazepam);
		PurposeList = new ArrayList<String>(Arrays.asList("Smoking addiction"));
		Medicine Varenicline = new Medicine("Varenicline", "Chantix", "", "", PurposeList);
		medList.add(Varenicline);
		PurposeList = new ArrayList<String>(Arrays.asList("Ulcerative Colitis"));
		Medicine Budesonide = new Medicine("Budesonide", "Uceris", "", "", PurposeList);
		medList.add(Budesonide);
		PurposeList = new ArrayList<String>(Arrays.asList("Urinary Incontinence"));
		Medicine Tolterodine = new Medicine("Tolterodine", "Detrol", "", "", PurposeList);
		medList.add(Tolterodine);
		PurposeList = new ArrayList<String>(Arrays.asList("Urinary Incontinence"));
		Medicine Oxybutynin = new Medicine("Oxybutynin", "Ditropan", "", "", PurposeList);
		medList.add(Oxybutynin);
		PurposeList = new ArrayList<String>(Arrays.asList("Vertigo","Nausea","Vommiting"));
		Medicine Meclizine = new Medicine("Meclizine", "Dramamine", "", "Antihistamine", PurposeList);
		medList.add(Meclizine);
		PurposeList = new ArrayList<String>(Arrays.asList("Pain","Hyperlipidemia","Atherosclerosis of Artery (Aortic, Carotid, Lower Extremity)","Peripheral Vascular Disease"));
		Medicine Aspirin = new Medicine("Aspirin", "Bayer", "", "", PurposeList);
		medList.add(Aspirin);
		PurposeList = new ArrayList<String>(Arrays.asList("Peripheral Vascular Disease"));
		Medicine Pentoxifylline = new Medicine("Pentoxifylline", "Trental", "", "", PurposeList);
		medList.add(Pentoxifylline);


		return medList;
	}

}
