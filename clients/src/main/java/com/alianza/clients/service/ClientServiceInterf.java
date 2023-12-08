package com.alianza.clients.service;

import java.util.List;

import com.alianza.clients.dto.ClientDTO;

public interface ClientServiceInterf {

	List<ClientDTO> getAll();

	void save(ClientDTO dto);

	List<ClientDTO> search(String sharedKey);

}
