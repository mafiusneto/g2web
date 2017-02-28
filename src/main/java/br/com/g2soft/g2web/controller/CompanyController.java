package br.com.g2soft.g2web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.g2soft.g2web.domain.Address;
import br.com.g2soft.g2web.domain.Company;
import br.com.g2soft.g2web.generic.EventException;
import br.com.g2soft.g2web.service.CompanyService;
import br.com.g2soft.g2web.util.Constants;

@Controller
@RequestMapping(path=Constants.URL_COMPANY)
public class CompanyController {

	@Autowired
	private CompanyService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Company create(@RequestBody Company company) {
		return service.create(company);
	}
	
	@RequestMapping(method=RequestMethod.GET, path=Constants.COMPANY_ID)
	public @ResponseBody Company view(@RequestParam Integer companyId) throws EventException {
		return service.view(companyId);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Company> list() {
		return service.list();
	}
	
	@RequestMapping(method=RequestMethod.PUT, path=Constants.COMPANY_ID)
	public @ResponseBody Company update(@RequestParam Integer companyId, @RequestBody Company company) throws EventException {
		return service.update(companyId, company);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path=Constants.COMPANY_ID)
	public @ResponseBody Company delete(@RequestParam Integer companyId) throws EventException {
		return service.delete(companyId);
	}
	
	@RequestMapping(method=RequestMethod.GET, path=Constants.URL_COMPANY_ADDRESS)
	public @ResponseBody Address getAddress(@RequestParam Integer companyId) throws EventException {
		return service.viewAddress(companyId);
	}
}
