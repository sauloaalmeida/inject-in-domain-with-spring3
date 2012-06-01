package br.com.lts.tfl.repository;

import java.util.List;

import br.com.lts.tfl.domain.Bairro;

public interface BairroRepository {

	void salvar(Bairro b);
	
	void deleta(Bairro b);
	
	Bairro consulta(Long id);
	
	void altera(Bairro b);

	List<Bairro> findAll();

	
}
