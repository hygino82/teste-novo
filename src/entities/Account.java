package entities;

import java.util.Objects;

public class Account {

	public static double DEPOSIT_FEE_PERCENTAGE = 0.02;
	private Long id;
	private Double balance;

	public Account() {
	}

	public Account(Long id, Double balance) {
		this.id = id;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(id, other.id);
	}

	public void deposit(double amount) {
		if (amount > 0) {
			amount -= amount * DEPOSIT_FEE_PERCENTAGE;
			balance += amount;
		}
	}

	public void withdraw(double amount) {
		if (amount > balance) {
			throw new IllegalArgumentException();
		}
		balance -= amount;
	}

	public double fullWithdraw() {
		final double aux = balance;
		balance = 0.0;
		return aux;
	}
}
