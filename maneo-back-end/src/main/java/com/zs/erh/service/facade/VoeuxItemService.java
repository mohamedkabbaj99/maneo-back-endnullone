package com.zs.erh.service.facade;

import com.zs.erh.bean.Produit;
import com.zs.erh.bean.VoeuxItem;
import com.zs.erh.service.vo.VoeuxItemVo;

import java.math.BigDecimal;
import java.util.List;

public interface VoeuxItemService {
    VoeuxItem save(VoeuxItem voeuxItem);

    VoeuxItem update(VoeuxItem voeuxItem);

    List<VoeuxItem> findByProduit(Produit produit);

    VoeuxItem findByQteDemande(BigDecimal qteDemande);

    VoeuxItem findByQteAccorde(BigDecimal qteAccorde);

    VoeuxItem findByQteCommande(BigDecimal qteCommande);

    VoeuxItem findByQteReceptionne(BigDecimal qteReceptionne);

    VoeuxItem findByQteLivre(BigDecimal qteLivre);

    List<VoeuxItem> findByVoeuxReference(String reference);

    int deleteByQteCommande(BigDecimal qteCommande);

    int deleteByQteLivre(BigDecimal qteLivre);

    List<VoeuxItem> search(VoeuxItemVo voeuxItemVo);


    List<VoeuxItem> findAll();

    public int qteLivre(BigDecimal qteCommande, BigDecimal qteReceptionne);
}
