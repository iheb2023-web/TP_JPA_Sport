package com.iheb.entities;

import javax.persistence.*;

@Entity
public class Sport{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idSport;
    private String nomSport;
    private String description;
    private String dateFondation;


    public Long getIdSport() {
        return idSport;
    }

    public void setIdSport(Long idSport) {
        this.idSport = idSport;
    }

    public String getNomSport() {
        return nomSport;
    }

    public void setNomSport(String nomSport) {
        this.nomSport = nomSport;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateFondation() {
        return dateFondation;
    }

    public void setDateFondation(String dateFondation) {
        this.dateFondation = dateFondation;
    }

	
}
