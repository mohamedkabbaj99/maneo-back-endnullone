package com.zs.erh.ws.provided.admin;


import com.zs.erh.bean.BudgetDetail;
import com.zs.erh.service.facade.BudgetDetailService;
import com.zs.erh.service.vo.BudgetDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/pfe/admin/budget-detail")
public class BudgetDetailAdminRest {
    @Autowired
    private BudgetDetailService budgetDetailService;

    @GetMapping("/mtInvAffecte/{mtInvAffecte}/mtFnctAffecte/{mtFnctAffecte}")
    public BudgetDetail findByMtInvAffecteAndMtFnctAffecte(@PathVariable BigDecimal mtInvAffecte, @PathVariable BigDecimal mtFnctAffecte) {
        return budgetDetailService.findByMtInvAffecteAndMtFnctAffecte(mtInvAffecte, mtFnctAffecte);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        budgetDetailService.deleteById(id);
    }

    @DeleteMapping("/mtInvPaye/{mtInvPaye}")
    public int deleteByMtInvReserveReliquat(@PathVariable BigDecimal mtInvReserveReliquat) {
        return budgetDetailService.deleteByMtInvReserveReliquat(mtInvReserveReliquat);
    }

    @DeleteMapping("/mtInvPayeReliquat/{mtInvPayeReliquat}")
    public int deleteByMtInvPayeReliquat(@PathVariable BigDecimal mtInvPayeReliquat) {
        return budgetDetailService.deleteByMtInvPayeReliquat(mtInvPayeReliquat);
    }

    @PostMapping("/delete-multiple-by-mtInvReserveReliquat")
    public int deleteByMtInvReserveReliquat(@RequestBody List<BudgetDetail> budgetDetails) {
        return budgetDetailService.deleteByMtInvReserveReliquat(budgetDetails);
    }

    @PostMapping("/")
    public int save(@RequestBody BudgetDetail budgetDetail) {
        return budgetDetailService.save(budgetDetail);
    }

    @PutMapping("/")
    public BudgetDetail update(@RequestBody BudgetDetail budgetDetail) {
        return budgetDetailService.update(budgetDetail);
    }

    @PostMapping("/search")
    public List<BudgetDetail> search(@RequestBody BudgetDetailVo budgetDetailVo) {
        return budgetDetailService.search(budgetDetailVo);
    }

    @GetMapping("/")
    public List<BudgetDetail> findAll() {
        return budgetDetailService.findAll();
    }

    @PutMapping("/mtInvReel/{mtInvReel}/mtInvPaye/{mtInvPaye}")
    public int calculerMtInvPayeReliquat(@PathVariable BigDecimal mtInvReel, @PathVariable BigDecimal mtInvPaye) {
        return budgetDetailService.calculerMtInvPayeReliquat(mtInvReel, mtInvPaye);
    }

    @PutMapping("/mtInvReel/{mtInvReel}/mtInvReserve/{mtInvReserve}/mtInvPaye/{mtInvPaye}")
    public int calculerMtInvReserveReliquat(@PathVariable BigDecimal mtInvReel, @PathVariable BigDecimal mtInvReserve, @PathVariable BigDecimal mtInvPaye) {
        return budgetDetailService.calculerMtInvReserveReliquat(mtInvReel, mtInvReserve, mtInvPaye);
    }

    
}
