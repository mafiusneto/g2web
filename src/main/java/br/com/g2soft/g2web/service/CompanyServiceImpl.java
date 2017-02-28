package br.com.g2soft.g2web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.g2soft.g2web.domain.Address;
import br.com.g2soft.g2web.domain.Company;
import br.com.g2soft.g2web.generic.EventException;
import br.com.g2soft.g2web.repository.CompanyRepository;
import br.com.g2soft.g2web.util.ErrorMessages;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository repository;
	
	public Company create(Company company) {
		company.setCreationDate(new Date());
		return repository.save(company);
	}

	public Company update(Integer companyId, Company company) throws EventException {
		Company companyDB = repository.findOne(companyId);
		
		if (companyDB == null) {
			throw new EventException(ErrorMessages.COMPANY_NOT_FOUND, HttpStatus.NOT_FOUND);
		} 
		companyDB.setCode(company.getCode());
		companyDB.setSocialReason(company.getSocialReason());
		companyDB.setFantasyName(company.getFantasyName());
		companyDB.setCpf(company.getCpf());
		companyDB.setCnpj(company.getCnpj());
		companyDB.setStateRegistration(company.getStateRegistration());
		companyDB.setMunicipalRegistration(company.getMunicipalRegistration());
		companyDB.setCnae(company.getCnae());
		companyDB.setTypeActivity(company.getTypeActivity());
		companyDB.setCrt(company.getCrt());
		companyDB.setAddress(company.getAddress());
		companyDB.setResponsible(company.getResponsible());
		return repository.save(companyDB);
	}

	public Company view(Integer companyId) throws EventException {
		
		Company companyDB = repository.findOne(companyId);
		
		if (companyDB == null) {
			throw new EventException(ErrorMessages.COMPANY_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		
		return companyDB;
	}

	public List<Company> list() {
		return (ArrayList<Company>) repository.findAll();
	}

	public Company delete(Integer companyId) throws EventException  {
		Company companyDB = repository.findOne(companyId);
		
		if (companyDB == null) {
			throw new EventException("dsadas", HttpStatus.BAD_REQUEST);			
		} 
		
		repository.delete(companyDB);
		
		return companyDB;
	}

	public Address viewAddress(Integer companyId) throws EventException {
		
		Company companyDB = repository.findOne(companyId);
		
		if (companyDB == null) {
			throw new EventException("dsadas", HttpStatus.BAD_REQUEST);			
		} 
		
		return companyDB.getAddress();
	}

}
