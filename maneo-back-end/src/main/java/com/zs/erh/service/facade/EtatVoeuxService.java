package com.zs.erh.service.facade;

import com.zs.erh.bean.EtatVoeux;
import com.zs.erh.service.vo.EtatVoeuxVo;

import java.util.List;

public interface EtatVoeuxService {

    EtatVoeux save(EtatVoeux etatVoeux);

    EtatVoeux update(EtatVoeux etatVoeux);

    EtatVoeux findByLibelle(String libelle);

    EtatVoeux findByCode(String code);

    int deleteByCode(String code);

    List<EtatVoeux> search(EtatVoeuxVo etatVoeuxVo);

    List<EtatVoeux> findAll();
}
