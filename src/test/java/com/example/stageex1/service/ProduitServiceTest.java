package com.example.stageex1.service;

import com.example.stageex1.controller.ProduitControlleur;
import com.example.stageex1.entites.Categorie;
import com.example.stageex1.entites.Produit;
import com.example.stageex1.repositories.CategorieRepository;
import com.example.stageex1.repositories.ProduitRepository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
 public class ProduitServiceTest {
    @Autowired
    private ProduitService service;
    @Autowired
    ProduitControlleur produitController;
    @Autowired
    private CategoriesService categorieService;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private ProduitRepository produitRepository;


    @Test
    public void SaveProduitSucces(){
        Categorie categories = new Categorie();
        categories.setNom("aa");
        categories.setQt(120L);
        Categorie savedCategorie = categorieService.ajout(categories);
        Produit expectedProduit = Produit.builder()
                .nomp("name prod")
                .qtp(1L)
                .disponible(true)
                .categorie(savedCategorie)
                .build();
        Produit savedProduit = service.ajouterP(expectedProduit, expectedProduit.getCategorie().getId());
        assertNotNull(savedProduit);
        assertNotNull(expectedProduit.getNomp() , savedProduit.getNomp());


    }

    @Test
    public void testUpdateProduct() {
        Produit produit = new Produit();
        Categorie categorie = new Categorie();
        categorie.setNom("Test Category");

        Categorie savedCategorie = categorieService.ajout(categorie);
        produit.setCategorie(savedCategorie);
        Long categorieId = savedCategorie.getId();

        Produit produitSaved = service.ajouterP(produit,categorieId);

        produitSaved.setNomp("Updated Test Product");
        produitSaved.setQtp(20L);
        produitSaved.setDisponible(true);

        service.update(produit.getId(), produitSaved, categorieId);

        Optional<Produit> produitRetrieved = service.findById(produitSaved.getId());
        assertTrue(produitRetrieved.isPresent());
        Produit retrievedProduct = produitRetrieved.get();
        assertEquals("Updated Test Product", retrievedProduct.getNomp());
        assertEquals(true, retrievedProduct.isDisponible());
    }

    @Test
    public void testDeleteProduit() throws ParseException {
        Produit produit = new Produit();
        Categorie categorie = new Categorie();
        categorie.setNom("Test");

        Categorie savedCategorie = categorieService.ajout(categorie);
        produit.setNomp("produit test");
        produit.setDisponible(true);
        produit.setCategorie(savedCategorie);
        produit.setQtp(10L);
        Long categorieId = savedCategorie.getId();
        produit = service.ajouterP(produit,categorieId);
        boolean isDeleted = service.delete(Math.toIntExact(produit.getId()));
        assertTrue(isDeleted);
        Optional<Produit> optionalProduit = produitRepository.findById(produit.getId());
        assertFalse(optionalProduit.isPresent());
    }

    @Test
    public void FindAllSucces() {
        List<Produit> produit =service.findall();
        assertThat(produit).isNotNull();
    }

    @Test
    public void testFindProduitById() {
        Categorie categorie = new Categorie();
        categorie.setNom("Test Category");
        categorie.setQt(5L);
        Categorie savedCategorie = categorieService.ajout(categorie);

        Produit produit = new Produit();
        produit.setNomp("Test Product");
        produit.setQtp(10L);
        produit.setCategorie(savedCategorie);
        Produit savedProduit = service.ajouterP(produit,savedCategorie.getId());


        Optional<Produit> foundProduit = service.findById(savedProduit.getId());
        assertThat(foundProduit).isNotNull();

    }

}