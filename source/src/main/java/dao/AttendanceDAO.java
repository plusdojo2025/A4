package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Allaccess;
import dto.Attendance;

public class AttendanceDAO {
	
	//出席状況を閲覧する(今日)
	public List<Attendance> select(Attendance card) {
		Connection conn = null;
		List<Attendance> cardList = new ArrayList<Attendance>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM Attendance WHERE attendanceDate = CURDATE()";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Attendance att = new Attendance();
				att.setAttendantId(rs.getInt("attendantId"));
                att.setNumber(rs.getInt("number"));
                att.setStatus(rs.getString("status"));
                att.setAttendanceDate(rs.getString("attendanceDate"));

				cardList.add(att);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}
	
	//出席状況を閲覧する(一か月)
	public List<Attendance> select(Attendance card, String year) {
		Connection conn = null;
		List<Attendance> cardList = new ArrayList<Attendance>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM Attendance \n"
					+ "WHERE YEAR(attendanceDate) = ? \n"
					+ "AND attendanceDate BETWEEN DATE_SUB(CURDATE(), INTERVAL 1 MONTH) AND CURDATE()";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setString(1, year);
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表をコレクションにコピーする
			while (rs.next()) {
                Attendance att = new Attendance();
                att.setAttendantId(rs.getInt("attendantId"));
                att.setNumber(rs.getInt("number"));
                att.setStatus(rs.getString("status"));
                att.setAttendanceDate(rs.getString("attendanceDate"));

				cardList.add(att);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}
	
	//学籍番号と日付を引数にその日の出席情報を取得する
	public Attendance attendanceSelect(int number, String attendanceDate) {
		Connection conn = null;
		Attendance attendanceData = new Attendance();
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true","root", "password");
			
			//SQL文を準備する
			String sql ="SELECT * FROM Attendance WHERE number=? AND attendanceDate=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SQL文を完成させる
			if(number != 0) {
				pStmt.setInt(1,number);
			}
			else {
				pStmt.setInt(1, 0);
			}
			if(attendanceDate != null) {
				pStmt.setString(2,"%"+attendanceDate+"%");
			}
			else {
				pStmt.setString(2, "%");
			}
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表をコレクションにコピーする
			attendanceData.setNumber(rs.getInt("number"));
			attendanceData.setAttendanceDate(rs.getString("attendanceDAte"));
			
		}catch (SQLException e) {
			e.printStackTrace();
			attendanceData = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			attendanceData = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					attendanceData = null;
				}
			}
		}
		return attendanceData;
	}
	
	//先生が出席状況を更新する
	public boolean update(Allaccess all) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "UPDATE Attendance SET status=?, attendanceDate=? WHERE number =?";
;
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, all.getStatus());
			pStmt.setString(2, all.getAttendanceDate());
			pStmt.setInt(3, all.getNumber());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
	
	public boolean update(Attendance attendance) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true","root", "password");
			
			//SQL文の準備する
			String sql = "UPDATE Attendance SET number=?,status=?,attendanceDate=? WHERE attendantId=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SQL文を完成させる
			pStmt.setInt(1, attendance.getNumber());
			pStmt.setString(2, attendance.getStatus());
			pStmt.setString(3, attendance.getAttendanceDate());
			pStmt.setInt(4, attendance.getAttendantId());
			
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	// 生徒・保護者が出席情報を登録する
	public boolean insert(Attendance card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "INSERT INTO Attendance (number, status, attendanceDate) VALUES (?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			
			pStmt.setInt(1, card.getNumber());
			pStmt.setString(2, card.getStatus());
			pStmt.setString(3, card.getAttendanceDate());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	

	

	
}
