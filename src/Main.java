import model.Account;
import repository.AccountRepository;
import repository.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Obtaining the configured connection
        Connection connection = ConnectionConfiguration.getInstance().getConnection();

        // Creating an instance of AccountRepository
        AccountRepository accountRepository = new AccountRepository(connection);

        // Creating an example account
        Account accountToAdd = new Account();
        accountToAdd.setId("1");
        accountToAdd.setAccountName("TestAccount");
        accountToAdd.setAccountType("Savings");
        accountToAdd.setBalance(1000.0f);
        accountToAdd.setCurrencyId("USD");
        accountToAdd.setTransactionId("1");

        // Calling the addAccount method
        accountRepository.addAccount(accountToAdd);

        System.out.println("Account added successfully.");

    }
}