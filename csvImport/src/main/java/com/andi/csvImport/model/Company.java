package com.andi.csvImport.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;



/**
 * 
 * Class name: Company
 *
 * Description: 
 * 
 *
 * Company: 
 *
 * @author 
 * @date 20/octo/2017
 *
 */
@Entity
@javax.persistence.Table(name="CO_EXT_COMPANY")
public class Company implements Serializable {

	private static final long serialVersionUID = 2143380322679023134L;

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(
		    strategy= GenerationType.AUTO,
		    generator="native"
		)
		@GenericGenerator(
		    name = "native",
		    strategy = "native"
		)
	//@Column(name="C_EXT_COMPANY", columnDefinition="NUMBER(11,0)", nullable = false)
	@Column(name="C_EXT_COMPANY", nullable = false)
	private Long id;
	
	@Column(name="C_DESCRIPTION", nullable = false, length=50)
	private String description;

	
	@Column(name="C_STREET", nullable = true, length=40)
	private String street;

	
	@Column(name="C_CITY", nullable = true, length=40)
	private String city;

	
	@Column(name="C_ZIP_CODE", nullable = true, length=10)
	private String zipcode;

	
	@Column(name="C_DISTRICT", nullable = true, length=50)
	private String district;


	
	@Column(name="C_COUNTRY", nullable = true, length=50)
	private String country;

	
	@Column(name="C_PHONE1", nullable = true, length=20)
	private String phone;

	
	@Column(name="C_PHONE2", nullable = true, length=20)
	private String fax;

	
	@Column(name="C_MANDANT", nullable = true, length=30)
	private String mandant;

	
//	@ManyToOne (fetch=FetchType.LAZY)
//	@JoinColumn (name="SITE_ID")
	private Long site;
	
	/**
     * Costruttore
     */
    public Company() {
    	super();
    }
    

  
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description.toUpperCase();
	}




	public String getStreet() {
		return street;
	}




	public void setStreet(String street) {
		this.street = street;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getZipcode() {
		return zipcode;
	}




	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}




	public String getDistrict() {
		return district;
	}




	public void setDistrict(String district) {
		this.district = district;
	}




	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getFax() {
		return fax;
	}




	public void setFax(String fax) {
		this.fax = fax;
	}




	public String getMandant() {
		return mandant;
	}




	public void setMandant(String mandant) {
		this.mandant = mandant;
	}




	@Override
	public String toString() {
		return "Company [id=" + id + ", description=" + description + ", street=" + street + ", city=" + city
				+ ", zipcode=" + zipcode + ", district=" + district + ", country=" + country + ", phone=" + phone
				+ ", fax=" + fax + ", mandant=" + mandant + "]";
	}




	public Long getSite() {
		return site;
	}




	public void setSite(Long site) {
		this.site = site;
	}






}
