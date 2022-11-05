package com.example.miniproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.miniproject.models.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

}
