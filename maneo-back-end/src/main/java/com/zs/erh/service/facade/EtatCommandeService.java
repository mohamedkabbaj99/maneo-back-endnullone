package com.zs.erh.service.facade;

import com.zs.erh.bean.EtatComande;
import com.zs.erh.service.vo.EtatComandeVo;


import java.util.List;

public interface EtatCommandeService {
    EtatComande save(EtatComande etatComande);

    EtatComande update(EtatComande etatComande);

    List<EtatComande> search(EtatComandeVo etatComandeVo);

    List<EtatComande> findAll();

    EtatComande findByLibelle(String libelle);

    EtatComande findByCode(String code);

    int deleteByLibelle(String libelle);

    int deleteByCode(String code);
}
