package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.ChefDepartment;
import com.zs.erh.service.facade.ChefDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pfe/admin/chef-department")
public class ChefDepartmentAdminRest {
    @Autowired
    private ChefDepartmentService chefDepartmentService;

    @GetMapping("/code{code}")
    public ChefDepartment findByCode(@PathVariable String code) {
        return chefDepartmentService.findByCode(code);
    }
    @GetMapping("/id/{id}")
    public Optional<ChefDepartment> findById(@PathVariable Long id) {
        return chefDepartmentService.findById(id);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return chefDepartmentService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<ChefDepartment> findAll() {
        return chefDepartmentService.findAll();
    }
    @PostMapping("/")
    public ChefDepartment save(@RequestBody ChefDepartment chefDepartment) {
        return chefDepartmentService.save(chefDepartment);
    }
    @PutMapping("/")
    public ChefDepartment update(@RequestBody ChefDepartment chefDepartment) {
        return chefDepartmentService.update(chefDepartment);
    }
}
