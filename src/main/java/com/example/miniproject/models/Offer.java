package com.example.miniproject.models;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private String photo;
	private Integer nbPost;
	private String experience;
	private String langue;
	private String genre;
	private String studyLevel;
	private Timestamp publishDate;
	private Timestamp expirationDate;
	@ManyToMany    
	private List<Contract> contract;
	@ManyToOne
	private Company company;
	@ManyToOne
	private Speciality speciality;
}
