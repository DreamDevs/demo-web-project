package edu.csupomona.cs480.object_class;

import java.util.ArrayList;
import java.util.List;

public class Radiology {

//Cardiac Work-Ups
	
	/* Possible Duplicates to check conditions for under Radiology
	 
		Aortic A.S.P: boolean AASP, ChestDiagnosis.get(0), AbdUSDiagnosis.get(0), AbdADDiagnosis.get(0)
		Aortic Aneurysm: ChestDiagnosis.get(1), AbdUSDiagnosis.get(1), AbdUSDiagnosis.get(1)
		Cardiomegaly: boolean Cardiomegaly, ChestDiagnosis.get(9)
		A.S.P of Lower Extremity:  String ASPofLower, String LowerEDASPofLower
	*/
	
	//Electrocardiogram
	boolean Electrocardiogram = true;
	String ElecDate; 		//Manage with Calendar in js
	String Arrhythmia; 		//Normal, Tachycardia, or Bradycardia
	boolean AFP; 			//Atrial Fibrillation Present
	boolean MI;  			//Myocardial Infarction
	String ElecOther;
//	
	//Echocardiogram
	boolean Echocardiogram = true;
	String EchoDate;
	boolean Cardiomegaly;
	boolean Cardiomyopathy;
	boolean AASP; 			//Aortic A.S.P
	float EF;				//Ejection Fraction %
	String EchoOther;
	
//X-Rays
	
	//Chest X-ray
	boolean ChestXRay = true;
	String ChestDate;
	List<Boolean> ChestDiagnosis = new ArrayList<Boolean>(9){{
		// Aortic A.S.P, Aortic Aneurysm, Aortic Ectasia
		// Aortic Tortuosity, Chronic Obstructive Pulmonary Disease (COPD), Pneumonia
		// Chronic Bronchitis, Pulmonary Cystic Fibrosis, Cardiomegaly

		add(false); add(false); add(false);
		add(false); add(false); add(false);
		add(false); add(false); add(false);
		}};
	String ChestOther;
	
	//Extremity X-ray
	boolean ExtremityXray = true;
	boolean UpperEx = true;
	String UpperDate;
	String ASPofUpper; //Left, Right, or Both
	
	boolean LowerEx = true;
	String LowerDate;
	String ASPofLower; //Left, Right, or Both
	
	boolean OtherEx = true;
	String OtherExDate;
	String OtherExResult;
	
//Ultrasound and Doppler Studies
	
	//Abdominal UltraSound
	boolean AbdUS = true;
	String AbdUSDate;
	List<Boolean> AbdUSDiagnosis = new ArrayList<Boolean>(4){{
		//Aortic A.S.P, Aortic Aneurysm, Nephritis, Renal Artery A.S.P
		add(false); add(false); add(false);add(false);}};
	String AbdUSOther;
	
	//Abdominal Aortic Doppler
	boolean AbdAD = true;
	String abdADDate;
	List<Boolean> AbdADDiagnosis = new ArrayList<Boolean>(2){{
		//Aortic A.S.P, Aortic Aneurysm
		add(false); add(false);}};
	String AbdADOther;
	
	//Lower Extremity Doppler
	boolean LowerED = true;
	String LowerEDDate;
	boolean MonophasicWaves;
	String LowerEDASPofLower; //Left, Right, or Both
	boolean PVD; //Peripheral Vascular Disease
	
	
//CT Scans: On Hold
	
	
	
