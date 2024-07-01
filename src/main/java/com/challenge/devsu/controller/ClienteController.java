package com.challenge.devsu.controller;

import com.challenge.devsu.dto.ClienteDTO;
import com.challenge.devsu.model.Cliente;
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

    @Autowired
    private IClienteService clienteService;

    /**
     *
     * @param id
     * @return a client by id
     */
    @GetMapping(value = "/obtenncion/{id}")
    public Cliente findById(@PathVariable(required = true) Long id){
        logger.info("Id:{}", id);

        return clienteService.findById(id);
    }

    @DeleteMapping(value = "/eliminacion/{id}")
    public void deleteById(@PathVariable(required = true) Long id){
        logger.info("Cliente id to delete:{}", id);

        clienteService.deleteById(id);
    }


    @PostMapping(value = "/creacion")
    public ResponseEntity<Cliente> create(@Valid @RequestBody ClienteDTO clienteDTO) {
        logger.info("Creacion de nuevo cliente:{}", clienteDTO);
        Cliente nuevoCliente = clienteService.create(clienteDTO);

        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    /**
     *
     * @return a JSON with all clients
     */
    @GetMapping(value = "/buscarTodos")
    public @ResponseBody Iterable<Cliente> findAll() {
        return clienteService.findAll();
    }
}
