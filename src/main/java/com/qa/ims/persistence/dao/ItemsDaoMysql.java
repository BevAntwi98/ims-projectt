package com.qa.ims.persistence.dao;

import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

	

	public class ItemsDaoMysql implements Dao<Items> {

		public static final Logger LOGGER = Logger.getLogger(CustomerDaoMysql.class);

		private String jdbcConnectionUrl;
		private String username;
		private String password;

		public ItemsDaoMysql(String username, String password) {
			this.jdbcConnectionUrl = "jdbc:mysql://" + Utils.MYSQL_URL + "/ims";
			this.username = username;
			this.password = password;
		}

		public ItemsDaoMysql(String jdbcConnectionUrl, String username, String password) {
			this.jdbcConnectionUrl = jdbcConnectionUrl;
			this.username = username;
			this.password = password;
		}

		Items itemFromResultSet(ResultSet resultSet) throws SQLException {
			Long id = resultSet.getLong("id");
			String item_name = resultSet.getString("item_name");
			int quantity = resultSet.getInt("quantity");
			Double total_price = resultSet.getDouble("total_price");
			return new Items(item_name, quantity, total_price);
		}

		/**
		 * Reads all customers from the database
		 *
		 * @return A list of customers
		 */
		@Override
		public List<Items> readAll() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from Items");) {
				ArrayList<Items> Items = new ArrayList<>();
				while (resultSet.next()) {
					Items.add(itemFromResultSet(resultSet));
				}
				return Items;
			} catch (SQLException e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return new ArrayList<>();
		}

		public Items readLatest() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM Items ORDER BY id DESC LIMIT 1");) {
				resultSet.next();
				return itemFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Creates a customer in the database
		 *
		 * @param customer - takes in a customer object. id will be ignored
		 */
		@Override
		public Items create (Items item) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("insert into Items (item_name, quantity, total_price) values('" + item.getItem_name()
						+ "','" + item.getQuantity() +"','" + item.getTotal_price() + "')");
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		public Items readItems(Long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT FROM Items where id = " + id);) {
				resultSet.next();
				return itemFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Updates a customer in the database
		 *
		 * @param customer - takes in a customer object, the id field will be used to
		 *                 update that customer in the database
		 * @return
		 */
		@Override
		public Items update(Items items) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("update Items set quantity ='" + items.getQuantity() + "' where id =" + items.getId());
				return readItems(items.getId());
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Deletes a customer in the database
		 *
		 * @param id - id of the customer
		 */
		@Override
		public void delete(long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("delete from Items where id = " + id);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
		}

		

	}



