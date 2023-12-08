package com.alianza.clients.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alianza.clients.entities.Client;

public interface ClientRepositoryInterf extends JpaRepository<Client, Integer> {
	
	List<Client> findBySharedKey(String sharedKey);

}
