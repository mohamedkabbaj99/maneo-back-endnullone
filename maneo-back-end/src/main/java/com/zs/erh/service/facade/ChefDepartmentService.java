package com.zs.erh.service.facade;

import com.zs.erh.bean.ChefDepartment;

import java.util.List;
import java.util.Optional;

public interface ChefDepartmentService {
    ChefDepartment findByCode(String code);
    Optional<ChefDepartment> findById(Long id);
    int deleteByCode(String code);
    List<ChefDepartment> findAll();
    ChefDepartment  save(ChefDepartment chefDepartment);
    ChefDepartment findByLogin(String login);
    ChefDepartment seconnecter(ChefDepartment chefDepartment);
    ChefDepartment update(ChefDepartment chefDepartment);
}

