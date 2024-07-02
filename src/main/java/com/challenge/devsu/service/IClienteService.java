package com.challenge.devsu.service;

import com.challenge.devsu.dto.DatosDeClienteDTO;
import com.challenge.devsu.dto.ClienteDTO;
import com.challenge.devsu.dto.response.ClienteResponseDTO;
import com.challenge.devsu.model.Cliente;

import java.util.List;

public interface IClienteService {

    ClienteResponseDTO crear(ClienteDTO personDTO);
    ClienteResponseDTO buscarPorId(Long id);
    void eliminarPorId(Long id);
    List<ClienteResponseDTO> buscarTodos();
    ClienteResponseDTO actualizar(Long id, DatosDeClienteDTO clienteAActualizarDTO);
}
