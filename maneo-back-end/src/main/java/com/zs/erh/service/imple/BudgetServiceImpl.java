package com.zs.erh.service.imple;

import com.zs.erh.bean.Budget;
import com.zs.erh.bean.BudgetDetail;
import com.zs.erh.bean.BudgetEntiteAdministrative;
import com.zs.erh.dao.BudgetDao;
import com.zs.erh.service.facade.BudgetDetailService;
import com.zs.erh.service.facade.BudgetEntiteAdministrativeService;
import com.zs.erh.service.facade.BudgetService;
import com.zs.erh.service.vo.BudgetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {
    @Autowired
    private BudgetDao budgetDao;
    @Autowired
    private BudgetDetailService budgetDetailService;
    @Autowired
    private BudgetEntiteAdministrativeService budgetEntiteAdministrativeService;
    @Autowired
    private EntityManager entityManager;

    @Override
    public int save(Budget budget) {
        calculerTotal(budget, budget.getBudgetEntiteAdministratives());
        calculerTotalPaye(budget, budget.getBudgetEntiteAdministratives());
        calculerTotalReserve(budget, budget.getBudgetEntiteAdministratives());
        if (findByAnnee(budget.getAnnee()) != null) {
            return -1;
        } else if (budget.getMtTotal()!= null && budget.getMtPaye()!= null && budget.getMtTotal().subtract(budget.getMtPaye()).doubleValue() < 0) {
            return -2;
        }
        BudgetDetail budgetDetail = budget.getBudgetDetail();
        BigDecimal mtCreditRest = (budgetDetail.getMtInvAffecte().add(budgetDetail.getMtFnctAffecte())).subtract(budgetDetail.getMtInvPaye().add(budgetDetail.getMtFnctPaye())).add(budgetDetail.getMtCreditOuvInv());
        if (budget.getMtTotal().subtract(mtCreditRest).doubleValue() < 0){
            return -4;
        } else {
            updateMtCreditBudgetDetail(budgetDetail, budget);
            budgetDao.save(budget);
            budgetEntiteAdministrativeService.save(budget, budget.getBudgetEntiteAdministratives());
            return 1;
        }
    }


    private void updateMtCreditBudgetDetail(BudgetDetail budgetDetail, Budget budget){
        BigDecimal nvmtCreditRest = budget.getMtTotal().add(budgetDetail.getMtCreditOuvInv());
        budgetDetail.setMtCreditOuvInv(nvmtCreditRest);
        budgetDetailService.update(budgetDetail);
    }

    private void calculerTotal(Budget budget, List<BudgetEntiteAdministrative> budgetEntiteAdministratives) {
        BigDecimal mtTotal = BigDecimal.valueOf(0);
        for (BudgetEntiteAdministrative budgetEntiteAdministrative : budgetEntiteAdministratives) {
            mtTotal = mtTotal.add(budgetEntiteAdministrative.getBudgetDetail().getMtInvAffecte().add(budgetEntiteAdministrative.getBudgetDetail().getMtFnctAffecte()));
        }
        budget.setMtTotal(mtTotal);
    }

    private void calculerTotalPaye(Budget budget, List<BudgetEntiteAdministrative> budgetEntiteAdministratives) {
        BigDecimal mtPaye = BigDecimal.valueOf(0);
        for (BudgetEntiteAdministrative budgetEntiteAdministrative : budgetEntiteAdministratives) {
            mtPaye = mtPaye.add(budgetEntiteAdministrative.getBudgetDetail().getMtInvPaye().add(budgetEntiteAdministrative.getBudgetDetail().getMtFnctPaye()));
        }
        budget.setMtTotal(mtPaye);
    }

    private void calculerTotalReserve(Budget budget, List<BudgetEntiteAdministrative> budgetEntiteAdministratives) {
        BigDecimal mtReserve = BigDecimal.valueOf(0);
        for (BudgetEntiteAdministrative budgetEntiteAdministrative : budgetEntiteAdministratives) {
            mtReserve = mtReserve.add(budgetEntiteAdministrative.getBudgetDetail().getMtInvReserve().add(budgetEntiteAdministrative.getBudgetDetail().getMtFnctReserve()));
        }
        budget.setMtTotal(mtReserve);
    }




    @Override
    public List<Budget> search(BudgetVo budgetVo) {
        String q = "select b from Budget b where 1=1";
        if (budgetVo.getDescription() != null) {
            q += " And b.description LIKE '%" + budgetVo.getDescription() + "%'";
        }
        if (budgetVo.getAnneeMin() != null) {
            q += " And b.annee >= '%" + budgetVo.getAnneeMin() + "%'";
        }
        if (budgetVo.getAnneeMax() != null) {
            q += " And b.annee <= '%" + budgetVo.getAnneeMax() + "%'";
        }
        if (budgetVo.getBudgetDetail() != null) {
            q += " And b.budgetDetail = '%" + budgetVo.getBudgetDetail() + "%'";
        }
        return entityManager.createQuery(q).getResultList();
    }

    @Override
    public Budget update(Budget budget) {
        return budgetDao.save(budget);
    }

    @Override
    public int deleteByAnnee(Integer annee) {
        return budgetDao.deleteByAnnee(annee);
    }


    @Override
    public Budget findByBudgetDetail(String budgetDetail) {
        return budgetDao.findByBudgetDetail(budgetDetail);
    }

    @Override
    public Budget findByDescription(String description) {
        return budgetDao.findByDescription(description);
    }

    @Override
    public Budget findByAnnee(Integer annee) {
        return budgetDao.findByAnnee(annee);
    }

    @Override
    public int deleteByAnnee(List<Budget> budgets) {
        int res = 0;
        for (int i = 0; i < budgets.size(); i++) {
            res += deleteByAnnee(budgets.get(i).getAnnee());
        }
        return res;
    }

    @Override
    public List<Budget> findAll() {
        return budgetDao.findAll();
    }


    /* private void calculerTotal(Budget budget, List<BudgetDetail> budgetDetails) {
        BigDecimal mtTotal = BigDecimal.valueOf(0);
        for (BudgetDetail bd :budgetDetails) {
            mtTotal = mtTotal.add(bd.getMtFnctAffecte().add(bd.getMtInvAffecte()));
        }
        budget.setMtTotal(mtTotal);
    }*/


}
