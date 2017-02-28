package br.com.g2soft.g2web.service;

import java.util.List;

import br.com.g2soft.g2web.domain.Address;
import br.com.g2soft.g2web.domain.Counter;
import br.com.g2soft.g2web.generic.EventException;

public interface CounterService {

	public Counter create(Counter counter) throws EventException;
	
	public Counter view(Integer counterId) throws EventException;
	
	public Counter update(Integer counterId, Counter counter) throws EventException;
	
	public List<Counter> list();
	
	public Counter delete(Integer counterId) throws EventException;
	
	public Address viewAddress(Integer counterId) throws EventException;
}
