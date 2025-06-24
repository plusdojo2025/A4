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
	public Sidpw isLoginOK(Sidpw Sidpw) {
		Connection conn = null;
		Sidpw resultSidpw = null;
	
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
	
			// SELECT文を準備する
			String sql = "SELECT * FROM Sidpw WHERE sName=? AND sPw=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, Sidpw.getsName());
			pStmt.setString(2, Sidpw.getsPw());
	
			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
	
			// ユーザーIDとパスワードが一致するユーザーがいれば結果をtrueにする
			if(rs.next()) {
				resultSidpw = new Sidpw();
	            resultSidpw.setsName(rs.getString("sName"));
	            resultSidpw.setsPw(rs.getString("sPw"));
	            resultSidpw.setClassName(rs.getInt("className"));
	      
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
		return resultSidpw;
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
			pStmt.setInt(1,card.getClassName());
			pStmt.setString(2,card.getsName());
			pStmt.setInt(3,card.getNumber());
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
			pStmt.setInt(3, card.getNumber());

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
			pStmt.setInt(1, card.getNumber());

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
	public ArrayList<Sidpw> select(int className) {
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
			if(className != 0) {
				pStmt.setInt(1,className);
			}
			else {
				pStmt.setInt(1, 0);
			}
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			//結果表をコレクションにコピーする
			while(rs.next()) {
				Sidpw sidpw = new Sidpw(rs.getInt("className"),
										rs.getString("sName"),
										rs.getInt("number"),
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
	
	public int select(String studentName) {
		Connection conn = null;
		int studentId = 0;
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true","root", "password");
						
			//SQL文を準備する
			String sql = "SELECT number FROM Sidpw WHERE sName=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SQL文を完成させる
			if(studentName != null) {
				pStmt.setString(1,"%"+studentName+"%");
			}
			else {
				pStmt.setString(1, "%");
			}
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			studentId = rs.getInt("number");
			
		}catch (SQLException e) {
			e.printStackTrace();
			studentId = 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			studentId = 0;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					studentId = 0;
				}
			}
		}
		return studentId;
		
	}

	public int studentSelectId(Sidpw sidpw) {
		Connection conn = null;
		int studentId = 0;
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
			
			studentId = rs.getInt("number");
			
		}catch (SQLException e) {
			e.printStackTrace();
			studentId = 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			studentId = 0;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					studentId = 0;
				}
			}
		}
		return studentId;
	}

	
	
	
}
