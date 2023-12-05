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
            Account newAccount = new Account("123456", "Test Account", "AccountType", 1233.0f,"USD", "789012" );
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

            // Update Account
            Account updatedAccount = new Account("123456", "Updated Account Name", "Updated Account Type", 1500.0f, "EUR", "987654");


            accountRepository.updateAccount(updatedAccount);
            System.out.println("Account updated successfully.");

            // Retrieve and print the updated account details
            Account retrievedUpdatedAccount = accountRepository.getAccountById("123456");
            if (retrievedUpdatedAccount != null) {
                System.out.println("Updated Account details");
                System.out.println("ID: " + retrievedUpdatedAccount.getId());
                System.out.println("Account Name: " + retrievedUpdatedAccount.getAccountName());
                System.out.println("Account Type: " + retrievedUpdatedAccount.getAccountType());
                System.out.println("Balance: " + retrievedUpdatedAccount.getBalance());
                System.out.println("Currency ID: " + retrievedUpdatedAccount.getCurrencyId());
                System.out.println("Transaction ID: " + retrievedUpdatedAccount.getTransactionId());
            } else {
                System.out.println("No account found with the ID 123456");
            }


            //InsertCurrency
            CurrencyRepository currencyRepository = new CurrencyRepository(connection);
            Currency newCurrency = new Currency();
            newCurrency.setId("KIO");
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

            // Update Currency
            Currency updatedCurrency = new Currency();
            updatedCurrency.setId("LOO");
            updatedCurrency.setCurrencyCode("££");
            updatedCurrency.setCurrencyName("Updated Currency Name");
            updatedCurrency.setCurrencySymbol("µµ");
            updatedCurrency.setExchangeRate("1.1");

            currencyRepository.updateCurrency(updatedCurrency);
            System.out.println("Currency updated successfully.");

            // Retrieve and print the updated currency details
            Currency retrievedUpdatedCurrency = currencyRepository.getCurrencyById("QIO");
            if (retrievedUpdatedCurrency != null) {
                System.out.println("Updated Currency details");
                System.out.println("ID: " + retrievedUpdatedCurrency.getId());
                System.out.println("Code: " + retrievedUpdatedCurrency.getCurrencyCode());
                System.out.println("Name: " + retrievedUpdatedCurrency.getCurrencyName());
                System.out.println("Symbol: " + retrievedUpdatedCurrency.getCurrencySymbol());
                System.out.println("Exchange Rate: " + retrievedUpdatedCurrency.getExchangeRate());
            } else {
                System.out.println("No currency found with the ID QIO");
            }


            //Insert Transactions
            Transaction newTransaction = new Transaction();
            newTransaction.setId("200");
            newTransaction.setCategory("expense");
            newTransaction.setLabel("None");
            newTransaction.setDate(LocalDate.parse("2023-12-04").atStartOfDay());
            newTransaction.setPaymentId("2");
            transactionRepository.addTransaction(newTransaction);
            System.out.println("Transaction added successfully.");


           // Delete Transactions
            String transactionIdToDelete = "155";
            boolean isTransactionDeleted = transactionRepository.deleteTransactionById(transactionIdToDelete);

            if (isTransactionDeleted) {
                System.out.println("Transaction with ID " + transactionIdToDelete + " deleted successfully");
            } else {
                System.out.println("No transaction found with the ID " + transactionIdToDelete);
            }

            // Update Transaction
            Transaction transactionToUpdate = new Transaction();
            transactionToUpdate.setId("101");
            transactionToUpdate.setCategory("income");
            transactionToUpdate.setLabel("Salary");
            transactionToUpdate.setDate(LocalDateTime.parse("2023-12-05T12:30:00"));
            transactionToUpdate.setPaymentId("3");
            transactionRepository.updateTransaction(transactionToUpdate);
            System.out.println("Transaction updated successfully.");

            //Get Transactions
            String transactionIdToRetrieve = "101";
            Transaction retrievedTransaction = transactionRepository.getTransactionById(transactionIdToRetrieve);

            if (retrievedTransaction != null) {
                System.out.println("Transaction details");
                System.out.println("ID: " + retrievedTransaction.getId());
                System.out.println("Category: " + retrievedTransaction.getCategory());
                System.out.println("Label: " + retrievedTransaction.getLabel());
                System.out.println("Date: " + retrievedTransaction.getDate());
                System.out.println("Payment ID: " + retrievedTransaction.getPaymentId());
            } else {
                System.out.println("No transaction found with the ID " + transactionIdToRetrieve);
            }


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
