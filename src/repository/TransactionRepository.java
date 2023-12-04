package repository;

import model.Transaction;

import java.sql.*;

public class TransactionRepository {
    private final Connection connection;

    private static final String INSERT_TRANSACTION_SQL =
            "INSERT INTO transaction (id, category, label, date, payment_id) VALUES (?, ?, ?, ?, ?)";

    private static final String SELECT_TRANSACTION_BY_ID_SQL =
            "SELECT * FROM transaction WHERE id = ?";

    private static final String DELETE_TRANSACTION_BY_ID_SQL =
            "DELETE FROM transaction WHERE id = ?";

    public TransactionRepository(Connection connection) {
        this.connection = connection;
    }

    public void addTransaction(Transaction transaction) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRANSACTION_SQL)) {
            preparedStatement.setString(1, transaction.getId());
            preparedStatement.setString(2, transaction.getCategory());
            preparedStatement.setString(3,transaction.getLabel());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(transaction.getDate().atStartOfDay()));
            preparedStatement.setString(5, transaction.getPaymentId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean deleteTransactionById(String transactionId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TRANSACTION_BY_ID_SQL)) {
            preparedStatement.setString(1, transactionId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Retourne true si au moins une ligne a été supprimée
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // En cas d'erreur, retourne false
        }
    }

    public Transaction getTransactionById(String transactionId) {
        String sql = "SELECT * FROM transaction WHERE id = ?";
        Transaction transaction = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, transactionId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    transaction = new Transaction();
                    transaction.setId(resultSet.getString("id"));
                    transaction.setCategory(resultSet.getString("category"));
                    transaction.setLabel(resultSet.getString("label"));
                    transaction.setDate(resultSet.getTimestamp("date").toLocalDateTime());
                    transaction.setPaymentId(resultSet.getString("payment_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transaction;
    }

}
