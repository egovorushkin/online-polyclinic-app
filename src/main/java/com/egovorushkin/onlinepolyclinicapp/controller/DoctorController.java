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

import com.egovorushkin.onlinepolyclinicapp.entity.Doctor;
import com.egovorushkin.onlinepolyclinicapp.service.DoctorService;
import com.egovorushkin.onlinepolyclinicapp.service.SpecialityService;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

	private DoctorService doctorService;
	
	@Autowired
	private SpecialityService specialityService;

	@Autowired
	public DoctorController(DoctorService theDoctorService) {
		doctorService = theDoctorService;
	}

	// list of doctors
	@GetMapping("/list")
	public String listDoctors(Model theModel) {

		// get doctors from database
		List<Doctor> theDoctors = doctorService.findAll();

		// add to the spring model
		theModel.addAttribute("doctors", theDoctors);

		return "/doctors/list-doctors";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Doctor theDoctor = new Doctor();

		theModel.addAttribute("doctor", theDoctor);
		theModel.addAttribute("specialities", specialityService.findAll());

		return "/doctors/doctor-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("doctorId") int theId, Model theModel) {

		// get the doctor from the service
		Doctor theDoctor = doctorService.findById(theId);

		// set doctor as a model attribute to pre-populate the form
		theModel.addAttribute("doctor", theDoctor);
		theModel.addAttribute("specialities", specialityService.findAll());

		// send over to our form
		return "doctors/doctor-form";
	}

	@PostMapping("/save")
	public String saveDoctor(@ModelAttribute("doctor") Doctor theDoctor) {

		// save the doctor
		doctorService.save(theDoctor);

		// use a redirect to prevent duplicate submissions
		return "redirect:/doctors/list";
	}

	@GetMapping("/delete")
	public String deleteDoctor(@RequestParam("doctorId") int theId) {

		// delete the doctor
		doctorService.deleteById(theId);

		return "redirect:/doctors/list";
	}

}
