package com.example.miniproject.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.miniproject.dao.CompanyRepository;
import com.example.miniproject.impl.CompanyImp;
import com.example.miniproject.models.Company;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements CompanyImp{
	@Autowired
	CompanyRepository cr;
	
	@Override
	public List<Company> getAllCompany() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Company getCompanyById(int id) {
		// TODO Auto-generated method stub
		return cr.findById(id).get();
	}

	@Override
	public List<Company> getCompanyBMC(String mc) {
		// TODO Auto-generated method stub
		return cr.findByNameContains(mc);
	}

	@Override
	public void saveCompany(Company o) {
		// TODO Auto-generated method stub
		cr.save(o);
		
	}

	public String saveImage(MultipartFile mf) throws IOException {
		// TODO Auto-generated method stub
		String nomImg = mf.getOriginalFilename();
		String tab[]=nomImg.split("\\.");
		String nomImgModif = tab[0]+System.currentTimeMillis()+"."+tab[1];
		String path = System.getProperty("user.home")+"/images-companys";
		Path p = Paths.get(path, nomImgModif);
		Files.write(p, mf.getBytes());
		return nomImgModif;		
	}
	
	@Override
	public void AddCompanyWithImage(Company o, MultipartFile mf) throws IOException {
		// TODO Auto-generated method stub
		if(mf!=null) {
			o.setPhoto(saveImage(mf));
			cr.save(o);
		}
	}

	@Override
	public byte[] getImage(int id) throws IOException {
		// TODO Auto-generated method stub
		String nomImage = cr.findById(id).get().getPhoto();
		Path p =Paths.get(System.getProperty("user.home")+"/images-companys", nomImage);
		return Files.readAllBytes(p);
	}

	@Override
	public void deleteCompany(int id) {
		// TODO Auto-generated method stub
		cr.deleteById(id);

	}

}
