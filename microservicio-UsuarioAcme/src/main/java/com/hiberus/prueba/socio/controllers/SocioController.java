package com.hiberus.prueba.socio.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.prueba.commons.controllers.CommonController;
import com.hiberus.prueba.commons.entity.Socio;
import com.hiberus.prueba.socio.services.SocioService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class SocioController extends CommonController<Socio, SocioService>{

	@Autowired
	private SocioService service;
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Socio socio, BindingResult result, @PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Socio> o = service.findById(id);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Socio socioDb = o.get();
		socioDb.setAddress(socio.getAddress());
		socioDb.setCity(socio.getCity());
		socioDb.setEmail(socio.getEmail());
		socioDb.setLast_name(socio.getLast_name());
		socioDb.setName(socio.getName());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(socioDb));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.ok(service.findByNameOrLastName(term));
	}

	

}
