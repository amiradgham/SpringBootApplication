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
import org.springframework.web.servlet.view.RedirectView;
import com.example.miniproject.impl.CompanyImp;
import com.example.miniproject.impl.ContractImp;
import com.example.miniproject.impl.OfferImp;
import com.example.miniproject.impl.SpecialityImp;
import com.example.miniproject.models.Offer;

@Controller
@RequestMapping("/dashboard/offers")

public class OfferController {
	
	@Autowired 
	OfferImp offerImp;
	@Autowired 
	CompanyImp companyImp;
	@Autowired 
	ContractImp contractImp;
	@Autowired 
	SpecialityImp speciality;
	
	@Autowired 
	 public void setOfferService(OfferImp oImp) {
		offerImp = oImp;
    }
	
	@GetMapping("/all")
	public String getAllOffers(Model m) {
		List<Offer>list = offerImp.getAllOffers();
		m.addAttribute("allOffers", list);
		return "offers";
	}
	
	@GetMapping("/deleteOffer/{id}")
	public String deleteOffer(@PathVariable int id)
	{
		offerImp.deleteOffer(id);
		return "redirect:/dashboard/offers/all";
	}
	
	@GetMapping("/addOffer")
	public String addOffer(Model m)
	{
		m.addAttribute("companys", companyImp.getAllCompany());
		m.addAttribute("contract", contractImp.getAllContract());
		m.addAttribute("speciality", speciality.getAllSpeciality());
		return "addOffer";
	}
	
	@PostMapping("/saveOffer")
	public RedirectView saveOffer(@ModelAttribute Offer offer)
	{
	 //Offer newOffer = new Offer(Integer.parseInt(offer.getId());
		offerImp.saveOffer(offer);	
		 RedirectView redirectView = new RedirectView();
		    redirectView.setUrl("all");
		    return redirectView;
	}
	
	@GetMapping("/editOffer/{id}")
	public String editOffer(Model m, @PathVariable("id") int id)
	{
		m.addAttribute("companys", companyImp.getAllCompany());
		m.addAttribute("contract", contractImp.getAllContract());
		m.addAttribute("speciality", speciality.getAllSpeciality());
		m.addAttribute("offer", offerImp.getOfferById(id));
		return "addOffer";
	}

}
