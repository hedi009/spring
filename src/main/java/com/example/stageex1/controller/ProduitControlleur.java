package com.example.stageex1.controller;

import com.example.stageex1.entites.Produit;
import com.example.stageex1.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/Produit")
public class ProduitControlleur {

    private ProduitService produitService;
    @Autowired
    public ProduitControlleur(ProduitService produitService) {
        this.produitService= produitService;
    }

   @PostMapping("/add/{id}")
   public Produit save(@RequestBody  Produit produit ,@PathVariable long id){
    return produitService.ajouterP(produit , id);
}




    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id)
    {
        produitService.delete(id);
    }


    @PutMapping("/update/{id}/{idcat}")
    public Produit update(@PathVariable Long id, @RequestBody Produit produit,@PathVariable Long idcat){
        return produitService.update(id,produit,idcat);
    }
    @GetMapping("/get")
    public List<Produit> findall() {
        return produitService.findall();
    }
    @GetMapping("/get/{id}")
    public Optional<Produit> findById(@PathVariable Long id) {
        return produitService.findById(id);
    }
    @GetMapping("/getprodbycat/{id}")
    public List<Produit> produitsByCategorie(@PathVariable Long id){return produitService.produitByCategorie(id);}


}


