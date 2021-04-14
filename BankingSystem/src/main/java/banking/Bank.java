package banking;

import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Optional;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		this.accounts = new LinkedHashMap();
	}

	private Account getAccount(Long accountNumber) {
        return accounts.get(accountNumber);
	}

	private Long getNextAccountNumber() {
		if (accounts.isEmpty()) {
			return 0L;
		}
		Long[] existingAccountIds = accounts.keySet().toArray(new Long[0]);

		return ++existingAccountIds[existingAccountIds.length - 1];
	}

	private void addAccount(Long nextAccountNumber, Account account) {
		accounts.put(nextAccountNumber, account);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		Long nextAccountNumber = getNextAccountNumber();
		// TODO: Extract somehow
		Account commercialAccount = new CommercialAccount(company, nextAccountNumber, pin, startingDeposit);
		addAccount(nextAccountNumber, commercialAccount);
        return nextAccountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		Long nextAccountNumber = getNextAccountNumber();
		// TODO: Extract somehow
		Account consumerAccount = new ConsumerAccount(person, nextAccountNumber, pin, startingDeposit);
		addAccount(nextAccountNumber, consumerAccount);
        return nextAccountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
        return true;
	}

	public double getBalance(Long accountNumber) {
		Account account = getAccount(accountNumber);
        return Objects.nonNull(account) ? account.getBalance() : -1;
	}

	public void credit(Long accountNumber, double amount) {
		Account account = getAccount(accountNumber);
		if(Objects.nonNull(account)) {
			account.creditAccount(amount);
		}
	}

	public boolean debit(Long accountNumber, double amount) {
		Account account = getAccount(accountNumber);

        return Objects.isNull(account) ? false : account.debitAccount(amount);
	}
}
