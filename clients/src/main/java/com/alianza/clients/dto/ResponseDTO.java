package com.alianza.clients.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDTO<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codeStatus;

	private String messageInfo;

	private T data;

}
