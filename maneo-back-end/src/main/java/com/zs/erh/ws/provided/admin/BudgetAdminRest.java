package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.Budget;
import com.zs.erh.service.facade.BudgetService;
import com.zs.erh.service.vo.BudgetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pfe/admin/budget")
public class BudgetAdminRest {
    @Autowired
    private BudgetService budgetService;

    @PostMapping("/")
    public Object save(@RequestBody Budget budget) {
        return budgetService.save(budget);
    }

    @PutMapping("/")
    public Budget update(@RequestBody Budget budget) {
        return budgetService.update(budget);
    }

    @DeleteMapping("/annee/{annee}")
    public int deleteByAnnee(@PathVariable Integer annee) {
        return budgetService.deleteByAnnee(annee);
    }

    @PostMapping("/delete-multiple-by-annee")
    public int deleteByAnnee(@RequestBody List<Budget> budgets) {
        return budgetService.deleteByAnnee(budgets);
    }

    @GetMapping("/budgetDetail/{budgetDetail}")
    public Budget findByBudgetDetail(@PathVariable String budgetDetail) {
        return budgetService.findByBudgetDetail(budgetDetail);
    }

    @GetMapping("/description/{description}")
    public Budget findByDescription(@PathVariable String description) {
        return budgetService.findByDescription(description);
    }

    @GetMapping("/annee/{annee}")
    public Budget findByAnnee(@PathVariable Integer annee) {
        return budgetService.findByAnnee(annee);
    }


    @GetMapping("/")
    public List<Budget> findAll() {
        return budgetService.findAll();
    }

    @PostMapping("/search")
    public List<Budget> search(@RequestBody BudgetVo budgetVo) {
        return budgetService.search(budgetVo);
    }

}
