package edu.csupomona.cs480;

import org.junit.Test;

import edu.csupomona.cs480.controller.WebController;


import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class WebControllerTest extends WebController{

	WebController webController = new WebController();
	
	
	@Test
	public void testRegression(){
		
		String name = "prediction for 1.5 = 2.5";
		assertEquals(name, webController.sampleRegression());
	
	}
	
	
}
