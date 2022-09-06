package com.andi.csvImport.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;


@Entity @javax.persistence.Table(name = "CO_PERSO")
public class Person implements Serializable {
    private static final long serialVersionUID = 2039929600241957716L;
     @Id @Column(name = "P_GUID", nullable = false, length = 50)
    private String pguid;
     @Column(name = "P_PERNO", nullable = true, length = 20)
    private String pernumber;
     @Column(name = "P_LANGU_ISO", nullable = true, length = 3) 
    private String languageCode;
     @Column(name = "P_LAST_NAME", nullable = true, length = 60)
    private String lastName;
     @Column(name = "P_FIRST_NAME", nullable = true, length = 40)
    private String firstName;
     @Column(name = "P_STREET", nullable = true, length = 40)
    private String addressStreet;
     @Column(name = "P_CITY", nullable = true, length = 40)
    private String addressCity;
     @Column(name = "P_ZIP_CODE", nullable = true, length = 10)
    private String addressZipCode;
     @Column(name = "P_VIS_NAME", nullable = true, length = 90)
    private String visName;
     @Column(name = "P_REASON", nullable = true, length = 70)
    private String reason;
     @Column(name = "P_PAPERTYPE", nullable = true)
    private Long paperTypeId;
     @Column(name = "P_PAPER_NO", nullable = true, length = 50)
    private String paperNo;
     @Column(name = "P_AUTHORIZATION", nullable = true, length = 50)
    private String authorization;
     @Column(name = "P_MANDANT", nullable = true, length = 50)
    private String mandant;
     @Column(name = "P_DATE_OF_BIRTH", nullable = true, length = 8)
    private String dateOfBirth;
     @Column(name = "P_PLACE_BIRTH", nullable = true, length = 50)
    private String birthPlace;
     @Column(name = "P_NATIONALITY", nullable = true, length = 50)
    private String nationality;
     @Column(name = "P_DISTRICT", nullable = true, length = 5)
    private String addressDistrict;
     @Column(name = "P_COUNTRY", nullable = true, length = 50)
    private String addressCountry;
     @Column(name = "P_PHONE1", nullable = true, length = 40)
    private String phone1;
     @Column(name = "P_PHONE2", nullable = true, length = 40)
    private String phone2;
     @Column(name = "P_LOGIN_USER", nullable = true)
    private Long loginUserId;
     @Column(name = "P_NOTE", nullable = true)
    private String note;
     @Column(name = "P_PHOTO_PATH", nullable = true)
    private String photoPath;
     @Column(name = "CLK_VALIDATION", nullable = false) @ColumnDefault("8")
    private int clk_validation;
    public int getClk_validation() {
        return clk_validation;
    }
     @Column(name = "P_FLAG_MENSA") @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean mensa;
    public void setClk_validation(int clk_validation) {
        this.clk_validation = clk_validation;
    }
     @Column(name = "PHOTO", nullable = true)
    private String photo;
//     @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "P_Type_Id")
     @Column(name = "type", nullable = true, length = 70)
    private Long type= 0L;
//     @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "P_Office")
     @Column(name = "office", nullable = true, length = 70)
    private Long office= 0L;
//     @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "P_CREDENTIALS")
     @Column(name = "credentials", nullable = true, length = 70)
    private Long credentials= 0L;
     @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "P_Ext_Company")
//     @Column(name = "company", nullable = true, length = 70)
    private Company company;
     @Transient
    private String badgeLabel;
     @Transient
    private String badges;
     @Transient
     private String fullName;
     @Transient
    private String groupsNames;

     @NotFound(action = NotFoundAction.IGNORE)
     @Where(clause = "spotgroup = 0")
//     @ManyToMany(fetch = FetchType.LAZY) 
     @JoinTable(name = "cw_groups_persons", 
     			joinColumns =  @JoinColumn(name = "person_id"), 
     			inverseJoinColumns =  @JoinColumn(name = "group_id"))
     
  //   @Where(clause = "spotgroup = 0", )
     @Column(name = "groups", nullable = true)
    private long groups=0L;
    
      @Transient
      @Column(name = "spot", nullable = true)
      private Long spot=0L;
   
//     @OneToMany(fetch = FetchType.LAZY) 
//     @JoinColumn(name = "B_GUID", referencedColumnName = "P_GUID")
     @Column(name = "badgesList", nullable = true)
    private long badgesList=0L;
     
     
