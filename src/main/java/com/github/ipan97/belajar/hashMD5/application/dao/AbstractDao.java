/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ipan97.belajar.hashMD5.application.dao;

import com.github.ipan97.belajar.hashMD5.application.App;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author ifan
 */
public class AbstractDao {

	private App app;
	private Connection connection;
	public AbstractDao(DataSource dataSource) {
		try {
			connection = dataSource.getConnection();
		} catch (SQLException ex) {
			Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Connection getConnection() {
		return connection;
	}

	
	
}
