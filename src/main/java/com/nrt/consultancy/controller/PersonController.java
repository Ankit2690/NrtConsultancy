package com.nrt.consultancy.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.nrt.consultancy.entities.Person;
import com.nrt.consultancy.services.EmailService;
import com.nrt.consultancy.services.PersonService;
import com.nrt.consultancy.services.SMSService;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;
    
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private SMSService smsService;
    
    //http://localhost:8080/createPerson
    @RequestMapping("/createPerson")
	public String viewCreatePersonForm() {
		return"person";
	}
	
	@RequestMapping(value="/savePerson" , method=RequestMethod.POST)
	public String savePerson(@ModelAttribute("person")Person person,Model model) {
		personService.saveOnePerson(person);
		model.addAttribute("person", person);
		return"Person_info";
	}
	//http://localhost:8080/listPerson
	@RequestMapping("/listPerson")
	public String listPersons(Model model) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons",persons);
		return"list_persons";
	}
 
	@RequestMapping(value="/compose",method=RequestMethod.POST)
	public String selectedOption(@RequestParam("selectedOption") String selectedOption,Model model){
		Person person = personService.getDetails(selectedOption);
		String email = person.getEmail();
		String phone = person.getPhone();
		Long id = person.getId();
		model.addAttribute("email",email);
		model.addAttribute("phone",phone);
		model.addAttribute("id",id);
		return "compose_email";
	}
	
	@RequestMapping(value="/sendEmail",method=RequestMethod.POST)
	public String sendEmail(@RequestParam("to") String to,@RequestParam("sub") String sub,
							@RequestParam("msg") String msg,@RequestParam("phone") String phone,@RequestParam("id")long id,Model model) {
		
		        emailService.sendEmail(to,sub,msg,id);
				model.addAttribute("msg","Email Sent");
				smsService.sendSMS(phone,msg,id);
				model.addAttribute("sms","SMS Sent");
				return"compose_email";
		
		}
	
}

