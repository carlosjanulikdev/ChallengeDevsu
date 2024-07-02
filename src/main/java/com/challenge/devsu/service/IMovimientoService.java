package com.challenge.devsu.service;

import com.challenge.devsu.dto.request.ClienteRequestDTO;
import com.challenge.devsu.dto.request.DatosDeClienteRequestDTO;
import com.challenge.devsu.dto.request.DatosDeMovimientoRequestDTO;
import com.challenge.devsu.dto.request.MovimientoRequestDTO;
import com.challenge.devsu.dto.response.ClienteResponseDTO;
import com.challenge.devsu.dto.response.MovimientoResponseDTO;

import java.util.List;

public interface IMovimientoService {

    MovimientoResponseDTO crear(MovimientoRequestDTO personDTO);
    MovimientoResponseDTO buscarPorId(Long id);
    void eliminarPorId(Long id);
    List<MovimientoResponseDTO> buscarTodos();
    MovimientoResponseDTO actualizar(Long id, DatosDeMovimientoRequestDTO movimientoAActualizarDTO);
}
