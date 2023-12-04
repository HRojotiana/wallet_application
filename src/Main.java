import model.Account;
import repository.AccountRepository;
import repository.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static repository.AccountRepository.INSERT_ACCOUNT_SQL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionConfiguration.getInstance().getConnection();

        try {

            AccountRepository accountRepository = new AccountRepository(connection);


            Account newAccount = new Account();
            newAccount.setId("123456");
            newAccount.setAccountName("Compte de test");
            newAccount.setAccountType("Type de compte");
            newAccount.setBalance(1000.0f);
            newAccount.setCurrencyId("USD");
            newAccount.setTransactionId("789012");
            accountRepository.addAccount(newAccount);

            System.out.println("Le compte a été ajouté avec succès.");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}