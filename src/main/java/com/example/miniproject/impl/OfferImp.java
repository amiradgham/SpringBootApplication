package com.example.miniproject.impl;

import java.io.IOException;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;
import com.example.miniproject.models.Offer;


public interface OfferImp {
	List<Offer> getAllOffers();
	Offer getOfferById(int id);
	List<Offer> getOfferBMC(String mc);
	void saveOffer(Offer o);
	void AddOfferWithImage(Offer o, MultipartFile mf) throws IOException;
	byte[] getImage(int id) throws IOException;
	void deleteOffer(int id);
}
