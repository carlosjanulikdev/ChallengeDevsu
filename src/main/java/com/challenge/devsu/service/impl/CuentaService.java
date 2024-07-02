package com.challenge.devsu.service.impl;

import com.challenge.devsu.dto.CuentaDTO;
import com.challenge.devsu.dto.DatosDeCuentaDTO;
import com.challenge.devsu.model.Cliente;
import com.challenge.devsu.model.Cuenta;
import com.challenge.devsu.model.TipoCuenta;
import com.challenge.devsu.repository.ClienteRepository;
import com.challenge.devsu.repository.CuentaRepository;
import com.challenge.devsu.repository.TipoCuentaRepository;
import com.challenge.devsu.service.ICuentaService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService implements ICuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private TipoCuentaRepository tipoCuentaRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    @SneakyThrows
    public Cuenta crear(CuentaDTO cuentaDTO) {
        Optional<TipoCuenta> tipoCuenta = tipoCuentaRepository.findById(cuentaDTO.getTipoCuentaId());
        Optional<Cliente> cliente = clienteRepository.findById(cuentaDTO.getClienteId());

        Cuenta cuenta = new Cuenta(cuentaDTO.getNumero(), tipoCuenta.get(), cuentaDTO.getSaldoInicial(),
                cuentaDTO.getEstado(), cliente.get());

        return cuentaRepository.save(cuenta);
    }

    public Cuenta buscarPorId(Long id){
        return cuentaRepository.findById(id).get();
    }

    public void eliminarPorId(Long id){
        cuentaRepository.deleteById(id);
    }

    public List<Cuenta> buscarTodas(){
        return (List<Cuenta>) cuentaRepository.findAll();
    }

    public Cuenta actualizar(Long id, DatosDeCuentaDTO datosDeCuentaDTO) {
        return cuentaRepository.findById(id)
                .map(cuenta -> {
                    cuenta.setNumero(datosDeCuentaDTO.getNumero());
                    cuenta.setSaldoInicial(datosDeCuentaDTO.getSaldoInicial());
                    cuenta.setEstado(datosDeCuentaDTO.getEstado());
                    return cuentaRepository.save(cuenta);
                })
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada con id " + id));
    }

}
