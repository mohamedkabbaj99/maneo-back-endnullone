package com.zs.erh.service.facade;

import com.zs.erh.bean.MembreEquipe;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;



public interface MembreEquipeService {
	public List<MembreEquipe> findAll();
	public List<MembreEquipe> findByEquipeCode(String code);
	public List<MembreEquipe> findByEquipeId(Long id);
	public int deleteByEquipeCode(String code);
	List<MembreEquipe> findByCollaborateurCode(String code);
	public MembreEquipe update(MembreEquipe membreEquipe);
	public MembreEquipe save(MembreEquipe membreEquipe);
	public MembreEquipe findByEquipeCodeAndCollaborateurLogin(String codeEquipe, String loginCollaborateur);
	public MembreEquipe findByEquipeCodeAndCollaborateurCode(String codeEquipe, String codeCollaborateur);
	public int deleteByEquipeCodeAndCollaborateurCode(String codeEquipe,String codeCollaborateur);
}