//     @OneToMany(fetch = FetchType.LAZY) 
//     @JoinColumn(name = "SP_GUID", referencedColumnName = "P_GUID")
     @Column(name = "spotList", nullable = true)
    private long spotList=0L;

    
     @Column(name = "LAST_UPD")
    private Date upd;
     @Column(name = "USER_UPD")
    private String user;
     
     @Column(name = "EMAIL_ADDRESS")
     private String emailAddress;
     
     @Column(name = "NICKNAME")
     private String nickname;
     
    public Person() {
        super();
    }
     @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pguid == null) ? 0 : pguid.hashCode());
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
        Person other = (Person)obj;
        if (getPguid() == null) {
            if (other.getPguid() != null)
                return false;
        } else if (!getPguid().equals(other.getPguid()))
            return false;
        return true;
    }
    public String getDisplayName() {
        String res = "";
        if (getFirstName() != null)
            res += getFirstName();
        if (getLastName() != null) {
            if (res != "")
                res += " ";
            res += getLastName();
        }
        if (getPernumber() != null) {
            if (res != "")
                res += " ";
            res += getPernumber();
        }
        return res;
    }
    public String getPguid() {
        return pguid;
    }
    public void setPguid(String pguid) {
        this.pguid = pguid;
    }
    public String getPernumber() {
        return pernumber;
    }
    public void setPernumber(String pernumber) {
        this.pernumber = pernumber;
    }
    public String getLanguageCode() {
        return languageCode;
    }
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getAddressStreet() {
        return addressStreet;
    }
    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }
    public String getAddressCity() {
        return addressCity;
    }
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }
    public String getAddressZipCode() {
        return addressZipCode;
    }
    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }
    public Long getType() {
        return type;
    }
    public void setType(Long type) {
        this.type = type;
    }
    public Long getOffice() {
        return office;
    }
    public void setOffice(Long office) {
        this.office = office;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public String getBadgeLabel() {
        return badgeLabel;
    }
    public void setBadgeLabel(String badgeLabel) {
        this.badgeLabel = badgeLabel;
    }
     @Override
    public String toString() {
        return "Person [pguid=" + pguid + ", pernumber=" + pernumber + ", languageCode=" + languageCode + ", lastName="
        +lastName + ", firstName=" + firstName + ", addressStreet=" + addressStreet + ", addressCity="
        +addressCity + ", addressZipCode=" + addressZipCode + ", badgeLabel=" + badgeLabel +  "]";
    }
    public String getVisName() {
        return visName;
    }
    public void setVisName(String visName) {
        this.visName = visName;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getPaperNo() {
        return paperNo;
    }
    public void setPaperNo(String paperNo) {
        this.paperNo = paperNo;
    }
    public Long getPaperTypeId() {
        return paperTypeId;
    }
    public void setPaperTypeId(Long paperTypeId) {
        this.paperTypeId = paperTypeId;
    }
    public String getAuthorization() {
        return authorization;
    }
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }
    public String getMandant() {
        return mandant;
    }
    public void setMandant(String mandant) {
        this.mandant = mandant;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public Date getDateOfBirthAsDate() {
        try {
            if (this.dateOfBirth == null) {
                return null;
            }
            return new SimpleDateFormat("yyyyMMdd").parse(this.dateOfBirth);
        } catch (ParseException e) {
            return null;
        }
    }
    public void setDateOfBirthAsDate(Date fromDateAsDate) {
        if (fromDateAsDate == null) {
            this.dateOfBirth = null;
        } else {
            this.dateOfBirth = new SimpleDateFormat("yyyyMMdd").format(fromDateAsDate);
        }
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getAddressDistrict() {
        return addressDistrict;
    }
    public void setAddressDistrict(String addressDistrict) {
        this.addressDistrict = addressDistrict;
    }
    public String getAddressCountry() {
        return addressCountry;
    }
    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }
    public String getPhone1() {
        return phone1;
    }
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }
    public String getPhone2() {
        return phone2;
    }
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getPhotoPath() {
        return photoPath;
    }
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getBadges() {
        return badges;
    }
    public void setBadges(String badges) {
        this.badges = badges;
    }
    public long getGroups() {
        return groups;
    }
    public void setGroups(long groups) {
        this.groups = groups;
    }
    public long getBadgesList() {
        return badgesList;
    }
    public void setBadgesList(long badgesList) {
        this.badgesList = badgesList;
    }
    public String getGroupsNames() {
        return groupsNames;
    }
    public void setGroupsNames(String groupsNames) {
        this.groupsNames = groupsNames;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setUpd(Date upd) {
        this.upd = new Date();
    }
    public Long getLoginUserId() {
        return loginUserId;
    }
    public void setLoginUserId(Long loginUserId) {
        this.loginUserId = loginUserId;
    }
    public String getBirthPlace() {
        return birthPlace;
    }
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public boolean isMensa() {
        return mensa;
    }
    public void setMensa(boolean mensa) {
        this.mensa = mensa;
    }
    public Long getCredentials() {
        return credentials;
    }
    public void setCredentials(Long credentials) {
        this.credentials = credentials;
    }
    public long getSpotList() {
        return spotList;
    }
    public void setSpotList(long spotList) {
        this.spotList = spotList;
    }
	public String getFullName() {
		this.fullName = this.firstName + " " +this.lastName ;
		return this.fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Long getSpot() {
		return spot;
	}
	public void setSpot(Long spot) {
		this.spot = spot;
	}
	
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
