package banking;

import java.util.Objects;

public abstract class AccountHolder {
	private int idNumber;

	/**
	 * @param idNumber The government-issued ID used during account setup.
	 */
	public AccountHolder(int idNumber){
		this.idNumber = idNumber;
	}

	/**
	 * @return private int {@link AccountHolder#idNumber}
	 */
	public int getIdNumber() {
        return idNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AccountHolder that = (AccountHolder) o;
		return idNumber == that.idNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idNumber);
	}

	public abstract boolean isPerson();
}
