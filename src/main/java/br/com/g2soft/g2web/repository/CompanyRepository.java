package br.com.g2soft.g2web.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.g2soft.g2web.domain.Company;

public interface CompanyRepository extends CrudRepository<Company, Integer> {

}
