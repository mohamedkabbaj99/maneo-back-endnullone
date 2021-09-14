package com.zs.erh.dao;

import com.zs.erh.bean.Produit;
import com.zs.erh.bean.VoeuxItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VoeuxItemDao extends JpaRepository<VoeuxItem, Long> {

    List<VoeuxItem> findByProduit(Produit produit);

    VoeuxItem findByQteDemande(BigDecimal qteDemande);

    VoeuxItem findByQteAccorde(BigDecimal qteAccorde);

    VoeuxItem findByQteCommande(BigDecimal qteCommande);

    VoeuxItem findByQteReceptionne(BigDecimal qteReceptionne);

    VoeuxItem findByQteLivre(BigDecimal qteLivre);

    List<VoeuxItem> findByVoeuxReference(String reference);

    int deleteByQteCommande(BigDecimal qteCommande);

    int deleteByQteLivre(BigDecimal qteLivre);
}
