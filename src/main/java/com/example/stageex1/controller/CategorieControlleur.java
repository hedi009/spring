package com.example.stageex1.controller;

import com.example.stageex1.entites.Categorie;
import com.example.stageex1.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/Categorie")
public class CategorieControlleur {

    private CategoriesService categoriesService;
    @Autowired
    public void categoriesService(CategoriesService categoriesService) {
        this.categoriesService= categoriesService;
    }

    @GetMapping("/get/{id}")
    public Optional<Categorie>  findById(@PathVariable Long id) {
        return categoriesService.findById(id);
    }
    @GetMapping("/get")
    public List<Categorie> findall() {
        return categoriesService.findall();
    }

    @PostMapping("add")
    public Categorie ajout(@RequestBody Categorie category) {
        return categoriesService.ajout(category);
    }
    @PutMapping("/update/{id}")
    public Categorie update(@PathVariable Long id,@RequestBody Categorie category){
        return categoriesService.update(id,category);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id)
    {
        categoriesService.delete(id);
    }
}
