package br.com.g2soft.g2web.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(unique=true)
	private Integer code;
	
	@NotNull
	private String socialReason;
	
	@NotNull
	private String fantasyName;
	
	private String cpf;
	
	private String cnpj;
	
	@NotNull
	private String stateRegistration;
	
	@NotNull
	private String municipalRegistration;
	
	@NotNull
	private String cnae;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private CompanyTypeActivity typeActivity;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private CRTType crt;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	private String responsible;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getSocialReason() {
		return socialReason;
	}

	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getStateRegistration() {
		return stateRegistration;
	}

	public void setStateRegistration(String stateRegistration) {
		this.stateRegistration = stateRegistration;
	}

	public String getMunicipalRegistration() {
		return municipalRegistration;
	}

	public void setMunicipalRegistration(String municipalRegistration) {
		this.municipalRegistration = municipalRegistration;
	}

	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
	}

	public CompanyTypeActivity getTypeActivity() {
		return typeActivity;
	}

	public void setTypeActivity(CompanyTypeActivity typeActivity) {
		this.typeActivity = typeActivity;
	}

	public CRTType getCrt() {
		return crt;
	}

	public void setCrt(CRTType crt) {
		this.crt = crt;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	
}
