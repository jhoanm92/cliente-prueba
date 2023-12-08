package com.alianza.clients.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alianza.clients.dto.ClientDTO;
import com.alianza.clients.entities.Client;
import com.alianza.clients.mapper.ClientMapper;
import com.alianza.clients.repository.ClientRepositoryInterf;
import com.alianza.clients.service.ClientServiceInterf;

@Service
public class ClientServiceImpl implements ClientServiceInterf {

	@Autowired
	private ClientRepositoryInterf clientRepository;

	@Override
	@Transactional(readOnly = true)
	public List<ClientDTO> getAll() {
		List<ClientDTO> listDto = new ArrayList<>();
		List<Client> listEntity = this.clientRepository.findAll();
		for (Client client : listEntity) {
			listDto.add(ClientMapper.toDto(client));
		}
		return listDto;
	}

	@Override
	@Transactional
	public void save(ClientDTO dto) {
		Client client = ClientMapper.toEntity(dto);
		client.setDataAdded(LocalDate.now());
		this.clientRepository.save(client);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClientDTO> search(String sharedKey) {
		List<ClientDTO> listDto = new ArrayList<>();
		List<Client> listEntity = this.clientRepository.findBySharedKey(sharedKey);
		for (Client client : listEntity) {
			listDto.add(ClientMapper.toDto(client));
		}
		return listDto;
	}

}
