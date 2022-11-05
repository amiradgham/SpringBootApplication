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
import com.example.miniproject.impl.CompanyImp;
import com.example.miniproject.models.Company;

@Controller
@RequestMapping("/dashboard/company")
public class CompanyController {
	@Autowired 
	CompanyImp companyImp;
	
	@Autowired 
	 public void setCompanyService(CompanyImp cImp) {
		companyImp = cImp;
   }
	
	@GetMapping("/all")
	public String getAllCompanys(Model m) {
		List<Company>list = companyImp.getAllCompany();
		m.addAttribute("allCompanys", list);
		return "companys";
	}
	
	@GetMapping("/deleteCompany/{id}")
	public String deleteCompany(@PathVariable int id)
	{
		companyImp.deleteCompany(id);
		return "redirect:/companys/all";
	}
	
	@GetMapping("/addCompany")
	public String addCompany(Model m)
	{
		m.addAttribute("companys", companyImp.getAllCompany());
		return "addCompany";
	}
	
	@PostMapping("/saveCompany")
	public String savecompanys(@ModelAttribute Company p)
	{
		companyImp.saveCompany(p);
		return "redirect:/companys/all";
	}
	
	@GetMapping("/editCompany/{id}")
	public String editCompany(Model m, @PathVariable("id") int id)
	{
		m.addAttribute("companys", companyImp.getAllCompany());
		return "addCompany";
	}
}
