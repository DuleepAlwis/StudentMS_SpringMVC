package com.stapp.DaoImpl;

import java.sql.DriverManager;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Datasource {

	private DriverManagerDataSource datasource;
	
	public Datasource() {
		this.datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/studentms_mvc_db");
		datasource.setUsername("root");
		datasource.setPassword("password");
	}
	
	public DriverManagerDataSource getDataSource() {
		return this.datasource;
	}
}
