/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.service.imple;

import com.zs.erh.bean.Commande;
import com.zs.erh.bean.Paiement;
import com.zs.erh.bean.TypePaiement;
import com.zs.erh.dao.PaiementDao;
import com.zs.erh.service.facade.CommandeService;
import com.zs.erh.service.facade.PaiementService;
import com.zs.erh.service.facade.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author admin
 */
@Service
public class PaiementServiceImpl implements PaiementService {

    @Autowired
    private PaiementDao paiementDao;

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private TypePaiementService typePaiementService;

    @Override
    public int save(Paiement paiement) {
        if (paiementDao.findByReference(paiement.getReference()) != null) {
            return -1;
        }
        Commande commande = commandeService.findByReference(paiement.getCommande().getReference());
        paiement.setCommande(commande);

        TypePaiement typePaiement = typePaiementService.findByReference(paiement.getTypePaiement().getReference());
        paiement.setTypePaiement(typePaiement);

        if (commande == null) {
            return -2;
        }
        if (typePaiement == null) {
            return -3;
        } else if (commande.getTotal().compareTo(commande.getTotalPaye().add(paiement.getMontant())) < 0) {
            return -4;
        } else {
            BigDecimal nvTotalPaye = commande.getTotalPaye().add(paiement.getMontant()) ;
            commande.setTotalPaye(nvTotalPaye);
            paiementDao.save(paiement);
            return 1;
        }

    }

    @Override
    public int deleteByCommandeReference(String reference) {
        return paiementDao.deleteByCommandeReference(reference);

    }

    @Override
    public List<Paiement> findByCommandeReference(String reference) {
        return paiementDao.findByCommandeReference(reference);
    }

    @Override
    public int deleteByTypePaiementReference(String reference) {
        return paiementDao.deleteByTypePaiementReference(reference);
    }

    @Override
    public List<Paiement> findByTypePaiementReference(String reference) {
        return paiementDao.findByTypePaiementReference(reference);
    }

    @Override
    public int deleteByReference(String refPaiement) {
        return paiementDao.deleteByReference(refPaiement);
    }

    @Override
    public Paiement findByReference(String refPaiement) {
        return paiementDao.findByReference(refPaiement);
    }

    @Override
    public int deleteMultiple(List<Paiement> paiements) {
        int res = 0;
        for (int i = 0; i < paiements.size(); i++) {
            res += deleteByReference(paiements.get(i).getReference());
        }
        return res;
    }


    @Override
    public List<Paiement> findAll() {
        return paiementDao.findAll();
    }

}
