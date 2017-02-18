package br.com.g2soft.g2web.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer code;
	
	private String name;
	
	private String fantasyName;
	
	private String email;
	
	private String fatherName;
	
	private String motherName;
	
	private String cpf;
	
	private String cnpj;
	
	private boolean situation;
	
	private String convenant;
	
	private String naturalOf;
	
	private String spouse;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> addresses;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Bunch> bunches;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNomeFantasia() {
		return fantasyName;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.fantasyName = nomeFantasia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String nomePai) {
		this.fatherName = nomePai;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String nomeMae) {
		this.motherName = nomeMae;
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

	public boolean getIsSituation() {
		return situation;
	}

	public void setIsSituation(boolean situacao) {
		this.situation = situacao;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getConvenant() {
		return convenant;
	}

	public void setConvenant(String convenant) {
		this.convenant = convenant;
	}

	public String getNaturalOf() {
		return naturalOf;
	}

	public void setNaturalOf(String naturalOf) {
		this.naturalOf = naturalOf;
	}

	public String getSpouse() {
		return spouse;
	}

	public void setSpouse(String spouse) {
		this.spouse = spouse;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public boolean isSituation() {
		return situation;
	}

	public void setSituation(boolean situation) {
		this.situation = situation;
	}

	public List<Bunch> getBunches() {
		return bunches;
	}

	public void setBunches(List<Bunch> bunches) {
		this.bunches = bunches;
	}
	
}
