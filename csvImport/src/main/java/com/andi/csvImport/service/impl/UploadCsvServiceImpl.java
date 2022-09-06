package com.andi.csvImport.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andi.csvImport.model.Company;
import com.andi.csvImport.model.Person;
import com.andi.csvImport.repo.CompanyRepository;
import com.andi.csvImport.repo.PersonRepository;
import com.andi.csvImport.service.UploadCsvService;

@Service
public class UploadCsvServiceImpl implements UploadCsvService 
{

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Value("${filePath}")
	String filePath;
	
	@Value("${id}")
	int id;
	
	@Value("${firstName}")
	int firstName;
	
	@Value("${lastname}")
	int lastname;
	
	@Value("${company}")
	int company;
	
	@Value("${status}")
	int status;

	
	@Transactional
	@Override
	public void importCsvData() 
	{
		try 
		{
			InputStream stream = this.getClass().getResourceAsStream(filePath);
			CSVParser records = CSVParser.parse(stream, Charset.forName("UTF-8"), CSVFormat.EXCEL.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().withDelimiter(';'));
			
			for (CSVRecord record : records)
			{
				Company c = new Company();
				Person p = new Person();
				
				if(record.get(status).equals("0"))
				{
					int b = Integer.parseInt(record.get(0));
					int a = 6;
					jdbcTemplate.execute("UPDATE CO_BADGE SET B_STATUS = "+ a + " WHERE B_GUID = "+b);
				}
				else				
				if(record.get(status).equals("1") ) 
				{
					//verifica che la company con la company.description esiste
					String descriptionById =companyRepository.findDescriptionById(Integer.parseInt(record.get(id)));
					//if not exist
					Company c1 = companyRepository.findDescriptionId(Integer.parseInt(record.get(id)));
					if(descriptionById == null)
					{	
						//c.setId(Long.valueOf(record.get(0)));
						c.setDescription(record.get(company));
						companyRepository.save(c);
					}
					else
					{
						c1.setDescription(record.get(company));
						companyRepository.save(c1);
					}
					
					//verificare che la persona esiste in CO_PERSON attraverso la person.guid
					Integer idRecord = personRepository.findIfPersonExists(Integer.parseInt(record.get(id)));
					
					if(idRecord!=null)
					{
						
						//Se esiste il sistema aggiorna nome e cognome e la company
						Optional<Person> opt = personRepository.findPerson(Integer.parseInt(record.get(id)));
						if(opt.isPresent()) {
							Person p1 = opt.get();
						p1.setFirstName(record.get(firstName));
						p1.setLastName(record.get(lastname));
						p1.setCompany(c1);
						personRepository.save(p1);
						}
					}
					else
					{
						p.setPguid(record.get(id));
						p.setAddressCity("0");
						p.setAddressCountry("0");
						p.setAddressDistrict("0");
						p.setAddressStreet("0");
						p.setAddressZipCode("0");
						p.setAuthorization("0");
						p.setBadgeLabel("0");
						p.setBadges("0");
						p.setBadgesList(0L);
						p.setBirthPlace("0");
						p.setClk_validation(0);
						p.setCredentials(0L);
						p.setDateOfBirth("0");
						p.setEmailAddress("0");
						p.setFirstName(record.get(firstName));
						p.setFullName(record.get(firstName));
						p.setGroups(0L);
						p.setGroupsNames("0");
						p.setLanguageCode("0");
						p.setLastName(record.get(lastname));
						p.setLoginUserId(0L);
						p.setMandant("0");
						p.setMensa(false);
						p.setNationality("0");
						p.setNickname("0");
						p.setNote("0");
						p.setOffice(0L);
						p.setPaperNo("0");
						p.setPaperTypeId(0L);
						p.setPernumber("0");
						p.setPhone1("0");
						p.setPhone2("0");
						p.setPhoto("0");
						p.setPhotoPath("0");
						p.setReason("0");
						p.setSpot(0L);
						p.setSpotList(0L);
						p.setType(0L);
						p.setUser("0");
						p.setVisName("0");
						p.setCompany(c);
						personRepository.save(p);
					}
				}
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
