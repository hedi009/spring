package com.example.stageex1.service;


import com.example.stageex1.entites.Categorie;
import com.example.stageex1.entites.Produit;
import com.example.stageex1.repositories.CategorieRepository;
import com.example.stageex1.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


@Service
public class ProduitService {

     @Autowired
     public  ProduitRepository produitRepository;
     @Autowired
     public CategorieRepository categorieRepository;
    @Autowired
    public ProduitService(ProduitRepository produitRepository)
    {
        this.produitRepository= produitRepository;
    }

    public Produit ajouterP (Produit produit , long id){

        produit.getCategorie();

       Categorie categorie = categorieRepository.findById(id).orElse(null);
        produit.setCategorie(categorie);
        produit.setDateCreationProd(new Timestamp(System.currentTimeMillis()));


        return produitRepository.save(produit);
    }



    public boolean delete(int id)
    {
        produitRepository.deleteById((long) id);
        return true;
    }


    public Produit update (Long id , Produit produit,Long idCat)
    {
        produit.getCategorie();
        Categorie categorie=categorieRepository.findById(idCat).orElse(null);
        produit.setCategorie(categorie);
        Produit existingproduit = produitRepository.findById(id).orElse(null);
        if (existingproduit != null) {
            existingproduit.setNomp(produit.getNomp());
            existingproduit.setDisponible(produit.isDisponible());
            existingproduit.setQtp(produit.getQtp());
            existingproduit.setDateModifProd(new Timestamp(System.currentTimeMillis()));
            return produitRepository.save(existingproduit);
        }
        return null;
    }
    public List<Produit> findall()
    {

        return produitRepository.findAll();
    }
    public Optional<Produit> findById(Long id)
    {
        return produitRepository.findById(id);
    }
    public List<Produit> produitByCategorie(Long idCategorie) {
        Categorie categorie = categorieRepository.findById(idCategorie).get();
        return produitRepository.findByCategorie(categorie);
    }




}


