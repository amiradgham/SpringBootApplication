package com.example.miniproject.restApi;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.miniproject.impl.CompanyImp;
import com.example.miniproject.models.Company;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/company")
public class CompanyRestApi {

@Autowired CompanyImp companyImp ;


@GetMapping("/all")
@CrossOrigin(origins = "http://localhost:4200")
public List<Company> getAllCompany(){
	return companyImp.getAllCompany();
}

@PostMapping(path="/add")
public void AddCompanyWithImage(@RequestParam("company") String p, @RequestParam(value="file",required= false) MultipartFile mf ) throws IOException{
	Company o = new ObjectMapper().readValue(p,Company.class);
	companyImp.AddCompanyWithImage(o,mf);
}

@PutMapping(path="/update")
public void saveCompany(@RequestParam("company") String p ) throws IOException{
	Company o = new ObjectMapper().readValue(p,Company.class);
	companyImp.saveCompany(o);
}

@GetMapping(path="/getImage/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
public byte[] getImage(@PathVariable("id") int id ) throws IOException{
	return companyImp.getImage(id);
}

@DeleteMapping("/delete/{id}")
public void deleteCompany(@PathVariable(value = "id") int id ) {
	companyImp.deleteCompany(id);	
}

}
