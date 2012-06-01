package br.com.lts.tfl.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/ApplicationContext.xml", "/ApplicationContextTest.xml"})
public class BairroTest 
{
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	@Before
	public void setup(){

		//cadastra o bairro para o teste usando o EntityManager
		//para isolar o comportamento do teste
		Bairro b = new Bairro("penha");
		em.persist(b);
	}

	@Transactional
	@Test
    public void getBairroTest()
    {		
		
		Bairro bairroPenha = new Bairro().get(1l);
	
		Assert.assertEquals(bairroPenha,new Bairro("penha"));
				
    }
	
	
	
}
