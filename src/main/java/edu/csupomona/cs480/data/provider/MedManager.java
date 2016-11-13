package edu.csupomona.cs480.data.provider;

import java.util.List;

import edu.csupomona.cs480.object_class.Medicine;

public interface MedManager {

	/**
	 * Get the medicine information object based on
	 * the given medicineName.
	 * <p>
	 * If the medicine does not exist, simply create
	 * one.
	 *
	 * @param medicineName
	 * @return the Medicine object
	 */
	public Medicine getMed(String medicineName);

	/**
	 * Update the given medicine object and persist it.
	 * <p>
	 * If the medicine does not exist before, this
	 * method will create a new record; otherwise,
	 * it will overwrite whatever is currently
	 * being stored.
	 *
	 * @param medicine object
	 */
	public void updateMed(Medicine med);

	/**
	 * Delete the given medicine from the storage.
	 *
	 * @param userId
	 */
	public void deleteMed(String medicineName);

	/**
	 * List all the current medicines in the storage.
	 *
	 * @return
	 */
	public List<Medicine> listAllMeds();
	
}
