package com.zs.erh.service.imple;

import com.zs.erh.bean.EtatVoeux;
import com.zs.erh.dao.EtatVoeuxDao;
import com.zs.erh.service.facade.EtatVoeuxService;
import com.zs.erh.service.vo.EtatVoeuxVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class EtatVoeuxServiceImpl implements EtatVoeuxService {

    @Autowired
    private EtatVoeuxDao etatVoeuxDao;

    @Autowired
    private EntityManager entityManager;
    @Override
    public EtatVoeux save(EtatVoeux etatVoeux) {
   if(findByLibelle(etatVoeux.getLibelle()) == null)
       etatVoeuxDao.save(etatVoeux);
   return etatVoeux;
    }

    @Override
    public EtatVoeux update(EtatVoeux etatVoeux) {
        return etatVoeuxDao.save(etatVoeux);
    }

    @Override
    public EtatVoeux findByLibelle(String libelle) {
        return etatVoeuxDao.findByLibelle(libelle);
    }

    @Override
    public EtatVoeux findByCode(String code) {
        return etatVoeuxDao.findByCode(code);
    }

    @Override
    public int deleteByCode(String code) {
        return etatVoeuxDao.deleteByCode(code);
    }

    @Override
    public List<EtatVoeux> search(EtatVoeuxVo etatVoeuxVo) {
        String q = "select ev from EtatVoeux ev where 1=1";
        if (etatVoeuxVo.getLibelle()!=null){
            q += " And ev.libelle LIKE '%" + etatVoeuxVo.getLibelle() + "%'";
        }
        if (etatVoeuxVo.getCode()!=null){
            q += " And ev.code = '%" + etatVoeuxVo.getCode() + "%'";
        }
        return  entityManager.createQuery(q).getResultList();
    }

    @Override
    public List<EtatVoeux> findAll() {
        return etatVoeuxDao.findAll();
    }
}
