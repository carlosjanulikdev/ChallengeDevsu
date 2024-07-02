package com.challenge.devsu.service;

import com.challenge.devsu.dto.CuentaDTO;
import com.challenge.devsu.dto.DatosDeCuentaDTO;
import com.challenge.devsu.model.Cuenta;

import java.util.List;

public interface ICuentaService {

    Cuenta crear(CuentaDTO cuentaDTO);
    Cuenta buscarPorId(Long id);
    void eliminarPorId(Long id);
    List<Cuenta> buscarTodas();
    Cuenta actualizar(Long id, DatosDeCuentaDTO datosDeCuentaDTO);
}
