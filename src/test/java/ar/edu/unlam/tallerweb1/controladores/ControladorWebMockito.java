package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

public class ControladorWebMockito {

	@InjectMocks
	private ControladorWeb controladorWeb;
	@Before
	public void inyeccionAntesDeCadaTest() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testInicio(){
		ModelAndView mav = controladorWeb.inicio();
		assertThat(mav.getViewName()).isEqualTo("redirect:/index");
		
	}
	@Test
	public void testIndex(){
		ModelAndView mav1 = controladorWeb.index();
		assertThat(mav1.getViewName()).isEqualTo("index");
	}
	@Test
	public void testIndexChofer(){
		ModelAndView mav2 = controladorWeb.indexChofer();
		assertThat(mav2.getViewName()).isEqualTo("index_chofer");
	}
	@Test
	public void testIndexAdministrador(){
		ModelAndView mav2 = controladorWeb.indexAdministrador();
		assertThat(mav2.getViewName()).isEqualTo("index_administrador");
	}
}
