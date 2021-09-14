package com.zs.erh.dao;


import com.zs.erh.bean.EntiteAdministrative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntiteAdministrativeDao extends JpaRepository<EntiteAdministrative, Long> {

    EntiteAdministrative findByCode(String code);

    EntiteAdministrative findByLibelle(String libelle);

    EntiteAdministrative findByCodeAndLibelle(String code, String libelle);

    int deleteByLibelle(String libelle);


}
