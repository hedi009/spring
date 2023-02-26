package com.example.stageex1.repositories;


import com.example.stageex1.entites.Categorie;
import com.example.stageex1.entites.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ProduitRepository extends JpaRepository<Produit, Long> {
     List<Produit> findByCategorie(Optional<Categorie> categorie);
     @Query(value = "select id , nomp , disponible,qtp,date_creation_prod,date_modif_prod,categorie_id from Produit ",nativeQuery = true)
     List<Produit> findAll ();
}
