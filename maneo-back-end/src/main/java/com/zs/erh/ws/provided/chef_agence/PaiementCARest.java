package com.zs.erh.ws.provided.chef_agence;

import com.zs.erh.bean.Paiement;
import com.zs.erh.service.facade.PaiementService;
import com.zs.erh.service.vo.PaiementVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/chef-agence/paiement")
public class PaiementCARest {

    @Autowired
    private PaiementService paiementService;

    // Read Methods

    @GetMapping("/")
    public List<Paiement> findAll() {
        return paiementService.findAll();
    }

    @GetMapping("/codeFacture/{code}")
    public List<Paiement> findByFactureCode(@PathVariable String code) {
        return paiementService.findByFactureCode(code);
    }

    // Statistiques Methods

    @PostMapping("/statistic-paiement")
    public PaiementVO calcStatistiquePaiement(@RequestBody PaiementVO paiementVO) {
        return paiementService.calcStatistiquePaiement(paiementVO);
    }

    // Create Methods

    @PostMapping("/")
    public Paiement save(@RequestBody Paiement paiement) {
        return paiementService.save(paiement);
    }

    // Update Methods

    @PutMapping("/")
    public int updatePaiement(@RequestBody Paiement paiement) {
        return paiementService.updatePaiement(paiement);
    }

    // Delete Methods

    @DeleteMapping("FactureCode/{code}")
    public int deleteByFactureCode(@PathVariable String code) {
        return paiementService.deleteByFactureCode(code);
    }

    @PostMapping("/delete-multiple-by-code")
    public int deleteMultiple(@RequestBody List<Paiement> paiements) {
        return paiementService.deleteMultiple(paiements);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return paiementService.deleteByReference(reference);
    }

    //total montant non paye

    @PostMapping("/calcTotalNonPaye")
    public BigDecimal totalNonPaye(@RequestBody Paiement paiement) {
        return paiementService.totalNonPaye(paiement);
    }

}
