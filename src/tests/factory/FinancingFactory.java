package tests.factory;

import entities.Financing;

public class FinancingFactory {
	
	public static Financing createValidFinancing() {
		return new Financing(10000.0, 2000.0, 20);
	}
}
