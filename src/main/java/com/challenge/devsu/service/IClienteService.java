package com.challenge.devsu.service;

import com.challenge.devsu.dto.request.DatosDeClienteRequestDTO;
import com.challenge.devsu.dto.request.ClienteRequestDTO;
import com.challenge.devsu.dto.response.ClienteResponseDTO;

import java.util.List;

public interface IClienteService {

    ClienteResponseDTO crear(ClienteRequestDTO personDTO);
    ClienteResponseDTO buscarPorId(Long id);
    void eliminarPorId(Long id);
    List<ClienteResponseDTO> buscarTodos();
    ClienteResponseDTO actualizar(Long id, DatosDeClienteRequestDTO clienteAActualizarDTO);
}
