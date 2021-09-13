package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.EtatBudget;
import com.zs.erh.service.facade.EtatBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/admin/etatBudget")
public class EtatBudgetAdminRest {
    @Autowired
    private EtatBudgetService etatBudgetService;

    @GetMapping("/")
    public List<EtatBudget> findAll(){
        return etatBudgetService.findAll();
    }
}
