package com.example.stageex1.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import static com.example.Stage_EX1.service.ProduitService.pr;

@RunWith(SpringRunner.class)
@SpringBootTest


class ProduitServiceTest {
    @Autowired
    private ProduitService produitService;
    @Autowired
    private CategoriesService categoriesService ;


   /* @Test
    public void SaveProduitSucces(){
        Categorie categories = new Categorie();
        Categorie savedCategorie = categoriesService.ajout(categories,);
        Produit expectedProduit = Produit.builder()
                .nomp("name prod")
                .QTP(1L)
                .Disponible(true)
                .id(1L)
                .build();
        Produit savedProduit = produitService.AjouterP(expectedProduit);
        assertNotNull(savedProduit);
        assertNotNull(savedProduit.getId());
        assertNotNull(expectedProduit.getQTP() , String.valueOf(savedProduit.getQTP()));
        assertNotNull(expectedProduit.getNomp() , savedProduit.getNomp());


    }

@Test
public void UpdateProduitSucces(){
    Categorie category = categorieRepository.findById(10L).orElse(null);
    assertNotNull(category);
    Produit produit = Pr.findById(14L).orElse(null);
    assertNotNull(produit);
    produit.setNomp("test test test");
    produit.setDisponible(true);
    produit.setId(category);
    produit.setQTP(140L);
    Produit savedProd=produitService.AjouterP(produit);

    Produit upadateProduit = savedProd;
    savedProd = produitService.update(savedProd.getId(), upadateProduit);


    assertNotNull(upadateProduit);
    assertNotNull(upadateProduit.getId());
    assertNotNull(upadateProduit.getQTP() , String.valueOf(savedProd.getQTP()));
    assertNotNull(upadateProduit.getNomp() , savedProd.getNomp());
}
    @Test
    public void DeleteProduitSucces(){
        Categorie categories = new Categorie();
        Produit produit = new Produit();
        Categorie savedCategorie = categoriesService.ajout(categories);
        Produit expectedProduit = Produit.builder()
                .id(12L)
                .nomp("name prod")
                .QTP(1L)
                .Disponible(true)
                .id(savedCategorie)
                .build();
        Produit savedProd=produitService.AjouterP(expectedProduit);

        boolean isDelted= produitService.delete(Math.toIntExact(savedProd.getId()));
        assertTrue(isDelted);
        Optional<Produit> optionalProduit= Pr.findById(savedProd.getId());
        assertFalse(optionalProduit.isPresent());
    }
*/
}