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
    public static final String SELECT_ALL_ACCOUNTS_SQL = "SELECT * FROM account";
    private static final String SELECT_ACCOUNT_BY_ID_SQL = "SELECT * FROM account WHERE id = ?";
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


}
