package com.hiberus.prueba.slogan.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.prueba.commons.controllers.CommonController;
import com.hiberus.prueba.commons.entity.Slogan;
import com.hiberus.prueba.slogan.services.SloganService;

@RestController
public class SloganController extends CommonController<Slogan, SloganService>{

	@Autowired
	private SloganService service;
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Slogan slogan, BindingResult result, @PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Slogan> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Slogan sloganDb = o.get();
		sloganDb.setText(slogan.getText());
		sloganDb.setTitle(slogan.getTitle());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(sloganDb));
	}
	


	

}
