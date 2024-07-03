package com.challenge.devsu.service.impl;

import com.challenge.devsu.dto.request.CuentaRequestDTO;
import com.challenge.devsu.dto.request.DatosDeCuentaRequestDTO;
import com.challenge.devsu.dto.response.CuentaResponseDTO;
import com.challenge.devsu.exception.ClienteInexistenteException;
import com.challenge.devsu.exception.CuentaInexistenteException;
import com.challenge.devsu.exception.TipoCuentaInexistenteException;
import com.challenge.devsu.model.Cliente;
import com.challenge.devsu.model.Cuenta;
import com.challenge.devsu.model.TipoCuenta;
import com.challenge.devsu.repository.ClienteRepository;
import com.challenge.devsu.repository.CuentaRepository;
import com.challenge.devsu.repository.TipoCuentaRepository;
import com.challenge.devsu.service.ICuentaService;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService implements ICuentaService {

    private CuentaRepository cuentaRepository;
    private TipoCuentaRepository tipoCuentaRepository;
    private ClienteRepository clienteRepository;
    private ModelMapper modelMapper;

    public CuentaService(CuentaRepository cuentaRepository, TipoCuentaRepository tipoCuentaRepository, ClienteRepository clienteRepository, ModelMapper modelMapper) {
        this.cuentaRepository = cuentaRepository;
        this.tipoCuentaRepository = tipoCuentaRepository;
        this.clienteRepository = clienteRepository;
        this.modelMapper = modelMapper;
    }

    @SneakyThrows
    public CuentaResponseDTO crear(CuentaRequestDTO cuentaDTO) {
        TipoCuenta tipoCuenta = tipoCuentaRepository.findById(cuentaDTO.getTipoCuentaId())
                                 .orElseThrow(() ->
                                        new TipoCuentaInexistenteException("No existe el tipo de cuenta con id: "+
                                                cuentaDTO.getTipoCuentaId()));

        Cliente cliente = clienteRepository.findById(cuentaDTO.getClienteId())
                            .orElseThrow(() ->
                                    new ClienteInexistenteException("No existe el cliente con id: "+
                                            cuentaDTO.getClienteId()));

        Cuenta cuenta = new Cuenta(cuentaDTO.getNumero(), tipoCuenta, cuentaDTO.getSaldoInicial(),
                cuentaDTO.getEstado(), cliente);

        cuentaRepository.save(cuenta);

        return modelMapper.map(cuenta, CuentaResponseDTO.class);
    }

    @SneakyThrows
    public CuentaResponseDTO buscarPorId(Long id){
        Cuenta cuenta = cuentaRepository.findById(id)
                .orElseThrow(() ->
                        new CuentaInexistenteException("No existe la cuenta con id: "+ id));

        return modelMapper.map(cuenta, CuentaResponseDTO.class);
    }

    public void eliminarPorId(Long id){
        cuentaRepository.deleteById(id);
    }

    public List<CuentaResponseDTO> buscarTodas(){
        List<Cuenta> cuentas = (List<Cuenta>) cuentaRepository.findAll();

        return cuentas.stream().map( cuenta ->
                modelMapper.map(cuenta, CuentaResponseDTO.class)).toList();
    }

    @SneakyThrows
    public CuentaResponseDTO actualizar(Long id, DatosDeCuentaRequestDTO datosDeCuentaDTO) {
        return cuentaRepository.findById(id)
                .map(cuenta -> {
                    cuenta.setNumero(datosDeCuentaDTO.getNumero());
                    cuenta.setSaldoInicial(datosDeCuentaDTO.getSaldoInicial());
                    cuenta.setEstado(datosDeCuentaDTO.getEstado());

                    return modelMapper.map(cuentaRepository.save(cuenta), CuentaResponseDTO.class);
                })
                .orElseThrow(() -> new CuentaInexistenteException("No existe la cuenta con id: "+ id));
    }

}
