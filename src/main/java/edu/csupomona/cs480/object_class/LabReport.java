package edu.csupomona.cs480.object_class;

public class LabReport {
	
	float HGBA1C;
	float LDL;
	boolean Microalbumin;
	float GFR;
	String PTH;
	String Calcium;

	public LabReport(float HGBA1C, float LDL, boolean Microalbumin, float GFR, String PTH, String Calcuium) {
		HGBA1C = this.HGBA1C;
		LDL = this.LDL;
		Microalbumin = this.Microalbumin;
		GFR = this.GFR;
		PTH = this.PTH;
		Calcium = this.Calcium;
	}
	
	public float getHGBA1C() {
		return HGBA1C;
	}
	public void setHGBA1C(float hGBA1C) {
		HGBA1C = hGBA1C;
	}
	public float getLDL() {
		return LDL;
	}
	public void setLDL(float lDL) {
		LDL = lDL;
	}
	public boolean isMicroalbumin() {
		return Microalbumin;
	}
	public void setMicroalbumin(boolean microalbumin) {
		Microalbumin = microalbumin;
	}
	public float getGFR() {
		return GFR;
	}
	public void setGFR(float gFR) {
		GFR = gFR;
	}
	public String getPTH() {
		return PTH;
	}
	public void setPTH(String pTH) {
		PTH = pTH;
	}
	public String getCalcium() {
		return Calcium;
	}
	public void setCalcium(String calcium) {
		Calcium = calcium;
	}
}
