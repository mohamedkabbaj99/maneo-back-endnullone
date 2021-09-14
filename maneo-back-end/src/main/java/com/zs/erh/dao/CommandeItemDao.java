/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.dao;

import com.zs.erh.bean.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author admin
 */
@Repository
public interface CommandeItemDao extends JpaRepository<CommandeItem, Long> {

    public CommandeItem findByReference(String reference);

    public int deleteByReference(String reference);

    public int deleteByCommandeReference(String reference);

    public List<CommandeItem> findByCommandeReference(String reference);

    public int deleteByProduitReference(String reference);

    public List<CommandeItem> findByProduitReference(String reference);

}
