package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Airport")
public class Airport implements BaseEntity{

	@Id
	Long id;
	
	@Column(name="ident")
	String ident;
	@Column(name="type")
	String type ; 
	@Column(name="name")
	String name;
	@Column(name="latitude_deg")
	Double latitudeDeg;
	@Column(name="longitude_deg")
	Double longitudeDeg;
	@Column(name="elevation_ft")
	Long elevationFt;
	@Column(name="iso_region")
	String isoRegion   ;
	@Column(name="municipality")
	String municipality ;
	@Column(name="scheduled_service")
	Boolean scheduledService;
	@Column(name="gps_code")
	String gpsCode   ;  
	@Column(name="iata_code")
	String iataCode  ;
	@Column(name="local_code")
	String localCode ; 
	@Column(name="home_link")
	String homeLink   ;
	@Column(name="wikipedia_link")
	String wikipediaLink;
	@Column(name="keywords")
	String keywords;
	
	@ManyToOne
	@JoinColumn(name="fk_country_id")
	private Country country;
	

	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getLatitudeDeg() {
		return latitudeDeg;
	}
	public void setLatitudeDeg(Double latitudeDeg) {
		this.latitudeDeg = latitudeDeg;
	}
	public Double getLongitudeDeg() {
		return longitudeDeg;
	}
	public void setLongitudeDeg(Double longitudeDeg) {
		this.longitudeDeg = longitudeDeg;
	}
	public Long getElevationFt() {
		return elevationFt;
	}
	public void setElevationFt(Long elevationFt) {
		this.elevationFt = elevationFt;
	}
	public String getIsoRegion() {
		return isoRegion;
	}
	public void setIsoRegion(String isoRegion) {
		this.isoRegion = isoRegion;
	}
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	public Boolean getScheduledService() {
		return scheduledService;
	}
	public void setScheduledService(Boolean scheduledService) {
		this.scheduledService = scheduledService;
	}
	public String getGpsCode() {
		return gpsCode;
	}
	public void setGpsCode(String gpsCode) {
		this.gpsCode = gpsCode;
	}
	public String getIataCode() {
		return iataCode;
	}
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}
	public String getLocalCode() {
		return localCode;
	}
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	public String getHomeLink() {
		return homeLink;
	}
	public void setHomeLink(String homeLink) {
		this.homeLink = homeLink;
	}
	public String getWikipediaLink() {
		return wikipediaLink;
	}
	public void setWikipediaLink(String wikipediaLink) {
		this.wikipediaLink = wikipediaLink;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

}
