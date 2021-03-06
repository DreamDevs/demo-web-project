package edu.csupomona.cs480.object_class;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat (pattern="yyyy-MM-dd") 
	Date ElecDate; 		//Manage with Calendar in js
	String Arrhythmia; 		//Normal, Tachycardia, or Bradycardia
	boolean AFP; 			//Atrial Fibrillation Present
	boolean MI;  			//Myocardial Infarction
	String ElecOther;
	
	//Echocardiogram
	boolean Echocardiogram = true;
	@DateTimeFormat (pattern="yyyy-MM-dd") 
	Date EchoDate;
	boolean Cardiomegaly;
	boolean Cardiomyopathy;
	boolean AASP; 			//Aortic A.S.P
	float EF;				//Ejection Fraction %
	String EchoOther;
	
//X-Rays
	
	//Chest X-ray
	boolean ChestXRay = true;
	@DateTimeFormat (pattern="yyyy-MM-dd")
	Date ChestDate;
	boolean AorticASP = false;
	boolean AorticAneurysm = false;
	boolean AorticEctasia = false;
	boolean AorticTortuosity = false;
	boolean COPD = false;
	boolean Pneumonia = false;
	boolean ChronicBronchitis = false;
	boolean PCF = false;
	boolean Cardiomegaly2 = false;
	String ChestOther;
	
	//Extremity X-ray
	boolean ExtremityXray = true;
	boolean UpperEx = true;
	@DateTimeFormat (pattern="yyyy-MM-dd")
	Date UpperDate;
	String ASPofUpper; //Left, Right, or Both
	
	boolean LowerEx = true;
	@DateTimeFormat (pattern="yyyy-MM-dd")
	Date LowerDate;
	String ASPofLower; //Left, Right, or Both
	
	boolean OtherEx = true;
	@DateTimeFormat (pattern="yyyy-MM-dd")
	Date OtherExDate;
	String OtherExResult;
	
//Ultrasound and Doppler Studies
	
	//Abdominal UltraSound
	boolean AbdUS = true;
	@DateTimeFormat (pattern="yyyy-MM-dd")
	Date AbdUSDate;
	boolean AorticASP2;
	boolean AorticAneurysm2;
	boolean Nephritis;
	boolean RenalArteryASP;
	String AbdUSOther;
	
	//Abdominal Aortic Doppler
	boolean AbdAD = true;
	@DateTimeFormat (pattern="yyyy-MM-dd")
	Date abdADDate;
	boolean AorticASP3;
	boolean AorticAneurysm3;
	String AbdADOther;
	
	//Lower Extremity Doppler
	boolean LowerED = true;
	@DateTimeFormat (pattern="yyyy-MM-dd")
	Date LowerEDDate;
	String MonophasicWaves;
	String LowerEDASPofLower; //Left, Right, or Both
	boolean PVD; //Peripheral Vascular Disease
	
	
	//CT Scans: On Hold
		
	
	public boolean isElectrocardiogram() {
		return Electrocardiogram;
	}
	public void setElectrocardiogram(boolean electrocardiogram) {
		Electrocardiogram = electrocardiogram;
	}
	public Date getElecDate() {
		return ElecDate;
	}
	public void setElecDate(Date elecDate) {
		ElecDate = elecDate;
	}
	public String getArrhythmia() {
		return Arrhythmia;
	}
	public void setArrhythmia(String arrhythmia) {
		Arrhythmia = arrhythmia;
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
	public Date getEchoDate() {
		return EchoDate;
	}
	public void setEchoDate(Date echoDate) {
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
	public Date getChestDate() {
		return ChestDate;
	}
	public void setChestDate(Date chestDate) {
		ChestDate = chestDate;
	}
	public boolean isAorticASP() {
		return AorticASP;
	}
	public void setAorticASP(boolean aorticASP) {
		AorticASP = aorticASP;
	}
	public boolean isAorticAneurysm() {
		return AorticAneurysm;
	}
	public void setAorticAneurysm(boolean aorticAneurysm) {
		AorticAneurysm = aorticAneurysm;
	}
	public boolean isAorticEctasia() {
		return AorticEctasia;
	}
	public void setAorticEctasia(boolean aorticEctasia) {
		AorticEctasia = aorticEctasia;
	}
	public boolean isAorticTortuosity() {
		return AorticTortuosity;
	}
	public void setAorticTortuosity(boolean aorticTortuosity) {
		AorticTortuosity = aorticTortuosity;
	}
	public boolean isCOPD() {
		return COPD;
	}
	public void setCOPD(boolean cOPD) {
		COPD = cOPD;
	}
	public boolean isPneumonia() {
		return Pneumonia;
	}
	public void setPneumonia(boolean pneumonia) {
		Pneumonia = pneumonia;
	}
	public boolean isChronicBronchitis() {
		return ChronicBronchitis;
	}
	public void setChronicBronchitis(boolean chronicBronchitis) {
		ChronicBronchitis = chronicBronchitis;
	}
	public boolean isPCF() {
		return PCF;
	}
	public void setPCF(boolean pCF) {
		PCF = pCF;
	}
	public boolean isCardiomegaly2() {
		return Cardiomegaly2;
	}
	public void setCardiomegaly2(boolean cardiomegaly2) {
		Cardiomegaly2 = cardiomegaly2;
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
	public Date getUpperDate() {
		return UpperDate;
	}
	public void setUpperDate(Date upperDate) {
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
	public Date getLowerDate() {
		return LowerDate;
	}
	public void setLowerDate(Date lowerDate) {
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
	public Date getOtherExDate() {
		return OtherExDate;
	}
	public void setOtherExDate(Date otherExDate) {
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
	public Date getAbdUSDate() {
		return AbdUSDate;
	}
	public void setAbdUSDate(Date abdUSDate) {
		AbdUSDate = abdUSDate;
	}
	public boolean isAorticASP2() {
		return AorticASP2;
	}
	public void setAorticASP2(boolean aorticASP2) {
		AorticASP2 = aorticASP2;
	}
	public boolean isAorticAneurysm2() {
		return AorticAneurysm2;
	}
	public void setAorticAneurysm2(boolean aorticAneurysm2) {
		AorticAneurysm2 = aorticAneurysm2;
	}
	public boolean isNephritis() {
		return Nephritis;
	}
	public void setNephritis(boolean nephritis) {
		Nephritis = nephritis;
	}
	public boolean isRenalArteryASP() {
		return RenalArteryASP;
	}
	public void setRenalArteryASP(boolean renalArteryASP) {
		RenalArteryASP = renalArteryASP;
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
	public Date getAbdADDate() {
		return abdADDate;
	}
	public void setAbdADDate(Date abdADDate) {
		this.abdADDate = abdADDate;
	}
	public boolean isAorticASP3() {
		return AorticASP3;
	}
	public void setAorticASP3(boolean aorticASP3) {
		AorticASP3 = aorticASP3;
	}
	public boolean isAorticAneurysm3() {
		return AorticAneurysm3;
	}
	public void setAorticAneurysm3(boolean aorticAneurysm3) {
		AorticAneurysm3 = aorticAneurysm3;
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
	public Date getLowerEDDate() {
		return LowerEDDate;
	}
	public void setLowerEDDate(Date lowerEDDate) {
		LowerEDDate = lowerEDDate;
	}
	public String getMonophasicWaves() {
		return MonophasicWaves;
	}
	public void setMonophasicWaves(String monophasicWaves) {
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
	