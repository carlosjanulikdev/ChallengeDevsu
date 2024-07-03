package com.challenge.devsu;

import com.challenge.devsu.dto.request.ClienteRequestDTO;
import com.challenge.devsu.dto.request.DatosDeClienteRequestDTO;
import com.challenge.devsu.dto.response.ClienteResponseDTO;
import com.challenge.devsu.exception.ClienteInexistenteException;
import com.challenge.devsu.model.Cliente;
import com.challenge.devsu.repository.ClienteRepository;
import com.challenge.devsu.service.impl.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCrearCliente() {
        ClienteRequestDTO clienteRequestDTO = new ClienteRequestDTO();
        clienteRequestDTO.setNombre("Juan Perez");
        clienteRequestDTO.setGenero("Masculino");
        clienteRequestDTO.setIdentificacion("Alguna");
        clienteRequestDTO.setDireccion("Ecuador 1501");
        clienteRequestDTO.setTelefono("1121313211");
        clienteRequestDTO.setContrasenia("12345");
        clienteRequestDTO.setEstado(true);

        Cliente clienteMock = new Cliente();
        clienteMock.setNombre("Juan Perez");
        clienteMock.setGenero("Masculino");
        clienteMock.setIdentificacion("Alguna");
        clienteMock.setDireccion("Ecuador 1501");
        clienteMock.setTelefono("1121313211");
        clienteMock.setContrasenia("12345");
        clienteMock.setEstado(true);

        ClienteResponseDTO clienteResponseMock = new ClienteResponseDTO();
        clienteResponseMock.setNombre("Juan Perez");
        clienteResponseMock.setGenero("Masculino");
        clienteResponseMock.setIdentificacion("Alguna");
        clienteResponseMock.setDireccion("Ecuador 1501");
        clienteResponseMock.setTelefono("1121313211");
        clienteResponseMock.setId(1L);

        when(modelMapper.map(any(), eq(ClienteResponseDTO.class))).thenReturn(clienteResponseMock);
        when(clienteRepository.save(any(Cliente.class))).thenReturn(clienteMock);

        ClienteResponseDTO clienteCreado = clienteService.crear(clienteRequestDTO);

        // Asserts
        assertNotNull(clienteCreado);
        assertNotNull(clienteCreado.getId());
        assertEquals("Juan Perez", clienteCreado.getNombre());
    }

    @Test
    public void testBuscarClientePorIdExistente() {
        Long idCliente = 1L;
        Cliente clienteMock = new Cliente();
        clienteMock.setId(idCliente);
        clienteMock.setNombre("Juan Perez");

        ClienteResponseDTO clienteResponseDTOMock = new ClienteResponseDTO();
        clienteResponseDTOMock.setId(idCliente);
        clienteResponseDTOMock.setNombre("Juan Perez");

        when(clienteRepository.findById(idCliente)).thenReturn(Optional.of(clienteMock));
        when(modelMapper.map(clienteMock, ClienteResponseDTO.class)).thenReturn(clienteResponseDTOMock);

        ClienteResponseDTO clienteEncontrado = clienteService.buscarPorId(idCliente);

        // Asserts
        assertNotNull(clienteEncontrado);
        assertEquals(idCliente, clienteEncontrado.getId());
        assertEquals("Juan Perez", clienteEncontrado.getNombre());
        verify(clienteRepository, times(1)).findById(idCliente);
    }

    @Test
    public void testBuscarClientePorIdNoExistente() {
        Long idCliente = 1L;
        when(clienteRepository.findById(idCliente)).thenReturn(Optional.empty());

        assertThrows(ClienteInexistenteException.class, () -> clienteService.buscarPorId(idCliente));
        verify(clienteRepository, times(1)).findById(idCliente);
    }

    @Test
    public void testEliminarClientePorId() {
        Long idCliente = 1L;

        clienteService.eliminarPorId(idCliente);

        // Assert
        verify(clienteRepository, times(1)).deleteById(idCliente);
    }

    @Test
    public void testBuscarTodosLosClientes() {
        Cliente clienteMock1 = new Cliente();
        clienteMock1.setNombre("Juan Perez");
        clienteMock1.setGenero("Masculino");
        clienteMock1.setIdentificacion("Alguna");
        clienteMock1.setDireccion("Ecuador 1501");
        clienteMock1.setTelefono("1121313211");
        clienteMock1.setContrasenia("12345");
        clienteMock1.setEstado(true);

        Cliente clienteMock2 = new Cliente();
        clienteMock2.setNombre("Maria Medina");
        clienteMock2.setGenero("Femenino");
        clienteMock2.setIdentificacion("Alguna");
        clienteMock2.setDireccion("Argentina 1000");
        clienteMock2.setTelefono("1121313213");
        clienteMock2.setContrasenia("6789");
        clienteMock2.setEstado(true);

        List<Cliente> clientesMock = Arrays.asList(clienteMock1, clienteMock2);

        ClienteResponseDTO clienteResponseDTOMock = new ClienteResponseDTO();
        clienteResponseDTOMock.setId(1L);
        clienteResponseDTOMock.setNombre("Juan Perez");

        when(clienteRepository.findAll()).thenReturn(clientesMock);
        when(modelMapper.map(any(), eq(ClienteResponseDTO.class))).thenAnswer(
                invocation -> {
                    Cliente cliente = invocation.getArgument(0);
                    return clienteResponseDTOMock;
                }
        );

        List<ClienteResponseDTO> clientesEncontrados = clienteService.buscarTodos();

        // Asserts
        assertNotNull(clientesEncontrados);
        assertEquals(2, clientesEncontrados.size());
        assertEquals("Juan Perez", clientesEncontrados.get(0).getNombre());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    public void testActualizarClienteExistente() {
        Long idCliente = 1L;
        DatosDeClienteRequestDTO datosDeClienteDTO = new DatosDeClienteRequestDTO();
        datosDeClienteDTO.setNombre("Nuevo Nombre");

        Cliente clienteExistente = new Cliente();
        clienteExistente.setId(idCliente);
        clienteExistente.setNombre("Nombre Antiguo");

        ClienteResponseDTO clienteResponseDTOMock = new ClienteResponseDTO();
        clienteResponseDTOMock.setId(1L);
        clienteResponseDTOMock.setNombre("Nuevo Nombre");

        when(clienteRepository.findById(idCliente)).thenReturn(Optional.of(clienteExistente));
        when(clienteRepository.save(any(Cliente.class))).thenAnswer(
                invocation -> {
                    Cliente clienteActualizado = invocation.getArgument(0);
                    clienteExistente.setNombre(clienteActualizado.getNombre());
                    return clienteExistente;
                }
        );
        when(modelMapper.map(clienteExistente, ClienteResponseDTO.class)).thenReturn(clienteResponseDTOMock);

        ClienteResponseDTO clienteActualizado = clienteService.actualizar(idCliente, datosDeClienteDTO);

        // Asserts
        assertNotNull(clienteActualizado);
        assertEquals(idCliente, clienteActualizado.getId());
        assertEquals("Nuevo Nombre", clienteActualizado.getNombre());
        verify(clienteRepository, times(1)).findById(idCliente);
        verify(clienteRepository, times(1)).save(any(Cliente.class));
    }

    @Test
    public void testActualizarClienteNoExistente() {
        Long idCliente = 1L;
        DatosDeClienteRequestDTO datosDeClienteDTO = new DatosDeClienteRequestDTO();
        datosDeClienteDTO.setNombre("Nuevo Nombre");

        when(clienteRepository.findById(idCliente)).thenReturn(Optional.empty());

        assertThrows(ClienteInexistenteException.class, () -> clienteService.actualizar(idCliente, datosDeClienteDTO));
        verify(clienteRepository, times(1)).findById(idCliente);
    }

}