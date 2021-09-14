/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.service.imple;

import com.zs.erh.bean.Budget;
import com.zs.erh.bean.Commande;
import com.zs.erh.bean.CommandeItem;
import com.zs.erh.dao.CommandeDao;
import com.zs.erh.service.facade.BudgetService;
import com.zs.erh.service.facade.CommandeItemService;
import com.zs.erh.service.facade.CommandeService;
import com.zs.erh.service.util.StringUtil;
import com.zs.erh.service.vo.CommandeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;


/**
 *
 * @author admin
 */
@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeDao commandeDao;

    @Autowired
    private CommandeItemService commandeItemService;
    @Autowired

    private BudgetService budgetService;

    @Autowired
    private EntityManager entityManager;

    @Override
    public int save(Commande commande) {

        calculerTotal(commande, commande.getCommandeItems());
        Commande loadedCommande = findByReference(commande.getReference());
        if (loadedCommande != null) {
            return -1;
        } else if (commande.getTotal().subtract(commande.getTotalPaye()).doubleValue() < 0) {

            return -2;
        }
        Budget budgetAnnee = budgetService.findByAnnee(commande.getBudget().getAnnee());
        commande.setBudget(budgetAnnee);
        if (budgetAnnee == null) {
            return -3;
        }
        Budget budget = commande.getBudget();
        BigDecimal mtReserveRestant = budget.getMtTotal().subtract(budget.getMtPaye().add(budget.getMtReserve()));
        if (commande.getTotal().subtract(mtReserveRestant).doubleValue() < 0){
            return -4;
        }else {
            updateMtReserveBudget(budget, commande);
            commandeDao.save(commande);
            commandeItemService.save(commande, commande.getCommandeItems());
            return 1;
        }
    }

    @Override
    public int deleteMultiple(List<Commande> commandes) {
        int res = 0;
        for (int i = 0; i < commandes.size(); i++) {
            res += deleteByReference(commandes.get(i).getReference());
        }
        return res;    }

    private void updateMtReserveBudget(Budget budget, Commande commande) {
        BigDecimal nvTotalReserve = commande.getTotal().add(budget.getMtReserve());
        budget.setMtReserve(nvTotalReserve);
        budgetService.update(budget);
    }

    private void calculerTotal(Commande commande, List<CommandeItem> commandeItems) {
        BigDecimal total = BigDecimal.valueOf(0);
        for (CommandeItem commandeItem : commandeItems) {
            total = total.add(commandeItem.getPrix().multiply(commandeItem.getQteCommandee()));
        }
        commande.setTotal(total);
    }

    @Override
    public List<Commande> search(CommandeVo commandeVo) {
        String query = "SELECT c FROM Commande c WHERE 1=1";
        if (StringUtil.isNotEmpty(commandeVo.getReference())) {
            query += " AND c.reference LIKE '%" + commandeVo.getReference() + "%'";
        }

        if (StringUtil.isNotEmpty(commandeVo.getTotalMin())) {
            query += " AND c.total >= '" + commandeVo.getTotalMin() + "'";
        }

        if (StringUtil.isNotEmpty(commandeVo.getTotalMax())) {
            query += " AND c.total <= '" + commandeVo.getTotalMax() + "'";
        }

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    @Override
    public int deleteByReference(String reference) {
        return commandeDao.deleteByReference(reference);
    }

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

}
