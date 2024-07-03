package com.challenge.devsu.service.impl;

import com.challenge.devsu.dto.request.ClienteRequestDTO;
import com.challenge.devsu.dto.request.DatosDeClienteRequestDTO;
import com.challenge.devsu.dto.response.ClienteResponseDTO;
import com.challenge.devsu.exception.ClienteInexistenteException;
import com.challenge.devsu.model.Cliente;
import com.challenge.devsu.repository.ClienteRepository;
import com.challenge.devsu.service.IClienteService;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    private ClienteRepository clienteRepository;
    private ModelMapper modelMapper;

    public ClienteService(ClienteRepository clienteRepository, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
        this.modelMapper = modelMapper;
    }

    @SneakyThrows
    public ClienteResponseDTO crear(ClienteRequestDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO.getNombre(), clienteDTO.getGenero(), clienteDTO.getEdad(), clienteDTO.getIdentificacion(),
                clienteDTO.getDireccion(), clienteDTO.getTelefono(), clienteDTO.getContrasenia(),
                clienteDTO.getEstado());

        clienteRepository.save(cliente);

        return modelMapper.map(cliente, ClienteResponseDTO.class);
    }

    @SneakyThrows
    public ClienteResponseDTO buscarPorId(Long id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() ->
                        new ClienteInexistenteException("No existe el cliente con id: "+ id));

        return modelMapper.map(cliente, ClienteResponseDTO.class);
    }

    public void eliminarPorId(Long id){
        clienteRepository.deleteById(id);
    }

    public List<ClienteResponseDTO> buscarTodos(){
        List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();

        return clientes.stream().map( cliente ->
                modelMapper.map(cliente, ClienteResponseDTO.class)).toList();
    }

    @SneakyThrows
    public ClienteResponseDTO actualizar(Long id, DatosDeClienteRequestDTO datosDeClienteDTO) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNombre(datosDeClienteDTO.getNombre());
                    cliente.setEdad(datosDeClienteDTO.getEdad());
                    cliente.setTelefono(datosDeClienteDTO.getTelefono());

                    return modelMapper.map(clienteRepository.save(cliente), ClienteResponseDTO.class);
                })
                .orElseThrow(() -> new ClienteInexistenteException("No existe el cliente con id: "+ id));
    }

}
