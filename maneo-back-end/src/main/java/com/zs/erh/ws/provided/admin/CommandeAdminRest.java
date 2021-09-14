/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.Commande;
import com.zs.erh.service.facade.CommandeService;
import com.zs.erh.service.vo.CommandeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/pfe/admin/commande")
public class CommandeAdminRest {

    @Autowired
    private CommandeService commandeService;

    @PostMapping("/search/")
    public List<Commande> search(@RequestBody CommandeVo commandeVo) {
        return commandeService.search(commandeVo);
    }

    @GetMapping("/reference/{reference}")
    public Commande findByReference(@PathVariable String reference) {
        return commandeService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return commandeService.deleteByReference(reference);
    }

    @PostMapping("/")
    public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }

    @PostMapping("/delete-multiple-by-reference")
    public int deleteMultiple(@RequestBody List<Commande> commandes) {
        return commandeService.deleteMultiple(commandes);
    }
}
