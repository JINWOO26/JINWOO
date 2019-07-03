package AcidRain;

import java.sql.*;

import javax.swing.JOptionPane;

public class DataBase extends JOptionPane {

	String DB_driverName = "oracle.jdbc.driver.OracleDriver";
	String DB_URL = "jdbc:oracle:thin:@192.168.30.75:1521:xe";
	String DB_USER = "c##ora_user";
	String DB_PW = "rla";

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public DataBase() {
		try {
			Class.forName(DB_driverName);

		} catch (ClassNotFoundException e) {
			System.out.println("[로드 오류]\n" + e.getStackTrace());
		}

	}

	public void closeDatabase() {
		try {
			if (connection != null) {
				connection.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			System.out.println("[닫기 오류]\n" + e.getStackTrace());
		}
	}

	public int UserInsert(String USER_ID, String USER_PW, String USER_NAME) {
		int resultValue = 0;

		try {
			String queryString = "INSERT INTO USER0 VALUES (" + "'" + USER_ID + "'," + "'" + USER_PW + "'," + "'"
					+ USER_NAME + "')";

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);

			statement = connection.createStatement();

			resultValue = statement.executeUpdate(queryString);
		} catch (SQLException e) {
			showMessageDialog(null, "ID가 존재합니다", "ID존재", JOptionPane.WARNING_MESSAGE);
		} finally {
			closeDatabase();
			
		}

		return resultValue;

	}

	public int ScoreInsert(String USER_ID) {
		int resultValue = 0;

		try {
			String queryString = "INSERT INTO SCORE VALUES('" + USER_ID + "'," + "'0','0','0')";

			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);

			statement = connection.createStatement();

			resultValue = statement.executeUpdate(queryString);
		} catch (SQLException e) {
			showMessageDialog(null, "Scoreboard입력오류", "ID존재", JOptionPane.WARNING_MESSAGE);
		} finally {
			closeDatabase();
		}

		return resultValue;

	}

	public int IDexist(String USER_ID) {
		int resultValue = 0;
		ResultSet rs = null;

		try {
			String queryString = "SELECT COUNT(*) FROM USER0 WHERE USER_ID = " + "'" + USER_ID + "'";
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);

			statement = connection.createStatement();
			rs = statement.executeQuery(queryString);

			while (rs.next()) {
				resultValue = rs.getInt(1);
			}

		} catch (SQLException e) {
			showMessageDialog(null, "입력오류", "ID존재", JOptionPane.WARNING_MESSAGE);
		} finally {
			closeDatabase();
		}

		return resultValue;

	}

	public int Loginselect(String USER_ID, String USER_PW) {
		int resultValue = 0;
		ResultSet rs = null;

		try {
			String queryString = "SELECT COUNT(*) FROM USER0 WHERE USER_ID = " + "'" + USER_ID + "'"
					+ " AND USER_PW = '" + USER_PW + "'";
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);

			statement = connection.createStatement();
			rs = statement.executeQuery(queryString);

			while (rs.next()) {
				resultValue = rs.getInt(1);
			}

		} catch (SQLException e) {
			showMessageDialog(null, "입력오류", "ID존재", JOptionPane.WARNING_MESSAGE);
		} finally {
			closeDatabase();
		}
		// ID없음
		if (IDexist(USER_ID) == 0) {
			return 0;
		}
		// 비밀번호 틀렸음
		else if (IDexist(USER_ID) == 1 && resultValue == 0) {
			return -1;
		}
		// 비밀번호 ID 다 맞음
		else if (resultValue == 1) {
			return 1;
		}

		else
			return 0;
	}
	
	public String Returnname(String USER_ID, String USER_PW) {
		String name = "";
		ResultSet rs = null;

		try {
			String queryString = "SELECT NAME FROM USER0 WHERE USER_ID = "+"'"+USER_ID+"' AND USER_PW = '"+USER_PW+"'";
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);

			statement = connection.createStatement();
			rs = statement.executeQuery(queryString);

			while (rs.next()) {
				name = rs.getString(1);
			}

		} catch (SQLException e) {
			showMessageDialog(null, "입력오류", "ID존재", JOptionPane.WARNING_MESSAGE);
		} finally {
			closeDatabase();
		}
		
		return name;
	}

}
