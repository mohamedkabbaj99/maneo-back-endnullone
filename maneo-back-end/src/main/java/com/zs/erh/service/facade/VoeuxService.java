package com.zs.erh.service.facade;

import com.zs.erh.bean.Produit;
import com.zs.erh.bean.Voeux;
import com.zs.erh.service.vo.VoeuxVo;

import java.util.List;

public interface VoeuxService {

    Voeux save(Voeux voeux);

    Voeux update(Voeux voeux);

    int deleteByReference(String reference);

    Voeux findByDescription(String description);

    Voeux findByReference(String reference);

    List<Voeux> findByBudgetAnneeAndDescription(Integer annee, String description);

    List<Voeux> findByEntiteAdministrative(String entiteAdministrative);

    List<Voeux> findByEntiteAdministrativeCode(String code);

    List<Voeux> findByEtatVoeuxLibelle(String libelle);

    List<Voeux> findByVoeuxItemsProduit(Produit produit);

    List<Voeux> search(VoeuxVo voeuxVo);

    List<Voeux> findAll();
}
