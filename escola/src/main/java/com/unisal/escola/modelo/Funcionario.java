package com.unisal.escola.modelo;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {
	
	@Id
	private long cpf;

	@Column(nullable = false)
	private String nome;

	private String telefoneResidencial;
	private String telefoneComercial;
	private String telefoneCelular;

	@Column(nullable = false)
	private Date dataNasc;	
	@Column(nullable = false)
	private char sexo;
	private String endereco;
	private float precoDaHora;
	@Column(nullable = false)
	private int perfilDeAcesso;
	private String senha;
	@Column(nullable = false)
	private String funcao;
	private ArrayList<Especialidade> especialidades;

	

	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public String getTelefoneComercial() {
		return telefoneComercial;
	}
	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public float getPrecoDaHora() {
		return precoDaHora;
	}
	public void setPrecoDaHora(float precoDaHora) {
		this.precoDaHora = precoDaHora;
	}
	public int getPerfilDeAcesso() {
		return perfilDeAcesso;
	}
	public void setPerfilDeAcesso(int perfilDeAcesso) {
		this.perfilDeAcesso = perfilDeAcesso;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public ArrayList<Especialidade> getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(ArrayList<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

}