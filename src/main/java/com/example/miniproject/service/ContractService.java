package com.example.miniproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miniproject.dao.CompanyRepository;
import com.example.miniproject.dao.ContractRepository;
import com.example.miniproject.impl.ContractImp;
import com.example.miniproject.models.Contract;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ContractService implements ContractImp {
	
	@Autowired
	ContractRepository cor;
	
	@Override
	public List<Contract> getAllContract() {
		// TODO Auto-generated method stub
		return cor.findAll();
	}

	@Override
	public Contract getContractById(int id) {
		// TODO Auto-generated method stub
		return cor.findById(id).get();
	}

	@Override
	public void saveContract(Contract o) {
		// TODO Auto-generated method stub
		cor.save(o);
	}

	@Override
	public void deleteContract(int id) {
		// TODO Auto-generated method stub
		cor.deleteById(id);

	}
}
