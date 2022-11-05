package com.example.miniproject.impl;

import java.io.IOException;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;
import com.example.miniproject.models.Company;

public interface CompanyImp {
	List<Company> getAllCompany();
	Company getCompanyById(int id);
	List<Company> getCompanyBMC(String mc);
	void saveCompany(Company o);
	void AddCompanyWithImage(Company o, MultipartFile mf) throws IOException;
	byte[] getImage(int id) throws IOException;
	void deleteCompany(int id);
}
