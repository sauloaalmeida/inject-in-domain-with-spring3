package br.com.lts.tfl.repository.jpa;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.lts.tfl.domain.Bairro;
import br.com.lts.tfl.repository.BairroRepository;

@Named("bairroRepository")
public class BairroRepositoryJPAImpl implements BairroRepository {
	
    @PersistenceContext   
    private EntityManager entityManager;      
          
	
	public void salvar(Bairro b){
		entityManager.persist(b);
	}
	
	public void deleta(Bairro b){
		entityManager.remove(b);
	}
	
	public void altera(Bairro b){
		Bairro bAntigo = entityManager.getReference(Bairro.class, b.getId());		
		bAntigo.setNome(b.getNome());
	}
	

	public Bairro consulta(Long idBairro) {		
		return entityManager.find(Bairro.class, idBairro);
	}

	public List<Bairro> findAll() {
		return entityManager.createQuery("from Bairro",Bairro.class).getResultList();
	}

	
}
