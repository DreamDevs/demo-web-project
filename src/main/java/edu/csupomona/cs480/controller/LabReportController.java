package edu.csupomona.cs480.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.csupomona.cs480.data.provider.MedManager;
import edu.csupomona.cs480.object_class.LabReport;
import edu.csupomona.cs480.object_class.MedString;
import edu.csupomona.cs480.object_class.Medicine;
import edu.csupomona.cs480.object_class.Person;
import edu.csupomona.cs480.object_class.Radiology;
import edu.csupomona.cs480.object_class.SpecialistReport;
import edu.csupomona.cs480.object_class.rabreport;

@Controller
public class LabReportController {
	
	@Autowired
	private MedManager medManager;
	private Person patient = new Person();
	private ModelAndView modelAndView = new ModelAndView();
	

	@RequestMapping(value="/mainPage", method = RequestMethod.GET)
	public String MainForm(Model model) {
	 model.addAttribute("patient", new Person());
     return "MainPage";
	}
	
	@RequestMapping(value="/mainPage", method = RequestMethod.POST)
    public String MainSubmit(Model model, @ModelAttribute Person person) {
		
		
		//Delaying the loading page so that AJAX can process the Medicine List
		try{
			Thread.sleep(500);
		}catch (InterruptedException e){
			Thread.currentThread().interrupt();
		}
		
		
		System.out.println("Meds: " + patient.getMedicineString());
		String tempMeds = patient.getMedicineString();
		patient = person;
		System.out.println(patient.getRadiologyReport().getElecDate());
		System.out.println(patient.getSpecialistReport().getCardiologistDate());
		patient.setMedicineString(tempMeds);
		patient.processMedicine();
		System.out.println(person.getLabReport().getHGBA1C());
		
		patient.createDiagnosisList();
		model.addAttribute("diagnosislist", patient.getDiagnosisList().getDiagnoses());
		model.addAttribute("medicinelist", patient.getMedicines());
		return "redirect:ConfirmPage";
	}
	
	
	@RequestMapping(value="/ConfirmPage", method = RequestMethod.GET)
    public String ConfirmForm(Model model) {
		System.out.println("My Meds:" + patient.getMedicineString());
        model.addAttribute("myPatient", patient);
        System.out.println(patient.getMedicineString());
        return "ConfirmPage";
    }
	
	@RequestMapping(value="/ConfirmPage", method = RequestMethod.POST)
    public String FinalizedForm(Model model, @ModelAttribute Person person) {
		
		patient.setFinalizedDiagnoses(person.getFinalizedDiagnoses());
		for (int i = 0; i < patient.getFinalizedDiagnoses().size();  i++){
			System.out.println(patient.getFinalizedDiagnoses().get(i));
		}
		model.addAttribute("myPatient", patient);
		
        return "MainResult";
    }
	
	@RequestMapping(value="/rabreport", method = RequestMethod.GET)
    public String indexForm(Model model) {
        model.addAttribute("rabreport", new rabreport());
        return "rabreport";
    }
	
	@RequestMapping(value="/rabreport", method = RequestMethod.POST)
    public String indexSubmit(@ModelAttribute rabreport rabreport) {
		System.out.println(rabreport.getCalcium());
       return "result2";
 }

	@RequestMapping(value="/labreport", method = RequestMethod.GET)
	public String LabReportForm(Model model) {
      model.addAttribute("labreport", new LabReport());
      return "labreport";
	}
	
	@RequestMapping(value="/labreport", method = RequestMethod.POST)
	public String LabReportSubmit(@ModelAttribute LabReport labreport) {
		System.out.println(labreport.getHGBA1C());
		return "redirect:radiology";
	}
	
	@RequestMapping(value="/radiology", method = RequestMethod.GET)
	public String RadiologyForm(Model model) {
      model.addAttribute("radiology", new Radiology());
      return "radiology";
	}
	
	@RequestMapping(value="/radiology", method = RequestMethod.POST)
	public String RadiologySubmit(@ModelAttribute Radiology radiology) {
		return "redirect:specialistreport";
	}
	
	@RequestMapping(value="/specialistreport", method = RequestMethod.GET)
    public String specialistForm(Model model) {
        model.addAttribute("specialistreport", new SpecialistReport());
        return "specialistreport";
    }

	@RequestMapping(value="/specialistreport", method = RequestMethod.POST)
     public String specialistSubmit(@ModelAttribute(value = "specialistreport") SpecialistReport specialistreport) {
        return "result5";
	}	
		
	//Page is not meant to be visited, only for retrieving information from client to server
	@RequestMapping(value="/ignoredPage",method=RequestMethod.POST)
	public @ResponseBody String  getSearchUserProfiles(@RequestBody MedString medString, HttpServletRequest request) {
	      
	       try{
	    	   patient.setMedicineString(medString.getMedicineList());
	    	   //patient.processMedicine();	    	   
	       }catch(Exception e){
	    	   e.printStackTrace();
	       }
	      
	       return "hello";
	   }
	
	//Medicine Test Page
	@RequestMapping(value="/person", method = RequestMethod.GET)
    public String PersonForm(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("medlist", medManager.listAllMeds());
        //base page html
        return "person";
    }

	@RequestMapping(value="/person", method = RequestMethod.POST)
    public String PersonSubmit(@ModelAttribute Person person) {
		
		patient = new Person(person);	
		//result page html
		return "result3";
    }
}
	
	
	

//	@RequestMapping(value="/input", method = RequestMethod.POST)
//	public String indexSubmit(@ModelAttribute LabReport labreport, Radiology radiology, SpecialistReport specialistreport) {
//		patient.setLabReport(labreport);
//		System.out.println(labreport.getHGBA1C());
////		patient.setRadiologyReport(radiology);
////		patient.setSpecialistReport(specialistreport);
//      return "output";
//  }
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