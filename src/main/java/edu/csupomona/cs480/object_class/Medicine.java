package edu.csupomona.cs480.object_class;

import java.util.*;

public class Medicine {
	String BothNames;
	String GenericName;
	String BrandName;
	String DeaStatus;
	String Classification;
	List<String> Purpose = new ArrayList<String>();
	
	//Medicine DrugName = new Medicine ("DrugName", "BrandName", "DEA", "Classification", PurposeList);
	public Medicine(String GenericName, String BrandName, String DeaStatus, String Classification, List<String> Purpose){
		BothNames = GenericName + " - " + BrandName;
		this.GenericName = GenericName;
		this.BrandName = BrandName;
		this.DeaStatus = DeaStatus;
		this.Classification = Classification;
		this.Purpose = Purpose;
	}
	
	//For Deep Copy 
	public Medicine(Medicine med){
		this.BothNames = med.BothNames;
		this.GenericName = med.GenericName;
		this.BrandName = med.BrandName;
		this.DeaStatus = med.DeaStatus;
		this.Classification = med.Classification;
		this.Purpose = med.Purpose;
	}
	
	public String getBothNames() {
		return BothNames;
	}
	public void setBothNames(String bothNames) {
		BothNames = bothNames;
	}
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
	
	public static Comparator<Medicine> sortByGName(){
		Comparator c = new Comparator<Medicine>(){
			@Override
			public int compare(Medicine a, Medicine b){
				return a.GenericName.compareTo(b.GenericName);
			}
		};
		return c;
	}
}
 