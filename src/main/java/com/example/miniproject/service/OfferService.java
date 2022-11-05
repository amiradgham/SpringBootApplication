package com.example.miniproject.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.miniproject.dao.OfferRepository;
import com.example.miniproject.impl.OfferImp;
import com.example.miniproject.models.Offer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OfferService implements OfferImp{
	@Autowired
	OfferRepository or;
	
	@Override
	public List<Offer> getAllOffers() {
		// TODO Auto-generated method stub
		return or.findAll();
	}

	@Override
	public Offer getOfferById(int id) {
		// TODO Auto-generated method stub
		return or.findById(id).get();
	}

	
	@Override
	public void saveOffer(Offer o) {
		// TODO Auto-generated method stub
		or.save(o);
	}
	
	public String saveImage(MultipartFile mf) throws IOException {
		// TODO Auto-generated method stub
		String nomImg = mf.getOriginalFilename();
		String tab[]=nomImg.split("\\.");
		String nomImgModif = tab[0]+System.currentTimeMillis()+"."+tab[1];
		String path = System.getProperty("user.home")+"/images-Offers";
		Path p = Paths.get(path, nomImgModif);
		Files.write(p, mf.getBytes());
		return nomImgModif;		
	}


	@Override
	public void AddOfferWithImage(Offer o, MultipartFile mf) throws IOException {
		// TODO Auto-generated method stub
		if(mf!=null) {
			o.setPhoto(saveImage(mf));
			or.save(o);
		}
	}

	@Override
	public byte[] getImage(int id) throws IOException {
		// TODO Auto-generated method stub
		String nomImage = or.findById(id).get().getPhoto();
		Path p =Paths.get(System.getProperty("user.home")+"/images-Offers", nomImage);
		return Files.readAllBytes(p);
	}

	@Override
	public void deleteOffer(int id) {
		// TODO Auto-generated method stub
		or.deleteById(id);
		
	}

	@Override
	public List<Offer> getOfferBMC(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

}
