package br.com.everis.lpu.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario extends EntidadeAbstrata<Long>{

	private String nome;
	private String email;
	private String senha;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name="usuario_permissao", joinColumns = @JoinColumn(name="codigo_usuario"),
//	inverseJoinColumns = @JoinColumn(name="codigo_permissao"))
//	private List<Permissao> permissoes;
	
	@OneToMany(mappedBy = "usuario")
	private List<Demanda> demandas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

//	public List<Permissao> getPermissoes() {
//		return permissoes;
//	}
//
//	public void setPermissoes(List<Permissao> permissoes) {
//		this.permissoes = permissoes;
//	}
	
}
