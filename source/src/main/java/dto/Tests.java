package dto;

import java.io.Serializable;

public class Tests implements Serializable{
	private int testsId; //成績ID
	private int number; //学籍番号
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
	

	
	public Tests(int testsId, int number, int term, String testName, int japanese, int averageJapanese, int math,
			int averageMath, int science, int averageScience, int social, int averageSocial, int english,
			int averageEnglish, int sum, int averageSum) {
		this.testsId = testsId;
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
		this.testsId = 0;
		this.number = 0;
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

	
	public Tests(int testsId, int number, int term, String testName, int japanese, int math, int science, int social,
			int english, int sum) {
		this.testsId = testsId;
		this.number = number;
		this.term = term;
		this.testName = testName;
		this.japanese = japanese;
		this.math = math;
		this.science = science;
		this.social = social;
		this.english = english;
		this.sum = sum;
	}
	
	
	public Tests(int testsId, int japanese, int averageJapanese, int math, int averageMath, int science,
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
	
	public Tests(int number, int term, String testName) {
		this.number = number;
		this.term = term;
		this.testName = testName;
	}

	public Tests(int term, String testName) {
		this.term = term;
		this.testName = testName;
	}
	
	public int getTestsId() {
		return testsId;
	}
	public void setTestsId(int testsId) {
		this.testsId = testsId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
