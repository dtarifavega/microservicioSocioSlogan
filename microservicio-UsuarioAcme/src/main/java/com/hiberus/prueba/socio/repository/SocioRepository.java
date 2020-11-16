package com.hiberus.prueba.socio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hiberus.prueba.commons.entity.Socio;

public interface SocioRepository extends PagingAndSortingRepository<Socio, Long> {

	@Query("select s from Socio s where upper(s.name) like upper(concat('%', ?1, '%')) or upper(s.last_name) like upper(concat('%', ?1, '%'))")
	public List<Socio> findByNameOrLastName(String term);
}
