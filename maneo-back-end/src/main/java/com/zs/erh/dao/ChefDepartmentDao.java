package com.zs.erh.dao;

import com.zs.erh.bean.ChefDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChefDepartmentDao extends JpaRepository <ChefDepartment,Long> {
    ChefDepartment findByCode(String code);
    Optional<ChefDepartment> findById(Long id);
    int deleteByCode(String code);
    ChefDepartment findByLogin(String login);
}
