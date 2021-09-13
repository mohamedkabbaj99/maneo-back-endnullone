package com.zs.erh.dao;


import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CollaborateurDao extends JpaRepository<Collaborateur, Long>{
	public List<Collaborateur> findAll();
	public Collaborateur findByCode(String code);
	//public List<Collaborateur> findByEquipeDefaultCode(String code);
	Optional<Collaborateur> findById(Long id);
	public Collaborateur findByLogin(String login);
	public Collaborateur findByLoginAndPassword(String login, String password);
	List<Collaborateur> findByAgenceChefAgenceCode(String code);
	public List<Collaborateur> findByAgenceCode(String code);

}
