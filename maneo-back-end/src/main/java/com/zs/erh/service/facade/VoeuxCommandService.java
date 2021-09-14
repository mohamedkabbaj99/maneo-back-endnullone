package com.zs.erh.service.facade;

import com.zs.erh.bean.CommandeItem;
import com.zs.erh.bean.VoeuxCommand;
import com.zs.erh.bean.VoeuxItem;
import com.zs.erh.service.vo.VoeuxCommandVo;


import java.math.BigDecimal;
import java.util.List;

public interface VoeuxCommandService {

    List<VoeuxCommand> findByCommandeItem(CommandeItem commandeItem);
    List<VoeuxCommand> findByVoeuxItem(VoeuxItem voeuxItem);
    VoeuxCommand findByQte(BigDecimal qte);
    VoeuxCommand findByQteLivre(BigDecimal qteLivre);
    VoeuxCommand findByQteReception(BigDecimal qteReception);
    int deleteByQteLivre(BigDecimal qteLivre);
    int deleteByQteReception(BigDecimal qteReception);
    VoeuxCommand update(VoeuxCommand voeuxCommand);
    int save(VoeuxCommand voeuxCommand, BigDecimal qteLivre, BigDecimal qteReception, BigDecimal qte);
    List<VoeuxCommand> search(VoeuxCommandVo voeuxCommandVo);
    List<VoeuxCommand> findAll();
}
