package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Announcemnts;

public class AnnouncementsDAO {
	
	//連絡情報を閲覧する
	public List<Announcemnts> select(String announce) {
		Connection conn = null;
		List<Announcemnts> announceList = new ArrayList<Announcemnts>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM Announcements WHERE className = ? ORDER BY announceDate DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, announce);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Announcemnts ann = new Announcemnts();
                ann.setAnnounceId(rs.getInt("announceId"));
                ann.setClassName(rs.getInt("className"));
                ann.setAnnounce(rs.getString("announce"));
                ann.setAnnounceDate(rs.getString("announceDate"));

                announceList.add(ann);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			announceList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			announceList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					announceList = null;
				}
			}
		}

		// 結果を返す
		return announceList;
	}
	
	//連絡登録情報から最新の情報だけを取得する
	public ArrayList<Announcemnts> selectLatest(String announce) {
		Connection conn = null;
		ArrayList<Announcemnts> announcelatest = new ArrayList<Announcemnts>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM Announcements ORDER BY announceDate DESC LIMIT 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Announcemnts ann = new Announcemnts();
                ann.setAnnounceId(rs.getInt("announceId"));
                ann.setClassName(rs.getInt("className"));
                ann.setAnnounce(rs.getString("announce"));
                ann.setAnnounceDate(rs.getString("announceDate"));
                announcelatest.add(ann);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			announcelatest = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			announcelatest = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					announcelatest = null;
				}
			}
		}

		// 結果を返す
		return announcelatest;
	}
	
	public ArrayList<Announcemnts> selectByClass(int className) {
		Connection conn = null;
		ArrayList<Announcemnts> announceList = new ArrayList<Announcemnts>();
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true","root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM Announcements WHERE className=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			
			if(className != 0) {
				pStmt.setInt(1, className);
			}
			else {
				pStmt.setInt(1,0);
			}
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				Announcemnts ann = new Announcemnts();
                ann.setAnnounceId(rs.getInt("announceId"));
                ann.setClassName(rs.getInt("className"));
                ann.setAnnounce(rs.getString("announce"));
                ann.setAnnounceDate(rs.getString("announceDate"));

                announceList.add(ann);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			announceList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			announceList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					announceList = null;
				}
			}
		}
		
		return announceList;
	}
	
	//連絡情報を登録する
	public boolean insert(int className, String enter, String announceDate) {
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
			String sql = "INSERT INTO Announcements (className, announce, announceDate) VALUES (?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, className);
			pStmt.setString(2, enter);
			pStmt.setString(3, announceDate);

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
