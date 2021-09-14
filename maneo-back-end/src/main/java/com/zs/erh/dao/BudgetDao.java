package com.zs.erh.dao;


import com.zs.erh.bean.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetDao extends JpaRepository<Budget, Long> {

    Budget findByBudgetDetail(String budgetDetail);

    Budget findByDescription(String description);

    Budget findByAnnee(Integer annee);

    int deleteByAnnee(Integer annee);

}
