package com.example.demo;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
public class DBConnection {
	private String dbUrl = "jdbc:postgresql://containers-us-west-136.railway.app:6686/railway";
	//имя пользователя к базе данных
	private String dbUserName = "postgres";
	//пароль к базе данных
	private String dbPassword = "4WLXDgi5khdXZY4RHKEc";

	public  Connection getConnection(String dbURL) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return connection;
	}
}
