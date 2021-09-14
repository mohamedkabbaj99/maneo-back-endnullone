package com.zs.erh.service.facade;

import com.zs.erh.bean.Budget;
import com.zs.erh.service.vo.BudgetVo;


import java.util.List;

public interface BudgetService {

    int save(Budget budget);

    Budget update(Budget budget);

    int deleteByAnnee(Integer annee);

    int deleteByAnnee(List<Budget> budgets);

    Budget findByBudgetDetail(String budgetDetail);

    Budget findByDescription(String description);

    Budget findByAnnee(Integer annee);

    List<Budget> search(BudgetVo budgetVo);

    List<Budget> findAll();

}
