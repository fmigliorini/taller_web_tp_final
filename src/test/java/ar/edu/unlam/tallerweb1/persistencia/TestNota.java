package ar.edu.unlam.tallerweb1.persistencia;



import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Nota;

public class TestNota {
	
	
	@Test 
	//PUNTO 1
	public void alCrearNotaDeberiaTenerValorMayorAunoYmenorIgualADiez() throws Exception{
		//PRUEBO LA LLAMADA DEL MÉTODO CONSTRUCTOR
		Nota miNota0=new Nota(3.0);
		//Nota esta entre 1 y 10 
		Assert.assertTrue(1<=miNota0.valor() && 10>=miNota0.valor());
		
	}
	//PUNTO 2
	@Test(expected=Exception.class)//da verde si ocurre una exception
	public void alCrearNotaConValorNuloDeberiaDarError()throws Exception{
		//cuando creo una nota me tiene que dar una exception
		Nota nota=new Nota(null);
		
		//TDE modifique el constructor para que de verde
		Assert.assertEquals(null,nota.valor());
	    //Hay una Exception 
		//No tiene sentido un try catch para un test
	}
	//PUNTO 3
	@Test(expected=Exception.class)
	public void alCrearNotaConValorMayorADiezDeError()throws Exception{
		Nota notaMayor=new Nota(30.0);
		Double valorActual=30.0;
		Assert.assertEquals(valorActual,notaMayor.valor());
		
	}
	//PUNTO 4 
	@Test(expected=Exception.class)
	public void alCrearNotaConValorNegativoDeError()throws Exception{
		Nota notaNegativa=new Nota(-30.0);
		Double valorActual=-30.0;
		Assert.assertEquals(valorActual,notaNegativa.valor());
	}
	//PUNTO 5
	@Test
	public void alCrearLaNotaConValorMayoraCuatroEsteAprobado() throws Exception{
		Nota miNota4=new Nota(5.0);
		Assert.assertEquals(true,miNota4.estaAprobado());
	}
	//PUNTO 6
	@Test
	public void alCrearLaNotaConValorMayorASieteEsteAprobado() throws Exception{
		Nota miNota5=new Nota(8.0);
		Assert.assertEquals(true,miNota5.estaAprobado());
	}
	//PUNTO 7
	@Test
	public void alCrearLaNotaConValorMenorACuatroNoEsteAprobado() throws Exception{
		Nota miNota=new Nota(3.0);
		Assert.assertEquals(false,miNota.estaAprobado());
	}
	//PUNTO 8
	@Test
	public void alCrearLaNotaMayorOIgualASiete() throws Exception{
		Nota miNota6=new Nota(7.0);
		Assert.assertEquals(true,miNota6.estaPromocionada());
	}
	//PUNTO 9
	
	@Test
	public void alCrearLaNotaEsteEntreCuatroYSiete() throws Exception{
		Nota miNota7=new Nota(4.0);
		Assert.assertEquals(true,miNota7.estaPromocionada());
	}
	//PUNTO 10
	@Test
	public void alCrearLaNotaRecuperadaPiseLaVieja() throws Exception{
		Nota miNota8=new Nota(2.0);
		miNota8.recuperar(6.0);
		Double valorRecuperado=6.0;
		Assert.assertEquals(valorRecuperado,miNota8.valor());
	}
	//PUNTO 11
	@Test
	public void alCrearLaNotaPiseSinImportaSiEsMayorOmenor() throws Exception{
		Nota miNota9=new Nota(7.0);
		miNota9.recuperar(4.0);
		Double valorRecuperado=4.0;
		Assert.assertEquals(valorRecuperado,miNota9.valor());
	}
	//arreglar
	/*@Test
	public void alCrearLaNotanPuedoRecuperarSiYaRecupere() throws Exception{
		Nota miNota10=new Nota(2.0);
		miNota10.recuperar(4.0);
		miNota10.recuperar(7.0);
		Double valorRecuperado=4.0;
		Assert.assertEquals(valorRecuperado,miNota10.valor());
	}*/
}
