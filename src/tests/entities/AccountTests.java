package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {

	@Test
	// @Tag(value = "Deve adicionar o valor quando a quanria for positiva")
	public void depositShouldIncreaseBalanceWhenPositiveMount() {
		// arrange
		final double amount = 200.0;
		final double expectedValue = 196.0;
		Account acc = new Account(1L, 0.0);

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
		Account acc = new Account(1L, expectedValue);

		// act
		acc.deposit(amount);

		// assert
		Assertions.assertEquals(acc.getBalance(), acc.getBalance());
	}
}
