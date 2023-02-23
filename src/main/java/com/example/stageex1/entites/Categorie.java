package com.example.stageex1.entites;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Categorie  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "nom")
    private String nom;
    @Column(name = "qt")
    private Long qt;
    @Column(name = "date_creation")
    private Timestamp dateCreation;
    @Column(name = "date_modif")
    private Timestamp dateModif ;
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Produit> produit  ;

}
