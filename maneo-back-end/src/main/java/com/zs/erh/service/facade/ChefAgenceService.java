package com.zs.erh.service.facade;

import com.zs.erh.bean.ChefAgence;

import java.util.List;
import java.util.Optional;

public interface ChefAgenceService {
    ChefAgence findByCode(String code);
    Optional<ChefAgence> findById(Long id);
    int deleteByCode(String code);
    List<ChefAgence> findAll();
    ChefAgence  save(ChefAgence chefAgence);
    ChefAgence findByLogin(String login);
    ChefAgence seconnecter(ChefAgence chefAgence);
    ChefAgence update(ChefAgence chefAgence);
}

