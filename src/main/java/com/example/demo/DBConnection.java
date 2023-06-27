package com.example.demo;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
public class DBConnection {
	//команда для выполнения SQL- скрипта из файла  init.sql для создания схемы и таблицы с данными
	private String script = "INIT=RUNSCRIPT FROM 'classpath:init.sql'";
	//Url базы H2  со скриптом
    private String dbURL_and_script = "jdbc:h2:mem:test;"+ script;
	//имя пользователя к базе данных H2
	private String dbUserName = "sa";
	//пароль к базе данных H2
	private String dbPassword = "";

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
