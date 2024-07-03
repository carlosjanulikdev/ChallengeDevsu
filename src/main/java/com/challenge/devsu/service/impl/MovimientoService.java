package com.challenge.devsu.service.impl;

import com.challenge.devsu.dto.request.DatosDeMovimientoRequestDTO;
import com.challenge.devsu.dto.request.MovimientoRequestDTO;
import com.challenge.devsu.dto.response.MovimientoResponseDTO;
import com.challenge.devsu.exception.CuentaInexistenteException;
import com.challenge.devsu.exception.MovimientoInexistenteException;
import com.challenge.devsu.exception.TipoMovimientoInexistenteException;
import com.challenge.devsu.model.Cuenta;
import com.challenge.devsu.model.Movimiento;
import com.challenge.devsu.model.TipoMovimiento;
import com.challenge.devsu.repository.CuentaRepository;
import com.challenge.devsu.repository.MovimientoRepository;
import com.challenge.devsu.repository.TipoMovimientoRepository;
import com.challenge.devsu.service.IMovimientoService;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.challenge.devsu.util.Constants;
import com.challenge.devsu.exception.ValidacionNegocioException;

import java.util.List;

@Service
public class MovimientoService implements IMovimientoService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private TipoMovimientoRepository tipoMovimientoRepository;

    @Autowired
    private ModelMapper modelMapper;


    @SneakyThrows
    public MovimientoResponseDTO crear(MovimientoRequestDTO movimientoDTO) {
        TipoMovimiento tipoMovimiento = tipoMovimientoRepository.findById(movimientoDTO.getTipoMovimientoId())
                .orElseThrow(() ->
                        new TipoMovimientoInexistenteException("No existe el tipo de movimiento con id: "+
                                movimientoDTO.getTipoMovimientoId()));

        Cuenta cuenta = cuentaRepository.findById(movimientoDTO.getCuentaId())
                .orElseThrow(() ->
                        new CuentaInexistenteException("No existe la cuenta con id: "+ movimientoDTO.getCuentaId()));

        //Calcular saldo disponible
        List<Movimiento> movimientosPrevios = movimientoRepository.findByCuentaIdOrderByIdDesc(movimientoDTO.getCuentaId());
        Double saldoDisponible = (movimientosPrevios != null && !movimientosPrevios.isEmpty()) ? movimientosPrevios.get(0).getSaldo() : cuenta.getSaldoInicial();

        if(Constants.TIPO_MOVIMIENTO_RETIRO.equals(tipoMovimiento.getDescripcion()) &&
            saldoDisponible + movimientoDTO.getValor() < 0){
            throw new ValidacionNegocioException("Saldo no disponible");
        }

        saldoDisponible+= movimientoDTO.getValor();

        Movimiento movimiento = new Movimiento(movimientoDTO.getFecha(), tipoMovimiento, movimientoDTO.getValor(),
                saldoDisponible, cuenta);

        movimientoRepository.save(movimiento);

        return modelMapper.map(movimiento, MovimientoResponseDTO.class);
    }

    @SneakyThrows
    public MovimientoResponseDTO buscarPorId(Long id){
        Movimiento movimiento = movimientoRepository.findById(id)
                .orElseThrow(() ->
                        new MovimientoInexistenteException("No existe el movimiento con id: "+ id));

        return modelMapper.map(movimiento, MovimientoResponseDTO.class);
    }

    public void eliminarPorId(Long id){
        movimientoRepository.deleteById(id);
    }

    public List<MovimientoResponseDTO> buscarTodos(){
        List<Movimiento> movimientos = (List<Movimiento>) movimientoRepository.findAll();

        return movimientos.stream().map( movimiento ->
                modelMapper.map(movimiento, MovimientoResponseDTO.class)).toList();
    }

    @SneakyThrows
    public MovimientoResponseDTO actualizar(Long id, DatosDeMovimientoRequestDTO datosDeMovimientoDTO) {
        return movimientoRepository.findById(id)
                .map(movimiento -> {
                    movimiento.setValor(datosDeMovimientoDTO.getValor());
                    movimiento.setSaldo(datosDeMovimientoDTO.getSaldo());

                    return modelMapper.map(movimientoRepository.save(movimiento), MovimientoResponseDTO.class);
                })
                .orElseThrow(() -> new MovimientoInexistenteException("No existe el movimiento con id: "+ id));
    }

}
