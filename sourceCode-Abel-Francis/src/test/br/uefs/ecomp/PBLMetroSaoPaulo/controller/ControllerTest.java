package br.uefs.ecomp.PBLMetroSaoPaulo.controller;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ControllerTest extends TestCase {
	
	private Controller testController;
	
	@Before
	public void setUp() {
		this.testController = Controller.getInstance();
	}
	
	@Test
	public void testeLerNoArquivoEInsere() {
		try {
			this.testController.lerNoArquivoEInsere("MapaMetro.txt");
			assertTrue(true);
		} catch (IOException e) {
			assertFalse("ERRO", false);
			e.printStackTrace();
		}
	}
}
