package edu.csupomona.cs480.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.csupomona.cs480.App;
import edu.csupomona.cs480.data.User;
import edu.csupomona.cs480.data.provider.MedManager;
import edu.csupomona.cs480.data.provider.UserManager;
import edu.csupomona.cs480.object_class.Medicine;

import org.apache.commons.math3.stat.regression.SimpleRegression;


/**
 * This is the controller used by Spring framework.
 * <p>
 * The basic function of this controller is to map
 * each HTTP API Path to the correspondent method.
 *
 */

@RestController
public class WebController {

	/**
	 * When the class instance is annotated with
	 * {@link Autowired}, it will be looking for the actual
	 * instance from the defined beans.
	 * <p>
	 * In our project, all the beans are defined in
	 * the {@link App} class.
	 */
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private MedManager medManager;

	/**
	 * This is a simple example of how the HTTP API works.
	 * It returns a String "OK" in the HTTP response.
	 * To try it, run the web application locally,
	 * in your web browser, type the link:
	 * 	http://localhost:8080/cs480/ping
	 */
	@RequestMapping(value = "/cs480/ping", method = RequestMethod.GET)
	String healthCheck() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "OK";
	}

	/**
	 * This is a simple example of how to use a data manager
	 * to retrieve the data and return it as an HTTP response.
	 * <p>
	 * Note, when it returns from the Spring, it will be
	 * automatically converted to JSON format.
	 * <p>
	 * Try it in your web browser:
	 * 	http://localhost:8080/cs480/user/user101
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.GET)
	User getUser(@PathVariable("userId") String userId) {
		User user = userManager.getUser(userId);
		return user;
	}

	/**
	 * This is an example of sending an HTTP POST request to
	 * update a user's information (or create the user if not
	 * exists before).
	 *
	 * You can test this with a HTTP client by sending
	 *  http://localhost:8080/cs480/user/user101
	 *  	name=John major=CS
	 *
	 * Note, the URL will not work directly in browser, because
	 * it is not a GET request. You need to use a tool such as
	 * curl.
	 *
	 * @param id
	 * @param name
	 * @param major
	 * @return
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.POST)
	User updateUser(
			@PathVariable("userId") String id,
			@RequestParam("name") String name,
			@RequestParam(value = "major", required = false) String major) {
		User user = new User();
		user.setId(id);
		user.setMajor(major);
		user.setName(name);
		userManager.updateUser(user);
		return user;
	}

	/**
	 * This API deletes the user. It uses HTTP DELETE method.
	 *
	 * @param userId
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.DELETE)
	void deleteUser(
			@PathVariable("userId") String userId) {
		userManager.deleteUser(userId);
	}

	/**
	 * This API lists all the users in the current database.
	 *
	 * @return
	 */
	@RequestMapping(value = "/cs480/users/list", method = RequestMethod.GET)
	List<User> listAllUsers() {
		return userManager.listAllUsers();
	}
	
	@RequestMapping(value = "/cs480/meds/list", method = RequestMethod.GET)
	List<Medicine> listAllMeds() {
		return medManager.listAllMeds();
	}

	/*********** Web UI Test Utility **********/
	/**
	 * This method provide a simple web UI for you to test the different
	 * functionalities used in this web service.
	 */
	@RequestMapping(value = "/cs480/home", method = RequestMethod.GET)
	ModelAndView getUserHomepage() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("users", listAllUsers());
		return modelAndView;
	}
	
	
	/********** Say Hello World API ************/
	/**
	 * This method says Hello to the World.
	 */
	@RequestMapping(value= "/cs480/helloworld", method = RequestMethod.GET)
	String HelloWorld(){
		return "Hello World";
	}
	
	/********** Sample API ************/
	/**
	 * This method will be removed sooner or later.
	 */
	@RequestMapping(value= "/cs480/potato", method = RequestMethod.GET)
	String Sample(){
		return "All lifeforms started out as a potato. Potato is love. Potato is life. If you disagree: (╯°□°)╯︵ ┻━┻";
	}
	
	/********** Sample API 2************/
	/**
	 * This method sends a sample string.
	 */
	@RequestMapping(value= "/cs480/string", method = RequestMethod.GET)
	String sampleString(){
		return "Just a string, don't question it.";
	}
	
	/********** Sample API 3************/
	/**
	 * This method sends a sample string.
	 */
	@RequestMapping(value= "/cs480/theProclaimers", method = RequestMethod.GET)
	String theProclaimers(){
		return "I would walk 500 miles and I would walk 500 more.";
	}
	
	@RequestMapping(value= "/cs480/regression", method = RequestMethod.GET)
	public String sampleRegression(){
	// creating regression object, passing true to have intercept term
    SimpleRegression simpleRegression = new SimpleRegression(true);

    // passing data to the model
    // model will be fitted automatically by the class 
    simpleRegression.addData(new double[][] {
            {1, 2},
            {2, 3},
            {3, 4},
            {4, 5},
            {5, 6}
    });

    // querying for model parameters
    System.out.println("slope = " + simpleRegression.getSlope());
    System.out.println("intercept = " + simpleRegression.getIntercept());

    // trying to run model for unknown data
    return ("prediction for 1.5 = " + simpleRegression.predict(1.5));
	
	}

}