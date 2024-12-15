package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingTests {

	@Test
	public void shouldNotThrowExceptionWhenQuotaIsSmallerThanHalfIncome() {
		Assertions.assertDoesNotThrow(() -> {
			new Financing(10000.0, 2000.0, 20);
		});
	}

	@Test
	public void shouldThrowExceptionWhenInvalidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Financing(100000.0, 2000.0, 20);
		});
	}

	@Test
	public void setTotalAmountShouldUpdateTotalAmountWhenIsValid() {
		final double updateTotalAmount = 5000.0;
		var financing = FinancingFactory.createValidFinancing();

		Assertions.assertAll(() -> Assertions.assertDoesNotThrow(() -> financing.setTotalAmount(updateTotalAmount)),
				() -> {
					financing.setTotalAmount(updateTotalAmount);
					Assertions.assertEquals(updateTotalAmount, financing.getTotalAmount());
				});
	}

	@Test
	public void setTotalAmountShouldThrowExceptionWhenTotalAmountIsInvalid() {
		final double invalidTotalAmount = 100000.0;
		var financing = FinancingFactory.createValidFinancing();

		Assertions.assertThrows(IllegalArgumentException.class, () -> financing.setTotalAmount(invalidTotalAmount));
	}

	@Test
	public void setIncomeShouldUpdateIncomeWhenIsValid() {
		final double updateIncome = 3000.0;
		var financing = FinancingFactory.createValidFinancing();

		Assertions.assertDoesNotThrow(() -> financing.setIncome(updateIncome));
		Assertions.assertEquals(updateIncome, financing.getIncome());
	}

	@Test
	public void setIncomeShouldThrowExceptionWhenIncomeIsInvalid() {
		final double invalidIncome = 300.0;
		var financing = FinancingFactory.createValidFinancing();

		Assertions.assertThrows(IllegalArgumentException.class, () -> financing.setIncome(invalidIncome));
	}

	@Test
	public void setMonthsShouldUpdateMonthsWhenIsValid() {
		final int updateMonths = 30;
		var financing = FinancingFactory.createValidFinancing();

		Assertions.assertDoesNotThrow(() -> financing.setMonths(updateMonths));
		Assertions.assertEquals(updateMonths, financing.getMonths());
	}
	
	@Test
	public void setMonthsShouldThrowExceptionWhenMonthsIsInvalid() {
		final int invalidMonths = 5;
		var financing = FinancingFactory.createValidFinancing();

		Assertions.assertThrows(IllegalArgumentException.class, () -> financing.setMonths(invalidMonths));
	}

	@Test
	public void shoudReturnCorrectQuota() {
		final double totalAmount = 10000.0;
		final double income = 2000.0;
		final int months = 20;
		final double expectedQuota = 400.0;

		Financing financing = new Financing(totalAmount, income, months);

		Assertions.assertEquals(expectedQuota, financing.quota());
	}

	@Test
	public void shoudReturnCorrectEntry() {
		final double totalAmount = 10000.0;
		final double income = 2000.0;
		final int months = 20;
		final double expectedEnty = 2000.0;

		Financing financing = new Financing(totalAmount, income, months);

		Assertions.assertEquals(expectedEnty, financing.entry());
	}
}
