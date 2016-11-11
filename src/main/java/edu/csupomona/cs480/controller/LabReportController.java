package edu.csupomona.cs480.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.csupomona.cs480.object_class.LabReport;
import edu.csupomona.cs480.object_class.Person;
import edu.csupomona.cs480.object_class.Radiology;
import edu.csupomona.cs480.object_class.SpecialistReport;
import edu.csupomona.cs480.object_class.rabreport;

@Controller
public class LabReportController {
	
	
//	@RequestMapping(value="/rabreport", method = RequestMethod.GET)
//    public String indexForm(Model model) {
//        model.addAttribute("rabreport", new rabreport());
//        return "rabreport";
//    }
//
//	@RequestMapping(value="/rabreport", method = RequestMethod.POST)
//    public String indexSubmit(@ModelAttribute rabreport rabreport) {
//		System.out.println(rabreport.getCalcium());
//        return "result2";
//    }
	
	@RequestMapping(value="/labreport", method = RequestMethod.GET)
	public String LabReportForm(Model model) {
      model.addAttribute("labreport", new LabReport());
      model.addAttribute("radiology", new Radiology());
      return "labreport";
	}
	
	@RequestMapping(value="/labreport", method = RequestMethod.POST)
	public String LabReportSubmit(@ModelAttribute LabReport labreport, Radiology radiology) {
		return "output";
	}
	
	
	

//	@RequestMapping(value="/input", method = RequestMethod.POST)
//	public String indexSubmit(@ModelAttribute LabReport labreport, Radiology radiology, SpecialistReport specialistreport) {
//		patient.setLabReport(labreport);
//		System.out.println(labreport.getHGBA1C());
////		patient.setRadiologyReport(radiology);
////		patient.setSpecialistReport(specialistreport);
//      return "output";
//  }
	
	
	
//	@RequestMapping(value="/person", method = RequestMethod.GET)
//    public String PersonForm(Model model) {
//        model.addAttribute("medicinepage", new Person());
//        //base page html
//        return "medicinepage";
//    }
//
//	@RequestMapping(value="/person", method = RequestMethod.POST)
//    public String PersonSubmit(@ModelAttribute Person person) {
//		System.out.println(person.getMedicine());
//		//result page html
//		//return "result3";
//        return "result4";
//    }
}
//	
//	
////	@RequestMapping(value="/lab", method = RequestMethod.GET)
////	public String viewLabResults(Model model){
////		model.addAttribute("lab", new LabReport());
////		
//////		List<String> lowHigh = new ArrayList<>();
//////		lowHigh.add("Low");
//////		lowHigh.add("Normal");
//////		lowHigh.add("High");
//////		model.addAttribute("lowHigh", lowHigh);
////		
////		return "lab";
////	}
////	
////	
////	@RequestMapping(value="/lab", method = RequestMethod.POST)
////    public String viewLabResults(@ModelAttribute LabReport lab) {
////        return "result";
////    }
////}
//
//	/*
//	@RequestMapping(value="/lab", method = RequestMethod.POST)
//	public String processLabReport(@ModelAttribute LabReport lab){
//		
//		// implement lab form logic here
//		
//		System.out.println("HGBA1C: " + lab.getHGBA1C());
//		System.out.println("LDL: " + lab.getLDL());
//		System.out.println("Microalbumin: " + lab.isMicroalbumin());
//		System.out.println("GFR: " + lab.getGFR());
//		System.out.println("PTH: " + lab.getPTH());
//		System.out.println("Calcium: " + lab.getCalcium());
//		return "LabReportSubmitted";
//	}
//
//}*/
////
//
//
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestMethod;
////import org.springframework.web.bind.annotation.ModelAttribute;
////import org.springframework.web.bind.annotation.RestController;
////import edu.csupomona.cs480.object_class.Greeting;
////
////
////@RestController
////public class LabReportController {
////
////	@RequestMapping(value="/greeting", method = RequestMethod.GET)
////  public String greetingForm(Model model) {
////      model.addAttribute("greeting", new Greeting());
////      return "greeting";
////  }
////
////	@RequestMapping(value="/greeting", method = RequestMethod.POST)
////  public String greetingSubmit(@ModelAttribute Greeting greeting) {
////      return "result";
////  }
////	
////	@RequestMapping(value="/cs480/lab", method = RequestMethod.GET)
////	public String viewLabResults(Model model){
////		LabReport labForm = new LabReport();
////		model.addAttribute("labForm", labForm);
////		
////		List<String> lowHigh = new ArrayList<>();
////		lowHigh.add("Low");
////		lowHigh.add("Normal");
////		lowHigh.add("High");
////		model.addAttribute("lowHigh", lowHigh);
////		
////		return "Lab Report";
////	}
////	
////
////	@RequestMapping(value="/cs480/lab", method = RequestMethod.POST)
////	public String processLabReport(@ModelAttribute("labForm") LabReport lab){
////		
////		// implement lab form logic here
////		
////		System.out.println("HGBA1C: " + lab.getHGBA1C());
////		System.out.println("LDL: " + lab.getLDL());
////		System.out.println("Microalbumin: " + lab.isMicroalbumin());
////		System.out.println("GFR: " + lab.getGFR());
////		System.out.println("PTH: " + lab.getPTH());
////		System.out.println("Calcium: " + lab.getCalcium());
////		return "LabReportSubmitted";
////	}
//
////}