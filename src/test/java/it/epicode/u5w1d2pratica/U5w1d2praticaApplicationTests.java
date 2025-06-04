package it.epicode.u5w1d2pratica;

import it.epicode.u5w1d2pratica.bean.Drink;
import it.epicode.u5w1d2pratica.bean.Menu;
import it.epicode.u5w1d2pratica.bean.Pizza;
import it.epicode.u5w1d2pratica.bean.Tavolo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class U5w1d2praticaApplicationTests {

	private  static AnnotationConfigApplicationContext ctx;

	@BeforeAll
	public static void creaContesto(){ ctx=
			new AnnotationConfigApplicationContext(U5w1d2praticaApplication.class);

	}

	@BeforeEach
	public void primaDelTest(){
		System.out.println("inizio test");
	}
	@Test
	public void verificaCostoCopertoTavolo1(){
//		AnnotationConfigApplicationContext ctx =
//				new AnnotationConfigApplicationContext(U5w1d2praticaApplication.class);

		Tavolo tavolo1 = ctx.getBean("t1",Tavolo.class);

		Assertions.assertEquals(3, tavolo1.getCostoCoperto());
	}

	@Test
	public void verificaNumeroPizzeEDrink (){

		Menu menu = ctx.getBean(Menu.class);

		long countPizza =menu.getProdotti().stream().filter(prodotto -> prodotto instanceof Pizza).count();
		long countDrink =menu.getProdotti().stream().filter(prodotto -> prodotto instanceof Drink).count();

		Assertions.assertAll(
				()->Assertions.assertEquals(2,countPizza),
				()->Assertions.assertEquals(2,countDrink)
		);
	}

	@AfterEach
	public  void dopoIlTest(){
		System.out.println("fine test");
	}

	@AfterAll
	public static void chiudiContesto(){
		ctx.close();
	}

	@ParameterizedTest
	@ValueSource(strings = {"tomato","mozzarella","salame"})
	public void verficaBeanEsistenti(String topping){

		Menu menu = ctx.getBean(Menu.class);
		boolean exist=menu.getProdotti().stream().anyMatch(prodotto -> prodotto.getNome().equalsIgnoreCase(topping));
		Assertions.assertTrue(exist);

	}

	@ParameterizedTest
	@CsvSource({"tomato,1","mozzarella,1","salame,0"})
	public void verficaToppingMenu(String topping,int numeroAtteso){

		Menu menu = ctx.getBean(Menu.class);
		long count =menu.getProdotti().stream().filter(prodotto -> prodotto.getNome().equalsIgnoreCase(topping)).count();
		Assertions.assertEquals(numeroAtteso,count);

	}

	//---------------------------------- compiti u5w1d3-----------------------
	// 1 .Test per verificare che il menu non sia vuoto e contenga prodotti
	@Test
	public void verificaContenutoMenu() {
		Menu menu = ctx.getBean(Menu.class);
		Assertions.assertNotNull(menu.getProdotti());
//		Assertions.assertFalse(menu.getProdotti().isEmpty(), "Il menu non deve essere vuoto");
	}

	// 2. verifica se il bean tavolo t1 esiste
	@Test
	public void verificaBeanTavoloEsistente() {
		boolean beanEsiste = ctx.containsBean("t1");
		Assertions.assertTrue(beanEsiste);
	}
	//3. verifica se esiste una pizza con nome pistacchiosa nel menu
	@ParameterizedTest
	@ValueSource(strings = {"pistacchiosa"})
	public void verificaPizzaPistacchiosa(String nomePizza){
		Menu menu = ctx.getBean(Menu.class);
		boolean esistePistacchiosa = menu.getProdotti().stream()
				.anyMatch(p -> p instanceof Pizza && p.getNome().equalsIgnoreCase(nomePizza));
		Assertions.assertTrue(esistePistacchiosa);
	}




	// 4. verifica l`esistenza di prodotti nel menu
	@ParameterizedTest
	@ValueSource(strings = {"acqua", "birra", "cola"})
	public void verificaEsistenzaProdottiMenu(String prodotto) {
		Menu menu = ctx.getBean(Menu.class);
		boolean esiste = menu.getProdotti().stream()
				.anyMatch(p -> p.getNome().equalsIgnoreCase(prodotto));
		Assertions.assertTrue(esiste);
	}
	// 5.
	@ParameterizedTest
	@CsvSource({"water,2", "birra,1", "cola,0"})
	public void verificaQuantitaProdottiMenu(String prodotto, int quantitaAttesa) {
		Menu menu = ctx.getBean(Menu.class);
		long quantita = menu.getProdotti().stream()
				.filter(p -> p.getNome().equalsIgnoreCase(prodotto))
				.count();
		Assertions.assertEquals(quantitaAttesa, quantita );
	}
}
