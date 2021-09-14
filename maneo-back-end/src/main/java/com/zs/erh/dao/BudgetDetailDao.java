package com.zs.erh.dao;


import com.zs.erh.bean.BudgetDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface BudgetDetailDao extends JpaRepository<BudgetDetail, Long> {

    BudgetDetail findByMtInvAffecteAndMtFnctAffecte(BigDecimal mtInvAffecte, BigDecimal mtFnctAffecte);

    int deleteByMtInvReserveReliquat(BigDecimal mtInvReserveReliquat);

    int deleteByMtInvPayeReliquat(BigDecimal mtInvPayeReliquat);

    BudgetDetail findByMtInvReelAndMtInvPaye(BigDecimal mtInvReel, BigDecimal mtInvPaye);

    BudgetDetail findByMtInvReelAndMtInvPayeAndMtInvReserve(BigDecimal mtInvReel, BigDecimal mtInvPaye, BigDecimal mtInvReserve);
/*

    BudgetDetail findByMtInvReserve(BigDecimal mtInvReserve);

    BudgetDetail findByMtFnctReserve(BigDecimal mtFnctReserve);

    BudgetDetail findByMtInvAffecte(BigDecimal mtInvAffecte);

    BudgetDetail findByMtFnctAffecte(BigDecimal mtFnctAffecte);

    BudgetDetail findByMtCreditOuvInv(BigDecimal mtCreditOuvInv);

    BudgetDetail findByMtCreditOuvFnct(BigDecimal mtCreditOuvFnct);

    BudgetDetail findByMtInvReel(BigDecimal mtInvReel);

    BudgetDetail findByMtInvPaye(BigDecimal mtInvPaye);

    BudgetDetail findByMtFnctPaye(BigDecimal mtFnctPaye);*/
}
