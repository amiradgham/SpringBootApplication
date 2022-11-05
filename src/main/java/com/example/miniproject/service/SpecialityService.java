package com.example.miniproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miniproject.dao.CompanyRepository;
import com.example.miniproject.dao.SpecialityRepository;
import com.example.miniproject.impl.SpecialityImp;
import com.example.miniproject.models.Speciality;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class SpecialityService implements SpecialityImp{
	@Autowired
	SpecialityRepository sr;
	
	@Override
	public List<Speciality> getAllSpeciality() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public Speciality getSpecialityById(int id) {
		// TODO Auto-generated method stub
		return sr.findById(id).get();
	}

	@Override
	public void saveSpeciality(Speciality o) {
		// TODO Auto-generated method stub
		sr.save(o);
	}

	@Override
	public void deleteSpeciality(int id) {
		// TODO Auto-generated method stub
		sr.deleteById(id);

	}

}
