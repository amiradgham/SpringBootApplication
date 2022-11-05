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
import com.example.miniproject.impl.ContractImp;
import com.example.miniproject.models.Contract;

@Controller
@RequestMapping("/dashboard/contract")
public class ContractController {
	@Autowired 
	ContractImp contractImp;
	
	@Autowired 
	 public void setContractService(ContractImp cImp) {
		contractImp = cImp;
   }

	@GetMapping("/all")
	public String getAllContract(Model m) {
		List<Contract>list = contractImp.getAllContract();
		m.addAttribute("allContracts", list);
		return "contracts";
	}
	
	@GetMapping("/deleteContract/{id}")
	public String deleteContract(@PathVariable int id)
	{
		contractImp.deleteContract(id);
		return "redirect:/contracts/all";
	}
	
	@GetMapping("/addContract")
	public String addContract(Model m)
	{
		m.addAttribute("Contracts", contractImp.getAllContract());
		return "addContract";
	}
	
	@PostMapping("/saveContract")
	public String saveContract(@ModelAttribute Contract p)
	{
		contractImp.saveContract(p);
		return "redirect:/contracts/all";
	}
	
	@GetMapping("/editContract/{id}")
	public String editContract(Model m, @PathVariable("id") int id)
	{
		m.addAttribute("companys", contractImp.getAllContract());
		return "addContract";
	}
}
