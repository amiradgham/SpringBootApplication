package com.example.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.miniproject.impl.SpecialityImp;
import com.example.miniproject.models.Speciality;

@Controller
@RequestMapping("/dashboard/speciality")
public class SpecialityContract {
	
	@Autowired 
	SpecialityImp specialtyImp;
	
	@Autowired 
	 public void setSpecialityService(SpecialityImp sImp) {
		specialtyImp = sImp;
   }

	@GetMapping("/all")
	public String getAllSpeciality(Model m) {
		List<Speciality>list = specialtyImp.getAllSpeciality();
		m.addAttribute("allSpecialitys", list);
		return "specialitys";
	}
	
	@GetMapping("/deleteSpeciality/{id}")
	public String deleteSpeciality(@PathVariable int id)
	{
		specialtyImp.deleteSpeciality(id);
		return "redirect:/specialitys/all";
	}
	
	@GetMapping("/addSpeciality")
	public String addSpeciality(Model m)
	{
		m.addAttribute("specialitys", specialtyImp.getAllSpeciality());
		return "addSpeciality";
	}
	
	@PostMapping("/saveSpeciality")
	public String saveSpeciality(@ModelAttribute Speciality p)
	{
		specialtyImp.saveSpeciality(p);
		return "redirect:/specialitys/all";
	}
	
	@GetMapping("/editSpeciality/{id}")
	public String editSpeciality(Model m, @PathVariable("id") int id)
	{
		m.addAttribute("allSpecialitys", specialtyImp.getAllSpeciality());
		return "addSpeciality";
	}

}
