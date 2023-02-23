package com.example.stageex1.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomp")
    private String nomp;
    @Column(name = "disponible")
    private boolean disponible;
    @Column(name = "qtp")
    private Long qtp;
    @Column(name = "date_creation_prod")

    private Timestamp dateCreationProd;
    @Column(name = "date_modif_prod")

    private Timestamp dateModifProd;

    @ManyToOne

    @JsonBackReference
    Categorie categorie;
    @Column(insertable=false, updatable=false)
    private Long categorie_id;


}