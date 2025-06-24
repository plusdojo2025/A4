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
	public ArrayList<Tests> select(int testsId) {
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
			
			pStmt.setInt(1, testsId);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Tests test = new Tests();
				test.setTestsId(rs.getInt("testsId"));
                test.setNumber(rs.getInt("number"));
                test.setTerm(rs.getInt("term"));
                test.setTestName(rs.getString("testName"));
                test.setJapanese(rs.getInt("japanese"));
                test.setAverageJapanese(rs.getInt("averageJapanese"));
                test.setMath(rs.getInt("math"));
                test.setAverageMath(rs.getInt("averageMath"));
                test.setScience(rs.getInt("science"));
                test.setAverageScience(rs.getInt("averageScience"));
                test.setSocial(rs.getInt("social"));
                test.setAverageSocial(rs.getInt("averageSocial"));
                test.setEnglish(rs.getInt("english"));
                test.setAverageEnglish(rs.getInt("averageEnglish"));
                test.setSum(rs.getInt("sum"));
                test.setAverageSum(rs.getInt("averageSum"));

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
	
	public ArrayList<Tests> select1(int number) {
		Connection conn = null;
		ArrayList<Tests> testsResult = new ArrayList<Tests>();
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true","root", "password");

			// SQL文を準備する
			String sql = "SELECT * FROM Tests WHERE number=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Tests test = new Tests();
				test.setTestsId(rs.getInt("testsId"));
			    test.setNumber(rs.getInt("number"));
			    test.setTerm(rs.getInt("term"));
			    test.setTestName(rs.getString("testName"));
			    test.setJapanese(rs.getInt("japanese"));
			    test.setAverageJapanese(rs.getInt("averageJapanese"));
			    test.setMath(rs.getInt("math"));
			    test.setAverageMath(rs.getInt("averageMath"));
			    test.setScience(rs.getInt("science"));
			    test.setAverageScience(rs.getInt("averageScience"));
			    test.setSocial(rs.getInt("social"));
			    test.setAverageSocial(rs.getInt("averageSocial"));
			    test.setEnglish(rs.getInt("english"));
			    test.setAverageEnglish(rs.getInt("averageEnglish"));
			    test.setSum(rs.getInt("sum"));
			    test.setAverageSum(rs.getInt("averageSum"));
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
	
	public ArrayList<Allaccess> select(int term, String testName) {
		Connection conn = null;
		ArrayList<Allaccess> testsResult = new ArrayList<Allaccess>();
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true","root", "password");

			// SQL文を準備する
			String sql = "SELECT s.sName t.term t.testName t.japanese t.math t.science t.social t.english t.sum"
						+"FROM Sidpw s JOIN Tests t ON s.number = t.number WHERE t.term=? AND t.testName";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SQL文を完成させる
			if(term != 0) {
				pStmt.setInt(1,term);
			}
			else {
				pStmt.setInt(1, 0);
			}
			if(testName != null) {
				pStmt.setString(2,"%"+testName+"%");
			}
			else {
				pStmt.setString(2, "%");
			}
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Allaccess test = new Allaccess();
				test.setsName(rs.getString("sName"));
				test.setTestsId(rs.getInt("testsId"));
				test.setNumber(rs.getInt("number"));
				test.setTerm(rs.getInt("term"));
				test.setTestName(rs.getString("testName"));
				test.setJapanese(rs.getInt("japanese"));
				test.setAverageJapanese(rs.getInt("averageJapanese"));
				test.setMath(rs.getInt("math"));
				test.setAverageMath(rs.getInt("averageMath"));
				test.setScience(rs.getInt("science"));
				test.setAverageScience(rs.getInt("averageScience"));
				test.setSocial(rs.getInt("social"));
				test.setAverageSocial(rs.getInt("averageSocial"));
				test.setEnglish(rs.getInt("english"));
				test.setAverageEnglish(rs.getInt("averageEnglish"));
				test.setSum(rs.getInt("sum"));
				test.setAverageSum(rs.getInt("averageSum"));
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
			stmt.setInt(1, card.getNumber());
            stmt.setInt(2, card.getTerm());
            stmt.setString(3, card.getTestName());
            stmt.setInt(4, card.getJapanese());
            stmt.setInt(5, card.getMath());
            stmt.setInt(6, card.getScience());
            stmt.setInt(7, card.getSocial());
            stmt.setInt(8, card.getEnglish());
            stmt.setInt(9, card.getJapanese() + card.getMath() + 
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
	
	public boolean insert(ArrayList<Tests> gradeList) {
		Connection conn = null;
		boolean result = false;
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a4?"
				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true","root", "password");

			// SQL文を準備する
			String sql = "INSERT INTO Tests (number, term, testName, "
					+ "japanese, math, science, social, english, sum) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			for(Tests grade: gradeList) {
				stmt.setInt(1, grade.getNumber());
	            stmt.setInt(2, grade.getTerm());
	            stmt.setString(3, grade.getTestName());
	            stmt.setInt(4, grade.getJapanese());
	            stmt.setInt(5, grade.getMath());
	            stmt.setInt(6, grade.getScience());
	            stmt.setInt(7, grade.getSocial());
	            stmt.setInt(8, grade.getEnglish());
	            stmt.setInt(9, grade.getSum());
	            
	            // SQL文を実行する
				if (stmt.executeUpdate() == 1) {
					result = true;
				}
				else {
					result = false;
					break;
				}
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
			pStmt.setInt(1, allaccess.getJapanese());
			pStmt.setInt(2, allaccess.getMath());
			pStmt.setInt(3, allaccess.getScience());
			pStmt.setInt(4, allaccess.getSocial());
			pStmt.setInt(5, allaccess.getEnglish());
			pStmt.setInt(6, allaccess.getSum());
			pStmt.setInt(7, allaccess.getTestsId());
			
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
			pStmt.setInt(1, allaccess.getTestsId());

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
