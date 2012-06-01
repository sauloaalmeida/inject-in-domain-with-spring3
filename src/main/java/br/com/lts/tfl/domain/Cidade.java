package br.com.lts.tfl.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import br.com.lts.tfl.repository.CidadeRepository;
import br.com.lts.tfl.repository.jpa.CidadeRepositoryJPAImpl;

@Entity
public class Cidade {
 
	@Transient
	private CidadeRepository cidadeRepository;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=2,nullable=false,unique=true)
	private String ddd;

	@Column(length=60,nullable=false,unique=false)
	private String nome;

	// Construtores
	public Cidade(Long id, String ddd,String nome) {
		this();
		this.id = id;
		this.ddd = ddd;
		this.nome = nome;
	}
	
	public Cidade(){
			
		cidadeRepository = new CidadeRepositoryJPAImpl();
			
	}
	
	//Métodos
	public void save(){
		
		cidadeRepository.save(this);
		
	}
	
	public Cidade get(Long idCidade){
		
		return cidadeRepository.get(idCidade);
		
	}
	
	
	
	//Gets e sets
	
	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}	
	 
}
 
