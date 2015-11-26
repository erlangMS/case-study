package br.unb.questionario.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import br.unb.questionario.service.PerguntaService;

@RunWith(PowerMockRunner.class)
public class PerguntaServiceTest {
	
	private PerguntaService perguntaService;
	
	@Before
	public void setUp(){
		perguntaService = Mockito.mock(PerguntaService.class);
	}
	
	@Test
	public void testFind(){
		perguntaService.find("", "", 0, 0, "");
	}

}
