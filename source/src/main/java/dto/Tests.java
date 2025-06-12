package dto;

import java.io.Serializable;

public class Tests implements Serializable{
	private String name; // 氏名
	private String number; //学籍番号
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getJapanese() {
		return japanese;
	}
	public void setJapanese(String japanese) {
		this.japanese = japanese;
	}
	public String getAverageJapanese() {
		return averageJapanese;
	}
	public void setAverageJapanese(String averageJapanese) {
		this.averageJapanese = averageJapanese;
	}
	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math;
	}
	public String getAverageMath() {
		return averageMath;
	}
	public void setAverageMath(String averageMath) {
		this.averageMath = averageMath;
	}
	public String getScience() {
		return science;
	}
	public void setScience(String science) {
		this.science = science;
	}
	public String getAverageScience() {
		return averageScience;
	}
	public void setAverageScience(String averageScience) {
		this.averageScience = averageScience;
	}
	public String getSocial() {
		return social;
	}
	public void setSocial(String social) {
		this.social = social;
	}
	public String getAverageSocial() {
		return averageSocial;
	}
	public void setAverageSocial(String averageSocial) {
		this.averageSocial = averageSocial;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getAverageEnglish() {
		return averageEnglish;
	}
	public void setAverageEnglish(String averageEnglish) {
		this.averageEnglish = averageEnglish;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public String getAverageSum() {
		return averageSum;
	}
	public void setAverageSum(String averageSum) {
		this.averageSum = averageSum;
	}
	public Tests(String name, String number, String term, String testName, String japanese, String averageJapanese,
			String math, String averageMath, String science, String averageScience, String social, String averageSocial,
			String english, String averageEnglish, String sum, String averageSum) {
		this.name = name;
		this.number = number;
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
	public Tests() {
		this.name = "";
		this.number = "";
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
