package com.andi.csvImport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andi.csvImport.service.UploadCsvService;

@SpringBootApplication
public class CsvImportApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvImportApplication.class, args);
	}
	
//	@Autowired
//    UploadCsvService uploadCsvService;
//
//	public void run(ApplicationArguments args) throws Exception
//	{
//		uploadCsvService.importCsvData();;
//	}

}
