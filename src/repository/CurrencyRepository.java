package repository;

import model.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyRepository {
    private static final String UPDATE_CURRENCY_SQL = "UPDATE currency SET currency_code = ?, currency_name = ?, currency_symbol = ?, exchangerate = ? WHERE id = ?";
    private Connection connection;
    private static final String INSERT_CURRENCY_SQL = "INSERT INTO currency (id, currency_code, currency_name, currency_symbol, exchangerate) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_CURRENCY_BY_ID_SQL = "DELETE FROM currency WHERE id = ?";

    public CurrencyRepository(Connection connection) {
        this.connection = connection;
    }

    public Currency getCurrencyById(String currencyId) {
        Currency currency = null;
        String sql = "SELECT * FROM currency WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, currencyId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    currency = mapResultSetToCurrency(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currency;
    }
    public void addCurrency(Currency currency) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CURRENCY_SQL)) {
            preparedStatement.setString(1, currency.getId());
            preparedStatement.setString(2, currency.getCurrencyCode());
            preparedStatement.setString(3, currency.getCurrencyName());
            preparedStatement.setString(4, currency.getCurrencySymbol());
            preparedStatement.setString(5, currency.getExchangeRate());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private Currency mapResultSetToCurrency(ResultSet resultSet) throws SQLException {
        Currency currency = new Currency();
        currency.setId(resultSet.getString("id"));
        currency.setCurrencyCode(resultSet.getString("currency_code"));
        currency.setCurrencyName(resultSet.getString("currency_name"));
        currency.setCurrencySymbol(resultSet.getString("currency_symbol"));
        currency.setExchangeRate(resultSet.getString("exchangerate"));
        return currency;
    }

    public void deleteCurrencyById(String currencyId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CURRENCY_BY_ID_SQL)) {
            preparedStatement.setString(1, currencyId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCurrency(Currency currency) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CURRENCY_SQL)) {
            preparedStatement.setString(1, currency.getCurrencyCode());
            preparedStatement.setString(2, currency.getCurrencyName());
            preparedStatement.setString(3, currency.getCurrencySymbol());
            preparedStatement.setString(4, currency.getExchangeRate());
            preparedStatement.setString(5, currency.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
