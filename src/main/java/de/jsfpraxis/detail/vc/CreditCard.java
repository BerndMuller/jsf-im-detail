package de.jsfpraxis.detail.vc;

import java.util.Arrays;

/**
 * Eine Kreditkarte bzw. Kreditkartennummer.
 * <p>
 * Eine Kreditkartennummer ist ein Quadrupel, wobei jedes Glied aus vier Ziffern besteht.
 *
 */
public class CreditCard {

	private String[] quads;

	public CreditCard(String q1, String q2, String q3, String q4) {
		if (q1.length() != 4 || q2.length() != 4 || q3.length() != 4 || q4.length() != 4) {
			throw new IllegalArgumentException("Quads nicht 4 Zeichen lang");
		}
		char[] chars = (q1 + q2 + q3 + q4).toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] < '0' || chars[i] > '9') {
				throw new IllegalArgumentException("Quads bestehen nicht ausschließlich aus Ziffern");
			}
		}
		quads = new String[] { q1, q2, q3, q4 };
	}

	/**
	 * Externe Repräsentation mit Leerzeichen als Trenner.
	 */
	@Override
	public String toString() {
		return quads[0] + " " + quads[1] + " " + quads[2] + " " + quads[3];
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(quads);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		if (!Arrays.equals(quads, other.quads))
			return false;
		return true;
	}

}
