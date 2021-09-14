package com.zs.erh.ws.provided.responsable_achat;

import com.zs.erh.bean.EntiteAdministrative;
import com.zs.erh.service.facade.EntiteAdministrativeService;
import com.zs.erh.service.vo.EntiteAdministrativeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maneo-rh/responsable-achat/entite-administrative")
public class EntiteAdministrativeRARest {
    @Autowired
    private EntiteAdministrativeService entiteAdministrativeService;

    @GetMapping("/code/{code}")
    public EntiteAdministrative findByCode(@PathVariable String code) {
        return entiteAdministrativeService.findByCode(code);
    }

    @GetMapping("/libelle/{libelle}")
    public EntiteAdministrative findByLibelle(@PathVariable String libelle) {
        return entiteAdministrativeService.findByLibelle(libelle);
    }

    @GetMapping("/code/{code}/libelle/{libelle}")
    public EntiteAdministrative findByCodeAndLibelle(@PathVariable String code, @PathVariable String libelle) {
        return entiteAdministrativeService.findByCodeAndLibelle(code, libelle);
    }

    @PostMapping("/")
    public EntiteAdministrative save(@RequestBody EntiteAdministrative entiteAdministrative) {
        return entiteAdministrativeService.save(entiteAdministrative);
    }

    @PutMapping("/")
    public EntiteAdministrative update(@RequestBody EntiteAdministrative entiteAdministrative) {
        return entiteAdministrativeService.update(entiteAdministrative);
    }

    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return entiteAdministrativeService.deleteByLibelle(libelle);
    }


    @PostMapping("/search")
    public List<EntiteAdministrative> search(@RequestBody EntiteAdministrativeVo entiteAdministrativeVo) {
        return entiteAdministrativeService.search(entiteAdministrativeVo);
    }

    @GetMapping("/")
    public List<EntiteAdministrative> findAll() {
        return entiteAdministrativeService.findAll();
    }
}
