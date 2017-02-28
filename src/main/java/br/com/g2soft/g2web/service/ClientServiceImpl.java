package br.com.g2soft.g2web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.g2soft.g2web.domain.Address;
import br.com.g2soft.g2web.domain.Client;
import br.com.g2soft.g2web.generic.EventException;
import br.com.g2soft.g2web.domain.Bunch;
import br.com.g2soft.g2web.repository.ClientRepository;
import br.com.g2soft.g2web.util.ErrorMessages;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository repository;
	
	public Client createClient(Client client) {
		return repository.save(client);
	}

	public Client updateClient(Integer clientId, Client client) throws EventException {
		
		Client clientDB = repository.findOne(clientId);
		
		if (clientDB == null) {
			throw new EventException(ErrorMessages.CLIENT_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		
		clientDB.setCode(client.getCode());
		clientDB.setName(client.getName());
		clientDB.setFantasyName(client.getFantasyName());
		clientDB.setEmail(client.getEmail());
		clientDB.setFatherName(client.getFatherName());
		clientDB.setMotherName(client.getMotherName());
		clientDB.setCpf(client.getCpf());
		clientDB.setCnpj(client.getCnpj());
		clientDB.setSituation(client.getIsSituation());
		clientDB.setConvenant(client.getConvenant());
		clientDB.setNaturalOf(client.getNaturalOf());
		clientDB.setSpouse(client.getSpouse());
		clientDB.setGender(client.getGender());
		clientDB.setAddresses(client.getAddresses());
	
		return repository.save(clientDB);
	}
	
	public Client view(Integer clientId) throws EventException {
		
		Client clientDB = repository.findOne(clientId);
		
		if (clientDB == null) {
			throw new EventException(ErrorMessages.CLIENT_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		
		return clientDB;
	}

	public List<Client> listClients() {		
		return (ArrayList<Client>) repository.findAll();
	}

	public List<Address> listAddresses(Integer clientId) throws EventException {
		
		Client clientDB = repository.findOne(clientId);
		
		if (clientDB == null) {
			throw new EventException(ErrorMessages.CLIENT_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		
		return clientDB.getAddresses();
	}

	public List<Bunch> listBunches(Integer clientId) throws EventException {
		
		Client clientDB = repository.findOne(clientId);
		
		if (clientDB == null) {
			throw new EventException(ErrorMessages.CLIENT_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		
		return clientDB.getBunches();
	}

	public Client deleteClient(Integer clientId) throws EventException {
		
		Client clientDB = repository.findOne(clientId);
		
		if (clientDB == null) {
			throw new EventException(ErrorMessages.CLIENT_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		
		repository.delete(clientDB);
		
		return clientDB;
	}
	
	
}
