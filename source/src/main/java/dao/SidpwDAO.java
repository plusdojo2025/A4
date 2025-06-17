package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Sidpw;

public class SidpwDAO {
	// 引数で指定されたidpwでログイン成功ならtrueを返す
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
}
