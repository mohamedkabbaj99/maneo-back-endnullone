package com.zs.erh.service.imple;

import com.zs.erh.bean.EtatComande;
import com.zs.erh.dao.EtatComandeDao;
import com.zs.erh.service.facade.EtatCommandeService;
import com.zs.erh.service.vo.EtatComandeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class EtatCommandeServiceImpl implements EtatCommandeService {
    @Autowired
    private EtatComandeDao etatComandeDao;

    @Autowired
    private EntityManager entityManager;


    @Override
    public EtatComande save(EtatComande etatComande) {
        if (findByLibelle(etatComande.getLibelle())==null)
            etatComandeDao.save(etatComande);
        return etatComande;
    }

    @Override
    public EtatComande update(EtatComande etatComande) {
        return etatComandeDao.save(etatComande);
    }

    @Override
    public List<EtatComande> search(EtatComandeVo etatComandeVo) {
        String q = "select ec from EtatComande ec where 1=1";
        if (etatComandeVo.getLibelle()!=null){
            q += " And ec.libelle LIKE '%" + etatComandeVo.getLibelle() + "%'";
        }
        if (etatComandeVo.getCode()!=null){
            q += " And ec.code LIKE '%" + etatComandeVo.getCode() + "%'";
        }
        return  entityManager.createQuery(q).getResultList();
    }

    @Override
    public List<EtatComande> findAll() {
        return etatComandeDao.findAll();
    }

    @Override
    public EtatComande findByLibelle(String libelle) {
        return etatComandeDao.findByLibelle(libelle);
    }

    @Override
    public EtatComande findByCode(String code) {
        return etatComandeDao.findByCode(code);
    }

    @Override
    public int deleteByLibelle(String libelle) {
        return etatComandeDao.deleteByLibelle(libelle);
    }

    @Override
    public int deleteByCode(String code) {
        return etatComandeDao.deleteByCode(code);
    }
}
