package br.com.g2soft.g2web.service;

import java.util.List;

import br.com.g2soft.g2web.domain.Address;
import br.com.g2soft.g2web.domain.Company;
import br.com.g2soft.g2web.generic.EventException;

public interface CompanyService {

	public Company create(Company company);
	
	public Company update(Integer companyId, Company company) throws EventException;
	
	public Company view(Integer companyId) throws EventException;
	
	public List<Company> list();
	
	public Company delete(Integer companyId) throws EventException;
	 
	public Address viewAddress(Integer companyId) throws EventException;
}
