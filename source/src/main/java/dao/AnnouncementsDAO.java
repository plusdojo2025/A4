package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Allaccess;
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

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			pStmt.setString(1, announce);

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
	
	public ArrayList<Announcemnts> select(int className) {
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

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			if(className != 0) {
				pStmt.setInt(1, className);
			}
			else {
				pStmt.setInt(1,0);
			}
			
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
	public boolean insert(Allaccess all) {
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
			String sql = "INSERT INTO Announcements (className, announce) VALUES (?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			
			pStmt.setInt(1, all.getClassName());
			pStmt.setString(2, all.getAnnounce());

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
