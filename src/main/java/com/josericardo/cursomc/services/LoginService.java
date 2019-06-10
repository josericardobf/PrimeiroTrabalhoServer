package com.josericardo.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.josericardo.cursomc.domain.Login;
import com.josericardo.cursomc.dto.LoginDTO;
import com.josericardo.cursomc.repositories.LoginRepository;
import com.josericardo.cursomc.services.exceptions.DataIntegrityException;
import com.josericardo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;
	
	public Login find(Integer email) {
		Optional<Login> obj = repo.findById(email);

		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! email: " + email
					+ ", Tipo: " + Login.class.getEmail());
		}

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! email: " + email + ", Tipo: " + Login.class.getEmail()));
	}
	
	public List<Login> findAll() {
		return repo.findAll();
	}
	
	public Page<Login> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Login fromDto(LoginDTO objDto) {
		return new Login(objDto.getEmail(), objDto.getPassword());
	}
}
