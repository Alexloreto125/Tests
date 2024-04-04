package com.epicode.U5D2;

import com.epicode.U5D2.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class Esercizio30102023ApplicationTests {
	@Autowired
	private Menu menu;

	@Test
	public void testMenu() {

		assertDoesNotThrow(() -> menu.printMenu());
	}
	@Autowired
	@Qualifier("Tavolo1")
	private Table table;

	@Test
	public void testTable() {
		assertDoesNotThrow(() -> table.print());
	}

	@Test
	public void testTotalOrder(){
		Table tavolo1 = new Table(1, 4, true, 2.0);
		Order order = new Order(2, tavolo1);
		order.addItem(new Drink("Test Drink", 100, 2.5));
		double expectedTotal = 2.0 * 2 + 2.5;
		double totale= order.getTotal();
		Assertions.assertEquals(expectedTotal, totale);

	}

	@Test
	public void testOrderAddItem() {
		Table tavolo = new Table(1, 4, true, 2.0);
		Order order = new Order(2, tavolo);
		Drink drink = new Drink("Test Drink", 100, 2.5);
		order.addItem(drink);
		assertTrue(order.orderedProducts.contains(drink));
	}

	@Test
	public void testMenuPizza() {

		assertFalse(menu.getPizzaList().isEmpty());
	}

}
