package com.zs.erh.dao;


import com.zs.erh.bean.BudgetEntiteAdministrative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetEntiteAdministrativeDao extends JpaRepository<BudgetEntiteAdministrative, Long> {

    List<BudgetEntiteAdministrative> findByEntiteAdministrativeLibelle(String libelle);

    List<BudgetEntiteAdministrative> findByBudgetAnnee(Integer annee);

    int deleteByEntiteAdministrativeLibelle(String libelle);

    int deleteByBudgetAnnee(Integer annee);

}
