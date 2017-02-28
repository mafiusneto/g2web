package br.com.g2soft.g2web.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.g2soft.g2web.domain.Counter;

public interface CounterRepository extends CrudRepository<Counter, Integer>{

}
