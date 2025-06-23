package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Tidpw;

public class TidpwDAO {
	// 引数で指定されたidpwでログイン成功ならtrueを返す
	public Tidpw isLoginOK(Tidpw Tidpw) {
		Connection conn = null;
		Tidpw resultTidpw = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SELECT文を準備する
			String sql = "SELECT * FROM Tidpw WHERE tName=? AND tPw=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, Tidpw.gettName());
			pStmt.setString(2, Tidpw.gettPw());
			
			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果をBeanに詰める
			if(rs.next()) {
			resultTidpw = new Tidpw();
            resultTidpw.settName(rs.getString("tName"));
            resultTidpw.settPw(rs.getString("tPw"));
            resultTidpw.setClassName(rs.getInt("className"));
      
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

			
		return resultTidpw;
	}		
		
		public boolean insert(Tidpw card) {
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
				String sql = "INSERT INTO Tidpw (className, tName, tPw) VALUES (?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
				// SQL文を完成させる
				pStmt.setInt(1,card.getClassName());
				pStmt.setString(2,card.gettName());
				pStmt.setString(3,card.gettPw());
				
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
