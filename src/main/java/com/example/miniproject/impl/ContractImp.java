package com.example.miniproject.impl;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.miniproject.models.Contract;

public interface ContractImp {
	List<Contract> getAllContract();
	Contract getContractById(int id);
	void saveContract(Contract o);
	void deleteContract(int id);
}
