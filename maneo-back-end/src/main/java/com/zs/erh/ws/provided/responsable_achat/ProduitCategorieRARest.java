/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.ws.provided.responsable_achat;

import com.zs.erh.bean.ProduitCategorie;
import com.zs.erh.service.facade.ProduitCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author admin
 */

@RestController
@RequestMapping("/maneo-rh/responsable-achat/produit-categorie")
public class ProduitCategorieRARest {
       @Autowired 
    private ProduitCategorieService produitCategorieService;

    @GetMapping("/reference/{reference}")
    public ProduitCategorie findByReference(@PathVariable String reference) {
        return produitCategorieService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference( @PathVariable String reference) {
        return produitCategorieService.deleteByReference(reference);
    }

    @PostMapping("/")
    public int save(@RequestBody ProduitCategorie produitCategorie) {
        return produitCategorieService.save(produitCategorie);
    }

    @GetMapping("/")
    public List<ProduitCategorie> findAll() {
        return produitCategorieService.findAll();
    }

    @PostMapping("/delete-multiple-by-reference")
    public int deleteMultiple(@RequestBody List<ProduitCategorie> produitCategories) {
        return produitCategorieService.deleteMultiple(produitCategories);
    }
    
}
