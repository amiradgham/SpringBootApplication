package com.example.miniproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.miniproject.models.Speciality;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {

}
