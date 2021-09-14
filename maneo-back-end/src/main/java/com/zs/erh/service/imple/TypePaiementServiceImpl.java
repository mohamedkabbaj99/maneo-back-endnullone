/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.service.imple;

import com.zs.erh.bean.TypePaiement;
import com.zs.erh.dao.TypePaiementDao;
import com.zs.erh.service.facade.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author admin
 */
@Service
public class TypePaiementServiceImpl implements TypePaiementService {

    @Autowired
    private TypePaiementDao typePaiementDao;


    @Override
    public int save(TypePaiement typePaiement) {
        TypePaiement loadedTypePaiement = findByReference(typePaiement.getReference());
        if (loadedTypePaiement != null) {
            return -1;
        } else {
            typePaiementDao.save(typePaiement);
            return 1;
        }

    }

    @Override
    public int deleteMultiple(List<TypePaiement> typePaiements) {
        int res = 0;
        for (int i = 0; i < typePaiements.size(); i++) {
            res += deleteByReference(typePaiements.get(i).getReference());
        }
        return res;      }

    @Override
    public TypePaiement findByReference(String ref) {
        return typePaiementDao.findByReference(ref);
    }

    @Override
    public int deleteByReference(String ref) {
        return typePaiementDao.deleteByReference(ref);
    }

    @Override
    public List<TypePaiement> findAll() {
        return typePaiementDao.findAll();
    }

}