	public boolean isElectrocardiogram() {
		return Electrocardiogram;
	}
	public void setElectrocardiogram(boolean electrocardiogram) {
		Electrocardiogram = electrocardiogram;
	}
	public String getElecDate() {
		return ElecDate;
	}
	public void setElecDate(String elecDate) {
		ElecDate = elecDate;
	}
	public String getArrhythmia() {
		return Arrhythmia;
	}
	public void setArrhythmia(String arrhthmia) {
		Arrhythmia = arrhthmia;
	}
	public boolean isAFP() {
		return AFP;
	}
	public void setAFP(boolean aFP) {
		AFP = aFP;
	}
	public boolean isMI() {
		return MI;
	}
	public void setMI(boolean mI) {
		MI = mI;
	}
	public String getElecOther() {
		return ElecOther;
	}
	public void setElecOther(String elecOther) {
		ElecOther = elecOther;
	}
	public boolean isEchocardiogram() {
		return Echocardiogram;
	}
	public void setEchocardiogram(boolean echocardiogram) {
		Echocardiogram = echocardiogram;
	}
	public String getEchoDate() {
		return EchoDate;
	}
	public void setEchoDate(String echoDate) {
		EchoDate = echoDate;
	}
	public boolean isCardiomegaly() {
		return Cardiomegaly;
	}
	public void setCardiomegaly(boolean cardiomegaly) {
		Cardiomegaly = cardiomegaly;
	}
	public boolean isCardiomyopathy() {
		return Cardiomyopathy;
	}
	public void setCardiomyopathy(boolean cardiomyopathy) {
		Cardiomyopathy = cardiomyopathy;
	}
	public boolean isAASP() {
		return AASP;
	}
	public void setAASP(boolean aASP) {
		AASP = aASP;
	}
	public float getEF() {
		return EF;
	}
	public void setEF(float eF) {
		EF = eF;
	}
	public String getEchoOther() {
		return EchoOther;
	}
	public void setEchoOther(String echoOther) {
		EchoOther = echoOther;
	}
	public boolean isChestXRay() {
		return ChestXRay;
	}
	public void setChestXRay(boolean chestXRay) {
		ChestXRay = chestXRay;
	}
	public String getChestDate() {
		return ChestDate;
	}
	public void setChestDate(String chestDate) {
		ChestDate = chestDate;
	}
	public List<Boolean> getChestDiagnosis() {
		return ChestDiagnosis;
	}
	public void setChestDiagnosis(List<Boolean> chestDiagnosis) {
		ChestDiagnosis = chestDiagnosis;
	}
	public String getChestOther() {
		return ChestOther;
	}
	public void setChestOther(String chestOther) {
		ChestOther = chestOther;
	}
	public boolean isExtremityXray() {
		return ExtremityXray;
	}
	public void setExtremityXray(boolean extremityXray) {
		ExtremityXray = extremityXray;
	}
	public boolean isUpperEx() {
		return UpperEx;
	}
	public void setUpperEx(boolean upperEx) {
		UpperEx = upperEx;
	}
	public String getUpperDate() {
		return UpperDate;
	}
	public void setUpperDate(String upperDate) {
		UpperDate = upperDate;
	}
	public String getASPofUpper() {
		return ASPofUpper;
	}
	public void setASPofUpper(String aSPofUpper) {
		ASPofUpper = aSPofUpper;
	}
	public boolean isLowerEx() {
		return LowerEx;
	}
	public void setLowerEx(boolean lowerEx) {
		LowerEx = lowerEx;
	}
	public String getLowerDate() {
		return LowerDate;
	}
	public void setLowerDate(String lowerDate) {
		LowerDate = lowerDate;
	}
	public String getASPofLower() {
		return ASPofLower;
	}
	public void setASPofLower(String aSPofLower) {
		ASPofLower = aSPofLower;
	}
	public boolean isOtherEx() {
		return OtherEx;
	}
	public void setOtherEx(boolean otherEx) {
		OtherEx = otherEx;
	}
	public String getOtherExDate() {
		return OtherExDate;
	}
	public void setOtherExDate(String otherExDate) {
		OtherExDate = otherExDate;
	}
	public String getOtherExResult() {
		return OtherExResult;
	}
	public void setOtherExResult(String otherExResult) {
		OtherExResult = otherExResult;
	}
	public boolean isAbdUS() {
		return AbdUS;
	}
	public void setAbdUS(boolean abdUS) {
		AbdUS = abdUS;
	}	
	public String getAbdUSDate() {
		return AbdUSDate;
	}
	public void setAbdUSDate(String abdUSDate) {
		AbdUSDate = abdUSDate;
	}
	public List<Boolean> getAbdUSDiagnosis() {
		return AbdUSDiagnosis;
	}
	public void setAbdUSDiagnosis(List<Boolean> abdUSDiagnosis) {
		AbdUSDiagnosis = abdUSDiagnosis;
	}
	public String getAbdUSOther() {
		return AbdUSOther;
	}
	public void setAbdUSOther(String abdUSOther) {
		AbdUSOther = abdUSOther;
	}
	public boolean isAbdAD() {
		return AbdAD;
	}
	public void setAbdAD(boolean abdAD) {
		AbdAD = abdAD;
	}
	public String getAbdADDate() {
		return abdADDate;
	}
	public void setAbdADDate(String abdADDate) {
		this.abdADDate = abdADDate;
	}
	public List<Boolean> getAbdADDiagnosis() {
		return AbdADDiagnosis;
	}
	public void setAbdADDiagnosis(List<Boolean> abdADDiagnosis) {
		AbdADDiagnosis = abdADDiagnosis;
	}
	public String getAbdADOther() {
		return AbdADOther;
	}
	public void setAbdADOther(String abdADOther) {
		AbdADOther = abdADOther;
	}
	public boolean isLowerED() {
		return LowerED;
	}
	public void setLowerED(boolean lowerED) {
		LowerED = lowerED;
	}
	public String getLowerEDDate() {
		return LowerEDDate;
	}
	public void setLowerEDDate(String lowerEDDate) {
		LowerEDDate = lowerEDDate;
	}
	public boolean isMonophasicWaves() {
		return MonophasicWaves;
	}
	public void setMonophasicWaves(boolean monophasicWaves) {
		MonophasicWaves = monophasicWaves;
	}
	public String getLowerEDASPofLower() {
		return LowerEDASPofLower;
	}
	public void setLowerEDASPofLower(String lowerEDASPofLower) {
		LowerEDASPofLower = lowerEDASPofLower;
	}
	public boolean isPVD() {
		return PVD;
	}
	public void setPVD(boolean pVD) {
		PVD = pVD;
	}
}
