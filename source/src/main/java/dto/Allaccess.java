package dto;

import java.io.Serializable;

public class Allaccess implements Serializable {
	private int className; // クラス名
	private String tName; // 氏名
	private String tPw; // パスワード
	
	private String sName; // 生徒の氏名
	private int number; //学籍番号
	private String sPw; // 生徒のパスワード
	
	private String pName; // 保護者の氏名
	private String pPw; // 保護者のパスワード
	
	private String status; // 出席状況
	private String attendanceDate; //出欠日
	
	private String announce; //連絡事項
	private String announceDate; //登録日時
	
	private int testsId; //テストID
	private int term; //学期
	private String testName; //テスト名
	private int japanese; //国語
	private int averageJapanese; //国語平均点
	private int math; //数学
	private int averageMath; //数学平均点
	private int science; //理科
	private int averageScience; //理科平均点
	private int social; //社会
	private int averageSocial; //社会平均点
	private int english; //英語
	private int averageEnglish; //英語平均点
	private int sum; //総合
	private int averageSum; //総合平均点
	
	
	
	public Allaccess(int number, String sName, String status, String attendanceDate) {
		this.number= number;
		this.sName = sName;
		this.status = status;
		this.attendanceDate = attendanceDate;
	}
	
	public Allaccess(int className, String announce) {
		this.className = className;
		this.announce = announce;
	}
	
	public Allaccess(int testsId, int term, String testName, int japanese,
			int averageJapanese, int math, int averageMath, int science, int averageScience,
			int social, int averageSocial, int english, int averageEnglish, int sum, int averageSum) {
		this.testsId = testsId;
		this.term = term;
		this.testName = testName;
		this.japanese = japanese;
		this.averageJapanese = averageJapanese;
		this.math = math;
		this.averageMath = averageMath;
		this.science = science;
		this.averageScience = averageScience;
		this.social = social;
		this.averageSocial = averageSocial;
		this.english = english;
		this.averageEnglish = averageEnglish;
		this.sum = sum;
		this.averageSum = averageSum;
	}
	
	
	public Allaccess(int className, String tName, String tPw, String sName, int number, String sPw, String pName,
			String pPw, String status, String attendanceDate, String announce, String announceDate, int testsId,
			int term, String testName, int japanese, int averageJapanese, int math, int averageMath, int science,
			int averageScience, int social, int averageSocial, int english, int averageEnglish, int sum,
			int averageSum) {
		this.className = className;
		this.tName = tName;
		this.tPw = tPw;
		this.sName = sName;
		this.number = number;
		this.sPw = sPw;
		this.pName = pName;
		this.pPw = pPw;
		this.status = status;
		this.attendanceDate = attendanceDate;
		this.announce = announce;
		this.announceDate = announceDate;
		this.testsId = testsId;
		this.term = term;
		this.testName = testName;
		this.japanese = japanese;
		this.averageJapanese = averageJapanese;
		this.math = math;
		this.averageMath = averageMath;
		this.science = science;
		this.averageScience = averageScience;
		this.social = social;
		this.averageSocial = averageSocial;
		this.english = english;
		this.averageEnglish = averageEnglish;
		this.sum = sum;
		this.averageSum = averageSum;
	}

	public Allaccess() {
		this.className = 0;
		this.tName = "";
		this.tPw = "";
		this.sName = "";
		this.number = 0;
		this.sPw = "";
		this.pName = "";
		this.pPw = "";
		this.status = "";
		this.attendanceDate = "";
		this.announce = "";
		this.announceDate = "";
		this.testsId = 0;
		this.term = 0;
		this.testName = "";
		this.japanese = 0;
		this.averageJapanese = 0;
		this.math = 0;
		this.averageMath = 0;
		this.science = 0;
		this.averageScience = 0;
		this.social = 0;
		this.averageSocial = 0;
		this.english = 0;
		this.averageEnglish = 0;
		this.sum = 0;
		this.averageSum = 0;
	}

	 

	public Allaccess(int testsId, int japanese, int averageJapanese, int math, int averageMath, int science,
			int averageScience, int social, int averageSocial, int english, int averageEnglish, int sum,
			int averageSum) {
		super();
		this.testsId = testsId;
		this.japanese = japanese;
		this.averageJapanese = averageJapanese;
		this.math = math;
		this.averageMath = averageMath;
		this.science = science;
		this.averageScience = averageScience;
		this.social = social;
		this.averageSocial = averageSocial;
		this.english = english;
		this.averageEnglish = averageEnglish;
		this.sum = sum;
		this.averageSum = averageSum;
	}

	public int getClassName() {
		return className;
	}

	public void setClassName(int className) {
		this.className = className;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettPw() {
		return tPw;
	}

	public void settPw(String tPw) {
		this.tPw = tPw;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getsPw() {
		return sPw;
	}

	public void setsPw(String sPw) {
		this.sPw = sPw;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpPw() {
		return pPw;
	}

	public void setpPw(String pPw) {
		this.pPw = pPw;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public String getAnnounce() {
		return announce;
	}

	public void setAnnounce(String announce) {
		this.announce = announce;
	}

	public String getAnnounceDate() {
		return announceDate;
	}

	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}

	public int getTestsId() {
		return testsId;
	}

	public void setTestsId(int testsId) {
		this.testsId = testsId;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getJapanese() {
		return japanese;
	}

	public void setJapanese(int japanese) {
		this.japanese = japanese;
	}

	public int getAverageJapanese() {
		return averageJapanese;
	}

	public void setAverageJapanese(int averageJapanese) {
		this.averageJapanese = averageJapanese;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getAverageMath() {
		return averageMath;
	}

	public void setAverageMath(int averageMath) {
		this.averageMath = averageMath;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getAverageScience() {
		return averageScience;
	}

	public void setAverageScience(int averageScience) {
		this.averageScience = averageScience;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	public int getAverageSocial() {
		return averageSocial;
	}

	public void setAverageSocial(int averageSocial) {
		this.averageSocial = averageSocial;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getAverageEnglish() {
		return averageEnglish;
	}

	public void setAverageEnglish(int averageEnglish) {
		this.averageEnglish = averageEnglish;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getAverageSum() {
		return averageSum;
	}

	public void setAverageSum(int averageSum) {
		this.averageSum = averageSum;
	}
	
	
}
