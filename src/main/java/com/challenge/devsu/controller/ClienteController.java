package com.challenge.devsu.controller;

import com.challenge.devsu.dto.ClienteDTO;
import com.challenge.devsu.dto.DatosDeClienteDTO;
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
    @GetMapping(value = "/obtencion/{id}")
    public Cliente buscarPorId(@PathVariable(required = true) Long id){
        logger.info("Id:{}", id);

        return clienteService.buscarPorId(id);
    }

    @DeleteMapping(value = "/eliminacion/{id}")
    public void eliminarPorId(@PathVariable(required = true) Long id){
        logger.info("Id de cliente a eliminar:{}", id);

        clienteService.eliminarPorId(id);
    }

    @PostMapping(value = "/creacion")
    public ResponseEntity<Cliente> crear(@Valid @RequestBody ClienteDTO clienteDTO) {
        logger.info("Creacion de nuevo cliente:{}", clienteDTO);
        Cliente nuevoCliente = clienteService.crear(clienteDTO);

        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id,
                                              @RequestBody DatosDeClienteDTO datosDeClienteDTO) {
        logger.info("Actualizacion de cliente con id:{} - valores a actualizar:{}", id, datosDeClienteDTO);

        return new ResponseEntity<>(clienteService.actualizar(id, datosDeClienteDTO), HttpStatus.OK);
    }

    /**
     *
     * @return a JSON with all clients
     */
    @GetMapping(value = "/buscarTodos")
    public @ResponseBody Iterable<Cliente> buscarTodos() {
        return clienteService.buscarTodos();
    }
}