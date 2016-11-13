package edu.csupomona.cs480;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.csupomona.cs480.object_class.Radiology;

public class RadiologyTest extends Radiology{
	
	Radiology r =  new Radiology();
	
	@Test
	public void testAddDate(){
		r.setAASP(true);
		assertEquals(true, r.isAASP());
	}

}
