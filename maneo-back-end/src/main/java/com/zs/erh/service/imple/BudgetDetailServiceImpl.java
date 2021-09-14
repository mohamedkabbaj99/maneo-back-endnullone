package com.zs.erh.service.imple;


import com.zs.erh.bean.BudgetDetail;
import com.zs.erh.dao.BudgetDetailDao;
import com.zs.erh.service.facade.BudgetDetailService;
import com.zs.erh.service.facade.BudgetService;
import com.zs.erh.service.vo.BudgetDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@Service
public class BudgetDetailServiceImpl implements BudgetDetailService {
    @Autowired
    private BudgetDetailDao budgetDetailDao;
    @Autowired
    private BudgetService budgetService;
    @Autowired
    private EntityManager entityManager;


    @Override
    public int deleteByMtInvReserveReliquat(BigDecimal mtInvReserveReliquat) {
        return budgetDetailDao.deleteByMtInvReserveReliquat(mtInvReserveReliquat);
    }

    @Override
    public int deleteByMtInvPayeReliquat(BigDecimal mtInvPayeReliquat) {
        return budgetDetailDao.deleteByMtInvPayeReliquat(mtInvPayeReliquat);
    }

    @Override
    public void deleteById(Long id) {
        budgetDetailDao.deleteById(id);
    }

    @Transactional
    @Override
    public int deleteByMtInvReserveReliquat(List<BudgetDetail> budgetDetails) {
        int res = 0;
        for (int i = 0; i < budgetDetails.size(); i++) {
            res += deleteByMtInvPayeReliquat(budgetDetails.get(i).getMtInvPayeReliquat());
        }
        return res;
    }


    @Override
    public BudgetDetail findByMtInvAffecteAndMtFnctAffecte(BigDecimal mtInvAffecte, BigDecimal mtFnctAffecte) {
        return budgetDetailDao.findByMtInvAffecteAndMtFnctAffecte(mtInvAffecte, mtFnctAffecte);
    }


    @Override
    public int save(BudgetDetail budgetDetail) {
        BudgetDetail bd = budgetDetailDao.findByMtInvAffecteAndMtFnctAffecte(budgetDetail.getMtInvAffecte(), budgetDetail.getMtFnctAffecte());
        if (bd != null) return -1;
        else {
            budgetDetailDao.save(budgetDetail);
            return 1;
        }
    }

    @Override
    public BudgetDetail update(BudgetDetail budgetDetail) {
        return budgetDetailDao.save(budgetDetail);
    }

    @Override
    public List<BudgetDetail> search(BudgetDetailVo budgetDetailVo) {
        String q = "select bd from BudgetDetail bd where 1=1";
        if (budgetDetailVo.getId() != null) {
            q += " And bd.id LIKE '%" + budgetDetailVo.getId() + "%'";
        }
        if (budgetDetailVo.getMtInvPayeReliquatMin() != null) {
            q += " And bd.mtInvPayeReliquat >= " + budgetDetailVo.getMtInvPayeReliquatMin();
        }
        if (budgetDetailVo.getMtInvPayeReliquatMax() != null) {
            q += " And bd.mtInvPayeReliquat <= " + budgetDetailVo.getMtInvPayeReliquatMax();
        }
        if (budgetDetailVo.getMtInvReserveReliquatMin() != null) {
            q += " And bd.mtInvReserveReliquat >= " + budgetDetailVo.getMtInvReserveReliquatMin();
        }
        if (budgetDetailVo.getMtInvReserveReliquatMax() != null) {
            q += " And bd.mtInvReserveReliquat <= " + budgetDetailVo.getMtInvReserveReliquatMax();
        }
        return entityManager.createQuery(q).getResultList();
    }

    @Override
    public int calculerMtInvPayeReliquat(BigDecimal mtInvReel, BigDecimal mtInvPaye) {
        BudgetDetail budgetDetail = budgetDetailDao.findByMtInvReelAndMtInvPaye(mtInvReel, mtInvPaye);
        if (budgetDetail == null) {
            return -1;
        } else if (budgetDetail.getMtInvPayeReliquat().compareTo(mtInvReel.subtract(mtInvPaye)) < 0) {
            return -2;
        } else {
            BigDecimal nvMtInvPayeReliquat = budgetDetail.getMtInvPayeReliquat();
            nvMtInvPayeReliquat = (mtInvReel.subtract(mtInvPaye));
            budgetDetail.setMtInvPayeReliquat(nvMtInvPayeReliquat);
            return 1;
        }
    }


    @Override
    public int calculerMtInvReserveReliquat(BigDecimal mtInvReel, BigDecimal mtInvReserve, BigDecimal mtInvPaye) {
        BudgetDetail budgetDetail = budgetDetailDao.findByMtInvReelAndMtInvPayeAndMtInvReserve(mtInvReel, mtInvPaye, mtInvReserve);
        if (budgetDetail == null) {
            return -1;
        } else if (budgetDetail.getMtInvReserveReliquat().compareTo(mtInvReel.subtract(mtInvReserve).subtract(mtInvPaye)) < 0) {
            return -2;
        } else {
            BigDecimal nvMtInvReserveReliquat = budgetDetail.getMtInvReserveReliquat();
            nvMtInvReserveReliquat = (mtInvReel.subtract(mtInvReserve).subtract(mtInvPaye));
            budgetDetail.setMtInvReserveReliquat(nvMtInvReserveReliquat);
            return 1;
        }
    }


    @Override
    public List<BudgetDetail> findAll() {
        return budgetDetailDao.findAll();
    }

    /*
    @Override
    public int save(Integer annee, BigDecimal mtInvReserve, BigDecimal mtFnctReserve, BigDecimal mtInvPaye, BigDecimal mtFnctPaye, BigDecimal mtInvAffecte, BigDecimal mtFnctAffecte) {
        Budget budget = budgetService.findByAnnee(annee);
        if (budget == null) {
            return -1;
        } else {
            BudgetDetail bd = new BudgetDetail();
            bd.setBudget(budget);
            bd.setMtInvReserve(mtInvReserve);
            bd.setMtFnctReserve(mtFnctReserve);
            bd.setMtInvPaye(mtInvPaye);
            bd.setMtFnctPaye(mtFnctPaye);
            bd.setMtInvAffecte(mtInvAffecte);
            bd.setMtFnctAffecte(mtFnctAffecte);

            BigDecimal total = bd.getMtInvAffecte().add(bd.getMtFnctAffecte());
            bd.setMtTotal(total);

            BigDecimal totalPaye = bd.getMtInvPaye().add(bd.getMtFnctPaye());
            bd.setMtPaye(totalPaye);

            BigDecimal totalReserve = bd.getMtInvReserve().add(bd.getMtFnctReserve());
            bd.setMtReserve(totalReserve);

            budgetDetailDao.save(bd);
            return 1;
        }
    }
   @Override
    public int calculerMtTotal(Integer annne) {
        BudgetDetail budgetDetail = findByBudgetAnnee(annne);
        if (budgetDetail == null){
            return -1;
        } else if (budgetDetail.getMtTotal().compareTo(budgetDetail.getMtInvAffecte().add(budgetDetail.getMtFnctAffecte())) <0){
            return -2;
        }else {
            BigDecimal nvMtTotal = budgetDetail.getMtTotal();
            nvMtTotal = (budgetDetail.getMtInvAffecte().add(budgetDetail.getMtFnctAffecte()));
            budgetDetail.setMtTotal(nvMtTotal);
            return 1;
}
        }*/


}


