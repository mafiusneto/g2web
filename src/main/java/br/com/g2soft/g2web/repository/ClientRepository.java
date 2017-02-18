package br.com.g2soft.g2web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.g2soft.g2web.domain.Address;
import br.com.g2soft.g2web.domain.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{

	public List<Address> findAddressesById(Integer clientId);
	
}
