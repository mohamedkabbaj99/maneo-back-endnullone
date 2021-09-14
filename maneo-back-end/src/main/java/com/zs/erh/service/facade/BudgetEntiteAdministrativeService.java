package com.zs.erh.service.facade;

import com.zs.erh.bean.Budget;
import com.zs.erh.bean.BudgetEntiteAdministrative;
import com.zs.erh.service.vo.BudgetEntiteAdministrativeVo;


import java.util.List;

public interface BudgetEntiteAdministrativeService {

    List<BudgetEntiteAdministrative> findByEntiteAdministrativeLibelle(String libelle);

    List<BudgetEntiteAdministrative> findByBudgetAnnee(Integer annee);

    int deleteByEntiteAdministrativeLibelle(String libelle);

    int deleteByBudgetAnnee(Integer annee);

    int save(Budget budget, List<BudgetEntiteAdministrative> budgetEntiteAdministratives);

    BudgetEntiteAdministrative update(BudgetEntiteAdministrative budgetEntiteAdministrative);

    List<BudgetEntiteAdministrative> findAll();

    List<BudgetEntiteAdministrative> search(BudgetEntiteAdministrativeVo budgetEntiteAdministrativeVo);
}
