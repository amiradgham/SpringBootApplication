package com.example.miniproject.restApi;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.miniproject.impl.OfferImp;
import com.example.miniproject.models.Offer;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/offer")
public class OfferRestApi {
	
@Autowired OfferImp offerImp ;

@GetMapping("/all")
public List<Offer> getAllOffer(){
	return offerImp.getAllOffers();
}

@PostMapping(path="/add")
public void AddOfferWithImage(@RequestParam("offer") String p, @RequestParam(value="file",required= false) MultipartFile mf ) throws IOException{
	Offer o = new ObjectMapper().readValue(p,Offer.class);
	offerImp.AddOfferWithImage(o,mf);
}

@GetMapping("/byId/{id}")
public Offer getOfferById(@PathVariable(value = "id") int id ){
	return offerImp.getOfferById(id);
}

@PutMapping(path="/update")
public void saveOffer(@RequestParam("offer") String p ) throws IOException{
	Offer o = new ObjectMapper().readValue(p,Offer.class);
	offerImp.saveOffer(o);
}

@GetMapping(path="/getImage/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
public byte[] getImage(@PathVariable("id") int id ) throws IOException{
	return offerImp.getImage(id);
}

@DeleteMapping("/delete/{id}")
public void deleteOffer(@PathVariable(value = "id") int id ) {
	offerImp.deleteOffer(id);	
}


}
