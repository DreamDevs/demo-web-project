package edu.csupomona.cs480.object_class;

import java.util.*;

public class Medicine {
	String GenericName;
	String BrandName;
	String DeaStatus;
	String Classification;
	List<String> Purpose = new ArrayList<String>();
	
	
	public String getGenericName() {
		return GenericName;
	}
	public void setGenericName(String genericName) {
		GenericName = genericName;
	}
	public String getBrandName() {
		return BrandName;
	}
	public void setBrandName(String brandName) {
		BrandName = brandName;
	}
	public String getDeaStatus() {
		return DeaStatus;
	}
	public void setDeaStatus(String deaStatus) {
		DeaStatus = deaStatus;
	}
	public String getClassification() {
		return Classification;
	}
	public void setClassification(String classification) {
		Classification = classification;
	}
	public List<String> getPurpose() {
		return Purpose;
	}
	public void setPurpose(List<String> purpose) {
		Purpose = purpose;
	}
}
 