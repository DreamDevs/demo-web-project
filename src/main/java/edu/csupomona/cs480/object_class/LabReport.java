package edu.csupomona.cs480.object_class;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class LabReport {
	
	@DateTimeFormat (pattern="yyyy-MM-dd")
	Date   date;
	double HGBA1C;
	double LDL;
	boolean Microalbumin;
	double GFR;
	String PTH;
	String Calcium;

	public double getHGBA1C() {
		return HGBA1C;
	}
	public void setHGBA1C(double hGBA1C) {
		HGBA1C = hGBA1C;
	}
	public double getLDL() {
		return LDL;
	}
	public void setLDL(double lDL) {
		LDL = lDL;
	}
	public boolean isMicroalbumin() {
		return Microalbumin;
	}
	public void setMicroalbumin(boolean microalbumin) {
		Microalbumin = microalbumin;
	}
	public double getGFR() {
		return GFR;
	}
	public void setGFR(double gFR) {
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
