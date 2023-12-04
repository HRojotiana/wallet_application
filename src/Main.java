import model.Account;
import model.Currency;
import model.Transaction;
import repository.AccountRepository;
import repository.ConnectionConfiguration;
import repository.CurrencyRepository;
import repository.TransactionRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static repository.AccountRepository.INSERT_ACCOUNT_SQL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionConfiguration.getInstance().getConnection();


        try {
            AccountRepository accountRepository = new AccountRepository(connection);

            //InsertAccount
            Account newAccount = new Account();
            newAccount.setId("123456");
            newAccount.setAccountName("Test Account");
            newAccount.setAccountType("Account Type");
            newAccount.setBalance(1000.0f);
            newAccount.setCurrencyId("USD");
            newAccount.setTransactionId("789012");
            accountRepository.addAccount(newAccount);
            System.out.println("Account created successfully.");

            //GetAccount
            String accountIdToRetrieve = "123456";
            Account retrievedAccount = accountRepository.getAccountById(accountIdToRetrieve);

            if (retrievedAccount != null) {
                System.out.println("Account details");
                System.out.println("ID: " + retrievedAccount.getId());
                System.out.println("Account Name: " + retrievedAccount.getAccountName());
                System.out.println("Account Type: " + retrievedAccount.getAccountType());
                System.out.println("Balance: " + retrievedAccount.getBalance());
                System.out.println("Currency ID: " + retrievedAccount.getCurrencyId());
                System.out.println("Transaction ID: " + retrievedAccount.getTransactionId());
            } else {
                System.out.println("No account found with the ID " + accountIdToRetrieve);
            }

                //InsertCurrency
            CurrencyRepository currencyRepository = new CurrencyRepository(connection);
            Currency newCurrency = new Currency();
            newCurrency.setId("KYB");
            newCurrency.setCurrencyCode("£");
            newCurrency.setCurrencyName("German");
            newCurrency.setCurrencySymbol("µ");
            newCurrency.setExchangeRate("0.98");

            currencyRepository.addCurrency(newCurrency);
            System.out.println("Currency added successfully");

            //GetCurrency
            String currencyIdToRetrieve = "USD";
            Currency retrievedCurrency = currencyRepository.getCurrencyById(currencyIdToRetrieve);

            if (retrievedCurrency != null) {
                System.out.println("Currency details");
                System.out.println("ID: " + retrievedCurrency.getId());
                System.out.println("Code: " + retrievedCurrency.getCurrencyCode());
                System.out.println("Name: " + retrievedCurrency.getCurrencyName());
                System.out.println("Symbol: " + retrievedCurrency.getCurrencySymbol());
                System.out.println("Exchange Rate: " + retrievedCurrency.getExchangeRate());
            } else {
                System.out.println("No currency found with the ID " + currencyIdToRetrieve);
            }
            // Delete Currency
            String currencyIdToDelete = "LMS";
            currencyRepository.deleteCurrencyById(currencyIdToDelete);
            System.out.println("Currency with ID " + currencyIdToDelete + " deleted successfully");

            TransactionRepository transactionRepository = new TransactionRepository(connection);

            //Insert Transactions
            Transaction newTransaction = new Transaction();
            newTransaction.setId("120");
            newTransaction.setCategory("expense");
            newTransaction.setLabel("None");
            newTransaction.setDate(LocalDate.parse("2023-12-04").atStartOfDay());
            newTransaction.setPaymentId("2");
            transactionRepository.addTransaction(newTransaction);
            System.out.println("Transaction added successfully.");


           // Delete Transactions
            String transactionIdToDelete = "110";
            boolean isTransactionDeleted = transactionRepository.deleteTransactionById(transactionIdToDelete);

            if (isTransactionDeleted) {
                System.out.println("Transaction with ID " + transactionIdToDelete + " deleted successfully");
            } else {
                System.out.println("No transaction found with the ID " + transactionIdToDelete);
            }

            //Get Transactions


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
