package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Runway")
public class Runway implements BaseEntity{

	@Id
	Long id;
	
	@Column(name="length_ft")
	Long lengthFt;
	@Column(name="width_ft")
	Long widthFt;
	@Column(name="surface")
	String surface;
	@Column(name="lighted")
	Boolean lighted;
	@Column(name="closed")
	Boolean closed;
	@Column(name="le_ident")
	String leIdent;
	@Column(name="leLatitude_deg")
	Double leLatitudeDeg;
	@Column(name="le_longitude_deg")
	Double leLongitudeDeg;
	@Column(name="le_elevation_ft")
	Double leElevationFt;
	@Column(name="le_heading_degT")
	Double leHeadingDegT;
	@Column(name="le_displaced_threshold_ft")
	Double leDisplacedThresholdFt;
	@Column(name="he_ident")
	String heIdent;
	@Column(name="he_latitude_deg")
	Double heLatitudeDeg;
	@Column(name="he_longitude_deg")
	Double heLongitudeDeg;
	@Column(name="he_elevation_ft")
	Long heElevationFt;
	@Column(name="he_heading_degT")
	Double heHeadingDegT;
	@Column(name="he_displaced_threshold_ft")
	Long heDisplacedThresholdFt;
	
	@ManyToOne
	@JoinColumn(name = "fk_airport_id")
	Airport airport;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLengthFt() {
		return lengthFt;
	}

	public void setLengthFt(Long lengthFt) {
		this.lengthFt = lengthFt;
	}

	public Long getWidthFt() {
		return widthFt;
	}

	public void setWidthFt(Long widthFt) {
		this.widthFt = widthFt;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public Boolean getLighted() {
		return lighted;
	}

	public void setLighted(Boolean lighted) {
		this.lighted = lighted;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public String getLeIdent() {
		return leIdent;
	}

	public void setLeIdent(String leIdent) {
		this.leIdent = leIdent;
	}

	public Double getLeLatitudeDeg() {
		return leLatitudeDeg;
	}

	public void setLeLatitudeDeg(Double leLatitudeDeg) {
		this.leLatitudeDeg = leLatitudeDeg;
	}

	public Double getLeLongitudeDeg() {
		return leLongitudeDeg;
	}

	public void setLeLongitudeDeg(Double leLongitudeDeg) {
		this.leLongitudeDeg = leLongitudeDeg;
	}

	public Double getLeElevationFt() {
		return leElevationFt;
	}

	public void setLeElevationFt(Double leElevationFt) {
		this.leElevationFt = leElevationFt;
	}

	public Double getLeHeadingDegT() {
		return leHeadingDegT;
	}

	public void setLeHeadingDegT(Double leHeadingDegT) {
		this.leHeadingDegT = leHeadingDegT;
	}

	public Double getLeDisplacedThresholdFt() {
		return leDisplacedThresholdFt;
	}

	public void setLeDisplacedThresholdFt(Double leDisplacedThresholdFt) {
		this.leDisplacedThresholdFt = leDisplacedThresholdFt;
	}

	public String getHeIdent() {
		return heIdent;
	}

	public void setHeIdent(String heIdent) {
		this.heIdent = heIdent;
	}

	public Double getHeLatitudeDeg() {
		return heLatitudeDeg;
	}

	public void setHeLatitudeDeg(Double heLatitudeDeg) {
		this.heLatitudeDeg = heLatitudeDeg;
	}

	public Double getHeLongitudeDeg() {
		return heLongitudeDeg;
	}

	public void setHeLongitudeDeg(Double heLongitudeDeg) {
		this.heLongitudeDeg = heLongitudeDeg;
	}

	public Long getHeElevationFt() {
		return heElevationFt;
	}

	public void setHeElevationFt(Long heElevationFt) {
		this.heElevationFt = heElevationFt;
	}

	public Double getHeHeadingDegT() {
		return heHeadingDegT;
	}

	public void setHeHeadingDegT(Double heHeadingDegT) {
		this.heHeadingDegT = heHeadingDegT;
	}

	public Long getHeDisplacedThresholdFt() {
		return heDisplacedThresholdFt;
	}

	public void setHeDisplacedThresholdFt(Long heDisplacedThresholdFt) {
		this.heDisplacedThresholdFt = heDisplacedThresholdFt;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	
	

}
