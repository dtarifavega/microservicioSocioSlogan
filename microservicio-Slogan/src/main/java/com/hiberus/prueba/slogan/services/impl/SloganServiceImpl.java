package com.hiberus.prueba.slogan.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.prueba.commons.entity.Slogan;
import com.hiberus.prueba.commons.services.CommonServiceImpl;
import com.hiberus.prueba.slogan.repository.SloganRepository;
import com.hiberus.prueba.slogan.services.SloganService;

@Service
public class SloganServiceImpl extends CommonServiceImpl<Slogan, SloganRepository> implements SloganService {

	@Autowired
	private SloganRepository repository;
	

}
