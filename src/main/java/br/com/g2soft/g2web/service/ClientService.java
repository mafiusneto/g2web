package br.com.g2soft.g2web.service;

import java.util.List;

import br.com.g2soft.g2web.domain.Address;
import br.com.g2soft.g2web.domain.Client;
import br.com.g2soft.g2web.generic.EventException;
import br.com.g2soft.g2web.domain.Bunch;

public interface ClientService {

	public Client createClient(Client client);
	
	public Client updateClient(Integer clientId, Client client) throws EventException;
	
	public Client view(Integer clientId) throws EventException;
	
	public List<Client> listClients();
	
	public List<Address> listAddresses(Integer clientId) throws EventException;
	
	public List<Bunch> listBunches(Integer clientId) throws EventException;
	
	public Client deleteClient(Integer clientId) throws EventException;
	
}
