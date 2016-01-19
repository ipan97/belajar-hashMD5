/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ipan97.belajar.hashMD5.application;

import com.github.ipan97.belajar.hashMD5.application.dao.UserDao;
import com.github.ipan97.belajar.hashMD5.application.domain.Users;
import com.github.ipan97.belajar.hashMD5.application.view.LoginDialog;
import com.twmacinta.util.MD5;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author ifan
 */
public class App {

	public static String enkripsiString(String s) {
		MD5 md5 = new MD5();
		md5.Update(s);
		String hash = md5.asHex();
		return hash;
	}

	public static DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/belajar");
		//set user database
		dataSource.setUsername("root");
		//set password
		dataSource.setPassword("admin");
		return dataSource;
	}

	public static void main(String[] args) {
		Users u = new Users();
		UserDao dao = new UserDao(getDataSource());
		u.setUsername("ipan");
		u.setPassword(enkripsiString("admin"));
//		dao.instertUser(u);
		LoginDialog login=new LoginDialog();
		login.setLocationRelativeTo(null);
		login.setVisible(true);
	}

}
