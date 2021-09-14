package com.zs.erh.ws.provided.responsable_achat;


import com.zs.erh.bean.BudgetEntiteAdministrative;
import com.zs.erh.service.facade.BudgetEntiteAdministrativeService;
import com.zs.erh.service.vo.BudgetEntiteAdministrativeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/maneo-rh/responsable-achat/budget-entite-administrative")
public class BudgetEntiteAdministrativeRARest {
    @Autowired
    private BudgetEntiteAdministrativeService budgetEntiteAdministrativeService;


    @PostMapping("/search")
    public List<BudgetEntiteAdministrative> search(@RequestBody BudgetEntiteAdministrativeVo budgetEntiteAdministrativeVo) {
        return budgetEntiteAdministrativeService.search(budgetEntiteAdministrativeVo);
    }

    @GetMapping("/")
    public List<BudgetEntiteAdministrative> findAll() {
        return budgetEntiteAdministrativeService.findAll();
    }

    @GetMapping("/entiteAdministrativeLibelle/{libelle}")
    public List<BudgetEntiteAdministrative> findByEntiteAdministrativeLibelle(@PathVariable String libelle) {
        return budgetEntiteAdministrativeService.findByEntiteAdministrativeLibelle(libelle);
    }

    @GetMapping("/budgetAnnee/{annee}")
    public List<BudgetEntiteAdministrative> findByBudgetAnnee(@PathVariable Integer annee) {
        return budgetEntiteAdministrativeService.findByBudgetAnnee(annee);
    }
/*


    @DeleteMapping("/entiteAdministrativeLibelle/{libelle}")
    public int deleteByEntiteAdministrativeLibelle(@PathVariable String libelle) {
        return budgetEntiteAdministrativeService.deleteByEntiteAdministrativeLibelle(libelle);
    }

    @DeleteMapping("/budgetAnnee/{annee}")
    public int deleteByBudgetAnnee(@PathVariable Integer annee) {
        return budgetEntiteAdministrativeService.deleteByBudgetAnnee(annee);
    }

    @PostMapping("/entiteAdministrativeLibelle/{libelleEntiteAdministrative}")
    public int save(@RequestBody Budget budget, @PathVariable  List<BudgetEntiteAdministrative> budgetEntiteAdministratives) {
        return budgetEntiteAdministrativeService.save(budget, budgetEntiteAdministratives);
    }

    @PutMapping("/")
    public BudgetEntiteAdministrative update(@RequestBody BudgetEntiteAdministrative budgetEntiteAdministrative) {
        return budgetEntiteAdministrativeService.update(budgetEntiteAdministrative);
    }*/
}
