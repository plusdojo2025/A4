package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import dto.Pidpw;

public class PidpwDAO {
	//保護者のユーザー情報を閲覧
	public Pidpw isLoginOK(Pidpw Pidpw) {
		Connection conn = null;
		Pidpw resultPidpw = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SELECT文を準備する
			String sql = "SELECT * FROM Pidpw WHERE pName=? AND pPw=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, Pidpw.getpName());
			pStmt.setString(2, Pidpw.getpPw());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果をBeanに詰める
				if(rs.next()) {
				resultPidpw = new Pidpw();
	            resultPidpw.setpName(rs.getString("pName"));
	            resultPidpw.setpPw(rs.getString("pPw"));
	            resultPidpw.setNumber(rs.getInt("number"));
	      
				}
			} catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

				
			return resultPidpw;
				
		}	
	
	//保護者のユーザー情報を登録
	public boolean insert(Pidpw card) {
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
			String sql = "INSERT INTO Pidpw (pName, number, pPw) VALUES (?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を完成させる
			pStmt.setString(1,card.getpName());
			pStmt.setInt(2,card.getNumber());
			pStmt.setString(3,card.getpPw());
			
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
	public boolean update(Pidpw card) {
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
			String sql = "UPDATE Pidpw SET pName = ?, pPw = ? WHERE number = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, card.getpName());
			pStmt.setString(2, card.getpPw());
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
	public boolean delete(Pidpw card) {
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
			String sql = "DELETE FROM Pidpw WHERE number=?";
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

	//学籍番号を引数に保護者の情報を取得する
	public ArrayList<Pidpw> slect(ArrayList<Integer> studentId) {
		Connection conn = null;
		ArrayList<Pidpw> parentInfo = new ArrayList<Pidpw>();
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true","root", "password");
			
			// プレースホルダーを動的に作成（?, ?, ?, ...）
			//学籍番号をまとめてデータベースで一気に検索できる
			String placeholders = studentId.stream()
				    .map(id -> "?")
				    .collect(Collectors.joining(","));
			
			//SQL文を準備する
			String sql = "SELECT pName,number,pPw FROM Pidpw WHERE number IN (" + placeholders + ")";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SQL文を完成させる
			// setString() を使うことがポイント！
			for (int i = 0; i < studentId.size(); i++) {
			    pStmt.setInt(i + 1, studentId.get(i));
			}
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				Pidpw pidpw = new Pidpw(rs.getString("pName"),
									    rs.getInt("number"),
									    rs.getString("pPw")
									    );
				parentInfo.add(pidpw);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			parentInfo = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			parentInfo = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					parentInfo = null;
				}
			}
		}
		return parentInfo;
	}
	
	public Pidpw slectAddParent(int studentId) {
		Connection conn = null;
		Pidpw pa = null;
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true","root", "password");

			
			//SQL文を準備する
			String sql = "SELECT pName,number,pPw FROM Pidpw WHERE number =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SQL文を完成させる
			// setString() を使うことがポイント！
			
			pStmt.setInt(1, studentId);
			
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				pa = new Pidpw(rs.getString("pName"),
									    rs.getInt("number"),
									    rs.getString("pPw")
									    );
				
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
		return pa;
	}
}
