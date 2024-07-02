package com.challenge.devsu.service;

import com.challenge.devsu.dto.CuentaDTO;
import com.challenge.devsu.dto.DatosDeCuentaDTO;
import com.challenge.devsu.dto.response.CuentaResponseDTO;

import java.util.List;

public interface ICuentaService {

    CuentaResponseDTO crear(CuentaDTO cuentaDTO);
    CuentaResponseDTO buscarPorId(Long id);
    void eliminarPorId(Long id);
    List<CuentaResponseDTO> buscarTodas();
    CuentaResponseDTO actualizar(Long id, DatosDeCuentaDTO datosDeCuentaDTO);
}
