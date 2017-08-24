package krishna.imcs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseFactory {

	private static DatabaseFactory connectionFactory;

	private Connection connection;

	private DatabaseFactory() {

	}

	public static DatabaseFactory createInstance() {
		if (connectionFactory == null) {
			connectionFactory = new DatabaseFactory();
		}

		return connectionFactory;
	}

	public static Connection getConnection() {
		return createInstance().createConnection();
	}

	private Connection createConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = ("jdbc:mysql://localhost:3306/employeedata?useSSL=true");
		String user = ("root");
		String password = ("root");

		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
