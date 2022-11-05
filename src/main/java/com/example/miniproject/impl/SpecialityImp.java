package com.example.miniproject.impl;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.miniproject.models.Speciality;

public interface SpecialityImp {
	List<Speciality> getAllSpeciality();
	Speciality getSpecialityById(int id);
	void saveSpeciality(Speciality o);
	void deleteSpeciality(int id);
}
