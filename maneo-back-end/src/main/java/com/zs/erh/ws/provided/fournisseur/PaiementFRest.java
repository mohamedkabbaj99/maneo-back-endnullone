/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.ws.provided.fournisseur;

import com.zs.erh.bean.Paiement;
import com.zs.erh.service.facade.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/maneo-rh/fournisseur/paiement")
public class PaiementFRest {

    @Autowired
    private PaiementService paiementService;

    @DeleteMapping("/commande/reference/{reference}")
    public int deleteByCommandeReference(@PathVariable String reference) {
        return paiementService.deleteByCommandeReference(reference);
    }

    @GetMapping("/commande/reference/{reference}")
    public List<Paiement> findByCommandeReference(@PathVariable String reference) {
        return paiementService.findByCommandeReference(reference);
    }

    @DeleteMapping("/type-paiement/Reference/{reference}")
    public int deleteByTypePaiementReference(@PathVariable String reference) {
        return paiementService.deleteByTypePaiementReference(reference);
    }

    @GetMapping("/type-paiement/Reference/{reference}")
    public List<Paiement> findByTypePaiementReference(@PathVariable String reference) {
        return paiementService.findByTypePaiementReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String refPaiement) {
        return paiementService.deleteByReference(refPaiement);
    }

    @GetMapping("/reference/{reference}")
    public Paiement findByReference(@PathVariable String refPaiement) {
        return paiementService.findByReference(refPaiement);
    }

    @GetMapping("/")
    public List<Paiement> findAll() {
        return paiementService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Paiement paiement) {
        return paiementService.save(paiement);
    }

    @PostMapping("/delete-multiple-by-reference")
    public int deleteMultiple(@RequestBody List<Paiement> paiements) {
        return paiementService.deleteMultiple(paiements);
    }

}
