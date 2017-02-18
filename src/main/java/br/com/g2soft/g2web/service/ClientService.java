package br.com.g2soft.g2web.service;

import java.util.List;

import br.com.g2soft.g2web.domain.Address;
import br.com.g2soft.g2web.domain.Client;
import br.com.g2soft.g2web.domain.Bunch;

public interface ClientService {

	public Client createClient(Client client);
	
	public Client updateClient(Integer clientId, Client client);
	
	public Client getClient(Integer clientId);
	
	public List<Client> listClients();
	
	public List<Address> listAddresses(Integer clientId);
	
	public List<Bunch> listGroups(Integer clientId);
	
	public Client deleteClient(Integer clientId);
}
