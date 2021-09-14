package com.zs.erh.service.imple;

import com.zs.erh.bean.Produit;
import com.zs.erh.bean.Voeux;
import com.zs.erh.dao.VoeuxDao;
import com.zs.erh.service.facade.VoeuxService;
import com.zs.erh.service.vo.VoeuxVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class VoeuxServiceImpl implements VoeuxService {

    @Autowired
    private VoeuxDao voeuxDao;
    @Autowired
    private EntityManager entityManager;



    @Override
    public Voeux save(Voeux voeux) {
        if (findByReference(voeux.getReference()) ==null)
            voeuxDao.save(voeux);
        return voeux;
    }

    @Override
    public Voeux update(Voeux voeux) {
        return voeuxDao.save(voeux);
    }

    @Override
    public int deleteByReference(String reference) {
        return voeuxDao.deleteByReference(reference);
    }


    @Override
    public Voeux findByDescription(String description) {
        return voeuxDao.findByDescription(description);
    }

    @Override
    public Voeux findByReference(String reference) {
        return voeuxDao.findByReference(reference);
    }

    @Override
    public List<Voeux> findByBudgetAnneeAndDescription(Integer annee, String description) {
        return voeuxDao.findByBudgetAnneeAndDescription(annee, description);
    }

    @Override
    public List<Voeux> findByEntiteAdministrative(String entiteAdministrative) {
        return voeuxDao.findByEntiteAdministrative(entiteAdministrative);
    }

    @Override
    public List<Voeux> findByEntiteAdministrativeCode(String code) {
        return voeuxDao.findByEntiteAdministrativeCode(code);
    }


    @Override
    public List<Voeux> findByEtatVoeuxLibelle(String libelle) {
        return voeuxDao.findByEtatVoeuxLibelle(libelle);
    }



    @Override
    public List<Voeux> findByVoeuxItemsProduit(Produit produit) {
        return voeuxDao.findByVoeuxItemsProduit(produit);
    }

    @Override
    public List<Voeux> search(VoeuxVo voeuxVo) {
        String q = "select v from Voeux v where 1=1";
        if (voeuxVo.getReference() != null){
            q += " And v.reference LIKE '%" + voeuxVo.getReference() + "%'";
        }
        if (voeuxVo.getDescription() != null){
            q += " And v.description LIKE '%" + voeuxVo.getDescription() + "%'";
        }
return entityManager.createQuery(q).getResultList();
    }

    @Override
    public List<Voeux> findAll() {
        return voeuxDao.findAll();
    }
}
