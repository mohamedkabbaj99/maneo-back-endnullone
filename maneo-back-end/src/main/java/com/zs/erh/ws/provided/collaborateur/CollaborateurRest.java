package com.zs.erh.ws.provided.collaborateur;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.service.facade.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "maneo-rh/collaborateur")
public class CollaborateurRest {

	@GetMapping("/login/{login}")
	public Collaborateur findByLogin(@PathVariable String login) {
		return collaborateurService.findByLogin(login);
	}


	@GetMapping("/code/{code}")
	public Collaborateur findByCode(@PathVariable String code) {
		return collaborateurService.findByCode(code);
	}

    @GetMapping("/codec/{codec}")
	public List<Collaborateur> findByAgenceChefAgenceCode(String codec) {
		return collaborateurService.findByAgenceChefAgenceCode(codec);
	}

	@GetMapping("/findCollaborateurs/{login}")
	public List<Collaborateur> findCollaborateurs(@PathVariable String login){
		return collaborateurService.findCollaborateurs(login);
	}

	@Autowired
	private CollaborateurService collaborateurService;
}
