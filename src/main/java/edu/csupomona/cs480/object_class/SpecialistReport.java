package edu.csupomona.cs480.object_class;

import java.util.Date;
import java.util.Hashtable;

public class SpecialistReport {

		//Cardiologist Report
		private Date CardiologistDate;
		private boolean Hyperlipidemia = false;
		private boolean Cardiomyopathy = false;
		private boolean CongestiveHeartFailure = false;
		private boolean AtrialFibrillation = false;
		private boolean AtrialFlutter = false;
		private boolean DeepVeinThrombosis = false;
		private boolean OldMyocardialInfarction = false;
		private boolean AnginaPectoris = false;
		private boolean SupraventricularTachycardia = false;
		private boolean Hypertension = false;
		private String CardiologistOther =  "";
		
		//Ophthalmologist Report
		private Date OphthalmologistDate;
		private String Glaucoma = "";
		private String Retinopathy = "";
		private String Proliferative = "";
		private String NonProliferative = "";
		private String Cataract = "";
		private String OphthalmologistOther = "";
		
		//Pulmonologist Report
		private Date PulmonologistDate;
		private boolean CompulsiveObstructivePulmonaryDisease = false;
		private boolean AsthmaBronchitis = false;
		private boolean PulmonaryEmbolism = false;
		private boolean PulmonaryCysticFibrosis = false;
		private String PulmonologistOther = "";
		
		//Neurologist Report
		private Date NeurologistDate;
		private boolean ParkinsonsDisease = false;
		private boolean SeizureDisorder = false;
		private boolean Epilepsy = false;
		private boolean MigrainHeadache = false;
		private boolean Dementia = false;
		private boolean AlzheimersDisease = false;
		private boolean MultipleSclerosis1 = false;
		private String NeurologistOther = "";
		
		// Psychiatrist/Psychologist Report
		private Date PsychiatristPsychologistDate;
		private boolean MajorDepression = false;
		private boolean AnxietyDisorder = false;
		private boolean Schizophrenia = false;
		private boolean BipolarDisease = false;
		private boolean AlcoholDependence = false;
		private String PsychiatristPsychologistOther = "";
		
		//RheumatologistReport
		private Date RheumatologistDate;
		private boolean RheumatoidArthritis = false;
		private boolean SystemicLupus = false;
		private boolean MultipleSclerosis2 = false;
		private String RheumatologistOther = "";
		
		//Podiatrist Report
		private Date PodiatristDate;
		private String BelowKneeAmputation = "";
		private String AboveKneeAmputation = "";
		private boolean Am = false;
		private boolean PolyNeuropathy = false;
		private boolean MonoNeuropathy = false;
		private boolean Onychomycosis = false;
		private boolean PeripheralVascularDisease = false;
		private String UlcersOfLowerExtremity = "";
		private String PodiatristOther = "";
		
		

		//Getters and Setters for each Variable


