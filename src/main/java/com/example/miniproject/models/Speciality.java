package com.example.miniproject.models;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Speciality {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Timestamp creationDate;
	@OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Offer> offer;

}
