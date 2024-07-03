package com.challenge.devsu;

import com.challenge.devsu.dto.response.ClienteResponseDTO;
import com.challenge.devsu.model.Cliente;
import com.challenge.devsu.repository.ClienteRepository;
import com.challenge.devsu.service.impl.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository; // Suponiendo que tienes un repositorio para Cliente

    @InjectMocks
    private ClienteService clienteService; // El servicio que vamos a probar

    @Test
    public void buscarPorId_DeberiaRetornarClienteCorrecto() {
        // Arrange
        Long idCliente = 1L;
        Cliente clienteMock = new Cliente();
        clienteMock.setId(idCliente);
        clienteMock.setNombre("Juan Perez");

        when(clienteRepository.findById(idCliente)).thenReturn(Optional.of(clienteMock));

        // Act
        ClienteResponseDTO clienteEncontrado = clienteService.buscarPorId(idCliente);

        // Assert
        assertNotNull(clienteEncontrado);
        assertEquals(idCliente, clienteEncontrado.getId());
        assertEquals("Juan Perez", clienteEncontrado.getNombre());

        verify(clienteRepository, times(1)).findById(idCliente);
    }

    // Puedes agregar más pruebas unitarias para otros métodos del servicio ClienteService aquí
}

