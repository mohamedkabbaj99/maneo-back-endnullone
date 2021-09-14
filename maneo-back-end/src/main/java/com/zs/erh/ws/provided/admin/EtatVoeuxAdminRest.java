package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.EtatVoeux;
import com.zs.erh.service.facade.EtatVoeuxService;
import com.zs.erh.service.vo.EtatVoeuxVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pfe/admin/etat-voeux")

public class EtatVoeuxAdminRest {
    @Autowired
    private EtatVoeuxService etatVoeuxService;

    @PostMapping("/")
    public EtatVoeux save(@RequestBody EtatVoeux etatVoeux) {
        return etatVoeuxService.save(etatVoeux);
    }

    @PutMapping("/")
    public EtatVoeux update(@RequestBody EtatVoeux etatVoeux) {
        return etatVoeuxService.update(etatVoeux);
    }

    @GetMapping("/libelle/{libelle}")
    public EtatVoeux findByLibelle(@PathVariable String libelle) {
        return etatVoeuxService.findByLibelle(libelle);
    }

    @GetMapping("/code/{code}")
    public EtatVoeux findByCode(@PathVariable String code) {
        return etatVoeuxService.findByCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return etatVoeuxService.deleteByCode(code);
    }

    @PostMapping("/search")
    public List<EtatVoeux> search(@RequestBody EtatVoeuxVo etatVoeuxVo) {
        return etatVoeuxService.search(etatVoeuxVo);
    }

    @GetMapping("/")
    public List<EtatVoeux> findAll() {
        return etatVoeuxService.findAll();
    }
}
