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
import br.com.g2soft.g2web.domain.Counter;
import br.com.g2soft.g2web.generic.EventException;
import br.com.g2soft.g2web.service.CounterService;
import br.com.g2soft.g2web.util.Constants;

@Controller
@RequestMapping(path = Constants.URL_COUNTER)
public class CounterController {

	@Autowired
	private CounterService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Counter create(@RequestBody Counter counter) throws EventException {
		
		return service.create(counter);
	}
	
	@RequestMapping(path = Constants.COUNTER_ID, method = RequestMethod.GET)
	public @ResponseBody Counter view(@RequestParam Integer counterId) throws EventException {
		
		return service.view(counterId);
	}
	
	@RequestMapping(path = Constants.COUNTER_ID, method = RequestMethod.PUT)
	public @ResponseBody Counter update(@RequestParam Integer counterId, @RequestBody Counter counter) throws EventException {
		
		return service.update(counterId, counter);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Counter> list() {
		
		return service.list();
	}
	
	@RequestMapping(path = Constants.COUNTER_ID, method = RequestMethod.DELETE)
	public @ResponseBody Counter delete(@RequestParam Integer counterId) throws EventException {
		
		return service.delete(counterId);
	}
	
	@RequestMapping(path = Constants.URL_COUNTER_ADDRESS, method = RequestMethod.GET)
	public @ResponseBody Address viewAddress(@RequestParam Integer counterId) throws EventException {
		
		return service.viewAddress(counterId);
	}
}
