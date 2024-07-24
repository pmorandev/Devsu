package com.pmoran.devsu.service.cuenta.api;

import com.pmoran.devsu.service.cuenta.model.MovimientoDTO;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@RequestMapping(ReportAPI.BASE_URL)
@Validated
public interface ReportAPI {

    //message = "EL inicio del rango de fecha no posee el rango correcto"

    final String BASE_URL = "/reportes";

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<MovimientoDTO>> getMovimientosByDateAndCliente(
            @RequestParam(name = "start", required = true)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam(name = "end", required = true)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end,
            @RequestParam(name = "cliente", required = true)
            @NotNull(message = "Id del cliente no especificado") Long cliente
            );

}
