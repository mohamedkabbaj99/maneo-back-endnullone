package com.zs.erh.ws.provided.responsable_achat;

import com.zs.erh.bean.EtatComande;
import com.zs.erh.service.facade.EtatCommandeService;
import com.zs.erh.service.vo.EtatComandeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maneo-rh/responsable-achat/etat-commande")

public class EtatCommandeRARest {
    @Autowired
    private EtatCommandeService etatCommandeService;

    @PostMapping("/")
    public EtatComande save(@RequestBody EtatComande etatComande) {
        return etatCommandeService.save(etatComande);
    }

    @PutMapping("/")
    public EtatComande update(@RequestBody EtatComande etatComande) {
        return etatCommandeService.update(etatComande);
    }

    @PostMapping("/search")
    public List<EtatComande> search(@RequestBody EtatComandeVo etatComandeVo) {
        return etatCommandeService.search(etatComandeVo);
    }

    @GetMapping("/")
    public List<EtatComande> findAll() {
        return etatCommandeService.findAll();
    }

    @GetMapping("/libelle/{libelle}")
    public EtatComande findByLibelle(@PathVariable String libelle) {
        return etatCommandeService.findByLibelle(libelle);
    }

    @GetMapping("/code/{code}")
    public EtatComande findByCode(@PathVariable String code) {
        return etatCommandeService.findByCode(code);
    }

    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return etatCommandeService.deleteByLibelle(libelle);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return etatCommandeService.deleteByCode(code);
    }
}
