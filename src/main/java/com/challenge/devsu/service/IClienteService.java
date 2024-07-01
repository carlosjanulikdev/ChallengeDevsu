package com.challenge.devsu.service;

import com.challenge.devsu.dto.ClienteDTO;
import com.challenge.devsu.model.Cliente;

import java.util.List;

public interface IClienteService {

    Cliente create(ClienteDTO personDTO);
    Cliente findById(Long id);
    void deleteById(Long id);
    List<Cliente> findAll();
}
