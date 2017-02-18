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
import br.com.g2soft.g2web.domain.Client;
import br.com.g2soft.g2web.service.ClientServiceImpl;
import br.com.g2soft.g2web.util.Constants;

@Controller
@RequestMapping(path=Constants.URL_CLIENT)
public class ClientController {

	@Autowired
	private ClientServiceImpl service;
	
	/*@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public String test() {
		
		return "Teste";
	}*/
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Client  createClient(@RequestBody Client client) {
		
		return service.createClient(client);
	}
	
	@RequestMapping(path = Constants.CLIENT_ID, method = RequestMethod.PUT)
	public @ResponseBody Client updateClient(@RequestParam Integer clientId, @RequestBody Client client) {
		
		return service.updateClient(clientId, client);
	}
	/*@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Client> listClients() {
		
		List<Client> clients = (List<Client>) clientRepository.findAll();
		
		return clients;
	}*/
	
	@RequestMapping(path=Constants.CLIENT_ID, method=RequestMethod.GET)	
	public @ResponseBody Client viewClient(@RequestParam Integer clientId) {
		
		return service.getClient(clientId);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Client> listClients() {
	
		return service.listClients();
	}
	
	@RequestMapping(path=Constants.URL_ADDRESS, method=RequestMethod.GET)
	public @ResponseBody List<Address> listAddresses(@RequestParam Integer clientId) {
		
		return service.listAddresses(clientId);
	}
	
	@RequestMapping(path=Constants.CLIENT_ID, method = RequestMethod.DELETE)
	public @ResponseBody Client deleteClient(@RequestParam Integer clientId) {
		
		return service.deleteClient(clientId);
	}
}
