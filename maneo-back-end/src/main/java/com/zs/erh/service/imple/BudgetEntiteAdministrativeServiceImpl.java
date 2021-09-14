package com.zs.erh.service.imple;

import com.zs.erh.bean.Budget;
import com.zs.erh.bean.BudgetEntiteAdministrative;
import com.zs.erh.dao.BudgetEntiteAdministrativeDao;
import com.zs.erh.service.facade.BudgetEntiteAdministrativeService;
import com.zs.erh.service.facade.BudgetService;
import com.zs.erh.service.facade.EntiteAdministrativeService;
import com.zs.erh.service.vo.BudgetEntiteAdministrativeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class BudgetEntiteAdministrativeServiceImpl implements BudgetEntiteAdministrativeService {
    @Autowired
    private BudgetEntiteAdministrativeDao budgetEntiteAdministrativeDao;
    @Autowired
    private BudgetService budgetService;
    @Autowired
    private EntiteAdministrativeService entiteAdministrativeService;
    @Autowired
    private EntityManager entityManager;


    @Override
    public List<BudgetEntiteAdministrative> findByEntiteAdministrativeLibelle(String libelle) {
        return budgetEntiteAdministrativeDao.findByEntiteAdministrativeLibelle(libelle);
    }

    @Override
    public List<BudgetEntiteAdministrative> findByBudgetAnnee(Integer annee) {
        return budgetEntiteAdministrativeDao.findByBudgetAnnee(annee);
    }

    @Override
    public int deleteByEntiteAdministrativeLibelle(String libelle) {
        return budgetEntiteAdministrativeDao.deleteByEntiteAdministrativeLibelle(libelle);
    }

    @Override
    public int deleteByBudgetAnnee(Integer annee) {
        return budgetEntiteAdministrativeDao.deleteByBudgetAnnee(annee);
    }

    @Override
    public int save(Budget budget, List<BudgetEntiteAdministrative> budgetEntiteAdministratives ) {
        for (BudgetEntiteAdministrative budgetEntiteAdministrative : budgetEntiteAdministratives) {
            Budget budget1 = budgetService.findByAnnee(budgetEntiteAdministrative.getBudget().getAnnee());
            budgetEntiteAdministrative.setBudget(budget1);
            if (budget1 != null) {
                budgetEntiteAdministrative.setBudget(budget);
                budgetEntiteAdministrativeDao.save(budgetEntiteAdministrative);
            }
        }
        return 1;

    }

    @Override
    public BudgetEntiteAdministrative update(BudgetEntiteAdministrative budgetEntiteAdministrative) {
        return budgetEntiteAdministrativeDao.save(budgetEntiteAdministrative);
    }

    @Override
    public List<BudgetEntiteAdministrative> search(BudgetEntiteAdministrativeVo budgetEntiteAdministrativeVo) {
        String q =  "select bea from BudgetEntiteAdministrative bea where 1=1";
        if(budgetEntiteAdministrativeVo.getBudget()!=null){
            q += " And bea.budget LIKE '%" + budgetEntiteAdministrativeVo.getBudget()+"%'";
        }
        if(budgetEntiteAdministrativeVo.getEntiteAdministrative()!=null){
            q += " And bea.entiteAdministrative = '%" + budgetEntiteAdministrativeVo.getEntiteAdministrative()+"%'";
        }
        if(budgetEntiteAdministrativeVo.getBudgetDetail()!=null){
            q += " And bea.budgetDetail = '%" + budgetEntiteAdministrativeVo.getBudgetDetail()+"%'";
        }
        return entityManager.createQuery(q).getResultList();
    }

    @Override
    public List<BudgetEntiteAdministrative> findAll() {
        return budgetEntiteAdministrativeDao.findAll();
    }


}
