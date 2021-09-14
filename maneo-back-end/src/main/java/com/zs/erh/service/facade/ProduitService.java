/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.service.facade;

import com.zs.erh.bean.Produit;

import java.util.List;

/**
 *
 * @author admin
 */
public interface ProduitService {

    public Produit findByReference(String ref);

    public int deleteByReference(String ref);

    public int save(Produit produit);

    public int deleteMultiple(List<Produit> produits);

    List<Produit> findAll();
}