		public Date getCardiologistDate() {
			return CardiologistDate;
		}
		public void setCardiologistDate(Date cardiologistDate) {
			CardiologistDate = cardiologistDate;
		}
		public boolean isHyperlipidemia() {
			return Hyperlipidemia;
		}
		public void setHyperlipidemia(boolean hyperlipidemia) {
			Hyperlipidemia = hyperlipidemia;
		}
		public boolean isCardiomyopathy() {
			return Cardiomyopathy;
		}
		public void setCardiomyopathy(boolean cardiomyopathy) {
			Cardiomyopathy = cardiomyopathy;
		}
		public boolean isCongestiveHeartFailure() {
			return CongestiveHeartFailure;
		}
		public void setCongestiveHeartFailure(boolean congestiveHeartFailure) {
			CongestiveHeartFailure = congestiveHeartFailure;
		}
		public boolean isAtrialFibrillation() {
			return AtrialFibrillation;
		}
		public void setAtrialFibrillation(boolean atrialFibrillation) {
			AtrialFibrillation = atrialFibrillation;
		}
		public boolean isAtrialFlutter() {
			return AtrialFlutter;
		}
		public void setAtrialFlutter(boolean atrialFlutter) {
			AtrialFlutter = atrialFlutter;
		}
		public boolean isDeepVeinThrombosis() {
			return DeepVeinThrombosis;
		}
		public void setDeepVeinThrombosis(boolean deepVeinThrombosis) {
			DeepVeinThrombosis = deepVeinThrombosis;
		}
		public boolean isOldMyocardialInfarction() {
			return OldMyocardialInfarction;
		}
		public void setOldMyocardialInfarction(boolean oldMyocardialInfarction) {
			OldMyocardialInfarction = oldMyocardialInfarction;
		}
		public boolean isAnginaPectoris() {
			return AnginaPectoris;
		}
		public void setAnginaPectoris(boolean anginaPectoris) {
			AnginaPectoris = anginaPectoris;
		}
		public boolean isSupraventricularTachycardia() {
			return SupraventricularTachycardia;
		}
		public void setSupraventricularTachycardia(boolean supraventricularTachycardia) {
			SupraventricularTachycardia = supraventricularTachycardia;
		}
		public boolean isHypertension() {
			return Hypertension;
		}
		public void setHypertension(boolean hypertension) {
			Hypertension = hypertension;
		}
		public String getCardiologistOther() {
			return CardiologistOther;
		}
		public void setCardiologistOther(String cardiologistOther) {
			CardiologistOther = cardiologistOther;
		}
		public Date getOphthalmologistDate() {
			return OphthalmologistDate;
		}
		public void setOphthalmologistDate(Date ophthalmologistDate) {
			OphthalmologistDate = ophthalmologistDate;
		}
		public String getGlaucoma() {
			return Glaucoma;
		}
		public void setGlaucoma(String glaucoma) {
			Glaucoma = glaucoma;
		}
		public String getRetinopathy() {
			return Retinopathy;
		}
		public void setRetinopathy(String retinopathy) {
			Retinopathy = retinopathy;
		}
		public String getProliferative() {
			return Proliferative;
		}
		public void setProliferative(String proliferative) {
			Proliferative = proliferative;
		}
		public String getNonProliferative() {
			return NonProliferative;
		}
		public void setNonProliferative(String nonProliferative) {
			NonProliferative = nonProliferative;
		}
		public String getCataract() {
			return Cataract;
		}
		public void setCataract(String cataract) {
			Cataract = cataract;
		}
		public String getOphthalmologistOther() {
			return OphthalmologistOther;
		}
		public void setOphthalmologistOther(String ophthalmologistOther) {
			OphthalmologistOther = ophthalmologistOther;
		}
		public Date getPulmonologistDate() {
			return PulmonologistDate;
		}
		public void setPulmonologistDate(Date pulmonologistDate) {
			PulmonologistDate = pulmonologistDate;
		}
		public boolean isCompulsiveObstructivePulmonaryDisease() {
			return CompulsiveObstructivePulmonaryDisease;
		}
		public void setCompulsiveObstructivePulmonaryDisease(boolean compulsiveObstructivePulmonaryDisease) {
			CompulsiveObstructivePulmonaryDisease = compulsiveObstructivePulmonaryDisease;
		}
		public boolean isAsthmaBronchitis() {
			return AsthmaBronchitis;
		}
		public void setAsthmaBronchitis(boolean asthmaBronchitis) {
			AsthmaBronchitis = asthmaBronchitis;
		}
		public boolean isPulmonaryEmbolism() {
			return PulmonaryEmbolism;
		}
		public void setPulmonaryEmbolism(boolean pulmonaryEmbolism) {
			PulmonaryEmbolism = pulmonaryEmbolism;
		}
		public boolean isPulmonaryCysticFibrosis() {
			return PulmonaryCysticFibrosis;
		}
		public void setPulmonaryCysticFibrosis(boolean pulmonaryCysticFibrosis) {
			PulmonaryCysticFibrosis = pulmonaryCysticFibrosis;
		}
		public String getPulmonologistOther() {
			return PulmonologistOther;
		}
		public void setPulmonologistOther(String pulmonologistOther) {
			PulmonologistOther = pulmonologistOther;
		}
		public Date getNeurologistDate() {
			return NeurologistDate;
		}
		public void setNeurologistDate(Date neurologistDate) {
			NeurologistDate = neurologistDate;
		}
		public boolean isParkinsonsDisease() {
			return ParkinsonsDisease;
		}
		public void setParkinsonsDisease(boolean parkinsonsDisease) {
			ParkinsonsDisease = parkinsonsDisease;
		}
		public boolean isSeizureDisorder() {
			return SeizureDisorder;
		}
		public void setSeizureDisorder(boolean seizureDisorder) {
			SeizureDisorder = seizureDisorder;
		}
		public boolean isEpilepsy() {
			return Epilepsy;
		}
		public void setEpilepsy(boolean epilepsy) {
			Epilepsy = epilepsy;
		}
		public boolean isMigrainHeadache() {
			return MigrainHeadache;
		}
		public void setMigrainHeadache(boolean migrainHeadache) {
			MigrainHeadache = migrainHeadache;
		}
		public boolean isDementia() {
			return Dementia;
		}
		public void setDementia(boolean dementia) {
			Dementia = dementia;
		}
		public boolean isAlzheimersDisease() {
			return AlzheimersDisease;
		}
		public void setAlzheimersDisease(boolean alzheimersDisease) {
			AlzheimersDisease = alzheimersDisease;
		}
		public boolean isMultipleSclerosis1() {
			return MultipleSclerosis1;
		}
		public void setMultipleSclerosis1(boolean multipleSclerosis1) {
			MultipleSclerosis1 = multipleSclerosis1;
		}
		public String getNeurologistOther() {
			return NeurologistOther;
		}
		public void setNeurologistOther(String neurologistOther) {
			NeurologistOther = neurologistOther;
		}
		public Date getPsychiatristPsychologistDate() {
			return PsychiatristPsychologistDate;
		}
		public void setPsychiatristPsychologistDate(Date psychiatristPsychologistDate) {
			PsychiatristPsychologistDate = psychiatristPsychologistDate;
		}
		public boolean isMajorDepression() {
			return MajorDepression;
		}
		public void setMajorDepression(boolean majorDepression) {
			MajorDepression = majorDepression;
		}
		public boolean isAnxietyDisorder() {
			return AnxietyDisorder;
		}
		public void setAnxietyDisorder(boolean anxietyDisorder) {
			AnxietyDisorder = anxietyDisorder;
		}
		public boolean isSchizophrenia() {
			return Schizophrenia;
		}
		public void setSchizophrenia(boolean schizophrenia) {
			Schizophrenia = schizophrenia;
		}
		public boolean isBipolarDisease() {
			return BipolarDisease;
		}
		public void setBipolarDisease(boolean bipolarDisease) {
			BipolarDisease = bipolarDisease;
		}
		public boolean isAlcoholDependence() {
			return AlcoholDependence;
		}
		public void setAlcoholDependence(boolean alcoholDependence) {
			AlcoholDependence = alcoholDependence;
		}
		public String getPsychiatristPsychologistOther() {
			return PsychiatristPsychologistOther;
		}
		public void setPsychiatristPsychologistOther(String psychiatristPsychologistOther) {
			PsychiatristPsychologistOther = psychiatristPsychologistOther;
		}
		public Date getRheumatologistDate() {
			return RheumatologistDate;
		}
		public void setRheumatologistDate(Date rheumatologistDate) {
			RheumatologistDate = rheumatologistDate;
		}
		public boolean isRheumatoidArthritis() {
			return RheumatoidArthritis;
		}
		public void setRheumatoidArthritis(boolean rheumatoidArthritis) {
			RheumatoidArthritis = rheumatoidArthritis;
		}
		public boolean isSystemicLupus() {
			return SystemicLupus;
		}
		public void setSystemicLupus(boolean systemicLupus) {
			SystemicLupus = systemicLupus;
		}
		public boolean isMultipleSclerosis2() {
			return MultipleSclerosis2;
		}
		public void setMultipleSclerosis2(boolean multipleSclerosis2) {
			MultipleSclerosis2 = multipleSclerosis2;
		}
		public String getRheumatologistOther() {
			return RheumatologistOther;
		}
		public void setRheumatologistOther(String rheumatologistOther) {
			RheumatologistOther = rheumatologistOther;
		}
		public Date getPodiatristDate() {
			return PodiatristDate;
		}
		public void setPodiatristDate(Date podiatristDate) {
			PodiatristDate = podiatristDate;
		}
		public String getBelowKneeAmputation() {
			return BelowKneeAmputation;
		}
		public void setBelowKneeAmputation(String belowKneeAmputation) {
			BelowKneeAmputation = belowKneeAmputation;
		}
		public String getAboveKneeAmputation() {
			return AboveKneeAmputation;
		}
		public void setAboveKneeAmputation(String aboveKneeAmputation) {
			AboveKneeAmputation = aboveKneeAmputation;
		}
		public boolean isAm() {
			return Am;
		}
		public void setAm(boolean am) {
			Am = am;
		}
		public boolean isPolyNeuropathy() {
			return PolyNeuropathy;
		}
		public void setPolyNeuropathy(boolean polyNeuropathy) {
			PolyNeuropathy = polyNeuropathy;
		}
		public boolean isMonoNeuropathy() {
			return MonoNeuropathy;
		}
		public void setMonoNeuropathy(boolean monoNeuropathy) {
			MonoNeuropathy = monoNeuropathy;
		}
		public boolean isOnychomycosis() {
			return Onychomycosis;
		}
		public void setOnychomycosis(boolean onychomycosis) {
			Onychomycosis = onychomycosis;
		}
		public boolean isPeripheralVascularDisease() {
			return PeripheralVascularDisease;
		}
		public void setPeripheralVascularDisease(boolean peripheralVascularDisease) {
			PeripheralVascularDisease = peripheralVascularDisease;
		}
		public String getUlcersOfLowerExtremity() {
			return UlcersOfLowerExtremity;
		}
		public void setUlcersOfLowerExtremity(String ulcersOfLowerExtremity) {
			UlcersOfLowerExtremity = ulcersOfLowerExtremity;
		}
		public String getPodiatristOther() {
			return PodiatristOther;
		}
		public void setPodiatristOther(String podiatristOther) {
			PodiatristOther = podiatristOther;
		}
}