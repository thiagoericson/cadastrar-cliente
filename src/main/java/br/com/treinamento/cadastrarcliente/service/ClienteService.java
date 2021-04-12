package br.com.treinamento.cadastrarcliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamento.cadastrarcliente.model.Cliente;
import br.com.treinamento.cadastrarcliente.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public void saveCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
}
