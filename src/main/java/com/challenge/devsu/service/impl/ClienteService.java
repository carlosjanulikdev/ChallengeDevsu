package com.challenge.devsu.service.impl;

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
    public Cliente create(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO.getNombre(), clienteDTO.getGenero(), clienteDTO.getEdad(), clienteDTO.getIdentificacion(),
                clienteDTO.getDireccion(), clienteDTO.getTelefono(), clienteDTO.getContrasenia(),
                clienteDTO.getEstado());

        return clienteRepository.save(cliente);
    }

    public Cliente findById(Long id){
        return clienteRepository.findById(id).get();
    }

    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }

    public List<Cliente> findAll(){
        return (List<Cliente>) clienteRepository.findAll();
    }
}
