/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.ws.provided.chef_department;

import com.zs.erh.bean.TypePaiement;
import com.zs.erh.service.facade.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** *
 * @author admin
 */@RestController
@RequestMapping("/maneo-rh/chef-department/admin/type-paiement")
public class TypePaiementCDRest {
    
    @Autowired
    private TypePaiementService typePaiementService;

    @GetMapping("/reference/{ref}")
    public TypePaiement findByReference(@PathVariable String ref) {
        return typePaiementService.findByReference(ref);
    }

    @DeleteMapping("/reference/{ref}")
    public int deleteByReference(@PathVariable String ref) {
        return typePaiementService.deleteByReference(ref);
    }

    @PostMapping("/")
    public int save(@RequestBody TypePaiement typePaiement) {
        return typePaiementService.save(typePaiement);
    }

    @GetMapping("/")
    public List<TypePaiement> findAll() {
        return typePaiementService.findAll();
    }

    @PostMapping("/delete-multiple-by-reference")
    public int deleteMultiple(@RequestBody List<TypePaiement> typePaiements) {
        return typePaiementService.deleteMultiple(typePaiements);
    }
}
