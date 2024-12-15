package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	@Test
	// @Tag(value = "Deve adicionar o valor quando a quanria for positiva")
	public void depositShouldIncreaseBalanceWhenPositiveMount() {
		// arrange
		final double amount = 200.0;
		final double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();

		// act
		acc.deposit(amount);

		// assert
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void depositDoNothingWhenNegativeAmount() {
		// arrange
		final double amount = -200.0;
		final double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);

		// act
		acc.deposit(amount);

		// assert
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		// arrange
		final double expectedValue = 0.0;
		final double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		// act
		final double result = acc.fullWithdraw();
		// assert
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertEquals(result, initialBalance);
	}

	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		// arrange
		Account acc = AccountFactory.createAccount(800.0);

		// act
		acc.withdraw(500.0);
		// assert
		Assertions.assertEquals(300.0, acc.getBalance());
	}

	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.0);
			acc.withdraw(1500.0);
		});
	}
}
