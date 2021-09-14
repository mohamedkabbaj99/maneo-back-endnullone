package com.zs.erh.service.imple;

import com.zs.erh.bean.EntiteAdministrative;
import com.zs.erh.dao.EntiteAdministrativeDao;
import com.zs.erh.service.facade.EntiteAdministrativeService;
import com.zs.erh.service.vo.EntiteAdministrativeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class EntiteAdministrativeServiceImpl implements EntiteAdministrativeService {
    @Autowired
    private EntiteAdministrativeDao entiteAdministrativeDao;
    @Autowired
    private EntityManager entityManager;



    @Override
    public EntiteAdministrative findByCode(String code) {
        return entiteAdministrativeDao.findByCode(code);
    }

    @Override
    public EntiteAdministrative findByLibelle(String libelle) {
        return entiteAdministrativeDao.findByLibelle(libelle);
    }

    @Override
    public EntiteAdministrative findByCodeAndLibelle(String code, String libelle) {
        return entiteAdministrativeDao.findByCodeAndLibelle(code, libelle);
    }

    @Override
    public EntiteAdministrative save(EntiteAdministrative entiteAdministrative) {
        if (findByLibelle(entiteAdministrative.getLibelle())== null)
        entiteAdministrativeDao.save(entiteAdministrative);
        return entiteAdministrative;
    }

    @Override
    public EntiteAdministrative update(EntiteAdministrative entiteAdministrative) {
        return entiteAdministrativeDao.save(entiteAdministrative);
    }

    @Override
    public int deleteByLibelle(String libelle) {
        return entiteAdministrativeDao.deleteByLibelle(libelle);
    }

    @Override
    public int deleteByLibelle(List<EntiteAdministrative> entiteAdministratives) {
        int res=0;
        for (int i = 0; i < entiteAdministratives.size(); i++) {
            res+=deleteByLibelle(entiteAdministratives.get(i).getLibelle());
        }
        return res;
    }

    @Override
    public List<EntiteAdministrative> search(EntiteAdministrativeVo entiteAdministrativeVo) {
        String q =  "select ea from EntiteAdministrative ea where 1=1";
        if(entiteAdministrativeVo.getCode()!=null){
            q += " And ea.code LIKE '%" + entiteAdministrativeVo.getCode()+"%'";
        }
        if(entiteAdministrativeVo.getLibelle()!=null){
            q += " And b.libelle = '%" + entiteAdministrativeVo.getLibelle()+"%'";
        }

        return entityManager.createQuery(q).getResultList();
    }

    @Override
    public List<EntiteAdministrative> findAll() {
        return entiteAdministrativeDao.findAll();
    }
}
