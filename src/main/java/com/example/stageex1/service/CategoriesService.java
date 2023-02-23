package com.example.stageex1.service;

import com.example.stageex1.entites.Categorie;
import com.example.stageex1.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    private CategorieRepository categorieRepository;

    @Autowired
    public CategoriesService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }


    public  Optional<Categorie> findById(Long id) {
        return categorieRepository.findById(id);
    }

    public  List<Categorie> findall() {
        return categorieRepository.findAll();
    }

    public Categorie ajout(Categorie category) {
        category.setDateCreation(new Timestamp(System.currentTimeMillis()));
        return categorieRepository.save(category);
    }

    public Categorie update(Long id, Categorie c) {
        Categorie existingCategorie = categorieRepository.findById(id).orElse(null);
        if (existingCategorie != null) {
            existingCategorie.setNom(c.getNom());
            existingCategorie.setQt(c.getQt());
            existingCategorie.setDateModif(new Timestamp(System.currentTimeMillis()));
            return categorieRepository.save(existingCategorie);
        }
        return null;
    }

    public boolean delete(Long id) {
        categorieRepository.deleteById(id);
        return true;
    }


}


