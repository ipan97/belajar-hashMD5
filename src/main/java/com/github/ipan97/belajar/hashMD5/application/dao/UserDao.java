/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ipan97.belajar.hashMD5.application.dao;

import com.github.ipan97.belajar.hashMD5.application.domain.Users;
import com.twmacinta.util.MD5;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author ifan
 */
public class UserDao extends AbstractDao {

	private PreparedStatement statement;
	private ResultSet resultSet;
	private final String SQL_INSERT
		= "INSERT INTO users(username,password) VALUES(?,?)";

	private final String SQL_LOGIN
		= "SELECT count(*) FROM users where username=? and password=md5(?)";

	public UserDao(DataSource dataSource) {
		super(dataSource);
	}

	public void instertUser(Users user) {
		try {
			statement = getConnection().prepareStatement(SQL_INSERT);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public Boolean userLogin(String user, String password) {
		try {
			statement = getConnection().prepareStatement(SQL_LOGIN);
			statement.setString(1, user);
			statement.setString(2, password);
			resultSet=statement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}

	}


	public Boolean statusLogin() {

		return false;
	}
}
