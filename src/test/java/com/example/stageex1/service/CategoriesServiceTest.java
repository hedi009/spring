package com.example.stageex1.service;

import com.example.stageex1.entites.Categorie;
import com.example.stageex1.repositories.CategorieRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriesServiceTest {
    @Autowired
    private CategoriesService service;
    @Autowired
    private CategorieRepository categorieRepository;
    @Test
    public void testAddCategorie() throws ParseException {
        Categorie categorie = new Categorie();
        categorie.setNom("Test Category Final");
        categorie.setQt(110L);
        categorie.setDateCreation(new Timestamp(System.currentTimeMillis()));
        Categorie savedCategorie = service.ajout(categorie);
        assertThat(savedCategorie).isNotNull();
        assertThat(savedCategorie.getNom()).isEqualTo("Test Category Final");
        assertThat(savedCategorie.getQt()).isEqualTo(110);
    }
    @Test
    public void testUpdateCategorie() {
        Categorie categorie = new Categorie();
        categorie.setNom("45");
        categorie.setQt(12L);
        Categorie savedCategorie = service.ajout(categorie);
        assertThat(savedCategorie).isNotNull();
        assertThat(savedCategorie.getNom()).isEqualTo("45");
        assertThat(savedCategorie.getQt()).isEqualTo(12);
        Categorie updatedCategorie = new Categorie();

        updatedCategorie.setNom("Test Category Updated");
        updatedCategorie.setQt(10L);

        Categorie modifiedCategorie = service.update(savedCategorie.getId(), updatedCategorie);
        assertThat(modifiedCategorie.getId()).isNotNull();
        assertThat(modifiedCategorie.getNom()).isEqualTo("Test Category Updated");
        assertThat(modifiedCategorie.getQt()).isEqualTo(10);
    }
    @Test
    public void testDeleteCategorie()  {
        Categorie categorie = new Categorie();
        categorie.setNom("Test Category3");
        Categorie savedCategorie = service.ajout(categorie);
        assertThat(savedCategorie).isNotNull();
        assertThat(savedCategorie.getNom()).isEqualTo("Test Category3");

        boolean isDeleted = service.delete(savedCategorie.getId());
        assertTrue(isDeleted);
        Optional<Categorie> optionalCategorie = service.findById(savedCategorie.getId());
        assertFalse(optionalCategorie.isPresent());
    }

    @Test
    public void FindAllSucces() {
        List<Categorie> foundCategorie = service.findall();
        assertNotNull(foundCategorie);

    }
    @Test
    public void testFindCategorieById() {

        Categorie categorie = new Categorie();
        categorie.setNom("Test Category");
        categorie.setQt(5L);
        Categorie savedCategorie = service.ajout(categorie);
        Optional<Categorie> foundCategorie = service.findById(savedCategorie.getId());
        assertThat(foundCategorie).isNotNull();

    }



}








