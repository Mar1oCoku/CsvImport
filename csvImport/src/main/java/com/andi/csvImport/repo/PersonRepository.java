package com.andi.csvImport.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.andi.csvImport.model.Person;

public interface PersonRepository extends JpaRepository<Person, String>{
	
	@Query(value="SELECT  p_guid FROM co_perso WHERE p_guid = :id ",nativeQuery=true)
	Integer findIfPersonExists(@RequestParam("id") Integer id);
	
	@Query(value="SELECT  * FROM co_perso WHERE p_guid = :id ",nativeQuery=true)
	Person findPerson(@RequestParam("id") Integer id);

}
