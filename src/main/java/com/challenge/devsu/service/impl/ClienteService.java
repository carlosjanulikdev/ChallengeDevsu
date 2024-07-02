package com.challenge.devsu.service.impl;

import com.challenge.devsu.dto.DatosDeClienteDTO;
import com.challenge.devsu.dto.ClienteDTO;
import com.challenge.devsu.model.Cliente;
import com.challenge.devsu.repository.ClienteRepository;
import com.challenge.devsu.service.IClienteService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @SneakyThrows
    public Cliente crear(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO.getNombre(), clienteDTO.getGenero(), clienteDTO.getEdad(), clienteDTO.getIdentificacion(),
                clienteDTO.getDireccion(), clienteDTO.getTelefono(), clienteDTO.getContrasenia(),
                clienteDTO.getEstado());

        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Long id){
        return clienteRepository.findById(id).get();
    }

    public void eliminarPorId(Long id){
        clienteRepository.deleteById(id);
    }

    public List<Cliente> buscarTodos(){
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Cliente actualizar(Long id, DatosDeClienteDTO datosDeClienteDTO) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNombre(datosDeClienteDTO.getNombre());
                    cliente.setEdad(datosDeClienteDTO.getEdad());
                    cliente.setTelefono(datosDeClienteDTO.getTelefono());
                    return clienteRepository.save(cliente);
                })
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id " + id));
    }

}
