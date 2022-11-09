package com.example.miniproject.restApi;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.miniproject.impl.ContractImp;
import com.example.miniproject.impl.SpecialityImp;
import com.example.miniproject.models.Contract;
import com.example.miniproject.models.Speciality;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/contract")
public class ContractRestApi {
	@Autowired ContractImp contractImp ;

	@GetMapping("/all")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Contract> getAllContract(){
		return contractImp.getAllContract();
	}

	@GetMapping("/byId/{id}")
	public Contract getAllSpeciality(@PathVariable(value = "id") int id ){
		return contractImp.getContractById(id);
	}

	@PostMapping(path="/add")
	public void saveContract(@RequestParam("contract") String p ) throws IOException{
		Contract o = new ObjectMapper().readValue(p,Contract.class);
		contractImp.saveContract(o);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteContract(@PathVariable(value = "id") int id ) {
		contractImp.deleteContract(id);	
	}

}
