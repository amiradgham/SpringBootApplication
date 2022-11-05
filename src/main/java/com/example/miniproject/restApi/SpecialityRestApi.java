package com.example.miniproject.restApi;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.miniproject.impl.SpecialityImp;
import com.example.miniproject.models.Speciality;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/api/spaciality")
public class SpecialityRestApi {

@Autowired SpecialityImp specialityImp ;

@GetMapping("/all")
public List<Speciality> getAllSpeciality(){
	return specialityImp.getAllSpeciality();
}

@GetMapping("/byId/{id}")
public List<Speciality> getAllSpeciality(@PathVariable(value = "id")int id ){
	return specialityImp.getAllSpeciality();
}

@PostMapping(path="/add")
public void saveSpeciality(@RequestParam("speciality") String p ) throws IOException{
	Speciality o = new ObjectMapper().readValue(p,Speciality.class);
	specialityImp.saveSpeciality(o);
}

@DeleteMapping("/delete/{id}")
public void deleteOffer(@PathVariable(value = "id") int id ) {
	specialityImp.deleteSpeciality(id);	
}


}
