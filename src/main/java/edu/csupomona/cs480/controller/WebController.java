package edu.csupomona.cs480.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.csupomona.cs480.data.provider.MedManager;
import edu.csupomona.cs480.object_class.MedString;
import edu.csupomona.cs480.object_class.Person;


@Controller
public class WebController {
	
	@Autowired
	private MedManager medManager;
	private Person patient = new Person();
	

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
		
		String tempMeds = patient.getMedicineString();
		patient = person;
		patient.setMedicineString(tempMeds);
		patient.processMedicine();
		
		patient.createDiagnosisList();
		model.addAttribute("diagnosislist", patient.getDiagnosisList().getDiagnoses());
		model.addAttribute("medicinelist", patient.getMedicines());
		return "redirect:ConfirmPage";
	}
	
	
	@RequestMapping(value="/ConfirmPage", method = RequestMethod.GET)
    public String ConfirmForm(Model model) {
        model.addAttribute("myPatient", patient);
        return "ConfirmPage";
    }
	
	@RequestMapping(value="/ConfirmPage", method = RequestMethod.POST)
    public String FinalizedForm(Model model, @ModelAttribute Person person) {
		
		//setting all the new values from ConfirmPage
		patient = person;
		patient.setFinalizedDiagnoses(person.getFinalizedDiagnoses());
		
		//testing to see if stuff worked
		if(!patient.getFinalizedDiagnoses().isEmpty()){
			for (int i = 0; i < patient.getFinalizedDiagnoses().size();  i++){
				System.out.println(patient.getFinalizedDiagnoses().get(i));
			}
		}
		model.addAttribute("myPatient", patient);
		
        return "MainResult";
    }	
		
	//Page is not meant to be visited, only for retrieving information from client to server
	@RequestMapping(value="/ignoredPage",method=RequestMethod.POST)
	public @ResponseBody String  getSearchUserProfiles(@RequestBody MedString medString, HttpServletRequest request) {
	      
	       try{
	    	   patient.setMedicineString(medString.getMedicineList());    	   
	       }catch(Exception e){
	    	   e.printStackTrace();
	       }
	      
	       return "hello";
	   }
}