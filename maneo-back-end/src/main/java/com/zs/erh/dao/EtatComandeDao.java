package com.zs.erh.dao;

import com.zs.erh.bean.EtatComande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatComandeDao extends JpaRepository<EtatComande, Long> {
    EtatComande findByLibelle(String libelle);

    EtatComande findByCode(String code);

    int deleteByLibelle(String libelle);

    int deleteByCode(String code);
}
