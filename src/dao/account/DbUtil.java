package dao.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Account;

public class DbUtil {
	public static final String url = "jdbc:mysql://localhost:3306/account?user=root&password=YL635901";
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	//install driver
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * create and get connection
	 * @return
	 */
	public Connection getConnection(){
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("ok");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * close connection
	 */
	public void closeConnection(){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Execute update(insert , delete , update)
	 * @param sql
	 * @param params
	 * @return
	 */
	public int excuteUpdate(String sql , Object... params){
		try {
			conn = this.getConnection();
			stmt = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					stmt.setObject(i + 1, params[i]);
				}
			}
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Execute query
	 * @param sql
	 * @param params
	 * @return
	 */
	public Account excuteQuery(String sql , Object... params){
		try {
			conn = this.getConnection();
			stmt = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					stmt.setObject(i+1 , params[i]);
				}
			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				//Analyse ResultSet
				Account acc = new Account(rs.getString("user"),
						rs.getString("pwd"));
				return acc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
