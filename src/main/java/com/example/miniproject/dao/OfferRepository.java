package com.example.miniproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.miniproject.models.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {

}
