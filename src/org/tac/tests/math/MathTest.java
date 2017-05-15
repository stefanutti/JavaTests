package org.tac.tests.math;

import java.math.*;

public class MathTest {
	public static void main(String[] args) {

		BigInteger bigInteger = new BigInteger("89390100008542091666");
		System.out.println("Debug: " + bigInteger.intValue());

		if (bigInteger.intValue() > 0) {
			System.out.println("Debug: Valore maggiore di zero");
		}
		else {
			System.out.println("Debug: Valore minore di zero");
		}

		bigInteger = new BigInteger("222018102300421");
		System.out.println("Debug: " + bigInteger.intValue());

		if (bigInteger.intValue() > 0) {
			System.out.println("Debug: Valore maggiore di zero");
		}
		else {
			System.out.println("Debug: Valore minore di zero");
		}
	}
}
