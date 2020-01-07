package com.egovorushkin.onlinepolyclinicapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egovorushkin.onlinepolyclinicapp.entity.Administrator;
import com.egovorushkin.onlinepolyclinicapp.service.AdministratorService;

@Controller
@RequestMapping("/administrators")
public class AdministratorController {

	private AdministratorService administratorService;

	@Autowired
	public AdministratorController(AdministratorService theAdministratorService) {
		administratorService = theAdministratorService;
	}

	// list of administrators
	@GetMapping("/list")
	public String listPatients(Model theModel) {

		// get administrators from database
		List<Administrator> theAdministrators = administratorService.findAll();

		// add to the spring model
		theModel.addAttribute("administrators", theAdministrators);

		return "/administrators/list-administrators";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Administrator theAdministrator = new Administrator();

		theModel.addAttribute("administrator", theAdministrator);

		return "/administrators/administrator-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("administratorId") int theId, Model theModel) {

		// get the administrator from the service
		Administrator theAdministrator = administratorService.findById(theId);

		// set administrator as a model attribute to pre-populate the form
		theModel.addAttribute("administrator", theAdministrator);

		// send over to our form
		return "administrators/administrator-form";
	}

	@PostMapping("/save")
	public String saveAdministrator(@ModelAttribute("administrator") Administrator theAdministrator) {

		// save the administrator
		administratorService.save(theAdministrator);

		// use a redirect to prevent duplicate submissions
		return "redirect:/administrators/list";
	}

	@GetMapping("/delete")
	public String deleteAdministrator(@RequestParam("administratorId") int theId) {

		// delete the administrator
		administratorService.deleteById(theId);

		return "redirect:/administrators/list";
	}
}
