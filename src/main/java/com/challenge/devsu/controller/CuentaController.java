package com.challenge.devsu.controller;

import com.challenge.devsu.dto.CuentaDTO;
import com.challenge.devsu.dto.DatosDeCuentaDTO;
import com.challenge.devsu.model.Cuenta;
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
    public Cuenta buscarPorId(@PathVariable(required = true) Long id){
        logger.info("Id:{}", id);

        return cuentaService.buscarPorId(id);
    }

    @DeleteMapping(value = "/eliminacion/{id}")
    public void eliminarPorId(@PathVariable(required = true) Long id){
        logger.info("Id de cuenta a eliminar:{}", id);

        cuentaService.eliminarPorId(id);
    }

    @PostMapping(value = "/creacion")
    public ResponseEntity<Cuenta> crear(@Valid @RequestBody CuentaDTO cuentaDTO) {
        logger.info("Creacion de nueva cuenta:{}", cuentaDTO);
        Cuenta nuevaCuenta = cuentaService.crear(cuentaDTO);

        return new ResponseEntity<>(nuevaCuenta, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Cuenta> actualizar(@PathVariable Long id,
                                              @RequestBody DatosDeCuentaDTO datosDeCuentaDTO) {
        logger.info("Actualizacion de cuenta con id:{} - valores a actualizar:{}", id, datosDeCuentaDTO);

        return new ResponseEntity<>(cuentaService.actualizar(id, datosDeCuentaDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/buscarTodas")
    public @ResponseBody Iterable<Cuenta> buscarTodas() {
        return cuentaService.buscarTodas();
    }
}
