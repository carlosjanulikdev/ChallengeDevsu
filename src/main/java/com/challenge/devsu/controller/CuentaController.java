package com.challenge.devsu.controller;

import com.challenge.devsu.dto.request.CuentaRequestDTO;
import com.challenge.devsu.dto.request.DatosDeCuentaRequestDTO;
import com.challenge.devsu.dto.response.CuentaResponseDTO;
import com.challenge.devsu.service.ICuentaService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cuentas")
public class CuentaController {
    Logger logger = LoggerFactory.getLogger(CuentaController.class);

    @Autowired
    private ICuentaService cuentaService;

    @GetMapping(value = "/obtencion/{id}")
    public CuentaResponseDTO buscarPorId(@PathVariable(required = true) Long id){
        logger.info("Id:{}", id);

        return cuentaService.buscarPorId(id);
    }

    @DeleteMapping(value = "/eliminacion/{id}")
    public void eliminarPorId(@PathVariable(required = true) Long id){
        logger.info("Id de cuenta a eliminar:{}", id);

        cuentaService.eliminarPorId(id);
    }

    @PostMapping(value = "/creacion")
    public ResponseEntity<CuentaResponseDTO> crear(@Valid @RequestBody CuentaRequestDTO cuentaDTO) {
        logger.info("Creacion de nueva cuenta:{}", cuentaDTO);
        CuentaResponseDTO nuevaCuenta = cuentaService.crear(cuentaDTO);

        return new ResponseEntity<>(nuevaCuenta, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<CuentaResponseDTO> actualizar(@PathVariable Long id,
                                              @RequestBody DatosDeCuentaRequestDTO datosDeCuentaDTO) {
        logger.info("Actualizacion de cuenta con id:{} - valores a actualizar:{}", id, datosDeCuentaDTO);

        return new ResponseEntity<>(cuentaService.actualizar(id, datosDeCuentaDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/buscarTodas")
    public @ResponseBody Iterable<CuentaResponseDTO> buscarTodas() {
        return cuentaService.buscarTodas();
    }
}
