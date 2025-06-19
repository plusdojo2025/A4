package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Allaccess;
import dto.Tests;

public class TestsDAO {
	
	//成績情報を閲覧する（１学期分）
	public ArrayList<Tests> select(String testsId) {
		Connection conn = null;
		ArrayList<Tests> testsList = new ArrayList<Tests>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM Tests WHERE term = ? AND testsId =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, testsId);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Tests test = new Tests();
				test.setTestsId(rs.getString("testsId"));
                test.setNumber(rs.getString("number"));
                test.setTerm(rs.getString("term"));
                test.setTestName(rs.getString("testName"));
                test.setJapanese(rs.getString("japanese"));
                test.setAverageJapanese(rs.getString("averageJapanese"));
                test.setMath(rs.getString("math"));
                test.setAverageMath(rs.getString("averageMath"));
                test.setScience(rs.getString("science"));
                test.setAverageScience(rs.getString("averageScience"));
                test.setSocial(rs.getString("social"));
                test.setAverageSocial(rs.getString("averageSocial"));
                test.setEnglish(rs.getString("english"));
                test.setAverageEnglish(rs.getString("averageEnglish"));
                test.setSum(rs.getString("sum"));
                test.setAverageSum(rs.getString("averageSum"));

                testsList.add(test);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			testsList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			testsList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					testsList = null;
				}
			}
		}

		// 結果を返す
		return testsList;
	}
	
	public ArrayList<Tests> select(Tests tests) {
		Connection conn = null;
		ArrayList<Tests> testsResult = new ArrayList<Tests>();
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true","root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM Tests WHERE number=? AND testName=? AND term=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SQL文を完成させる
			if(tests.getNumber() != null) {
				pStmt.setString(1,"%"+tests.getNumber()+"%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if(tests.getTestName() != null) {
				pStmt.setString(2,"%"+tests.getTestName()+"%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if(tests.getTerm() != null) {
				pStmt.setString(3,"%"+tests.getTerm()+"%");
			}
			else {
				pStmt.setString(3, "%");
			}
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Tests test = new Tests();
				test.setTestsId(rs.getString("testsId"));
			    test.setNumber(rs.getString("number"));
			    test.setTerm(rs.getString("term"));
			    test.setTestName(rs.getString("testName"));
			    test.setJapanese(rs.getString("japanese"));
			    test.setAverageJapanese(rs.getString("averageJapanese"));
			    test.setMath(rs.getString("math"));
			    test.setAverageMath(rs.getString("averageMath"));
			    test.setScience(rs.getString("science"));
			    test.setAverageScience(rs.getString("averageScience"));
			    test.setSocial(rs.getString("social"));
			    test.setAverageSocial(rs.getString("averageSocial"));
			    test.setEnglish(rs.getString("english"));
			    test.setAverageEnglish(rs.getString("averageEnglish"));
			    test.setSum(rs.getString("sum"));
			    test.setAverageSum(rs.getString("averageSum"));
			    testsResult.add(test);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			testsResult = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			testsResult = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					testsResult = null;
				}
			}
		}
		return testsResult;
	}
	
	//成績情報を登録する
	public boolean insert(Tests card) {
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
			String sql = "INSERT INTO Tests (number, term, testName, "
					+ "japanese, math, science, social, english, sum) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			stmt.setString(1, card.getNumber());
            stmt.setString(2, card.getTerm());
            stmt.setString(3, card.getTestName());
            stmt.setString(4, card.getJapanese());
            stmt.setString(5, card.getMath());
            stmt.setString(6, card.getScience());
            stmt.setString(7, card.getSocial());
            stmt.setString(8, card.getEnglish());
            stmt.setString(9, card.getJapanese() + card.getMath() + 
            				card.getScience() + card.getSocial() + 
            				card.getEnglish());

			// SQL文を実行する
			if (stmt.executeUpdate() == 1) {
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
	
	//成績情報を更新する
	public boolean update(Allaccess allaccess) {
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
			String sql = "UPDATE Tests SET japanese = ?, math = ?, "
					+ "science = ?, social = ?, english = ?, sum = ? "
					+ "WHERE testsId = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, allaccess.getJapanese());
			pStmt.setString(2, allaccess.getMath());
			pStmt.setString(3, allaccess.getScience());
			pStmt.setString(4, allaccess.getSocial());
			pStmt.setString(5, allaccess.getEnglish());
			pStmt.setString(6, allaccess.getSum());
			pStmt.setString(7, allaccess.getTestsId());
			
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
	
	//成績情報を削除する
	public boolean delete(Allaccess allaccess) {
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
			String sql = "DELETE FROM Tests WHERE testsId = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, allaccess.getTestsId());

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
