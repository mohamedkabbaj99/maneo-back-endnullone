/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.service.facade;

import com.zs.erh.bean.ProduitCategorie;

import java.util.List;

/**
 *
 * @author admin
 */
public interface ProduitCategorieService {

    public ProduitCategorie findByReference(String ref);

    public int deleteByReference(String ref);

    public int save(ProduitCategorie produitCategorie);

    public int deleteMultiple(List<ProduitCategorie> produitCategories);

    List<ProduitCategorie> findAll();
}
