package dto;

import java.io.Serializable;

public class Allaccess implements Serializable {
	private String className; // クラス名
	private String tName; // 氏名
	private String tPw; // パスワード
	
	private String sName; // 生徒の氏名
	private String number; //学籍番号
	private String sPw; // 生徒のパスワード
	
	private String pName; // 保護者の氏名
	private String pPw; // 保護者のパスワード
	
	private String status; // 出席状況
	private String attendanceDate; //出欠日
	
	private String announce; //連絡事項
	private String announceDate; //登録日時
	
	private String term; //学期
	private String testName; //テスト名
	private String japanese; //国語
	private String averageJapanese; //国語平均点
	private String math; //数学
	private String averageMath; //数学平均点
	private String science; //理科
	private String averageScience; //理科平均点
	private String social; //社会
	private String averageSocial; //社会平均点
	private String english; //英語
	private String averageEnglish; //英語平均点
	private String sum; //総合
	private String averageSum; //総合平均点
	
	public String getClassName() {
		return className;
	}
	public String gettName() {
		return tName;
	}
	public String gettPw() {
		return tPw;
	}
	public String getsName() {
		return sName;
	}
	public String getNumber() {
		return number;
	}
	public String getsPw() {
		return sPw;
	}
	public String getpName() {
		return pName;
	}
	public String getpPw() {
		return pPw;
	}
	public String getStatus() {
		return status;
	}
	public String getAttendanceDate() {
		return attendanceDate;
	}
	public String getAnnounce() {
		return announce;
	}
	public String getAnnounceDate() {
		return announceDate;
	}
	public String getTerm() {
		return term;
	}
	public String getTestName() {
		return testName;
	}
	public String getJapanese() {
		return japanese;
	}
	public String getAverageJapanese() {
		return averageJapanese;
	}
	public String getMath() {
		return math;
	}
	public String getAverageMath() {
		return averageMath;
	}
	public String getScience() {
		return science;
	}
	public String getAverageScience() {
		return averageScience;
	}
	public String getSocial() {
		return social;
	}
	public String getAverageSocial() {
		return averageSocial;
	}
	public String getEnglish() {
		return english;
	}
	public String getAverageEnglish() {
		return averageEnglish;
	}
	public String getSum() {
		return sum;
	}
	public String getAverageSum() {
		return averageSum;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public void settPw(String tPw) {
		this.tPw = tPw;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setsPw(String sPw) {
		this.sPw = sPw;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public void setpPw(String pPw) {
		this.pPw = pPw;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public void setAnnounce(String announce) {
		this.announce = announce;
	}
	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public void setJapanese(String japanese) {
		this.japanese = japanese;
	}
	public void setAverageJapanese(String averageJapanese) {
		this.averageJapanese = averageJapanese;
	}
	public void setMath(String math) {
		this.math = math;
	}
	public void setAverageMath(String averageMath) {
		this.averageMath = averageMath;
	}
	public void setScience(String science) {
		this.science = science;
	}
	public void setAverageScience(String averageScience) {
		this.averageScience = averageScience;
	}
	public void setSocial(String social) {
		this.social = social;
	}
	public void setAverageSocial(String averageSocial) {
		this.averageSocial = averageSocial;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public void setAverageEnglish(String averageEnglish) {
		this.averageEnglish = averageEnglish;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public void setAverageSum(String averageSum) {
		this.averageSum = averageSum;
	}
	
	public Allaccess(String sName, String status, String attendanceDate) {
		this.sName = sName;
		this.status = status;
		this.attendanceDate = attendanceDate;
	}
	
	public Allaccess(String className, String tName, String tPw, String sName, String number, String sPw, String pName,
			String pPw, String status, String attendanceDate, String announce, String announceDate, String term,
			String testName, String japanese, String averageJapanese, String math, String averageMath, String science,
			String averageScience, String social, String averageSocial, String english, String averageEnglish,
			String sum, String averageSum) {
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
		this.className = "";
		this.tName = "";
		this.tPw = "";
		this.sName = "";
		this.number = "";
		this.sPw = "";
		this.pName = "";
		this.pPw = "";
		this.status = "";
		this.attendanceDate = "";
		this.announce = "";
		this.announceDate = "";
		this.term = "";
		this.testName = "";
		this.japanese = "";
		this.averageJapanese = "";
		this.math = "";
		this.averageMath = "";
		this.science = "";
		this.averageScience = "";
		this.social = "";
		this.averageSocial = "";
		this.english = "";
		this.averageEnglish = "";
		this.sum = "";
		this.averageSum = "";
	}
}
