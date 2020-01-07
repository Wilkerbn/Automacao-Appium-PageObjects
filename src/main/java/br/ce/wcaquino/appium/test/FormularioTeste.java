package br.ce.wcaquino.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.FormularioPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class FormularioTeste extends BaseTest {

	

	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {

		menu.acessarFormulario();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {

		// Escrever nome
		page.escreverNome("Wilker");

		// Checar nome escrito
		assertEquals("Wilker", page.obterNome());

	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {

		// clicar no combo
		page.selecionarCombo("Nintendo Switch"); 

		// efetuar verificação
		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());

	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {

		// verificar status dos elementos
		Assert.assertFalse(page.isCheckMarcado());
		Assert.assertTrue(page.isSwitchMarcado());

		// clicar nos elementos
		page.clicarCheck();
		page.clicarSwitch();

		// verificar estados alterados
		Assert.assertTrue(page.isCheckMarcado());
		Assert.assertFalse(page.isSwitchMarcado());

	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException, Exception {
		
		//Preencher campos
		page.escreverNome("Wilker");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("Nintendo Switch");
		
		//salvar
		page.salvar();

		//verificações
		Assert.assertEquals("Nome: Wilker", page.obterNomeCadastrado());
		Assert.assertEquals("Console: switch", page.obterConsoleCadastrado());
		Assert.assertTrue(page.obterCheckCadastrado().endsWith("Off"));
		Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Marcado"));

	}



}
