package br.com.treinamento.cadastrarcliente.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "'cpf' é obrigatório")
	private Long cpf;
	
	@Column(name="primeiro_nome")
	@NotNull(message = "'primeiroNome' é obrigatório")
	private String primeiroNome;
	
	@Column(name="ultimo_nome")
	@NotNull(message = "'ultimoNome' é obrigatório")
	private String ultimoNome;
	
	private Double salario;
	
	private String profissao;
	
	private String sexo;
	
	// TODO: Ao salvar/atualizar a data, está decrementando 1 dia;
	@Column(name="data_nascimento")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Past(message = "'dataNascimento' deve estar no passado!")
	@NotNull(message = "'dataNascimento' é obrigatório")
	private Date dataNascimento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
