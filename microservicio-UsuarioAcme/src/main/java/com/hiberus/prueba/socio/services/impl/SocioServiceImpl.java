package com.hiberus.prueba.socio.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiberus.prueba.commons.entity.Socio;
import com.hiberus.prueba.commons.services.CommonServiceImpl;
import com.hiberus.prueba.socio.repository.SocioRepository;
import com.hiberus.prueba.socio.services.SocioService;

@Service
public class SocioServiceImpl extends CommonServiceImpl<Socio, SocioRepository> implements SocioService {

	@Autowired
	private SocioRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Socio> findByNameOrLastName(String term) {
		return repository.findByNameOrLastName(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Socio> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}






	

}
