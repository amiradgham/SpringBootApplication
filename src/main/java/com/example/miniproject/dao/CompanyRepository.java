package com.example.miniproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.miniproject.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	List<Company> findByNameContains(String nom);

}
