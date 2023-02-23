package com.example.stageex1.service;

import com.example.stageex1.entites.Categorie;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriesServiceTest {
    @Autowired
    private CategoriesService categoriesService;
    @Test
    public void shouldsavecategorywithsuccec() {
      Categorie expectedCategorie = Categorie.builder()
                .id(1L)
                .qt(78L)
                .nom("MM")
                .build();
        Categorie categorieAjoue = categoriesService.ajout(expectedCategorie);
        Assertions.assertNotNull(categorieAjoue);
        Assertions.assertNotNull(categorieAjoue.getId());
        Assertions.assertEquals(expectedCategorie.getQt(),categorieAjoue.getQt());
        Assertions.assertEquals(expectedCategorie.getId(),categorieAjoue.getId());
        Assertions.assertEquals(expectedCategorie.getNom(),categorieAjoue.getNom());

    }
    @Test
    public void shouldupdatecategorywithsuccec() {
        Categorie expectedCategorie = Categorie.builder()
                .id(15L)
                .qt(78L)
                .nom("test")
                .build();
        Categorie categorieAjoue = categoriesService.ajout(expectedCategorie);
        Categorie categorieToUpdate =categorieAjoue;
        categorieToUpdate.setId(2L);
        categorieToUpdate.setNom("JJ");
        categorieToUpdate.setQt(65L);

        Assertions.assertNotNull(categorieToUpdate);
        Assertions.assertNotNull(categorieToUpdate.getId());
        Assertions.assertEquals(categorieToUpdate.getQt(),categorieAjoue.getQt());
        Assertions.assertEquals(categorieToUpdate.getId(),categorieAjoue.getId());
        Assertions.assertEquals(categorieToUpdate.getNom(),categorieAjoue.getNom());

    }
    @Test
    public void shoulddeletecategorywithsuccec() {
        Categorie expectedCategorie = Categorie.builder()
                .id(30L)
                .qt(78L)
                .nom("MM")
                .build();
        Categorie categorieAjoue = categoriesService.ajout(expectedCategorie);


        boolean isDeleted =categoriesService.delete(categorieAjoue.getId());
        Assertions.assertTrue(isDeleted);
        Optional<Categorie> categorie=categoriesService.findById(categorieAjoue.getId());
        assertFalse(categorie.isPresent());




}


    }





