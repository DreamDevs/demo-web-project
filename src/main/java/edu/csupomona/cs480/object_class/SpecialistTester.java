package edu.csupomona.cs480.object_class;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class SpecialistTester extends SpecialistReport{

	SpecialistReport spec = new SpecialistReport();
	
	@Test
	public void testSpecialistNames(){
		
		String name = "Cardiologist";
		System.out.println(spec.specialistNames[0]);
		assertEquals(name, spec.specialistNames[0]);
	
	}
	
}
