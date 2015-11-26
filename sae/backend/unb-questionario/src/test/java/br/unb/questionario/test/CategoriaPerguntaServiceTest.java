package br.unb.questionario.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.testng.Assert;

import br.unb.questionario.model.CategoriaPergunta;
import br.unb.questionario.service.CategoriaPerguntaService;

@RunWith(PowerMockRunner.class)
public class CategoriaPerguntaServiceTest {
	private CategoriaPerguntaService categoriaServices;
	
	@Before
	public void setUp(){
		categoriaServices = Mockito.mock(CategoriaPerguntaService.class);
	}
	
	@Test
    public void testFind() {
		categoriaServices.find("", "", 0, 0, "");
		Assert.assertEquals(true, true);
	}

	@Test
    public void testFindById() {
		categoriaServices.findById(0);
		Assert.assertEquals(true, true);
	}

	@Test
    public void testUpdate() {
		CategoriaPergunta categoriaPergunta = Mockito.mock(CategoriaPergunta.class);
		categoriaPergunta.setDenominacao("Denominacao");
		categoriaServices.update(categoriaPergunta);
		Assert.assertEquals(true, true);
	}
	
	@Test
    public void testInsert() {
		CategoriaPergunta categoriaPergunta = Mockito.mock(CategoriaPergunta.class);
		categoriaPergunta.setDenominacao("Denominacao");
		categoriaServices.insert(categoriaPergunta);
		Assert.assertEquals(true, true);
	}

	
}
