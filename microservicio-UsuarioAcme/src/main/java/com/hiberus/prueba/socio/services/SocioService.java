package com.hiberus.prueba.socio.services;

import java.util.List;

import com.hiberus.prueba.commons.entity.Socio;
import com.hiberus.prueba.commons.services.CommonService;

public interface SocioService extends CommonService<Socio>{
	
	public List<Socio> findByNameOrLastName(String term);
	
	public Iterable<Socio> findAllById(Iterable<Long> ids);

}
