package pe.andy.rojas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lugar")

public class locaciones implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(unique = true)
	private Integer locationId;
	@Column
	private String direccion;
	@Column
	private Integer postalCode;
	@Column
	private String city;
	@Column
	private String provincita;
	@Column
	private Integer paisId;
	
	
	public locaciones(Integer locationId, String direccion, Integer postalCode, String city, String provincita,
			Integer paisId) {
		super();
		this.locationId = locationId;
		this.direccion = direccion;
		this.postalCode = postalCode;
		this.city = city;
		this.provincita = provincita;
		this.paisId = paisId;
	}
	
	public locaciones() {
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvincita() {
		return provincita;
	}

	public void setProvincita(String provincita) {
		this.provincita = provincita;
	}

	public Integer getPaisId() {
		return paisId;
	}

	public void setPaisId(Integer paisId) {
		this.paisId = paisId;
	}
	
	
	
}
