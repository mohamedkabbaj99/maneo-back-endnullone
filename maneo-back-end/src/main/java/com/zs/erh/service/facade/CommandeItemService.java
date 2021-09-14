/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.service.facade;

import com.zs.erh.bean.Commande;
import com.zs.erh.bean.CommandeItem;

import java.util.List;

/**
 *
 * @author admin
 */
public interface CommandeItemService {

    public CommandeItem findByReference(String reference);

    public int deleteByReference(String reference);

    public int deleteByCommandeReference(String reference);

    public List<CommandeItem> findByCommandeReference(String reference);

    public int deleteByProduitReference(String reference);

    public List<CommandeItem> findByProduitReference(String reference);

    public int save(Commande commande, List<CommandeItem> commandeItems);

    public int deleteMultiple(List<CommandeItem> commandeItems);

    List<CommandeItem> findAll();
}
