package com.alianza.clients.mapper;

import com.alianza.clients.dto.ClientDTO;
import com.alianza.clients.entities.Client;

public class ClientMapper {

	public static ClientDTO toDto(Client client) {
		ClientDTO dto = new ClientDTO();
		dto.setId(client.getId());
		dto.setSharedKey(client.getSharedKey());
		dto.setBussinessId(client.getBussinessId());
		dto.setEmail(client.getEmail());
		dto.setPhone(client.getPhone());
		dto.setDataAdded(client.getDataAdded());
		dto.setStartDate(client.getStartDate());
		dto.setEndDate(client.getEndDate());
		return dto;
	}

	public static Client toEntity(ClientDTO dto) {
		Client client = new Client();
		client.setId(dto.getId());
		client.setSharedKey(dto.getSharedKey());
		client.setBussinessId(dto.getBussinessId());
		client.setEmail(dto.getEmail());
		client.setPhone(dto.getPhone());
		client.setDataAdded(dto.getDataAdded());
		client.setStartDate(dto.getStartDate());
		client.setEndDate(dto.getEndDate());
		return client;
	}

}
