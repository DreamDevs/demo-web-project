package edu.csupomona.cs480.object_class;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class SpecialistTester extends SpecialistReport{

	SpecialistReport spec = new SpecialistReport();
	
	
	@Test
	public void testSpecialistNames(){
		
		String name = "Cardiologist";
		assertEquals(name, spec.specialistNames[0]);
	
	}
	
	@Test
	public void testSpecialistNames2(){
		String name = "Neurologist";
		assertEquals(name, spec.specialistNames[3]);
	}
	
	@Test
	public void testSpecialistNames3(){
		String name = "Podiatrist";
		assertEquals(name, spec.specialistNames[6]);
	}
	
	
	@Test
	public void testDiagnosis(){
		spec.setStatus(0, true);
		assertEquals(true, spec.getStatus(0));
	}
	
	@Test
	public void testDiagnosis2(){
		spec.setStatus(11, true);
		assertEquals(true, spec.getStatus(11));
	}
	
	@Test
	public void testSpecialistTest(){
		spec.setStatus(4,true);
		spec.setSpecialistTruth(0,false);
		assertEquals(false, spec.getStatus(4));
	}
	
	@Test
	public void testSpecialistTest2(){
		spec.setStatus(19,true);
		spec.setSpecialistTruth(3,false);
		assertEquals(false, spec.getStatus(19));
	}
	
	@Test
	public void testAddDate(){
		spec.addDate(spec.getSpecialistName(0), "October 4, 2020");
		assertEquals("October 4, 2020", spec.getDate(spec.getSpecialistName(0)));
	}
	
	@Test
	public void testAddDate2(){
		spec.addDate(spec.getSpecialistName(4), "October 4, 2020");
		assertEquals("October 4, 2020", spec.getDate(spec.getSpecialistName(4)));
	}
	
}
