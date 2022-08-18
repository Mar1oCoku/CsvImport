package com.andi.csvImport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andi.csvImport.service.UploadCsvService;


@RestController
public class CsvController
{
	@Autowired
    UploadCsvService uploadCsvService;
	
	@GetMapping("/uploadCsv")
	public  void richiesteGestite()
	{
		 uploadCsvService.importCsvData();
	}

}
