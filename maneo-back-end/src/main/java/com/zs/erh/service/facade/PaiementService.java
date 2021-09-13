package com.zs.erh.service.facade;
import com.zs.erh.bean.Paiement;
import com.zs.erh.service.vo.PaiementVO;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface PaiementService {
    public List<Paiement> findAll();
    public Paiement findByReference(String reference);
    public List<Paiement> findByFactureCode(String code);
    public Paiement save(Paiement paiement);
    public int updatePaiement(Paiement paiement);
    public int deleteByReference(String reference);
    public int deleteByFactureCode(String code);
    public int deleteMultiple(List<Paiement> paiements);
    public PaiementVO calcStatistiquePaiement(PaiementVO paiementVO);
    public BigDecimal totalPaye(Long factureId);
    public BigDecimal totalNonPaye(Paiement paiement);
}
