package com.challenge.devsu.service;

import com.challenge.devsu.dto.request.CuentaRequestDTO;
import com.challenge.devsu.dto.request.DatosDeCuentaRequestDTO;
import com.challenge.devsu.dto.response.CuentaResponseDTO;

import java.util.List;

public interface ICuentaService {

    CuentaResponseDTO crear(CuentaRequestDTO cuentaDTO);
    CuentaResponseDTO buscarPorId(Long id);
    void eliminarPorId(Long id);
    List<CuentaResponseDTO> buscarTodas();
    CuentaResponseDTO actualizar(Long id, DatosDeCuentaRequestDTO datosDeCuentaDTO);
}
