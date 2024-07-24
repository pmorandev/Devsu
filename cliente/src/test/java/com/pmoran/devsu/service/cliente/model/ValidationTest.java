package com.pmoran.devsu.service.cliente.model;

import com.pmoran.devsu.service.cliente.constant.GeneroEnum;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ValidationTest {

    private Validator validator;

    @BeforeEach
    public void initValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testBadPasswordClienteDto() {
        ClienteDTO badDto = getRightDto();
        badDto.setPassword("1234567890");

        Set<ConstraintViolation<ClienteDTO>> fails = validator.validate(badDto);
        assertEquals(1, fails.size());
    }

    @Test
    public void testBadTelefonoClienteDto() {
        ClienteDTO badDto = getRightDto();
        badDto.setTelefono("aad1234567890");

        Set<ConstraintViolation<ClienteDTO>> fails = validator.validate(badDto);
        assertEquals(1, fails.size());
    }

    @Test
    public void testBadEdadClienteDto() {
        ClienteDTO badDto = getRightDto();
        badDto.setEdad(17);

        Set<ConstraintViolation<ClienteDTO>> fails = validator.validate(badDto);
        assertEquals(1, fails.size());
    }

    @Test
    public void testRightClienteDto() {
        ClienteDTO rightDto = getRightDto();

        Set<ConstraintViolation<ClienteDTO>> fails = validator.validate(rightDto);

        assertEquals(0, fails.size());
    }

    private ClienteDTO getRightDto() {
        ClienteDTO newCliente = new ClienteDTO();
        newCliente.setIdentidad("1234-1234-12345");
        newCliente.setEstado(true);
        newCliente.setPassword("S$a123456789w");
        newCliente.setEdad(34);
        newCliente.setTelefono("+1234567890");
        newCliente.setGenero(GeneroEnum.MASCULINO);
        newCliente.setDireccion("Fake Address");
        newCliente.setNombre("Fake Name");
        return newCliente;
    }

}
