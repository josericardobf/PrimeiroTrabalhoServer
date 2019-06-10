package com.josericardo.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.josericardo.cursomc.domain.Login;
import com.josericardo.cursomc.dto.LoginDTO;
import com.josericardo.cursomc.services.LoginService;

@RestController
@RequestMapping(value="/Logins")
public class LoginResource {

	@Autowired
	private LoginService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Login> find(@PathVariable Integer id)	{
		Login obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<LoginDTO>> findAll() {
		List<Login> list = service.findAll();
		List<LoginDTO> listDto = list.stream().map(obj -> new LoginDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<LoginDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Login> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<LoginDTO> listDto = list.map(obj -> new LoginDTO(obj));

		return ResponseEntity.ok().body(listDto);
	}
}