package aulaJUnit.tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import aulaJUnit.entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	
	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		/** Padrão AAA **/
		
		// Arrange:  instancie os objetos necessários
		double amount = 200.00;
		double expectedValue = 196.00;
		//Account acc = new Account(1L, 0.0);
		Account acc = AccountFactory.createEmptyAccount();
		
		// Act:  execute as ações necessárias
		acc.deposit(amount);
		
		// Assert: declare o que deveria acontecer (resultado esperado)
		Assertions.assertEquals(acc.getBalance(), expectedValue);
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		
		double expectedValue = 100.00;
		//Account acc = new Account(1L, expectedValue);
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.00;
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullWithdraw();
		
		Assertions.assertTrue(acc.getBalance() == expectedValue);
		Assertions.assertTrue(result == initialBalance);
	}
	
	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		
		Account acc = AccountFactory.createAccount(800.00);
		
		acc.withdraw(500);
		
		Assertions.assertEquals(300, acc.getBalance());
	}
	
	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
		Assertions.assertThrows(IllegalArgumentException.class, 
				() -> {
					Account acc = AccountFactory.createAccount(800.00);
					acc.withdraw(801.0);
				});
		
	}
}
