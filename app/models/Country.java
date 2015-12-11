package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
@Entity
@Table(name = "Country",
indexes = {
	      @Index(name="code_index", columnList = "code")})
public class Country implements BaseEntity{
	
	@Id
	Long id;
	
	@Column(name="code")
	private String code;
	@Column(name="name")
	private String name;
	@Column(name="continent")
	private String continent;
	@Column(name="keywords")
	private String keywords;
	@Column(name="wikipedia_link")
	private String wikipediaLink;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getWikipediaLink() {
		return wikipediaLink;
	}
	public void setWikipediaLink(String wikipediaLink) {
		this.wikipediaLink = wikipediaLink;
	}
	

}
