package com.challenge.devsu.controller;

import com.challenge.devsu.dto.request.ClienteRequestDTO;
import com.challenge.devsu.dto.request.DatosDeClienteRequestDTO;
import com.challenge.devsu.dto.response.ClienteResponseDTO;
import com.challenge.devsu.service.IClienteService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
    Logger logger = LoggerFactory.getLogger(ClienteController.class);

    private IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(value = "/obtencion/{id}")
    public ClienteResponseDTO buscarPorId(@PathVariable(required = true) Long id){
        logger.info("Id:{}", id);

        return clienteService.buscarPorId(id);
    }

    @DeleteMapping(value = "/eliminacion/{id}")
    public void eliminarPorId(@PathVariable(required = true) Long id){
        logger.info("Id de cliente a eliminar:{}", id);

        clienteService.eliminarPorId(id);
    }

    @PostMapping(value = "/creacion")
    public ResponseEntity<ClienteResponseDTO> crear(@Valid @RequestBody ClienteRequestDTO clienteDTO) {
        logger.info("Creacion de nuevo cliente:{}", clienteDTO);
        ClienteResponseDTO nuevoCliente = clienteService.crear(clienteDTO);

        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<ClienteResponseDTO> actualizar(@PathVariable Long id,
                                              @RequestBody DatosDeClienteRequestDTO datosDeClienteDTO) {
        logger.info("Actualizacion de cliente con id:{} - valores a actualizar:{}", id, datosDeClienteDTO);

        return new ResponseEntity<>(clienteService.actualizar(id, datosDeClienteDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/buscarTodos")
    public @ResponseBody Iterable<ClienteResponseDTO> buscarTodos() {
        return clienteService.buscarTodos();
    }
}
