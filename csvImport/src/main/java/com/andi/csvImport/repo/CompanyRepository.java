package com.andi.csvImport.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.andi.csvImport.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	@Query(value="Select c_description from co_ext_company where c_ext_company = :id",nativeQuery=true)
	String findDescriptionById(@RequestParam("id") int id);
	
	@Query(value="Select * from co_ext_company where c_ext_company = :id",nativeQuery=true)
	Company findDescriptionId(@RequestParam("id") int id);
}
