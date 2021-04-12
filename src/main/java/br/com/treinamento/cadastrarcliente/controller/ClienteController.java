package br.com.treinamento.cadastrarcliente.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.cadastrarcliente.model.Cliente;
import br.com.treinamento.cadastrarcliente.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	// POST
	@PostMapping("")
	public ResponseEntity<?> add(@Valid @RequestBody Cliente cliente) {
		clienteService.saveCliente(cliente);
		return new ResponseEntity<>(HttpStatus.CREATED); // 201
	}
	
	// Para o @Valid
	// TODO: Colocar no package HANDLER
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
