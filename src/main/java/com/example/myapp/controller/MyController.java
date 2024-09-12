package com.example.myapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/api/greeting")
    @Operation(summary = "Get Greeting", description = "Retorna un mensaje de Bienvenida.")
    public String getGreeting() {
        return "Bienvenido!";
    }

    @PostMapping("/api/submit")
    @Operation(summary = "Submit Data", description = "Recibe data y retorna un mensaje de confirmacion.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data correctamente recibida."),
            @ApiResponse(responseCode = "400", description = "Mala request, data invalida.")
    })
    public String submitData(@RequestBody String data) {
        return "Data recibida: " + data;
    }

    @GetMapping("/api/user/{id}")
    public String getUserById(@PathVariable("id") Long id) {
        return "User ID: " + id;
    }

    @GetMapping("/api/search")
    @Operation(summary = "Search", description = "Searches for items based on a query parameter.")
    public String search(
            @RequestParam(name = "query", defaultValue = "")
            @Parameter(description = "Search query") String query) {
        return "Resultados de la búsqueda para: " + query;
    }

    public class MyRequest {
        @Schema(description = "The data to be submitted", example = "Hello")
        private String data;
    }

}