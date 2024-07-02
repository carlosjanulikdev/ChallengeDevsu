package com.challenge.devsu.controller;

import com.challenge.devsu.dto.request.DatosDeMovimientoRequestDTO;
import com.challenge.devsu.dto.request.MovimientoRequestDTO;
import com.challenge.devsu.dto.response.MovimientoResponseDTO;
import com.challenge.devsu.service.IMovimientoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movimientos")
public class MovimientoController {
    Logger logger = LoggerFactory.getLogger(MovimientoController.class);

    @Autowired
    private IMovimientoService movimientoService;

    @GetMapping(value = "/obtencion/{id}")
    public MovimientoResponseDTO buscarPorId(@PathVariable(required = true) Long id){
        logger.info("Id:{}", id);

        return movimientoService.buscarPorId(id);
    }

    @DeleteMapping(value = "/eliminacion/{id}")
    public void eliminarPorId(@PathVariable(required = true) Long id){
        logger.info("Id de movimiento a eliminar:{}", id);

        movimientoService.eliminarPorId(id);
    }

    @PostMapping(value = "/creacion")
    public ResponseEntity<MovimientoResponseDTO> crear(@Valid @RequestBody MovimientoRequestDTO movimientoDTO) {
        logger.info("Creacion de nuevo movimiento:{}", movimientoDTO);
        MovimientoResponseDTO nuevoMovimiento = movimientoService.crear(movimientoDTO);

        return new ResponseEntity<>(nuevoMovimiento, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<MovimientoResponseDTO> actualizar(@PathVariable Long id,
                                              @RequestBody DatosDeMovimientoRequestDTO datosDeMovimientoDTO) {
        logger.info("Actualizacion de movimiento con id:{} - valores a actualizar:{}", id, datosDeMovimientoDTO);

        return new ResponseEntity<>(movimientoService.actualizar(id, datosDeMovimientoDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/buscarTodos")
    public @ResponseBody Iterable<MovimientoResponseDTO> buscarTodos() {
        return movimientoService.buscarTodos();
    }
}
