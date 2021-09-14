/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.ws.provided.chef_department;

import com.zs.erh.bean.CommandeItem;
import com.zs.erh.service.facade.CommandeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/maneo-rh/chef-department/commande-item")
public class CommandeItemCDRest {

    @Autowired
    private CommandeItemService commandeItemService;

    @GetMapping("/")
    public List<CommandeItem> findAll() {
        return commandeItemService.findAll();
    }

    @PostMapping("/delete-multiple-by-reference")
    public int deleteMultiple(@RequestBody List<CommandeItem> commandeItems) {
        return commandeItemService.deleteMultiple(commandeItems);
    }

/*
    public CommandeItem findByRef(String reference) {
        return commandeItemService.findByRef(reference);
    }

    public int deleteByRef(String reference) {
        return commandeItemService.deleteByRef(reference);
    }

    public int deleteByCommandeReference(String reference) {
        return commandeItemService.deleteByCommandeReference(reference);
    }

    public List<CommandeItem> findByCommandeReference(String reference) {
        return commandeItemService.findByCommandeReference(reference);
    }

    public int deleteByProduitRef(String reference) {
        return commandeItemService.deleteByProduitRef(reference);
    }

    public List<CommandeItem> findByProduitRef(String reference) {
        return commandeItemService.findByProduitRef(reference);
    }

    public int save(Commande commande, List<CommandeItem> commandeItems) {
        return commandeItemService.save(commande, commandeItems);
    }
*/

}
