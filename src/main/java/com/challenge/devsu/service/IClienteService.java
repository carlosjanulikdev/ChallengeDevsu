package com.challenge.devsu.service;

import com.challenge.devsu.dto.DatosDeClienteDTO;
import com.challenge.devsu.dto.ClienteDTO;
import com.challenge.devsu.model.Cliente;

import java.util.List;

public interface IClienteService {

    Cliente crear(ClienteDTO personDTO);
    Cliente buscarPorId(Long id);
    void eliminarPorId(Long id);
    List<Cliente> buscarTodos();
    Cliente actualizar(Long id, DatosDeClienteDTO clienteAActualizarDTO);
}
