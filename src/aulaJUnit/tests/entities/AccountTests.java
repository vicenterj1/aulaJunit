package aulaJUnit.tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import aulaJUnit.entities.Account;

public class AccountTests {
	
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		/** Padrão AAA **/
		
		// Arrange:  instancie os objetos necessários
		double amount = 200.00;
		double expectedValue = 196.00;
		Account acc = new Account(1L, 0.0);
		
		// Act:  execute as ações necessárias
		acc.deposit(amount);
		
		// Assert: declare o que deveria acontecer (resultado esperado)
		Assertions.assertEquals(acc.getBalance(), expectedValue);
	}

}
