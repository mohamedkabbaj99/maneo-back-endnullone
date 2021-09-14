package com.zs.erh.service.imple;

import com.zs.erh.bean.Produit;
import com.zs.erh.bean.VoeuxItem;
import com.zs.erh.dao.VoeuxItemDao;
import com.zs.erh.service.facade.VoeuxItemService;
import com.zs.erh.service.vo.VoeuxItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@Service
public class VoeuxItemImpl implements VoeuxItemService {
@Autowired
private VoeuxItemDao voeuxItemDao;

@Autowired
private EntityManager entityManager;

    @Override
    public VoeuxItem save(VoeuxItem voeuxItem) {
        if (findByQteCommande(voeuxItem.getQteCommande())==null)
            voeuxItemDao.save(voeuxItem);
        return  voeuxItem;
    }

    @Override
    public VoeuxItem update(VoeuxItem voeuxItem) {
        return voeuxItemDao.save(voeuxItem);
    }

    @Override
    public List<VoeuxItem> findByProduit(Produit produit) {
        return voeuxItemDao.findByProduit(produit);
    }

    @Override
    public VoeuxItem findByQteDemande(BigDecimal qteDemande) {
        return voeuxItemDao.findByQteDemande(qteDemande);
    }

    @Override
    public VoeuxItem findByQteAccorde(BigDecimal qteAccorde) {
        return voeuxItemDao.findByQteAccorde(qteAccorde);
    }

    @Override
    public VoeuxItem findByQteCommande(BigDecimal qteCommande) {
        return voeuxItemDao.findByQteCommande(qteCommande);
    }

    @Override
    public VoeuxItem findByQteReceptionne(BigDecimal qteReceptionne) {
        return voeuxItemDao.findByQteReceptionne(qteReceptionne);
    }

    @Override
    public VoeuxItem findByQteLivre(BigDecimal qteLivre) {
        return voeuxItemDao.findByQteLivre(qteLivre);
    }

    @Override
    public List<VoeuxItem> findByVoeuxReference(String reference) {
        return voeuxItemDao.findByVoeuxReference(reference);
    }

    @Override
    public int deleteByQteCommande(BigDecimal qteCommande) {
        return voeuxItemDao.deleteByQteCommande(qteCommande);
    }

    @Override
    public int deleteByQteLivre(BigDecimal qteLivre) {
        return voeuxItemDao.deleteByQteLivre(qteLivre);
    }

    @Override
    public List<VoeuxItem> search(VoeuxItemVo voeuxItemVo) {
        String q = "select vi from VoeuxItem vi where 1=1";
        if (voeuxItemVo.getId() != null)  {
            q += " And vi.id LIKE '%" + voeuxItemVo.getId() + "%'";
        }
        if (voeuxItemVo.getQteCommandeMin() != null) {
            q += " And vi.qteCommande >= " + voeuxItemVo.getQteCommandeMin();
        }
        if (voeuxItemVo.getQteCommandeMax() != null) {
            q += " And vi.qteCommande <= " + voeuxItemVo.getQteCommandeMax();
        }
        if (voeuxItemVo.getQteLivreMin() != null) {
            q += " And vi.qteLivre >= " + voeuxItemVo.getQteLivreMin();
        }
        if (voeuxItemVo.getQteLivreMax() != null) {
            q += " And vi.qteLivre <= " + voeuxItemVo.getQteLivreMax();
        }
        return entityManager.createQuery(q).getResultList();
    }


    @Override
    public List<VoeuxItem> findAll() {
        return voeuxItemDao.findAll();
    }

    @Override
    public int qteLivre(BigDecimal qteCommande, BigDecimal qteReceptionne) {
        VoeuxItem voeuxItem = voeuxItemDao.findByQteCommande(qteCommande);
        if (voeuxItem == null){
            return -1;
        }else {
            BigDecimal qteLivre = voeuxItem.getQteCommande();
            qteLivre = (qteCommande.subtract(qteReceptionne));
            voeuxItem.setQteAccorde(qteLivre);
            return 1;
        }
    }
}
