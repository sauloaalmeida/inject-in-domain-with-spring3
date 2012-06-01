package br.com.lts.tfl.domain;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Configurable;

import br.com.lts.tfl.repository.BairroRepository;

@Entity
@Configurable
public class Bairro implements Serializable{
	
	private static final long serialVersionUID = -8807424123051026006L;

	@Transient
	@Inject
	private BairroRepository bairroRepository;
 
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=40,nullable=false,unique=true)
	private String nome;

	public Bairro(Long id, String nome) {
		this(nome);
		this.id = id;
	}
	
	public Bairro() {
		
	}
	
	public Bairro( String nome) {
		this();
		this.nome = nome;
	}
	
	
	public void salvar() {
		bairroRepository.salvar(this);		
	}	
	
	
	public void alterar(){
		bairroRepository.altera(this);
	}
	
	public Bairro get(Long id){
		return bairroRepository.consulta(id);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Bairro [id=" + id + ", nome=" + nome + "]";
	}

	public List<Bairro> getAll() {
		return bairroRepository.findAll();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bairro other = (Bairro) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	
	
	 
}
 
