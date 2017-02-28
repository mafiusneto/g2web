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
import br.com.g2soft.g2web.domain.Bunch;
import br.com.g2soft.g2web.domain.Client;
import br.com.g2soft.g2web.generic.EventException;
import br.com.g2soft.g2web.service.ClientService;
import br.com.g2soft.g2web.util.Constants;

@Controller
@RequestMapping(path = Constants.URL_CLIENT)
public class ClientController {

	@Autowired
	private ClientService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Client  createClient(@RequestBody Client client) {
		
		return service.createClient(client);
	}
	
	@RequestMapping(path = Constants.CLIENT_ID, method = RequestMethod.PUT)
	public @ResponseBody Client updateClient(@RequestParam Integer clientId, @RequestBody Client client) throws EventException {
		
		return service.updateClient(clientId, client);
	}
	
	@RequestMapping(path = Constants.CLIENT_ID, method = RequestMethod.GET)	
	public @ResponseBody Client viewClient(@RequestParam Integer clientId) throws EventException {
		
		return service.view(clientId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Client> listClients() {
	
		return service.listClients();
	}
	
	@RequestMapping(path = Constants.URL_CLIENT_ADDRESS, method = RequestMethod.GET)
	public @ResponseBody List<Address> listAddresses(@RequestParam Integer clientId) throws EventException {
		
		return service.listAddresses(clientId);
	}
	
	@RequestMapping(path = Constants.URL_CLIENT_BUNCH, method = RequestMethod.GET)
	public @ResponseBody List<Bunch> listBunches(@RequestParam Integer clientId) throws EventException {
		
		return service.listBunches(clientId);
	}
	
	@RequestMapping(path = Constants.CLIENT_ID, method = RequestMethod.DELETE)
	public @ResponseBody Client deleteClient(@RequestParam Integer clientId) throws EventException {
		
		return service.deleteClient(clientId);
	}
}
