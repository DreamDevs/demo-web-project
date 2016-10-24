package edu.csupomona.cs480.util;

import java.io.File;
import java.net.URL;


/**
 * This is an utility class to help file locating.
 */
public class ResourceResolver {

	/** The base folder to store all the data used by this project. */
	private static final String BASE_DIR = System.getProperty("user.home") + "/cs480";
	static File file = new File("");
	private static final String STATIC_DIR = file.getAbsolutePath() + "/src/main/resources/static/js";

	/**
	 * Get the file used to store the user object JSON
	 *
	 * @param userId
	 * @return
	 */
	public static File getUserFile() {
		File file = new File(BASE_DIR + "/" + "user-map.json");
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		return file;
	}
	
	/**
	 * Get the file used to store the med object JSON
	 *
	 * @param MedicineName
	 * @return
	 */
	public static File getMedFile() {
		File file = new File(STATIC_DIR + "/" + "medList.json");
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		return file;
	}
}
