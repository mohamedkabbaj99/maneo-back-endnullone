/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.ws.provided.responsable_achat;

import com.zs.erh.bean.Produit;
import com.zs.erh.service.facade.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author admin
 */

@RestController
@RequestMapping("/maneo-rh/responsable-achat/admin/produit")
public class ProduitRARest {
    
    @Autowired
    private ProduitService produitService;

    @GetMapping("/Reference/{ref}")
    public Produit findByReference(@PathVariable String ref) {
        return produitService.findByReference(ref);
    }

    @DeleteMapping("/Reference/{ref}")
    public int deleteByReference(@PathVariable String ref) {
        return produitService.deleteByReference(ref);
    }

    @PostMapping("/")
    public int save(@RequestBody Produit produit) {
        return produitService.save(produit);
    }

    @GetMapping("/")
    public List<Produit> findAll() {
        return produitService.findAll();
    }

    @PostMapping("/delete-multiple-by-reference")
    public int deleteMultiple(@RequestBody List<Produit> produits) {
        return produitService.deleteMultiple(produits);
    }
    
}
