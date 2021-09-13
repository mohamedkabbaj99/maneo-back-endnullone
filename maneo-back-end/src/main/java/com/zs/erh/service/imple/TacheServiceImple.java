package com.zs.erh.service.imple;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.zs.erh.bean.GroupeTache;
import com.zs.erh.bean.MembreEquipe;
import com.zs.erh.bean.Tache;
import com.zs.erh.dao.TacheDao;
import com.zs.erh.service.facade.*;
import com.zs.erh.service.util.DateUtil;
import com.zs.erh.service.vo.BudgetVO;
import com.zs.erh.service.vo.CollaborateurVo;
import com.zs.erh.service.vo.StatisticVO;
import com.zs.erh.service.vo.TacheVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class TacheServiceImple extends AbstractFacade<Tache> implements TacheService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TacheDao tacheDao;

    @Autowired
    private GroupeTacheService groupeTacheService;

    @Autowired
    private CategorieTacheService categorieTacheService;
    @Autowired
    private EtatTacheService etatTacheService;
    @Autowired
    private MembreEquipeService membreEquipeService;
    @Autowired
    private PeriodeService periodeService;
    @Autowired
    private CalendrierJourFeriesService calendrierJourFeriesService;
    @Autowired
    private DemandeCongeService demandeCongeService;


    public List<Tache> findByGroupeTacheIdAndMembreEquipeCollaborateurId(Long grpId, Long collabId) {
        return tacheDao.findByGroupeTacheIdAndMembreEquipeCollaborateurId(grpId, collabId);
    }

    public List<Tache> findByMembreEquipeCollaborateurId(Long id) {
        return tacheDao.findByMembreEquipeCollaborateurId(id);
    }

    public Tache findByCode(String code) {
        return tacheDao.findByCode(code);
    }

    public List<Tache> findByGroupeTacheCode(String code) {
        return tacheDao.findByGroupeTacheCode(code);
    }

    public List<Tache> findAll() {
        return tacheDao.findAll();
    }

    public Tache findByPeriodeIdAndMembreEquipeIdAndDateDemarrageEffective(Tache tache) {
        String query = initQuery();
        query += addConstraint("item.periode.id", tache.getPeriode().getId());
        query += addConstraint("item.membreEquipe.id", tache.getMembreEquipe().getId());
        query += addConstraintDate("item", "dateDemarrageEffective", "=", tache.getDateDemarrageEffective());
        System.out.println("query = " + query);
        Tache result = findSingleResult(query);
        System.out.println("tache = " + result);
        return result;
    }

    public Tache save(Tache tache) {
        if (findByCode(tache.getCode()) != null) {
            return null;
        } else {
            GroupeTache groupeTache = groupeTacheService.findByCode(tache.getGroupeTache().getCode());
            if (groupeTache == null) {
                return null;
            }
            if (tache.getDateDemarrageEffective() == null) {
                return null;
            } else if (findByPeriodeIdAndMembreEquipeIdAndDateDemarrageEffective(tache) != null) {
                return null;
            } else {
                tache.setGroupeTache(groupeTache);
                if (tache.getLibelle() == null) {
                    tache.setLibelle(groupeTache.getLibelle());
                }
                tache.setDateFinEffective(tache.getDateDemarrageEffective());
                tache.setCategorieTache(categorieTacheService.findByCode(tache.getCategorieTache().getCode()));
                tache.setEtatTache(etatTacheService.findByCode(tache.getEtatTache().getCode()));
                tache.setPeriode(periodeService.findByCode(tache.getPeriode().getCode()));
                tache.setMembreEquipe(membreEquipeService.findByEquipeCodeAndCollaborateurCode(tache.getMembreEquipe().getEquipe().getCode(),
                        tache.getMembreEquipe().getCollaborateur().getCode()));
                tacheDao.save(tache);
                return tache;
            }
        }
    }

    public Tache saveForCollaborateur(Tache tache) {
        if (findByCode(tache.getCode()) != null) {
            return null;
        } else {
            GroupeTache groupeTache = groupeTacheService.findByCode(tache.getGroupeTache().getCode());
            MembreEquipe membreEquipe = this.membreEquipeService.findByEquipeCodeAndCollaborateurLogin(tache.getMembreEquipe().getEquipe().getCode(),
                    tache.getMembreEquipe().getCollaborateur().getLogin());
            if (groupeTache == null) {
                return null;
            }
            if (tache.getDateDemarrageEffective() == null) {
                return null;
            } else if (findByPeriodeIdAndMembreEquipeIdAndDateDemarrageEffective(tache) != null) {
                return null;
            } else {
                tache.setGroupeTache(groupeTache);
                if (tache.getLibelle() == null) {
                    tache.setLibelle(groupeTache.getLibelle());
                }
                tache.setGroupeTache(groupeTache);
                tache.setMembreEquipe(membreEquipe);
                tache.setCategorieTache(categorieTacheService.findByCode(tache.getCategorieTache().getCode()));
                tache.setEtatTache(etatTacheService.findByCode(tache.getEtatTache().getCode()));
                tache.setPeriode(periodeService.findByCode(tache.getPeriode().getCode()));
                tacheDao.save(tache);
                return tache;
            }
        }
    }

    public int updateTache(Tache tache) {
        Tache tacheUpdated = findByCode(tache.getCode());
        tacheUpdated.setCode(tache.getCode());
        tacheUpdated.setLibelle(tache.getLibelle());
        tacheUpdated.setDescription(tache.getDescription());
        tacheUpdated.setDateDemarrageEffective(tache.getDateDemarrageEffective());
        tacheUpdated.setDateFinEffective(tache.getDateDemarrageEffective());
        tacheUpdated.setAnnee(tache.getAnnee());
        tacheUpdated.setMois(tache.getMois());
        tacheUpdated.setSemaine(tache.getSemaine());
        tacheUpdated.setGroupeTache(groupeTacheService.findByCode(tache.getGroupeTache().getCode()));
        tacheUpdated.setPeriode(periodeService.findByCode(tache.getPeriode().getCode()));
        tacheUpdated.setCategorieTache(categorieTacheService.findByCode(tache.getCategorieTache().getCode()));
        tacheUpdated.setEtatTache(etatTacheService.findByCode(tache.getEtatTache().getCode()));
        tacheUpdated.setMembreEquipe(membreEquipeService.findByEquipeCodeAndCollaborateurCode(tache.getMembreEquipe().getEquipe().getCode(),
                tache.getMembreEquipe().getCollaborateur().getCode()));
        tacheDao.save(tacheUpdated);
        return 1;
    }

    @Transactional
    public int deleteByGroupeTacheCode(String code) {
        return tacheDao.deleteByGroupeTacheCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return tacheDao.deleteBycode(code);
    }

    @Transactional
    public int deleteMultiple(List<Tache> taches) {
        int res = 0;
        for (int i = 0; i < taches.size(); i++) {
            res += deleteByCode(taches.get(i).getCode());
        }
        return res;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }


    public List<TacheVo> calcStatistique(TacheVo tacheVo) {
        System.out.println("tacheVo = " + tacheVo);
        String query = "SELECT new com.zs.erh.service.vo.TacheVo(t.groupeTache.lot,COUNT(t.periode.id)) FROM Tache t WHERE 1=1";
        query += addCriteria(tacheVo);
        query += " GROUP BY t.groupeTache.lot.id";
        System.out.println("query = " + query);
        List<TacheVo> res = getEntityManager().createQuery(query).getResultList();
        System.out.println("res = " + res);
        return res;
    }

    public String addCriteria(TacheVo tacheVo) {
        String query = "";
        query += addConstraint("t.libelle", tacheVo.getLibelle(), "LIKE");
        query += addConstraint("t.annee", tacheVo.getAnnee());
        query += addConstraint("t.mois", tacheVo.getMois());
        query += addConstraint("t.semaine", tacheVo.getSemaine());
        query += addConstraintMinMaxDate("t", "dateDemarrageEffective", tacheVo.getDateDemarrageEffectiveMin(), tacheVo.getDateDemarrageEffectiveMax());
        query += addConstraint("t.membreEquipe.collaborateur.id", tacheVo.getResponsableId());
        query += addConstraint("t.membreEquipe.id", tacheVo.getMembreEquipeId());
        query += addConstraint("t.membreEquipe.equipe.id", tacheVo.getEquipeId());
        query += addConstraint("t.groupeTache.lot.projet.id", tacheVo.getProjetId());
        query += addConstraint("t.groupeTache.lot.id", tacheVo.getLotId());
        query += addConstraint("t.groupeTache.lot.projet.client.id", tacheVo.getClientId());
        query += addConstraint("t.periode.id", tacheVo.getPeriodeId());
        query += addConstraint("t.groupeTache.lot.projet.agence.chefAgence.id", tacheVo.getChefAgenceId());
        query += addConstraint("t.etatTache.id", tacheVo.getEtatTacheId());
        return query;
    }



    public List<CollaborateurVo> suivreCollaborateurs(CollaborateurVo collaborateurVo) {
        return calcStatistiqueSuiviCollaborateur(collaborateurVo);
    }
    public Long calculNbrTache(TacheVo tacheVo){
        String query = "select count(t) from Tache t where 1=1";
        query += addConstraintMinMaxDate("t", "dateDemarrageEffective", tacheVo.getDateDemarrageEffectiveMin(), tacheVo.getDateDemarrageEffectiveMax());
        query += addConstraint("t.groupeTache.lot.projet.agence.chefAgence.id", tacheVo.getChefAgenceId());
        Long result = (Long) entityManager.createQuery(query).getSingleResult();
        if(result == null){
            return new Long(0);
        }
        else return result;
    }

    public List<CollaborateurVo> calcStatistiqueSuiviCollaborateur(CollaborateurVo collabVo) {
        List<CollaborateurVo> collaborateurVos = calcTacheCount(collabVo);
        Long totalJourWithoutWeekEnd = DateUtil.totalJourWithoutWeekEnd(collabVo.getDateDemarrageEffectiveMin(), collabVo.getDateDemarrageEffectiveMax());
        Long jourFierie = calendrierJourFeriesService.calcNombreJourTotal(collabVo.getDateDemarrageEffectiveMin(), collabVo.getDateDemarrageEffectiveMax());
        System.out.println("totalJourWithoutWeekEnd = " + totalJourWithoutWeekEnd + "  jourFierie = " + jourFierie);
        for (CollaborateurVo collaborateurVo : collaborateurVos) {
            collaborateurVo.setSommeJourNonWeekEnd(BigDecimal.valueOf(totalJourWithoutWeekEnd - jourFierie));
            Long conge = demandeCongeService.calcNombreJourTotal(collaborateurVo.getCollaborateur().getId(), collabVo.getDateDemarrageEffectiveMin(), collabVo.getDateDemarrageEffectiveMax());
            collaborateurVo.setSommeJourConge(new BigDecimal(conge));
            collaborateurVo.setSommeJourDecalage(collaborateurVo.getSommeJourNonWeekEnd().subtract(collaborateurVo.getSommeJourTravail().add(collaborateurVo.getSommeJourConge())));
        }
        return collaborateurVos;
    }

    public List<CollaborateurVo> calcTacheCount(CollaborateurVo collabVo) {
        String query = "SELECT new com.zs.erh.service.vo.CollaborateurVo(t.membreEquipe.collaborateur,COUNT(t.id)) FROM Tache t WHERE 1=1";
        query += addConstraintMinMaxDate("t", "dateDemarrageEffective", collabVo.getDateDemarrageEffectiveMin(), collabVo.getDateDemarrageEffectiveMax());
        query += addConstraint("t", "groupeTache.lot.projet.agence.chefAgence.id", "=", collabVo.getChefAgenceId());
        query += addConstraint("t", "groupeTache.equipe.responsable.id", "=", collabVo.getChefEquipeId());
        query += " GROUP BY t.membreEquipe.collaborateur.id ORDER BY t.membreEquipe.collaborateur.nom ASC,t.membreEquipe.collaborateur.prenom ASC";
        System.out.println("query = " + query);
        List<CollaborateurVo> res = getEntityManager().createQuery(query).getResultList();
        return res;
    }

    public List<Tache> search(TacheVo tacheVo) {
        System.out.println("tacheVo = " + tacheVo);
        String query = "SELECT t FROM Tache t WHERE 1=1";
        query += addCriteria(tacheVo);
        query += " ORDER BY t.dateDemarrageEffective DESC, t.periode.id ASC,t.membreEquipe.collaborateur.nom ASC,t.membreEquipe.collaborateur.prenom ASC  ";

        System.out.println("query = " + query);
        return findMultipleResult(query);
    }


    @Override
    public Class<Tache> getEntityClass() {
        return Tache.class;
    }
}