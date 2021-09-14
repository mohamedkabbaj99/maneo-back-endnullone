package com.zs.erh.service.facade;

import com.zs.erh.bean.EntiteAdministrative;
import com.zs.erh.service.vo.EntiteAdministrativeVo;


import java.util.List;

public interface EntiteAdministrativeService {

    EntiteAdministrative findByCode(String code);

    EntiteAdministrative findByLibelle(String libelle);

    EntiteAdministrative findByCodeAndLibelle(String code, String libelle);

    EntiteAdministrative save(EntiteAdministrative entiteAdministrative);

    EntiteAdministrative update(EntiteAdministrative entiteAdministrative);

    int deleteByLibelle(String libelle);

    int deleteByLibelle(List<EntiteAdministrative> entiteAdministratives);

    List<EntiteAdministrative> search(EntiteAdministrativeVo entiteAdministrativeVo);

    List<EntiteAdministrative> findAll();

}
