package com.zs.erh.service.imple;

import com.zs.erh.bean.ProduitCategorie;
import com.zs.erh.dao.ProduitCategorieDao;
import com.zs.erh.service.facade.ProduitCategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitCategorieServiceImpl implements ProduitCategorieService {

   @Autowired
   private ProduitCategorieDao produitCategorieDao;


    @Override
    public int save(ProduitCategorie produitCategorie) {
        ProduitCategorie loadedCategorieProduit = findByReference(produitCategorie.getReference());
        if (loadedCategorieProduit != null) {
            return -1;
        } else {
            produitCategorieDao.save(produitCategorie);
            return 1;
        }

    }

    @Override
    public int deleteMultiple(List<ProduitCategorie> produitCategories) {
        int res = 0;
        for (int i = 0; i < produitCategories.size(); i++) {
            res += deleteByReference(produitCategories.get(i).getReference());
        }
        return res;
    }

    @Override
    public ProduitCategorie findByReference(String ref) {
        return produitCategorieDao.findByReference(ref);
    }

    @Override
    public int deleteByReference(String ref) {
        return produitCategorieDao.deleteByReference(ref);
    }

    @Override
    public List<ProduitCategorie> findAll() {
        return produitCategorieDao.findAll();
    }

}
