/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.service.facade;

import com.zs.erh.bean.Paiement;

import java.util.List;

/**
 *
 * @author admin
 */
public interface PaiementService {

    public int deleteByCommandeReference(String reference);

    public List<Paiement> findByCommandeReference(String reference);

    public int deleteByTypePaiementReference(String reference);

    public List<Paiement> findByTypePaiementReference(String reference);

    public int deleteByReference(String refPaiement);

    public Paiement findByReference(String refPaiement);

    public int deleteMultiple(List<Paiement> paiements);

    List<Paiement> findAll();

    public int save(Paiement paiement);
}
