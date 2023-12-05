package repository;

import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class AccountRepository {
    public static final String INSERT_ACCOUNT_SQL = "INSERT INTO account (id, account_name, account_type, balance, currency_id, transaction_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_ACCOUNT_SQL = "UPDATE account SET account_name = ?, account_type = ?, balance = ?, currency_id = ?, transaction_id = ? WHERE id = ?";

    final Connection connection;

    public AccountRepository(Connection connection) {
        this.connection = connection;
    }

    public void addAccount(Account account) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT_SQL)) {
            preparedStatement.setString(1, account.getId());
            preparedStatement.setString(2, account.getAccountName());
            preparedStatement.setString(3, account.getAccountType());
            preparedStatement.setFloat(4, account.getBalance());
            preparedStatement.setString(5, account.getCurrencyId());
            preparedStatement.setString(6, account.getTransactionId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account getAccountById(String accountId) {
        String sql = "SELECT * FROM account WHERE id = ?";
        Account account = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, accountId);
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                account = new Account(resultSet.getString("id"),
                        resultSet.getString("account_name"),
                        resultSet.getString("account_type"),
                        resultSet.getFloat("balance"),
                        resultSet.getString("currency_id"),
                        resultSet.getString("transaction_id"));
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }

        return account;
    }

    public void updateAccount(Account account) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT_SQL)) {
            preparedStatement.setString(1, account.getAccountName());
            preparedStatement.setString(2, account.getAccountType());
            preparedStatement.setFloat(3, account.getBalance());
            preparedStatement.setString(4, account.getCurrencyId());
            preparedStatement.setString(5, account.getTransactionId());
            preparedStatement.setString(6, account.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
