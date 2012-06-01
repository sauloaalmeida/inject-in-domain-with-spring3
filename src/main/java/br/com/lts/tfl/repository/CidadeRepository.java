package br.com.lts.tfl.repository;

import br.com.lts.tfl.domain.Cidade;

public interface CidadeRepository {

	void save(Cidade c);
	
	void deleta(Cidade c);
	
	void consulta(Cidade c);
	
	void altera(Cidade c,Cidade cNova);

	Cidade get(Long idCidade);
	
}
