package com.zs.erh.ws.provided.general;

import com.zs.erh.bean.Periode;
import com.zs.erh.service.facade.PeriodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("maneo-rh/general/periode")
public class PeriodeRest {
    @Autowired
    private PeriodeService periodeService;

    @GetMapping("/")
    public List<Periode> findAll() {
        return periodeService.findAll();
    }
    @GetMapping("/code/{code}")
    public Periode findByCode(@PathVariable String code) {
        return periodeService.findByCode(code);
    }
}
