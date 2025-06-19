package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Sidpw;

public class SidpwDAO {
	//生徒のユーザー情報を閲覧
	public boolean isLoginOK(Sidpw Sidpw) {
		Connection conn = null;
		boolean loginResult = false;
	
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
	
			// SELECT文を準備する
			String sql = "SELECT count(*) FROM Sidpw WHERE sName=? AND sPw=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, Sidpw.getsName());
			pStmt.setString(2, Sidpw.getsPw());
	
			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
	
			// ユーザーIDとパスワードが一致するユーザーがいれば結果をtrueにする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}
	
		// 結果を返す
		return loginResult;
	}		
	
	//生徒のユーザー情報を登録する
	public boolean insert(Sidpw card) {
		Connection conn = null;
		boolean result = false;
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/A4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文を準備する
			String sql = "INSERT INTO Sidpw (className, sName, number, sPw) VALUES (?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を完成させる
			pStmt.setString(1,card.getClassName());
			pStmt.setString(2,card.getsName());
			pStmt.setString(3,card.getNumber());
			pStmt.setString(4,card.getsPw());
			
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
		// 結果を返す
		return result;
	}
	
	//生徒のユーザー情報を更新する
	public boolean update(Sidpw card) {
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
			String sql = "UPDATE Sidpw SET sName = ?, sPw = ? WHERE number = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, card.getsName());
			pStmt.setString(2, card.getsPw());
			pStmt.setString(3, card.getNumber());

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
	
	//生徒のユーザー情報を削除する
	public boolean delete(Sidpw card) {
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
			String sql = "DELETE FROM Sidpw WHERE number=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, card.getNumber());

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

	//クラス名を引数に生徒の情報を取得する
	public ArrayList<Sidpw> select(String className) {
		Connection conn = null;
		ArrayList<Sidpw> studentInfo = new ArrayList<Sidpw>();
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true","root", "password");
			
			//SQL文を準備する
			String sql = "SELECT className,sName,number,sPw FROM Sidpw WHERE className=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SQL文を完成させる
			if(className != null) {
				pStmt.setString(1,"%"+className+"%");
			}
			else {
				pStmt.setString(1, "%");
			}
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			//結果表をコレクションにコピーする
			while(rs.next()) {
				Sidpw sidpw = new Sidpw(rs.getString("className"),
										rs.getString("sName"),
										rs.getString("number"),
										rs.getString("sPw")
										);
				studentInfo.add(sidpw);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			studentInfo = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			studentInfo = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					studentInfo = null;
				}
			}
		}
		
		return studentInfo;
	}

	public String studentSelectId(Sidpw sidpw) {
		Connection conn = null;
		String studentId = "";
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true","root", "password");
						
			//SQL文を準備する
			String sql = "SELECT number FROM Sidpw WHERE sName=? AND sPw=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SQL文を完成させる
			if(sidpw.getsName() != null) {
				pStmt.setString(1,"%"+sidpw.getsName()+"%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if(sidpw.getsPw() != null) {
				pStmt.setString(2,"%"+sidpw.getsPw()+"%");
			}
			else {
				pStmt.setString(2, "%");
			}
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			studentId = rs.getString("number");
			
		}catch (SQLException e) {
			e.printStackTrace();
			studentId = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			studentId = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					studentId = null;
				}
			}
		}
		return studentId;
	}
	
	
}
