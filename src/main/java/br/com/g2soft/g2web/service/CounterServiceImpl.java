package br.com.g2soft.g2web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.g2soft.g2web.domain.Address;
import br.com.g2soft.g2web.domain.Counter;
import br.com.g2soft.g2web.generic.EventException;
import br.com.g2soft.g2web.repository.CounterRepository;
import br.com.g2soft.g2web.util.ErrorMessages;

@Service
public class CounterServiceImpl implements CounterService {

	@Autowired
	private CounterRepository repository;

	public Counter create(Counter counter) throws EventException {
		
		verifyCnpjAndCpf(counter);
		
		return repository.save(counter);
	}

	public Counter view(Integer counterId) throws EventException {
		Counter counterDB = repository.findOne(counterId);
		
		verifyCounter(counterDB);
		
		return counterDB;
	}

	public Counter update(Integer counterId, Counter counter) throws EventException {

		Counter counterDB = repository.findOne(counterId);
		
		verifyCounter(counterDB);
		verifyCnpjAndCpf(counter);
		
		counterDB.setName(counter.getName());
		counterDB.setCrc(counter.getCrc());
		counterDB.setCnpj(counter.getCnpj());
		counterDB.setCpf(counter.getCpf());
		counterDB.setAddress(counter.getAddress());
		
		return repository.save(counterDB);
	}

	public List<Counter> list() {
		return (ArrayList<Counter>) repository.findAll();
	}

	public Counter delete(Integer counterId) throws EventException {
		Counter counterDB = repository.findOne(counterId);
		
		verifyCounter(counterDB);
		
		repository.delete(counterDB);
		
		return counterDB;
	}

	public Address viewAddress(Integer counterId) throws EventException {
		Counter counterDB = repository.findOne(counterId);
		
		verifyCounter(counterDB);
		
		return counterDB.getAddress();
	}
	
	private void verifyCounter(Counter counter) throws EventException{
		
		if (counter == null) {
			throw new EventException(ErrorMessages.COUNTER_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
	}
	
	private void verifyCnpjAndCpf(Counter counter) throws EventException { 
		
		if (counter.getCnpj() == null && counter.getCpf() == null) {
			throw new EventException(ErrorMessages.CNPJ_OR_CPF_PROPERTY_NOT_NULL, HttpStatus.BAD_REQUEST);
		}
	}
}
