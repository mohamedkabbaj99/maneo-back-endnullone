/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.dao;


import com.zs.erh.bean.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author admin
 */
@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long> {

    public int deleteByCommandeReference(String reference);

    public List<Paiement> findByCommandeReference(String reference);

    public int deleteByTypePaiementReference(String reference);

    public List<Paiement> findByTypePaiementReference(String reference);

    public int deleteByReference(String refPaiement);

    public Paiement findByReference(String refPaiement);

}
